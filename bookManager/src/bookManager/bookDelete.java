package bookManager;
/*
 * ͼ��ɾ��ģ��
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class bookDelete extends JFrame
{
	Label bookIdSearchLabel;
	Label bookIdLabel;
	Label bookNameLabel;
	Label bookAuthorLabel;
	Label bookTypeLabel;
	Label bookPublishLabel;
	Label bookDateLabel;
	Label bookTranslatorLabel;
	Label bookPriceLabel;
	Label bookNumberLabel;
	TextField bookIdSearchText;
	TextField bookIdText;
	TextField bookNameText;
	TextField bookAuthorText;
	TextField bookTypeText;
	TextField bookPublishText;
	TextField bookDateText;
	TextField bookTranslatorText;
	TextField bookPriceText;
	TextField bookNumberText;
	Button bookDeleteSearchButton;
	Button bookDeleteButton;
	Button bookDeleteCloseButton;
	//���췽��
	public bookDelete()
	{
		//GUI���
		this.setTitle("ɾ��ͼ��|���ũ������ͼ����Ĺ���ϵͳ");
		this.setSize(800, 500);
		this.setLayout(null);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		bookIdSearchLabel = new Label("ͼ��ID");
		bookIdLabel = new Label("ͼ��ID");
		bookNameLabel = new Label("ͼ������");
		bookAuthorLabel = new Label("��    ��");
		bookTypeLabel = new Label("ͼ�����");
		bookPublishLabel = new Label("�� �� ��");
		bookDateLabel = new Label("��������");
		bookTranslatorLabel = new Label("��    ��");
		bookPriceLabel = new Label("��    ��");
		bookNumberLabel = new Label("ͼ������");
		bookIdSearchText = new TextField("");
		bookIdText = new TextField("");
		bookNameText = new TextField("");
		bookAuthorText = new TextField("");
		bookTypeText = new TextField("");
		bookPublishText = new TextField("");
		bookDateText = new TextField("");
		bookTranslatorText = new TextField("");
		bookPriceText = new TextField("");
		bookNumberText = new TextField("");
		bookDeleteButton = new Button("ȷ��ɾ��");
		bookDeleteCloseButton = new Button("��   ��");
		bookDeleteSearchButton = new Button("��    ѯ");
		bookIdSearchLabel.setBounds(280, 50, 50, 20);
		bookIdLabel.setBounds(170, 170, 50, 20);
		bookNameLabel.setBounds(410, 170, 50, 20);
		bookAuthorLabel.setBounds(170, 200, 50, 20);
		bookTypeLabel.setBounds(410, 200, 50, 20);
		bookPublishLabel.setBounds(170, 230, 50, 20);
		bookDateLabel.setBounds(410, 230, 50, 20);
		bookTranslatorLabel.setBounds(170, 260, 50, 20);
		bookPriceLabel.setBounds(410, 260, 50, 20);
		bookNumberLabel.setBounds(170, 290, 50, 20);
		bookIdSearchText.setBounds(340, 50, 160, 20);
		bookIdText.setBounds(230, 170, 160, 20);
		bookNameText.setBounds(470, 170, 160, 20);
		bookAuthorText.setBounds(230, 200, 160, 20);
		bookTypeText.setBounds(470, 200, 160, 20);
		bookPublishText.setBounds(230, 230, 160, 20);
		bookDateText.setBounds(470, 230, 160, 20);
		bookTranslatorText.setBounds(230, 260, 160, 20);
		bookPriceText.setBounds(470, 260, 160, 20);
		bookNumberText.setBounds(230, 290, 160, 20);
		bookDeleteSearchButton.setBounds(460, 90, 80, 25);
		bookDeleteButton.setBounds(300, 330, 80, 25);
		bookDeleteCloseButton.setBounds(420, 330, 80, 25);
		add(bookIdSearchLabel);
		add(bookIdLabel);
		add(bookNameLabel);
		add(bookAuthorLabel);
		add(bookTypeLabel);
		add(bookPublishLabel);
		add(bookDateLabel);
		add(bookTranslatorLabel);
		add(bookPriceLabel);
		add(bookNumberLabel);
		add(bookIdSearchText);
		add(bookIdText);
		add(bookNameText);
		add(bookAuthorText);
		add(bookTypeText);
		add(bookPublishText);
		add(bookDateText);
		add(bookTranslatorText);
		add(bookPriceText);
		add(bookNumberText);
		add(bookDeleteSearchButton);
		add(bookDeleteButton);
		add(bookDeleteCloseButton);
		//��ѯ��TextField����д
		bookIdText.setEditable(false);
		bookNameText.setEditable(false);
		bookAuthorText.setEditable(false);
		bookTypeText.setEditable(false);
		bookPublishText.setEditable(false);
		bookDateText.setEditable(false);
		bookTranslatorText.setEditable(false);
		bookPriceText.setEditable(false);
		bookNumberText.setEditable(false);
		/*
		 * Ϊ��ѯ��ť��Ӽ�أ�ִ��bookDeleteSearchActionPerformed(ActionEvent e)����
		 */
		bookDeleteSearchButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						bookDeleteSearchActionPerformed(e);
					}
				}
				);
		/*
		 * Ϊɾ����ť��Ӽ�أ�ִ��bookChangeSaveActionPerformed(ActionEvent e)����
		 */
		bookDeleteButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						bookChangeSaveActionPerformed(e);
					}
				}
				);
		/*
		 * Ϊ�˳���ť��Ӽ�أ�ִ��dispose�ͷŴ��ڲ���
		 */
		bookDeleteCloseButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						dispose();
					}
				}
				);
	}
	/*
	 * �����ѯʱִ�еķ���
	 */
	public void bookDeleteSearchActionPerformed(ActionEvent e)
	{
		//��ò�ѯ���
		String searchId = bookIdSearchText.getText();
		//���Ϊ�գ�������ʾ
		if(searchId.equals(""))
		{
			JOptionPane.showMessageDialog(null, "��ѯʱͼ���Ų�����Ϊ��");
			return;
		}
		try
		{
			//��ѯ��sql���
			String sql = "select * from book where r_bookId='"+searchId+"'";
			//���ݿ��ѯ
			ResultSet rs = dateBase.executeQuery(sql);
			//�ܲ鵽�����
			if(rs.next())
			{
				bookIdText.setText(rs.getString("r_bookId"));
				bookNameText.setText(rs.getString("r_bookName"));
				bookAuthorText.setText(rs.getString("r_bookAuthor"));
				bookTypeText.setText(rs.getString("r_bookType"));
				bookPublishText.setText(rs.getString("r_bookPublish"));
				bookDateText.setText(rs.getString("r_bookDate"));
				bookTranslatorText.setText(rs.getString("r_bookTranslator"));
				bookPriceText.setText(rs.getString("r_bookPrice"));
				bookNumberText.setText(rs.getString("r_bookNumber"));
			}
			//�޷��鵽��������ʾ
			else
			{
				JOptionPane.showMessageDialog(null, "û�в�ѯ����ͼ��");
			}
		}
		catch(SQLException g)
		{
			JOptionPane.showMessageDialog(null, "����·�޷����ӣ�");
		}
	}
	//���ɾ��ʱִ�еĲ���
	public void bookChangeSaveActionPerformed(ActionEvent e)
	{
		String bookId = bookIdText.getText();
		String sql = "delete from book where r_bookId='"+bookId+"'";
		if(dateBase.executeUpdate(sql) == 1)
		{
			//����ɾ���ɹ�����ʾ���������Ļ
			JOptionPane.showMessageDialog(null, "ͼ�� "+bookId+"ɾ���ɹ���");
			bookIdText.setText("");
			bookNameText.setText("");
			bookAuthorText.setText("");
			bookTypeText.setText("");
			bookPublishText.setText("");
			bookDateText.setText("");
			bookTranslatorText.setText("");
			bookPriceText.setText("");
			bookNumberText.setText("");
		}
	}
}
