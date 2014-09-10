package bookManager;
/*
 * 图书删除模块
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
	//构造方法
	public bookDelete()
	{
		//GUI设计
		this.setTitle("删除图书|乡村农家书屋图书借阅管理系统");
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
		bookDeleteButton = new Button("确定删除");
		bookDeleteCloseButton = new Button("退   出");
		bookDeleteSearchButton = new Button("查    询");
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
		//查询后TextField不可写
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
		 * 为查询按钮添加监控，执行bookDeleteSearchActionPerformed(ActionEvent e)方法
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
		 * 为删除按钮添加监控，执行bookChangeSaveActionPerformed(ActionEvent e)方法
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
		 * 为退出按钮添加监控，执行dispose释放窗口操作
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
	 * 点击查询时执行的方法
	 */
	public void bookDeleteSearchActionPerformed(ActionEvent e)
	{
		//获得查询编号
		String searchId = bookIdSearchText.getText();
		//编号为空，返回提示
		if(searchId.equals(""))
		{
			JOptionPane.showMessageDialog(null, "查询时图书编号不允许为空");
			return;
		}
		try
		{
			//查询的sql语句
			String sql = "select * from book where r_bookId='"+searchId+"'";
			//数据库查询
			ResultSet rs = dateBase.executeQuery(sql);
			//能查到的情况
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
			//无法查到，返回提示
			else
			{
				JOptionPane.showMessageDialog(null, "没有查询到该图书");
			}
		}
		catch(SQLException g)
		{
			JOptionPane.showMessageDialog(null, "数据路无法连接！");
		}
	}
	//点击删除时执行的操作
	public void bookChangeSaveActionPerformed(ActionEvent e)
	{
		String bookId = bookIdText.getText();
		String sql = "delete from book where r_bookId='"+bookId+"'";
		if(dateBase.executeUpdate(sql) == 1)
		{
			//返回删除成功的提示并且清空屏幕
			JOptionPane.showMessageDialog(null, "图书 "+bookId+"删除成功！");
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
