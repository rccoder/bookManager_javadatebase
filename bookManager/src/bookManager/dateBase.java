package bookManager;
/*
 * 对数据库操作进行封装
 */
import java.sql.*;
import javax.swing.*;
public class dateBase 
{
	//定义URL，采用odbc连接，数据源 为 bookManager
	private static String url = "jdbc:odbc:bookManager";
	private static Connection con = null;
	public dateBase()
	{
		try
		{
			if(con == null)
			{
				//建立连接
				con = DriverManager.getConnection(url);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "数据库无法打开！");
		}
	}
	/*
	 * 重写数据库查询
	 */
	public static ResultSet executeQuery(String sql)
	{
		try
		{	if(con == null)
			{
				
				System.out.println(sql);
				new dateBase();
			}
				//返回statement对象后更新数据库
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				con = null;
				return rs;
				
		}
				catch(SQLException e)
				{
					JOptionPane.showMessageDialog(null, "数据库无法连接" + e);
					System.out.println(sql);
					System.out.println(e);
					System.exit(0);
					return null;
				}
			//
	}
	/*
	 * 重写数据库更新
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
			JOptionPane.showMessageDialog(null, "数据库无法更新"+e);
			return -1;
		}
	}
	/*
	 * 重写数据库的关闭
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
			JOptionPane.showMessageDialog(null, "数据库无法关闭");
		}
	}
}
