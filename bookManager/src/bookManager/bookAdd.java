package bookManager;
/*
 * 管理员下添加图书模块
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
		this.setTitle("增加图书|乡村农家书屋图书借阅管理系统");
		this.setSize(800, 500);
		this.setLayout(null);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		bookIdLabel = new Label("图书ID");
		bookNameLabel = new Label("图书名称");
		bookAuthorLabel = new Label("作    者");
		bookTypeLabel = new Label("图书类别");
		bookPublishLabel = new Label("出 版 社");
		bookDateLabel = new Label("出版日期");
		bookTranslatorLabel = new Label("译    者");
		bookPriceLabel = new Label("定    价");
		bookNumberLabel = new Label("图书数量");
		bookIdText = new TextField("");
		bookNameText = new TextField("");
		bookAuthorText = new TextField("");
		bookTypeText = new TextField("");
		bookPublishText = new TextField("");
		bookDateText = new TextField("");
		bookTranslatorText = new TextField("");
		bookPriceText = new TextField("");
		bookNumberText = new TextField("");
		bookAddButton = new Button("确定添加");
		bookAddCloseButton = new Button("退   出");
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
		 * 为提交按钮添加监控
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
		 * 为关闭按钮添加监控
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
	 * 点击提交按钮后执行的方法
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
		 * 图书ID默认不能为空，为空弹出提示
		 */
		if(bookId.equals(""))
		{
			JOptionPane.showMessageDialog(null, "图书编号不能为空！");
			return;
		}
		/*
		 * 调用bookIdExitJudge模块，防止学号重复
		 */
		if(bookIdExitJudge(bookId))
		{
			JOptionPane.showMessageDialog(null, "图书编号不能重复！");
			return;
		}
		try
		{
			/*
			 * 价格为空时，默认为58
			 */
			if(bookPrice.equals(""))
			{
				price = 58;
			}
			/*
			 * 不为空时，转化为float
			 */
			else
			{
				price = Float.parseFloat(bookPrice);
			}
			/*
			 * 读书数量为空时默认为10
			 */
			if(bookNumber.equals(""))
			{
				number = 10;
			}
			/*
			 * 读书数量不为空，字符串转化为float
			 */
			else
			{
				number = Integer.parseInt(bookNumber);
			}
			/*
			 * 添加数据库记录的sql语句
			 */
			String sql = "insert into book(r_bookId, r_bookName,"
					+ "r_bookType, r_bookPublish, r_bookDate, r_bookTranslator,"
					+ "r_bookPrice, r_bookAuthor, r_bookNumber) values ('"+bookId+"', '"+bookName+"',"
							+ "'"+bookType+"', '"+bookPublish+"', '"+bookDate+"', '"+bookTranslator+"',"
									+ "'"+price+"', '"+bookAuthor+"', '"+number+"')";
			/*
			 * 执行数据库的更新，更新完成返回值为1，TextField重写为空
			 */
			if(dateBase.executeUpdate(sql) == 1)
			{
				JOptionPane.showMessageDialog(null, "图书添加成功！");
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
			JOptionPane.showMessageDialog(null, "图书价格或图书数量填写错误，正确应该为数字！");
		}
		catch(Exception f2)
		{
		}
	}
	/*
	 * 返回布尔数，用来判断ID是否重复，即在表中存在
	 */
	public boolean bookIdExitJudge(String bookId)
	{
		/*
		 * 用来查询的sql语句
		 */
		String sql = "select * from book where r_bookId='"+bookId+"'";
		ResultSet rs = dateBase.executeQuery(sql);
		/*
		 * 找到return TRUE，否则return FALSE
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
			JOptionPane.showMessageDialog(null, "数据库无法正常连接！");
		}
		return false;
	}
}
