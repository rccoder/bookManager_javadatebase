package bookManager;
/*
 * ���߲���ģ��
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class userSearch extends JFrame
{
	Label readerNameLabel;
	Label readerSexLabel;
	Label readermohuLabel;
	TextField readerNameText;
	TextField readerSexText;
	TextField readermohuText;
	Button readerSearchButton;
	Button readerCloseButton;
	public userSearch()
	{
		this.setTitle("���߲�ѯ|���ũ������ͼ����Ĺ��� ϵͳ");
		this.setSize(800, 500);
		this.setLayout(null);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		readerNameLabel = new Label("��������");
		readerSexLabel = new Label("�����Ա�");
		readermohuLabel = new Label("ģ������");
		readerNameText = new TextField("");
		readerSexText = new TextField("");
		readermohuText = new TextField("");
		readerSearchButton = new Button("��    ѯ");
		readerCloseButton = new Button("ȡ     ��");
		readerNameLabel.setBounds(170, 40, 50, 20);
		readerSexLabel.setBounds(410, 40, 50, 20);
		readermohuLabel.setBounds(250, 80, 50, 20);
		readerNameText.setBounds(230, 40, 160, 20);
		readerSexText.setBounds(470, 40, 160, 20);
		readermohuText.setBounds(310, 80, 160, 20);
		readerSearchButton.setBounds(300, 110, 80, 25);
		readerCloseButton.setBounds(420, 110, 80, 25);
		add(readerNameLabel);
		add(readerSexLabel);
		add(readermohuLabel);
		add(readerNameText);
		add(readerSexText);
		add(readermohuText);
		add(readerSearchButton);
		add(readerCloseButton);
		JOptionPane.showMessageDialog(null, "Ϊ��֤��ѯ�����׼ȷ�ԣ�����ʹ��ģ������ʱ����ǰ������Ϊ��");
		/*
		 * Ϊ��ѯ��ť��Ӽ��
		 */
		readerSearchButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						readerSearchButtonActionPerformed(e);
					}
				}
				);
		/*
		 * �ر����ݿ����ӣ��ͷŴ���
		 */
		readerCloseButton.addActionListener(
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
	 * ��ѯ��ť�����ִ�еķ���
	 */
	public void readerSearchButtonActionPerformed(ActionEvent e)
	{
		try
		{
			/*
			 * ��TextField�����ݽ���getText
			 */
			String readerName = readerNameText.getText();
			String readerSex = readerSexText.getText();
			String readermohu = readermohuText.getText();
			//����������õ���sql
			String sql1, sql2, sql3, sql4;
			//Ϊ������ֱ����׼��
			String[] readerTableHead = {"����ID", "��������", "�����Ա�", "���߿ɽ�������"};
			/*
			 * ����TextField�������Ƿ�Ϊ��д������sql���
			 */
			String sql = "select * from reader ";
			if(readerName.equals(""))
			{
				sql1 = "";
			}
			else
			{
				sql1 = "r_readerName='"+readerName+"'";
			}
			if(readerSex.equals(""))
			{
				sql2 = "";
			}
			else
			{
				sql2 = "r_readerSex='"+readerSex+"'";
				if(!readerName.equals(""))
				{
					sql2 = " and " + sql2;
				}
			}
			if(readermohu.equals(""))
			{
				sql3 = ""; 
			}
			else
			{
				sql3 = "r_readerName like '%"+readermohu+"%'";
				if(!(readerName.equals("") && readerSex.equals("")))
				{
					sql3 = " and " + sql3;
				}
			}
			sql4 = sql1 + sql2 + sql3;
			/*
			 * ������һ����Ϊ��ʱ����sql���
			 */
			if(!sql.equals(""))
			{
				sql = sql + "where " + sql4;
			}
			/*
			 * ȫ��Ϊ�գ������ʾ��Ϣ
			 */
			else
			{
				JOptionPane.showMessageDialog(null, "��������ȷ������");
			}
			ResultSet rs = dateBase.executeQuery(sql);
			/*
			 * ������ͷ����
			 */
			Object[][] readerSearchTable = new Object[20][readerTableHead.length];
			//i--�����ڱ���н����о�
			int i = 0;
			int flag = 0;
			while(rs.next())
			{
				flag = 1;
				readerSearchTable[i][0] = rs.getString("r_readerId");
				readerSearchTable[i][1] = rs.getString("r_readerName");
				readerSearchTable[i][2] = rs.getString("r_readerSex");
				readerSearchTable[i][3] = rs.getString("r_readerDays");
				i++;
			}
			if(flag == 0)
			{
				JOptionPane.showMessageDialog(null, "û���ҵ����Ӧ�Ķ���");
			}
			JTable table = new JTable(readerSearchTable, readerTableHead);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(20, 140, 760, 300);
			flag = 0;
			add(scrollPane);
		}
		catch(SQLException c)
		{
			JOptionPane.showMessageDialog(null, "���ݿ���ʴ���");
			System.exit(0);
		}
	}
}
