package bookManager;
/*
 * ��¼�û��޸���ģ�飬��Ҫ��������������֤
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
		this.setTitle("�޸�����|���ũ������ͼ����Ĺ���ϵͳ");
		this.setSize(800, 500);
		this.setLayout(null);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		useNameLabel = new Label("�û�����");
		useOldPasswordLabel = new Label("�����������");
		useNewPasswordLabel = new Label("������������");
		useNameText = new TextField(globalUsename.login_user);
		useOldPasswordText = new TextField("");
		useNewPasswordText = new TextField("");
		changePasswordButton = new Button("ȷ���޸�");
		changePasswordCloseButton = new Button("��   ��");
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
		JOptionPane.showMessageDialog(null, "ע�⣺�����޸���ɺ���Ҫ���µ�¼");
		/*
		 * Ϊ�޸İ�ť��Ӽ�أ�ִ��changePasswordActionPerofrmed(ActionEvent e)����
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
		 * Ϊ�رհ�ť��Ӽ������ͷŴ���
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
	 * ���ھ��������֤����
	 */
	public void changePasswordActionPerformed(ActionEvent e)
	{
		String oldPassword = useOldPasswordText.getText();
		try
		{
			/*
			 * �ڵ�¼֮��Ͱѵ�¼�û�������globalUsename���е�Login_user��̬�����У������������ݿ����֤
			 */
			String sql = "select * from user where r_username='"+globalUsename.login_user+"'";
			System.out.println(sql);
			ResultSet rs = dateBase.executeQuery(sql);
			System.out.println(1);
			System.out.println(rs);
			/*
			 * ��֤�ɹ���ȡ�����ݿ��е�����
			 */
			if(rs.next())
			{
				/*
				 * ���ݿ��е������������������ͬ������½�����һ��������ִ�У���changePasswordButton()����
				 */
				if(oldPassword.equals(rs.getString("r_password")))
				{
					changePasswordButton();
				}
				/*
				 * ��һ�µ���������ؾ���������������ʾ
				 */
				else
				{
					JOptionPane.showMessageDialog(null, "�������������");
				}
			}
		
			/*
			 * �ر����ݿ�����
			 */
			dateBase.Close();
		}
		catch(SQLException g)
		{
			JOptionPane.showMessageDialog(null, "����·�޷����ӣ�" + g);
		}
		catch(Exception h)
		{
			System.out.println(h);
		}
	}
	/*
	 * ��������֤�ɹ�������ȷ��ִ�еķ��������������������ݿ��е�д��
	 */
	public void changePasswordButton()
	{
		/*
		 * ���������
		 */
		String newPassword = useNewPasswordText.getText();
		String sql = "update user set r_password='"+newPassword+"' "
				+ " where r_username='"+globalUsename.login_user+"'";
		/*
		 * ִ�����ݿ�ĸ��£����˳�����£�������ʾΪ1�������޸ĳɹ�����ʾ
		 */
		if(dateBase.executeUpdate(sql) == 1)
		{
			JOptionPane.showMessageDialog(null, globalUsename.login_user+"���� �޸ĳɹ���");
			System.exit(0);
		}
		dateBase.Close();
	}
}
