package bookManager;
/*
 * 用来借阅读书的模块
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;
import java.util.*;
public class bookLeave extends JFrame 
{
	Label bookIdSearchLabel;
	Label bookIdLabel;
	Label bookNameLabel;
	Label bookPublishLabel;
	Label bookAuthorLabel;
	Label bookDateLabel;
	Label bookTranslatorLabel;
	TextField  bookIdSearchText;
	TextField bookIdText;
	TextField bookNameText;
	TextField bookPublishText;
	TextField bookAuthorText;
	TextField bookDateText;
	TextField bookTranslatorText;
	Label readerIdSearchLabel;
	Label readerIdLabel;
	Label readerNameLabel;
	Label readerSexLabel;
	Label  readerDayLabel;
	TextField readerIdSearchText;
	TextField readerIdText;
	TextField readerNameText;
	TextField readerSexText;
	TextField readerDayText;
	Label borrowIdLabel;
	Label borrowDayLabel;
	TextField borrowIdText;
	TextField borrowDayText;
	Button bookSearchButton;
	Button readerSearchButton;
	Button borrowButton;
	Button borrowCloseButton;
	/*
	 * 构造方法
	 */
	public bookLeave()
	{
		this.setTitle("读书借阅|乡村农家书屋图书借阅管理系统");
		this.setSize(800, 500);
		this.setLayout(null);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		bookIdSearchLabel = new Label("读书ID");
		bookIdLabel = new Label("读书ID");
		bookNameLabel = new Label("读书名称");
		bookPublishLabel = new Label("出版社");
		bookAuthorLabel = new Label("作   者");
		bookDateLabel = new Label("出版日期");
		bookTranslatorLabel = new Label("译者");
		bookIdSearchText = new TextField("");
		bookIdText = new TextField("");
		bookNameText = new TextField("");
		bookPublishText = new TextField("");
		bookAuthorText = new TextField("");
		bookDateText = new TextField("");
		bookTranslatorText = new TextField("");
		readerIdSearchLabel = new Label("读者ID");
		readerIdLabel  = new Label("读者ID");
		readerNameLabel  = new Label("读者姓名");
		readerSexLabel = new Label("性   别");
		readerDayLabel = new Label("最大可\n借阅天数");
		readerIdSearchText = new TextField("");
		readerIdText = new TextField("");
		readerNameText = new TextField("");
		readerSexText = new TextField("");
		readerDayText = new TextField("");
		borrowIdLabel = new Label("借阅ID");
		borrowDayLabel = new Label("借阅日期");
		borrowIdText = new TextField("");
		borrowDayText = new TextField("");
		bookSearchButton = new Button("查   询");
		readerSearchButton = new Button("查   询");
		borrowButton = new Button("确定借阅");
		borrowCloseButton = new Button("取  消");
		bookIdSearchLabel.setBounds(70, 30, 50, 20);
		bookIdLabel.setBounds(100, 90, 50, 20);
		bookNameLabel.setBounds(100, 120, 50, 20);
		bookPublishLabel.setBounds(100, 150, 50, 20);
		bookAuthorLabel.setBounds(100, 180, 50, 20);
		bookDateLabel.setBounds(100, 210, 50, 20);
		bookTranslatorLabel.setBounds(100, 240, 50, 20);
		readerIdSearchLabel.setBounds(400, 30, 50, 20);
		readerIdLabel.setBounds(430, 90, 50, 20);
		readerNameLabel.setBounds(430, 120, 50, 20);
		readerSexLabel.setBounds(430, 150, 50, 20);
		readerDayLabel.setBounds(430, 180, 90, 20);
		borrowIdLabel.setBounds(120, 330, 50, 20);
		borrowDayLabel.setBounds(400, 330, 50, 20);
		bookIdSearchText.setBounds(140, 30, 160, 20);
		bookIdText.setBounds(170, 90, 160, 20);
		bookNameText.setBounds(170, 120, 160, 20);
		bookPublishText.setBounds(170, 150, 160, 20);
		bookAuthorText.setBounds(170, 180, 160, 20);
		bookDateText.setBounds(170, 210, 160, 20);
		bookTranslatorText.setBounds(170, 240, 160, 20);
		readerIdSearchText.setBounds(470, 30, 160, 20);
		readerIdText.setBounds(530, 90, 160, 20);
		readerNameText.setBounds(530, 120, 160, 20);
		readerSexText.setBounds(530, 150, 160, 20);
		readerDayText.setBounds(530, 180, 160, 20);
		borrowIdText.setBounds(190, 330, 160, 20);
		borrowDayText.setBounds(470, 330, 160, 20);
		bookSearchButton.setBounds(310, 30, 80, 25);
		readerSearchButton.setBounds(640, 30, 80, 25);
		borrowButton.setBounds(220, 390, 80, 25);
		borrowCloseButton.setBounds(440, 390, 80, 25);
		add(bookIdSearchLabel);
		add(bookIdLabel);
		add(bookNameLabel);
		add(bookPublishLabel);
		add(bookAuthorLabel);
		add(bookDateLabel);
		add(bookTranslatorLabel);
		add(bookIdSearchText);
		add(bookIdText);
		add(bookNameText);
		add(bookPublishText);
		add(bookAuthorText);
		add(bookDateText);
		add(bookTranslatorText);
		add(readerIdSearchLabel);
		add(readerIdLabel);
		add(readerNameLabel);
		add(readerSexLabel);
		add(readerDayLabel);
		add(readerIdSearchText);
		add(readerIdText);
		add(readerNameText);
		add(readerSexText);
		add(readerDayText);
		add(borrowIdLabel);
		add(borrowDayLabel);
		add(borrowIdText);
		add(borrowDayText);
		add(bookSearchButton);
		add(readerSearchButton);
		add(borrowButton);
		add(borrowCloseButton);
		//TextField不可被编辑
		bookIdText.setEnabled(false);
		bookNameText.setEnabled(false);
		bookPublishText.setEnabled(false);
		bookAuthorText.setEnabled(false);
		bookDateText.setEnabled(false);
		bookTranslatorText.setEnabled(false);
		readerIdText.setEnabled(false);
		readerNameText.setEnabled(false);
		readerSexText.setEnabled(false);
		readerDayText.setEnabled(false);
		/*
		 * 为书籍查询按钮添加监控，执行bookSearchButtonActionPerformed(ActionEvent e)方法
		 */
		bookSearchButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						bookSearchButtonActionPerformed(e);
					}
				}
				);
		/*
		 * 为读者查询添加监控，执行readerSearchButtonActionPerformed(ActionEvent e)方法
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
		 * 为借阅按钮添加监控，执行borrowButtonActionPerformed(ActionEvent e)方法
		 */
		borrowButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						borrowButtonActionPerformed(e);
					}
				}
				);
		/*
		 * 为退出按钮添加监控，执行释放窗口操作
		 */
		borrowCloseButton.addActionListener(
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
	 * 用来查询书籍的方法
	 */
	public void bookSearchButtonActionPerformed(ActionEvent e)
	{
		//得到书籍ID
		String bookId = bookIdSearchText.getText();
		//书籍ID为空的情况，返回提示
		if(bookId.equals(""))
		{
			JOptionPane.showMessageDialog(null, "查询时图书编号不允许为空");
			return;
		}
		//用来查询的sql语句
		String sql = "select * from book where r_bookId='"+bookId+"'";
		try
		{
			//执行数据库查询
			ResultSet rs = dateBase.executeQuery(sql);
			//查到的情况
			if(rs.next())
			{
				bookIdText.setText(rs.getString("r_bookId"));
				bookNameText.setText(rs.getString("r_bookName"));
				bookPublishText.setText(rs.getString("r_bookPublish"));
				bookAuthorText.setText(rs.getString("r_bookAuthor"));
				bookDateText.setText(rs.getString("r_bookDate"));
				bookTranslatorText.setText(rs.getString("r_bookTranslator"));
			}
			//没有查到的情况
			else
			{
				JOptionPane.showMessageDialog(null, "没有查到该书籍");
			}
		}
		//抛出SQL异常
		catch(SQLException g)
		{
			JOptionPane.showMessageDialog(null, "数据路无法连接！");
		}
	}
	/*
	 * 用来执行读者查询的方法，基本和前面用来查询读书的方法一样
	 */
	public void readerSearchButtonActionPerformed(ActionEvent e)
	{
		//得到ID
		String readerId = readerIdSearchText.getText();
		//ID为空的情况
		if(readerId.equals(""))
		{
			JOptionPane.showMessageDialog(null, "读者查询时不允许为空");
			return;
		}
		//执行查询操作的sql语句
		String sql = "select * from reader where r_readerId='"+readerId+"'";
		try
		{
			//执行数据库查询
			ResultSet rs = dateBase.executeQuery(sql);
			//查到的情况
			if(rs.next())
			{
				readerIdText.setText(rs.getString("r_readerId"));
				readerNameText.setText(rs.getString("r_readerName"));
				readerSexText.setText(rs.getString("r_readerSex"));
				readerDayText.setText(rs.getString("r_readerDays"));
			}
			//没哟查到的情况
			else
			{
				JOptionPane.showMessageDialog(null, "没有查询到该图书");
			}
		}
		//抛出数据库异常
		catch(SQLException e1)
		{
			JOptionPane.showMessageDialog(null, "数据路无法连接！" + e1);
		}
	}
	/*
	 * 用来执行借阅这一动作的方法
	 */
	public void borrowButtonActionPerformed(ActionEvent e)
	{
		//得到所需要的参数
		String borrowId = borrowIdText.getText();
		String borrowDay = borrowDayText.getText();
		String borrowName = readerNameText.getText();
		String borrowBook = bookNameText.getText();
		String borrowDays = readerDayText.getText();
		//borrowId为空的情况，返回提示
		if(borrowId.equals(""))
		{
			JOptionPane.showMessageDialog(null, "借阅ID不能为空！");
			return;
		}
		//判断borrowId是否已经存在
		if(borrowIdJudgeExit(borrowId))
		{
			JOptionPane.showMessageDialog(null, "改借阅ID已经存在");
			return;
		}
		//默认借阅天数为2014/08/01
		if(borrowDay.equals(""))
		{
			borrowDay = "2014/08/01";	
		}
		//执行插入的sql语句
		String sql = "insert into borrow(r_borrowId, r_borrowName,"
				+ "r_borrowBook, r_borrowDay, r_borrowDays) "
				+ " values ('"+borrowId+"', '"+borrowName+"', '"+borrowBook+"',"
						+ "'"+borrowDay+"', '"+borrowDays+"')";
		//数据库更新成功，返回1
		if(dateBase.executeUpdate(sql) == 1)
		{
			JOptionPane.showMessageDialog(null, "借书记录添加成功！");
		}
	}
	public boolean borrowIdJudgeExit(String borrowId)
	{
		/*
		 * 用来查询的sql语句
		 */
		String sql = "select * from borrow where r_borrowId='"+borrowId+"'";
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
