package bookManager;
/*
 * �����ݿ�������з�װ
 */
import java.sql.*;
import javax.swing.*;
public class dateBase 
{
	//����URL������odbc���ӣ�����Դ Ϊ bookManager
	private static String url = "jdbc:odbc:bookManager";
	private static Connection con = null;
	public dateBase()
	{
		try
		{
			if(con == null)
			{
				//��������
				con = DriverManager.getConnection(url);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "���ݿ��޷��򿪣�");
		}
	}
	/*
	 * ��д���ݿ��ѯ
	 */
	public static ResultSet executeQuery(String sql)
	{
		try
		{	if(con == null)
			{
				
				System.out.println(sql);
				new dateBase();
			}
				//����statement�����������ݿ�
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				con = null;
				return rs;
				
		}
				catch(SQLException e)
				{
					JOptionPane.showMessageDialog(null, "���ݿ��޷�����" + e);
					System.out.println(sql);
					System.out.println(e);
					System.exit(0);
					return null;
				}
			//
	}
	/*
	 * ��д���ݿ����
	 */
	public static int executeUpdate(String sql)
	{
		try
		{
			if(con == null)
			{
				new dateBase();
			}
				return con.createStatement().executeUpdate(sql);
			
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, "���ݿ��޷�����"+e);
			return -1;
		}
	}
	/*
	 * ��д���ݿ�Ĺر�
	 */
	public static void Close()
	{
		try
		{
			if(con != null)
			{
				con.close();
			}
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, "���ݿ��޷��ر�");
		}
	}
}
