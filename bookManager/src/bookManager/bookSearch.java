package bookManager;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
/*
 * �鼮��ѯ���ܣ����Ա�����ʽչʾ
 */
public class bookSearch extends JFrame
{
	Label bookNameLabel;
	Label bookAuthorLabel;
	Label bookPublishLabel;
	Label bookTypeLabel;
	TextField bookNameText;
	TextField bookAuthorText;
	TextField bookPublishText;
	TextField bookTypeText;
	Button searchButton;
	Button closeButton;
	public bookSearch()
	{
		this.setTitle("�鼮��ѯ|���ũ������ͼ����Ĺ���ϵͳ");
		this.setSize(800, 500);
		this.setLayout(null);
		//���ڿɼ�
		this.setVisible(true);
		//ʹ�������
		this.setLocationRelativeTo(null);
		bookNameLabel = new Label("ͼ������");
		bookAuthorLabel = new Label("��      ��");
		bookPublishLabel = new Label("�� �� ��");
		bookTypeLabel = new Label("ͼ�����");
		bookNameText = new TextField("");
		bookAuthorText = new TextField("");
		bookPublishText = new TextField("");
		bookTypeText = new TextField("");
		searchButton = new Button("��   ѯ");
		closeButton = new Button("��   ��");
		bookNameLabel.setBounds(170, 20, 50, 20);
		bookAuthorLabel.setBounds(410, 20, 50, 20);
		bookPublishLabel.setBounds(170, 50, 50, 20);
		bookTypeLabel.setBounds(410, 50, 50, 20);
		bookNameText.setBounds(230, 20, 160, 20);
		bookAuthorText.setBounds(470, 20, 160, 20);
		bookPublishText.setBounds(230, 50, 160, 20);
		bookTypeText.setBounds(470, 50, 160, 20);
		searchButton.setBounds(300, 90, 80, 25);
		closeButton.setBounds(420, 90, 80, 25);
		add(bookNameLabel);
		add(bookAuthorLabel);
		add(bookPublishLabel);
		add(bookTypeLabel);
		add(bookNameText);
		add(bookAuthorText);
		add(bookPublishText);
		add(bookTypeText);
		add(searchButton);
		add(closeButton);
		/*
		 * ����ѯ��ť��Ӽ���������searchButtonActionPerformed(ActionEvent e)����
		 */
		searchButton.addActionListener(
				new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				searchButtonActionPerformed(e);
			}
		}
		);
		/*
		 * �ر����ݿ����ӣ��ͷŴ���
		 */
		closeButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						dateBase.Close();
						dispose();
					}
				}
				);
	}
	/*
	 * �����ѯ��ť��ִ�еķ���
	 */
	public void searchButtonActionPerformed(ActionEvent e)
	{
		try
		{
			String bookName = bookNameText.getText();
			String bookAuthor = bookAuthorText.getText();
			String bookPublish = bookPublishText.getText();
			String bookType = bookTypeText.getText();
			String sql = "select * from book ";
			String sql1, sql2, sql3, sql4, sql5;
			/*
			 * Ϊ������Ʊ��ʱ�ı�ͷ��׼��
			 */
			String[] bookTableHead = {"ͼ��ID", "ͼ������", "����", 
					"����", "������", "��������", "ͼ��۸�", "����"};
			/*
			 * ��ÿһ��TextField����getText��Ȼ���жϷ�Ϊ�գ��������д����ȷ��sql��䣬ʹ��ģ������
			 */
			if(bookName.equals(""))
			{
				sql1 = "";
			}
			else
			{
				sql1 = "r_bookName like'%"+bookName+"%'";
			}
			if(bookAuthor.equals(""))
			{
				sql2 = "";
			}
			else
			{
				sql2 = "r_bookAuthor like '%"+bookAuthor+"%'";
				if(!bookName.equals(""))
				{
					sql2 = " and " + sql2;
				}
			}
			if(bookPublish.equals(""))
			{
				sql3 = "";
			}
			else
			{
				sql3 = "r_bookPublish like '%"+bookPublish+"%'";
				if(!bookName.equals("") && bookAuthor.equals(""))
				{
					sql3 = " and " + sql3;
				}
			}
			if(bookType.equals(""))
			{
				sql4 = "";
			}
			else
			{
				sql4 = "r_bookType like '%"+bookType+"%'";
				if(!(bookName.equals("") && bookAuthor.equals("") && bookPublish.equals("")))
				{
					sql4 = " and " + sql4;
				}
			}
			sql5 = sql1 + sql2 + sql3 + sql4;
			/*
			 * ��sql������ɵ��������������һ��TextField��Ϊ��
			 */
			if(!sql5.equals(""))
			{
				sql = sql + " where " + sql5;
			}
			/*
			 * ����TextfFieldȫ��Ϊ�գ�����return������ʼ��ѯ
			 */
			else
			{
				JOptionPane.showMessageDialog(null, "��ѯ����Ϊ�գ�����������");
				return;
			}
			ResultSet rs = dateBase.executeQuery(sql);
			/*
			 * ����bookTable�Ķ���Ĭ�ϱ����20�У�����ΪbookTableHead.length�ĳ���
			 */
			Object[][] bookTable = new Object[20][bookTableHead.length];
			int i = 0;
			//flag��ʼֵΪ0.���ִ����rs.next()����˵�����ղ�������ƥ�䵽��ͼ�飬flag����Ϊ1�����û���ҵ�����Ϊ0��ִ�������if�ж�
			int flag = 0;
			while(rs.next())
			{
				flag = 1;
				bookTable[i][0] = rs.getString("r_bookId");
				bookTable[i][1] = rs.getString("r_bookName");
				bookTable[i][2] = rs.getString("r_bookAuthor");
				bookTable[i][3] = rs.getString("r_bookType");
				bookTable[i][4] = rs.getString("r_bookPublish");
				bookTable[i][5] = rs.getString("r_bookDate");
				bookTable[i][6] = rs.getFloat("r_bookPrice");
				bookTable[i][7] = rs.getString("r_bookTranslator");
				i++;
			}
			if(flag == 0)
			{
				JOptionPane.showMessageDialog(null, "û���ҵ���Ҫ���͵�ͼ��");
			}
			//����������JScrollPane��
			JTable table = new JTable(bookTable, bookTableHead);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(20, 140, 760, 300);
			flag = 0;
			add(scrollPane);
		}
		catch(SQLException b)
		{
			JOptionPane.showMessageDialog(null, "���ݿ���ʴ���");
			System.exit(0);
		}
	}
}
