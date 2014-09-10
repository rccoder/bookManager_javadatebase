package bookManager;
/*
 * 增加读者的模块
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class readerAdd extends JFrame 
{
	Label readerIdLabel;
	Label readerNameLabel;
	Label readerSexLabel;
	Label  readerDayLabel;
	TextField readerIdText;
	TextField readerNameText;
	TextField readerSexText;
	TextField readerDayText;
	Button readerAddButton;
	Button readerAddCloseButton;
	public readerAdd()
	{
		//GUI设计
		this.setTitle("读者注册|乡村农家书屋图书借阅管理系统");
		this.setSize(800, 500);
		this.setLayout(null);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		readerIdLabel = new Label("读者ID");
		readerNameLabel = new Label("读者姓名");
		readerSexLabel = new Label("读者性别");
		readerDayLabel = new Label("可借阅天数");
		readerIdText = new TextField("");
		readerNameText = new TextField("");
		readerSexText = new TextField("");
		readerDayText = new TextField("");
		readerAddButton = new Button("确定注册");
		readerAddCloseButton = new Button("取   消");
		readerIdLabel.setBounds(170, 100, 50, 20);
		readerNameLabel.setBounds(410, 100, 50, 20);
		readerSexLabel.setBounds(170, 130, 50, 20);
		readerDayLabel.setBounds(410, 130, 50, 20);
		readerIdText.setBounds(230, 100, 160, 20);
		readerNameText.setBounds(470, 100, 160, 20);
		readerSexText.setBounds(230, 130, 160, 20);
		readerDayText.setBounds(470, 130, 160, 20);
		readerAddButton.setBounds(300, 200, 80, 25);
		readerAddCloseButton.setBounds(420, 200, 80, 25);
		add(readerIdLabel);
		add(readerNameLabel);
		add(readerSexLabel);
		add(readerDayLabel);
		add(readerIdText);
		add(readerNameText);
		add(readerSexText);
		add(readerDayText);
		add(readerAddButton);
		add(readerAddCloseButton);
		/*
		 * 读者增加按钮进行的监控，执行readerAddActionPerformed(ActionEvent e)的方法
		 */
		readerAddButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						readerAddActionPerformed(e);
					}
				}
				);
		/*
		 * 为退出按钮添加监控
		 */
		readerAddCloseButton.addActionListener(
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
	 * 点击增加后执行的方法
	 */
	public void readerAddActionPerformed(ActionEvent e)
	{
		//获得所需要的文本
		String readerId = readerIdText.getText();
		String readerName = readerNameText.getText();
		String readerSex = readerSexText.getText();
		String readerDay = readerDayText.getText();
		int day;
		//读者ID为空报错弹窗提示
		if(readerId.equals(""))
		{

			JOptionPane.showMessageDialog(null, "读者ID不能为空！");
			return;
		}
		//读者ID重复，执行返回布尔数的方法readerIdExitJudge(boolean readerId)
		if(readerIdExitJudge(readerId))
		{
			JOptionPane.showMessageDialog(null, "读者ID不能重复！");
			return;
		}
		try
		{
		//默认最大可借阅天数为30，否则，字符串转化为数字
		if(readerDay.equals(""))
		{
			day = 30;
		}
		else
		{
			day = Integer.parseInt(readerDay);
		}
		//插入数据库的sql语句
		String sql = "insert into reader(r_readerId, r_readerName, r_readerSex, r_readerDays)"
				+ " values ('"+readerId+"', '"+readerName+"', '"+readerSex+"'"
						+ ",'"+day+"')";
		//更新成功返回1，并且清空屏幕文本框内容
		if(dateBase.executeUpdate(sql) == 1)
		{
			JOptionPane.showMessageDialog(null, "读者添加成功！");
		    readerIdText.setText("");
			readerNameText.setText("");
			readerSexText.setText("");
			readerSexText.setText("");
		}
	}
	//最大可借阅天数产生问题，抛出错误
	catch(NumberFormatException f1)
	{
		JOptionPane.showMessageDialog(null, "可借阅天数错误，正确应该为数字！");
	}
	catch(Exception f2)
	{
		System.out.println(f2);
	}
	}
	/*
	 * 判断读者ID是否重复，返回布尔数
	 */
	public boolean readerIdExitJudge(String readerId)
	{
		String sql = "select * from reader where r_readerId='"+readerId+"'";
		ResultSet rs = dateBase.executeQuery(sql);
		try
		{
			//重复，即在数据库中找到这个ID，返回true,否则返回false
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
