package bookManager;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
/*
 * 书籍查询功能，将以表格的形式展示
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
		this.setTitle("书籍查询|乡村农家书屋图书借阅管理系统");
		this.setSize(800, 500);
		this.setLayout(null);
		//窗口可见
		this.setVisible(true);
		//使界面居中
		this.setLocationRelativeTo(null);
		bookNameLabel = new Label("图书名称");
		bookAuthorLabel = new Label("作      者");
		bookPublishLabel = new Label("出 版 社");
		bookTypeLabel = new Label("图书类别");
		bookNameText = new TextField("");
		bookAuthorText = new TextField("");
		bookPublishText = new TextField("");
		bookTypeText = new TextField("");
		searchButton = new Button("查   询");
		closeButton = new Button("关   闭");
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
		 * 给查询按钮添加监听，调用searchButtonActionPerformed(ActionEvent e)方法
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
		 * 关闭数据库连接，释放窗口
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
	 * 点击查询按钮后执行的方法
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
			 * 为后面绘制表格时的表头做准备
			 */
			String[] bookTableHead = {"图书ID", "图书名称", "作者", 
					"类型", "出版社", "出版日期", "图书价格", "译者"};
			/*
			 * 对每一个TextField进行getText，然后判断否为空，根据情况写出正确的sql语句，使用模糊查找
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
			 * 有sql语句生成的情况，即至少有一个TextField不为空
			 */
			if(!sql5.equals(""))
			{
				sql = sql + " where " + sql5;
			}
			/*
			 * 几个TextfField全部为空，进行return，不开始查询
			 */
			else
			{
				JOptionPane.showMessageDialog(null, "查询条件为空，请重新输入");
				return;
			}
			ResultSet rs = dateBase.executeQuery(sql);
			/*
			 * 创建bookTable的对象，默认表格有20行，列数为bookTableHead.length的长度
			 */
			Object[][] bookTable = new Object[20][bookTableHead.length];
			int i = 0;
			//flag初始值为0.如果执行了rs.next()，则说明按照查找条件匹配到了图书，flag将变为1，如果没有找到，则为0，执行下面的if判断
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
				JOptionPane.showMessageDialog(null, "没有找到所要类型的图书");
			}
			//创建表格，添加JScrollPane。
			JTable table = new JTable(bookTable, bookTableHead);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(20, 140, 760, 300);
			flag = 0;
			add(scrollPane);
		}
		catch(SQLException b)
		{
			JOptionPane.showMessageDialog(null, "数据库访问错误！");
			System.exit(0);
		}
	}
}
