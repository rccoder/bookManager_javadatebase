package bookManager;
/*
 * 读者注销模块
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class readerDelete extends JFrame 
{
	Label readerIdSearchLabel;
	Label readerIdLabel;
	Label readerNameLabel;
	Label readerSexLabel;
	Label readerDayLabel;
	TextField readerIdSearchText;
	TextField readerIdText;
	TextField readerNameText;
	TextField readerSexText;
	TextField readerDayText;
	Button readerDeleteSearchButton;
	Button readerDeleteButton;
	Button readerDeleteCloseButton;
	
	public readerDelete()
	{
		//GUI设计
		this.setTitle("读者注销|乡村农家书屋图书借阅管理系统");
		this.setSize(800, 500);
		this.setLayout(null);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		readerIdSearchLabel = new Label("读者ID");
		readerIdLabel = new Label("读者ID");
		readerNameLabel = new Label("读者姓名");
		readerSexLabel = new Label("性   别");
		readerDayLabel = new Label("可借阅天数");
		readerDeleteSearchButton = new Button("查   询");
		readerDeleteButton = new Button("确定删除");
		readerDeleteCloseButton = new Button("退  出");
		readerIdSearchText = new TextField("");
		readerIdText = new TextField("");
		readerNameText = new TextField("");
		readerSexText = new TextField("");
		readerDayText = new TextField("");
		readerIdSearchLabel.setBounds(280, 100, 50, 20);
		readerIdLabel.setBounds(170, 220, 50 ,20);
		readerNameLabel.setBounds(410, 220, 50, 20);
		readerSexLabel.setBounds(170, 250, 50, 20);
		readerDayLabel.setBounds(410, 250, 50, 20);
		readerIdSearchText.setBounds(340, 100, 160, 20);
		readerIdText.setBounds(230, 220, 160, 20);
		readerNameText.setBounds(470, 220, 160, 20);
		readerSexText.setBounds(230, 250, 160, 20);
		readerDayText.setBounds(470, 250, 160, 20);
		readerDeleteSearchButton.setBounds(460, 140, 80, 25);
		readerDeleteButton.setBounds(300, 320, 80, 25);
		readerDeleteCloseButton.setBounds(420, 320, 80, 25);
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
		add(readerDeleteSearchButton);
		add(readerDeleteButton);
		add(readerDeleteCloseButton);
		readerIdText.setEditable(false);
		readerNameText.setEditable(false);
		readerSexText.setEditable(false);
		readerDayText.setEditable(false);
		/*
		 * 为查询按钮添加监控，执行readerDeleteSearchActionPerformed(ActionEvent e)方法
		 */
		readerDeleteSearchButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						readerDeleteSearchActionPerformed(e);
					}
				}
				);
		/*
		 * 为删除按钮添加监控，执行readerDeleteActionPerformed(ActionEvent e)方法
		 */
		readerDeleteButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						readerDeleteActionPerformed(e);
					}
				}
				);
		/*
		 * 为退出按钮添加监控，释放窗口
		 */
		readerDeleteCloseButton.addActionListener(
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
	 *用来执行数据查询的方法
	 */
	public void readerDeleteSearchActionPerformed(ActionEvent e)
	{
		//得到查询ID
		String readerIdSearch = readerIdSearchText.getText();
		//ID为空的时候，弹出提示
		if(readerIdSearch.equals(""))
		{
			JOptionPane.showMessageDialog(null, "查询时图书编号不允许为空");
			return;
		}
		try
		{
			//执行查询数据库的sql语句
			String sql = "select * from reader where r_readerId='"+readerIdSearch+"'";
			ResultSet rs = dateBase.executeQuery(sql);
			//查到的情况，填满文本框
			if(rs.next())
			{
				readerIdText.setText(rs.getString("r_readerId"));
				readerNameText.setText(rs.getString("r_readerName"));
				readerSexText.setText(rs.getString("r_readerSex"));
				readerDayText.setText(rs.getString("r_readerDays"));
			}
			//没有查到，返回提示
			else
			{
				JOptionPane.showMessageDialog(null, "没有找到这样的读者");
			}
		}
		//抛出SQL异常
		catch(SQLException g)
		{
			JOptionPane.showMessageDialog(null, "数据路无法连接！");
		}
	}
	/*
	 * 用来执行删除的方法
	 */
	public void readerDeleteActionPerformed(ActionEvent e)
	{
		//获得ID
		String readerId = readerIdText.getText();
		//执行删除的sql语句
		String sql = "delete from reader where r_readerId='"+readerId+"'";
		//数据库更新成功，返回1
		if(dateBase.executeUpdate(sql) == 1)
		{
			JOptionPane.showMessageDialog(null, "读者 "+readerId+"删除成功！");
			readerIdText.setText("");
			readerNameText.setText("");
			readerSexText.setText("");
			readerDayText.setText("");
		}
	}
}
