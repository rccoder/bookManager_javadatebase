package bookManager;
/*
 * 修改图书模块
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class bookChange extends JFrame
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
	Button bookChangeSearchButton;
	Button bookChangeSaveButton;
	Button bookChangeCloseButton;
	public bookChange()
	{
		/*
		 * GUI设计
		 */
		this.setTitle("修改图书|乡村农家书屋图书借阅管理系统");
		this.setSize(800, 500);
		this.setLayout(null);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		bookIdSearchLabel = new Label("图书ID");
		bookIdLabel = new Label("图书ID");
		bookNameLabel = new Label("图书名称");
		bookAuthorLabel = new Label("作    者");
		bookTypeLabel = new Label("图书类别");
		bookPublishLabel = new Label("出 版 社");
		bookDateLabel = new Label("出版日期");
		bookTranslatorLabel = new Label("译    者");
		bookPriceLabel = new Label("定    价");
		bookNumberLabel = new Label("图书数量");
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
		bookChangeSaveButton = new Button("确定修改");
		bookChangeCloseButton = new Button("退   出");
		bookChangeSearchButton = new Button("查    询");
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
		bookChangeSearchButton.setBounds(460, 90, 80, 25);
		bookChangeSaveButton.setBounds(300, 330, 80, 25);
		bookChangeCloseButton.setBounds(420, 330, 80, 25);
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
		add(bookChangeSearchButton);
		add(bookChangeSaveButton);
		add(bookChangeCloseButton);
		//查询后bookIdText不可写
		bookIdText.setEditable(false);
		/*
		 * 为按照ID进行查询的按钮添加监控，执行bookChangeSearchActionPerformed(ActionEvent e)方法
		 */
		bookChangeSearchButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						bookChangeSearchActionPerformed(e);
					}
				}
				);
		/*
		 * 查询后进行修改，提交保存，添加监控，执行bookChangeSaveActionPerformed(ActionEvent e)方法
		 */
		bookChangeSaveButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						bookChangeSaveActionPerformed(e);
					}
				}
				);
		/*
		 * 窗口关闭按钮
		 */
		bookChangeCloseButton.addActionListener(
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
	 * 用来进行按照ID查询的方法
	 */
	public void bookChangeSearchActionPerformed(ActionEvent e)
	{
		//或者要查询的ID
		String searchId = bookIdSearchText.getText();
		if(searchId.equals(""))
		{
			JOptionPane.showMessageDialog(null, "查询时图书编号不允许为空");
			return;
		}
		try
		{
			String sql = "select * from book where r_bookId='"+searchId+"'";
			//数据库查询
			ResultSet rs = dateBase.executeQuery(sql);
			//查到数据，进行更新
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
			//没有该图书，返回提示
			else
			{
				JOptionPane.showMessageDialog(null, "在数据库中没有发现编号为" + searchId + "的图书");
			}
		}
		catch(SQLException g)
		{
			JOptionPane.showMessageDialog(null, "数据路无法连接！");
		}
	}
	/*
	 * 更改数据后用来提交的方法
	 */
	public void bookChangeSaveActionPerformed(ActionEvent e)
	{
		//或者所需值
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
		try
		{
			//空表示默认，不为转化为相应内型
			if(bookPrice.equals(""))
			{
				price = 58;
			}
			else
			{
				price = Float.parseFloat(bookPrice);
			}
			if(bookNumber.equals(""))
			{
				number = 10;
			}
			else
			{
				number = Integer.parseInt(bookNumber);
			}
			//更新数据库的sql语句
			String sql = "update book set r_bookName='"+bookName+"'"
					+ ",r_bookType='"+bookType+"',r_bookPublish='"+bookPublish+"',"
							+ "r_bookDate='"+bookDate+"', r_bookTranslator='"+bookTranslator+"',"
									+ "r_bookPrice='"+price+"', r_bookAuthor='"+bookAuthor+"',"
											+ "r_bookNumber='"+number+"' where r_bookId='"+bookId+"'";
			//更新成功，返回1
			if(dateBase.executeUpdate(sql) == 1)
			{
				JOptionPane.showMessageDialog(null, "图书修改成功！");
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
			System.out.println(f2);
		}
	}
}
