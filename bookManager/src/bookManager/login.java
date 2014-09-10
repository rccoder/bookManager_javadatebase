package bookManager;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;
/*
 * ��¼����
 * �û������������user���ű��У���¼ʱ����ƥ�䣬�ɹ�����ʾ��¼�ɹ���
 * ͬʱ��show���еķ���adminJudge(String is_admin)���Σ�����֤�Ƿ�Ϊ����Ա
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
		this.setTitle("��¼|���ũ������ͼ����Ĺ���ϵͳ");
		this.setSize(260, 170);
		this.setVisible(true);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		usenameLabel = new Label("�û���");
		passwordLabel = new Label("����");
		butOk = new Button("��¼");
		butRe = new Button("ȡ��");
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
	 * �����¼����еĶ���
	 */
	public void butOkActionPerformed(ActionEvent e)
	{
		String user = usename.getText();
		String pass = password.getText();
		System.out.println(user);
		System.out.println(pass);
		String is_admin;
		/*
		 * �û���������Ϊ�յ�ʱ����ʾ
		 */
		if(user.equals("") || pass.equals(""))
		{
			JOptionPane.showMessageDialog(null, "�û��������벻��Ϊ�� ");
			return;
		}
		/*
		 * ��ѯ���ݿ⣬���û��������붼�ڵ�ʱ�����ƥ�䣬��user���ű���
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
			 * ��ѯ������ʱ����ʾ����
			 */
			else
			{
				JOptionPane.showMessageDialog(null, "�û������������ ");
				return;
			}
			/*
			 * ��user��Ϊ��̬������������globalUsename�еľ�̬��Login_user�У��������������޸ĵ�
			 */
			globalUsename.login_user = user;
			/*
			 * ����show
			 */
			show SHOW = new show();
			/*
			 * ��show�е�adminJudge(String is_admin)�������Σ���֤�Ƿ�Ϊ����Ա
			 */
			SHOW.adminJudge(is_admin);
			/*
			 * dispose�������
			 */
			dispose();
		}
		/*
		 * �׳��쳣
		 */
		catch(SQLException q)
		{
			System.out.println(q);
			JOptionPane.showMessageDialog(null, "�޷��������ݿ�" + q);
		}
	}
	public static void main(String[] args)
	{
		new login();
	}
}
