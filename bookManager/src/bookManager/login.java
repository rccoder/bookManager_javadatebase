package bookManager;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;
/*
 * 登录界面
 * 用户名和密码存在user这张表中，登录时进行匹配，成功这显示登录成功，
 * 同时给show类中的方法adminJudge(String is_admin)传参，以验证是否为管理员
 */
public class login extends Frame
{
	TextField usename;
	TextField password;
	Label usenameLabel;
	Label passwordLabel;
	Button butOk;
	Button butRe;
	public  login()
	{
		this.setTitle("登录|乡村农家书屋图书借阅管理系统");
		this.setSize(260, 170);
		this.setVisible(true);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		usenameLabel = new Label("用户名");
		passwordLabel = new Label("密码");
		butOk = new Button("登录");
		butRe = new Button("取消");
		usename = new TextField();
		password = new TextField();
		usenameLabel.setBounds(40, 53, 60, 20);
		passwordLabel.setBounds(40, 83, 60, 20);
		usename.setBounds(100, 50, 120, 20);
		password.setBounds(100, 80, 120, 20);
		butOk.setBounds(45, 120, 80, 25);
		butRe.setBounds(135, 120, 80, 25);
		add(usenameLabel);
		add(passwordLabel);
		add(usename);
		add(password);
		add(butOk);
		add(butRe);
		butOk.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						butOkActionPerformed(e);
					}
				}
				);
		butRe.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						dateBase.Close();
						dispose();
					}
				}
				);
		addWindowListener(
				new WindowAdapter()
				{
					public void windowClosing(WindowEvent e)
					{
						dateBase.Close();
						System.exit(0);
					}
				}
				);
	}
	/*
	 * 点击登录后进行的动作
	 */
	public void butOkActionPerformed(ActionEvent e)
	{
		String user = usename.getText();
		String pass = password.getText();
		System.out.println(user);
		System.out.println(pass);
		String is_admin;
		/*
		 * 用户名或密码为空的时候提示
		 */
		if(user.equals("") || pass.equals(""))
		{
			JOptionPane.showMessageDialog(null, "用户名或密码不能为空 ");
			return;
		}
		/*
		 * 查询数据库，当用户名和密码都在的时候进行匹配，在user这张表中
		 */
		try
		{
			String sql = "select * from user where r_username="
					+ "'"+user+"' and r_password="
							+ "'"+pass+"'";
			ResultSet rs = dateBase.executeQuery(sql);
			if(rs.next())
			{
				is_admin = rs.getString("r_is_admin");
			}
			/*
			 * 查询不到的时候显示错误
			 */
			else
			{
				JOptionPane.showMessageDialog(null, "用户名或密码错误 ");
				return;
			}
			/*
			 * 把user做为静态变量，保存在globalUsename中的静态量Login_user中，方便后面的密码修改等
			 */
			globalUsename.login_user = user;
			/*
			 * 调用show
			 */
			show SHOW = new show();
			/*
			 * 给show中的adminJudge(String is_admin)方法传参，验证是否为管理员
			 */
			SHOW.adminJudge(is_admin);
			/*
			 * dispose这个窗口
			 */
			dispose();
		}
		/*
		 * 抛出异常
		 */
		catch(SQLException q)
		{
			System.out.println(q);
			JOptionPane.showMessageDialog(null, "无法连接数据库" + q);
		}
	}
	public static void main(String[] args)
	{
		new login();
	}
}
