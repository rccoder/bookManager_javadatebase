package bookManager;
/*
 * 图书归还模块
 */
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class borrowCome extends JFrame 
{
		Label borrowIdSearchLabel;
		Label borrowIdLabel;
		Label borrowNameLabel;
		Label borrowBookLabel;
		Label borrowDayLabel;
		Label borrowDaysLabel;
		TextField  borrowIdSearchText;
		TextField borrowIdText;
		TextField borrowNameText;
		TextField borrowBookText;
		TextField borrowDayText;
		TextField borrowDaysText;
		Button borrowIdSearchButton;
		Button borrowComeButton;
		Button borrowComeCloseButton;
		/*
		 * 构造方法
		 */
		public borrowCome()
		{
			this.setTitle("借阅归还|乡村农家书屋图书借阅管理系统");
			this.setSize(800, 500);
			this.setLayout(null);
			this.setVisible(true);
			borrowIdSearchLabel = new Label("借阅ID");
			borrowIdLabel = new Label("借阅ID");
			borrowNameLabel = new Label("借阅人");
			borrowBookLabel = new Label("借阅书籍");
			borrowDayLabel = new Label("借阅日期");
			borrowDaysLabel = new Label("可借阅天数");
			borrowIdSearchButton = new Button("查 询");
			borrowComeButton  = new Button("确定归还");
			borrowComeCloseButton = new Button("退    出");
			borrowIdSearchText = new TextField("");
			borrowIdText = new TextField("");
			borrowNameText = new TextField("");
			borrowBookText = new TextField("");
			borrowDayText = new TextField("");
			borrowDaysText = new TextField("");
			borrowIdSearchLabel.setBounds(240, 50, 50, 20);
			borrowIdLabel.setBounds(140, 160, 50, 20);
			borrowNameLabel.setBounds(400, 160, 50, 20);
			borrowBookLabel.setBounds(140, 190, 50, 20);
			borrowDayLabel.setBounds(400, 190, 50, 20);
			borrowDaysLabel.setBounds(140, 220, 50, 20);
			borrowIdSearchText.setBounds(310, 50, 160, 20);
			borrowIdText.setBounds(210, 160, 160, 20);
			borrowNameText.setBounds(470, 160, 160, 20);
			borrowBookText.setBounds(210, 190, 160, 20);
			borrowDayText.setBounds(470, 190, 160, 20);
			borrowDaysText.setBounds(210, 220, 160, 20);
			borrowIdSearchButton.setBounds(490, 80, 85, 25);
			borrowComeButton.setBounds(220, 330, 85,25);
			borrowComeCloseButton.setBounds(440, 330, 85, 25);
			add(borrowIdSearchLabel);
			add(borrowIdLabel);
			add(borrowNameLabel);
			add(borrowBookLabel);
			add(borrowDayLabel);
			add(borrowDaysLabel);
			add(borrowIdSearchText);
			add(borrowIdText);
			add(borrowNameText);
			add(borrowBookText);
			add(borrowDayText);
			add(borrowDaysText);
			add(borrowIdSearchButton);
			add(borrowComeButton);
			add(borrowComeCloseButton);
			borrowIdText.setEnabled(false);
			borrowNameText.setEnabled(false);
			borrowBookText.setEnabled(false);
			borrowDayText.setEnabled(false);
			borrowDaysText.setEnabled(false);
			/*
			 * 为借阅ID查询按钮添加监控，执行borrowIdSearchButtonActionPerformed(ActionEvent e)方法
			 */
			borrowIdSearchButton.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							borrowIdSearchButtonActionPerformed(e);
						}
					}
					);
			/*
			 * 为归还按钮添加监控，执行borrowComeButtonActionPerformed(ActionEvent e)方法
			 */
			borrowComeButton.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							borrowComeButtonActionPerformed(e);
						}
					}
					);
			/*
			 * 为退出按钮添加监控，执行释放窗口操作
			 */
			borrowComeCloseButton.addActionListener(
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
		 * 执行查询操作的方法
		 */
		public void borrowIdSearchButtonActionPerformed(ActionEvent e)
		{
			//得到ID
			String borrowId = borrowIdSearchText.getText();
			//ID为空的情况
			if(borrowId.equals(""))
			{
				JOptionPane.showMessageDialog(null, "查询ID不能为空");
			}
			//执行查询操作的sql语句
			String sql = "select * from borrow where r_borrowId='"+borrowId+"'";
			//执行数据库查询
			ResultSet rs = dateBase.executeQuery(sql);
			try
			{
				//查到的情况
				if(rs.next())
				{
					borrowIdText.setText(rs.getString("r_borrowId"));
					borrowNameText.setText(rs.getString("r_borrowName"));
					borrowBookText.setText(rs.getString("r_borrowBook"));
					borrowDayText.setText(rs.getString("r_borrowDay"));
					borrowDaysText.setText(rs.getString("r_borrowDays"));
				}
				//查不到的情况
				else
				{
					JOptionPane.showMessageDialog(null, "查不到该次借阅记录");
				}
			}
			//抛出SQL异常
			catch(SQLException e1)
			{
				JOptionPane.showMessageDialog(null, "数据库连接错误");
			}
		}
		/*
		 * 执行归还，删除借阅记录的方法
		 */
		public void borrowComeButtonActionPerformed(ActionEvent e)
		{
			//得到borrowId
			String borrowId = borrowIdText.getText();
			//执行删除操作的sql语句
			String sql = "delete from borrow where r_borrowId='"+borrowId+"'";
			if(dateBase.executeUpdate(sql) == 1)
			{
				JOptionPane.showMessageDialog(null, "还书成功");
			}
		}
}
