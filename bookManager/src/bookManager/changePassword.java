package bookManager;
/*
 * 登录用户修改密模块，需要输入旧密码进行验证
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class changePassword extends JFrame
{
	Label useNameLabel;
	Label useOldPasswordLabel;
	Label useNewPasswordLabel;
	TextField useNameText;
	TextField useOldPasswordText;
	TextField useNewPasswordText;
	Button changePasswordButton;
	Button changePasswordCloseButton;
	public changePassword()
	{
		this.setTitle("修改密码|乡村农家书屋图书借阅管理系统");
		this.setSize(800, 500);
		this.setLayout(null);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		useNameLabel = new Label("用户姓名");
		useOldPasswordLabel = new Label("请输入旧密码");
		useNewPasswordLabel = new Label("请输入新密码");
		useNameText = new TextField(globalUsename.login_user);
		useOldPasswordText = new TextField("");
		useNewPasswordText = new TextField("");
		changePasswordButton = new Button("确定修改");
		changePasswordCloseButton = new Button("退   出");
		useNameLabel.setBounds(280, 100, 50, 20);
		useOldPasswordLabel.setBounds(280, 130, 50, 20);
		useNewPasswordLabel.setBounds(280, 160, 50, 20);
		useNameText.setBounds(350, 100, 160, 20);
		useOldPasswordText.setBounds(350, 130, 160, 20);
		useNewPasswordText.setBounds(350, 160, 160, 20);
		changePasswordButton.setBounds(310, 200, 80, 25);
		changePasswordCloseButton.setBounds(410, 200, 80, 25);
		useNameText.setEnabled(false);
		add(useNameLabel);
		add(useOldPasswordLabel);
		add(useNewPasswordLabel);
		add(useNameText);
		add(useOldPasswordText);
		add(useNewPasswordText);
		add(changePasswordButton);
		add(changePasswordCloseButton);
		JOptionPane.showMessageDialog(null, "注意：密码修改完成后需要重新登录");
		/*
		 * 为修改按钮添加监控，执行changePasswordActionPerofrmed(ActionEvent e)方法
		 */
		changePasswordButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						changePasswordActionPerformed(e);
					}
				}
				);
		
		/*
		 * 为关闭按钮添加监听，释放窗口
		 */
		changePasswordCloseButton.addActionListener(
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
	 * 用于旧密码的验证方法
	 */
	public void changePasswordActionPerformed(ActionEvent e)
	{
		String oldPassword = useOldPasswordText.getText();
		try
		{
			/*
			 * 在登录之后就把登录用户储存在globalUsename类中的Login_user静态变量中，这里用于数据库的验证
			 */
			String sql = "select * from user where r_username='"+globalUsename.login_user+"'";
			System.out.println(sql);
			ResultSet rs = dateBase.executeQuery(sql);
			System.out.println(1);
			System.out.println(rs);
			/*
			 * 验证成功，取得数据库中的密码
			 */
			if(rs.next())
			{
				/*
				 * 数据库中的密码与输入的密码相同的情况下进行下一步方法的执行，即changePasswordButton()方法
				 */
				if(oldPassword.equals(rs.getString("r_password")))
				{
					changePasswordButton();
				}
				/*
				 * 不一致的情况，返回旧密码输入错误的提示
				 */
				else
				{
					JOptionPane.showMessageDialog(null, "旧密码输入错误");
				}
			}
		
			/*
			 * 关闭数据库连接
			 */
			dateBase.Close();
		}
		catch(SQLException g)
		{
			JOptionPane.showMessageDialog(null, "数据路无法连接！" + g);
		}
		catch(Exception h)
		{
			System.out.println(h);
		}
	}
	/*
	 * 就密码验证成功并且正确后执行的方法，用于新密码在数据库中的写入
	 */
	public void changePasswordButton()
	{
		/*
		 * 获得新密码
		 */
		String newPassword = useNewPasswordText.getText();
		String sql = "update user set r_password='"+newPassword+"' "
				+ " where r_username='"+globalUsename.login_user+"'";
		/*
		 * 执行数据库的更新，如果顺利更新，返回提示为1，弹出修改成功的提示
		 */
		if(dateBase.executeUpdate(sql) == 1)
		{
			JOptionPane.showMessageDialog(null, globalUsename.login_user+"密码 修改成功！");
			System.exit(0);
		}
		dateBase.Close();
	}
}
