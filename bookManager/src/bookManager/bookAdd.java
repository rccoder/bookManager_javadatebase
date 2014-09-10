package bookManager;
/*
 * ����Ա�����ͼ��ģ��
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;
import java.text.*;
public class bookAdd extends JFrame
{
	Label bookIdLabel;
	Label bookNameLabel;
	Label bookAuthorLabel;
	Label bookTypeLabel;
	Label bookPublishLabel;
	Label bookDateLabel;
	Label bookTranslatorLabel;
	Label bookPriceLabel;
	Label bookNumberLabel;
	TextField bookIdText;
	TextField bookNameText;
	TextField bookAuthorText;
	TextField bookTypeText;
	TextField bookPublishText;
	TextField bookDateText;
	TextField bookTranslatorText;
	TextField bookPriceText;
	TextField bookNumberText;
	Button bookAddButton;
	Button bookAddCloseButton;
	public bookAdd()
	{
		this.setTitle("����ͼ��|���ũ������ͼ����Ĺ���ϵͳ");
		this.setSize(800, 500);
		this.setLayout(null);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		bookIdLabel = new Label("ͼ��ID");
		bookNameLabel = new Label("ͼ������");
		bookAuthorLabel = new Label("��    ��");
		bookTypeLabel = new Label("ͼ�����");
		bookPublishLabel = new Label("�� �� ��");
		bookDateLabel = new Label("��������");
		bookTranslatorLabel = new Label("��    ��");
		bookPriceLabel = new Label("��    ��");
		bookNumberLabel = new Label("ͼ������");
		bookIdText = new TextField("");
		bookNameText = new TextField("");
		bookAuthorText = new TextField("");
		bookTypeText = new TextField("");
		bookPublishText = new TextField("");
		bookDateText = new TextField("");
		bookTranslatorText = new TextField("");
		bookPriceText = new TextField("");
		bookNumberText = new TextField("");
		bookAddButton = new Button("ȷ�����");
		bookAddCloseButton = new Button("��   ��");
		bookIdLabel.setBounds(170, 40, 50, 20);
		bookNameLabel.setBounds(410, 40, 50, 20);
		bookAuthorLabel.setBounds(170, 70, 50, 20);
		bookTypeLabel.setBounds(410, 70, 50, 20);
		bookPublishLabel.setBounds(170, 100, 50, 20);
		bookDateLabel.setBounds(410, 100, 50, 20);
		bookTranslatorLabel.setBounds(170, 130, 50, 20);
		bookPriceLabel.setBounds(410, 130, 50, 20);
		bookNumberLabel.setBounds(170, 160, 50, 20);
		bookIdText.setBounds(230, 40, 160, 20);
		bookNameText.setBounds(470, 40, 160, 20);
		bookAuthorText.setBounds(230, 70, 160, 20);
		bookTypeText.setBounds(470, 70, 160, 20);
		bookPublishText.setBounds(230, 100, 160, 20);
		bookDateText.setBounds(470, 100, 160, 20);
		bookTranslatorText.setBounds(230, 130, 160, 20);
		bookPriceText.setBounds(470, 130, 160, 20);
		bookNumberText.setBounds(230, 160, 160, 20);
		bookAddButton.setBounds(300, 200, 80, 25);
		bookAddCloseButton.setBounds(420, 200, 80, 25);
		add(bookIdLabel);
		add(bookNameLabel);
		add(bookAuthorLabel);
		add(bookTypeLabel);
		add(bookPublishLabel);
		add(bookDateLabel);
		add(bookTranslatorLabel);
		add(bookPriceLabel);
		add(bookNumberLabel);
		add(bookIdText);
		add(bookNameText);
		add(bookAuthorText);
		add(bookTypeText);
		add(bookPublishText);
		add(bookDateText);
		add(bookTranslatorText);
		add(bookPriceText);
		add(bookNumberText);
		add(bookAddButton);
		add(bookAddCloseButton);
		/*
		 * Ϊ�ύ��ť��Ӽ��
		 */
		bookAddButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						bookAddActionPerformed(e);
					}
				}
				);
		/*
		 * Ϊ�رհ�ť��Ӽ��
		 */
		bookAddCloseButton.addActionListener(
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
	 * ����ύ��ť��ִ�еķ���
	 */
	public void bookAddActionPerformed(ActionEvent e)
	{
		String bookId = bookIdText.getText();
		String bookName = bookNameText.getText();
		String bookAuthor = bookAuthorText.getText();
		String bookType = bookTypeText.getText();
		String bookPublish = bookPublishText.getText();
		String bookDate = bookDateText.getText();
		String bookTranslator = bookTranslatorText.getText();
		String bookPrice = bookPriceText.getText();
		String bookNumber = bookNumberText.getText();
		float price;
		int number;
		/*
		 * ͼ��IDĬ�ϲ���Ϊ�գ�Ϊ�յ�����ʾ
		 */
		if(bookId.equals(""))
		{
			JOptionPane.showMessageDialog(null, "ͼ���Ų���Ϊ�գ�");
			return;
		}
		/*
		 * ����bookIdExitJudgeģ�飬��ֹѧ���ظ�
		 */
		if(bookIdExitJudge(bookId))
		{
			JOptionPane.showMessageDialog(null, "ͼ���Ų����ظ���");
			return;
		}
		try
		{
			/*
			 * �۸�Ϊ��ʱ��Ĭ��Ϊ58
			 */
			if(bookPrice.equals(""))
			{
				price = 58;
			}
			/*
			 * ��Ϊ��ʱ��ת��Ϊfloat
			 */
			else
			{
				price = Float.parseFloat(bookPrice);
			}
			/*
			 * ��������Ϊ��ʱĬ��Ϊ10
			 */
			if(bookNumber.equals(""))
			{
				number = 10;
			}
			/*
			 * ����������Ϊ�գ��ַ���ת��Ϊfloat
			 */
			else
			{
				number = Integer.parseInt(bookNumber);
			}
			/*
			 * ������ݿ��¼��sql���
			 */
			String sql = "insert into book(r_bookId, r_bookName,"
					+ "r_bookType, r_bookPublish, r_bookDate, r_bookTranslator,"
					+ "r_bookPrice, r_bookAuthor, r_bookNumber) values ('"+bookId+"', '"+bookName+"',"
							+ "'"+bookType+"', '"+bookPublish+"', '"+bookDate+"', '"+bookTranslator+"',"
									+ "'"+price+"', '"+bookAuthor+"', '"+number+"')";
			/*
			 * ִ�����ݿ�ĸ��£�������ɷ���ֵΪ1��TextField��дΪ��
			 */
			if(dateBase.executeUpdate(sql) == 1)
			{
				JOptionPane.showMessageDialog(null, "ͼ����ӳɹ���");
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
		catch(NumberFormatException f1)
		{
			JOptionPane.showMessageDialog(null, "ͼ��۸��ͼ��������д������ȷӦ��Ϊ���֣�");
		}
		catch(Exception f2)
		{
		}
	}
	/*
	 * ���ز������������ж�ID�Ƿ��ظ������ڱ��д���
	 */
	public boolean bookIdExitJudge(String bookId)
	{
		/*
		 * ������ѯ��sql���
		 */
		String sql = "select * from book where r_bookId='"+bookId+"'";
		ResultSet rs = dateBase.executeQuery(sql);
		/*
		 * �ҵ�return TRUE������return FALSE
		 */
		try
		{
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(SQLException f3)
		{
			JOptionPane.showMessageDialog(null, "���ݿ��޷��������ӣ�");
		}
		return false;
	}
}
