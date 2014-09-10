package bookManager;
/*
 * 读者修改模块
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;
import java.text.*;
import java.util.*;
public class readerChange extends JFrame 
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
	Button readerChangeSearchButton;
	Button readerChangeButton;
	Button readerChangeCloseButton;
	/*
	 * 构造方法
	 */
	public readerChange()
	{
		//GUI设计
		this.setTitle("读者修改|乡村农家书屋图书借阅管理系统");
		this.setSize(800, 500);
		this.setLayout(null);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		readerIdSearchLabel = new Label("读者ID");
		readerIdLabel = new Label("读者ID");
		readerNameLabel = new Label("读者姓名");
		readerSexLabel = new Label("性   别");
		readerDayLabel = new Label("可借阅天数");
		readerChangeSearchButton = new Button("查   询");
		readerChangeButton = new Button("修改");
		readerChangeCloseButton = new Button("退  出");
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
		readerChangeSearchButton.setBounds(460, 140, 80, 25);
		readerChangeButton.setBounds(300, 320, 80, 25);
		readerChangeCloseButton.setBounds(420, 320, 80, 25);
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
		add(readerChangeSearchButton);
		add(readerChangeButton);
		add(readerChangeCloseButton);
		readerIdText.setEditable(false);
		/*
		 * 为查询按钮添加监控,执行readerChangeSearchActionPerformed(ActionEvent e)方法
		 */
		readerChangeSearchButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						readerChangeSearchActionPerformed(e);
					}
				}
				);
		/*
		 * 为修改按钮添加监控，执行readerChangeActionPerformed(ActionEvent e)方法
		 */
		readerChangeButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						readerChangeActionPerformed(e);
					}
				}
				);
		/*
		 * 为退出按钮添加监控，释放窗口
		 */
		readerChangeCloseButton.addActionListener(
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
	 * 用来查询的方法
	 */
	public void readerChangeSearchActionPerformed(ActionEvent e)
	{
		//得到查询文本框的内容
		String readerIdSearch = readerIdSearchText.getText();
		//查询编号为空的情况，返回提示
		if(readerIdSearch.equals(""))
		{
			JOptionPane.showMessageDialog(null, "查询时读者编号不允许为空");
			return;
		}
		try
		{
			//执行查询的sql语句
			String sql = "select * from reader where r_readerId='"+readerIdSearch+"'";
			ResultSet rs = dateBase.executeQuery(sql);
			//查到的情况
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
				JOptionPane.showMessageDialog(null, "在数据库中没有发现编号为" + readerIdSearch + "的读者");
			}
		}
		catch(SQLException g)
		{
			JOptionPane.showMessageDialog(null, "数据路无法连接！");
		}
	}
	/*
	 * 用来执行数据修改的方法
	 */
	public void readerChangeActionPerformed(ActionEvent e)
	{
		//得到文本框的内容
		String readerId = readerIdText.getText();
		String readerName = readerNameText.getText();
		String readerSex = readerSexText.getText();
		String readerDay = readerDayText.getText();
		int day;
		//默认最大可借阅天数为30，空返回30，其他的话转化为数字，否则抛出异常
		try
		{
		if(readerDay.equals(""))
		{
			day = 30;
		}
		else
		{
			day = Integer.parseInt(readerDay);
		}
		//执行数据库更新的sql语句
		String sql = "update reader set r_readerName='"+readerName+"'"
				+ ",r_readerSex='"+readerSex+"',r_readerDays='"+day+"' where "
						+ "r_readerId='"+readerId+"'";
		//进行数据库更新
		if(dateBase.executeUpdate(sql) == 1)
		{
			JOptionPane.showMessageDialog(null, "读者 "+readerId+"修改成功！");
		}
		}
		//抛出转化异常
		catch(NumberFormatException f1)
		{
			JOptionPane.showMessageDialog(null, "最大可借阅天数填写错误，正确应该为数字！");
		}
		catch(Exception e8)
		{
			
		}
	}
}
