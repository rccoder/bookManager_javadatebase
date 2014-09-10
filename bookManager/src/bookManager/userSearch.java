package bookManager;
/*
 * 读者查找模块
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class userSearch extends JFrame
{
	Label readerNameLabel;
	Label readerSexLabel;
	Label readermohuLabel;
	TextField readerNameText;
	TextField readerSexText;
	TextField readermohuText;
	Button readerSearchButton;
	Button readerCloseButton;
	public userSearch()
	{
		this.setTitle("读者查询|乡村农家书屋图书借阅管理 系统");
		this.setSize(800, 500);
		this.setLayout(null);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		readerNameLabel = new Label("读者姓名");
		readerSexLabel = new Label("读者性别");
		readermohuLabel = new Label("模糊查找");
		readerNameText = new TextField("");
		readerSexText = new TextField("");
		readermohuText = new TextField("");
		readerSearchButton = new Button("查    询");
		readerCloseButton = new Button("取     消");
		readerNameLabel.setBounds(170, 40, 50, 20);
		readerSexLabel.setBounds(410, 40, 50, 20);
		readermohuLabel.setBounds(250, 80, 50, 20);
		readerNameText.setBounds(230, 40, 160, 20);
		readerSexText.setBounds(470, 40, 160, 20);
		readermohuText.setBounds(310, 80, 160, 20);
		readerSearchButton.setBounds(300, 110, 80, 25);
		readerCloseButton.setBounds(420, 110, 80, 25);
		add(readerNameLabel);
		add(readerSexLabel);
		add(readermohuLabel);
		add(readerNameText);
		add(readerSexText);
		add(readermohuText);
		add(readerSearchButton);
		add(readerCloseButton);
		JOptionPane.showMessageDialog(null, "为保证查询结果的准确性，请在使用模糊查找时保持前面内容为空");
		/*
		 * 为查询按钮添加监控
		 */
		readerSearchButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						readerSearchButtonActionPerformed(e);
					}
				}
				);
		/*
		 * 关闭数据库连接，释放窗口
		 */
		readerCloseButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						dateBase.Close();
						dispose();
					}
				}
				);
	}
	/*
	 * 查询按钮监控中执行的方法
	 */
	public void readerSearchButtonActionPerformed(ActionEvent e)
	{
		try
		{
			/*
			 * 对TextField的内容进行getText
			 */
			String readerName = readerNameText.getText();
			String readerSex = readerSexText.getText();
			String readermohu = readermohuText.getText();
			//申明后面会用到的sql
			String sql1, sql2, sql3, sql4;
			//为后面出现表格做准备
			String[] readerTableHead = {"读者ID", "读者姓名", "读者性别", "读者可借阅天数"};
			/*
			 * 根据TextField的内容是否为空写出灵活的sql语句
			 */
			String sql = "select * from reader ";
			if(readerName.equals(""))
			{
				sql1 = "";
			}
			else
			{
				sql1 = "r_readerName='"+readerName+"'";
			}
			if(readerSex.equals(""))
			{
				sql2 = "";
			}
			else
			{
				sql2 = "r_readerSex='"+readerSex+"'";
				if(!readerName.equals(""))
				{
					sql2 = " and " + sql2;
				}
			}
			if(readermohu.equals(""))
			{
				sql3 = ""; 
			}
			else
			{
				sql3 = "r_readerName like '%"+readermohu+"%'";
				if(!(readerName.equals("") && readerSex.equals("")))
				{
					sql3 = " and " + sql3;
				}
			}
			sql4 = sql1 + sql2 + sql3;
			/*
			 * 至少有一个不为空时生成sql语句
			 */
			if(!sql.equals(""))
			{
				sql = sql + "where " + sql4;
			}
			/*
			 * 全部为空，输出提示信息
			 */
			else
			{
				JOptionPane.showMessageDialog(null, "请输入正确的数据");
			}
			ResultSet rs = dateBase.executeQuery(sql);
			/*
			 * 创建表头对象
			 */
			Object[][] readerSearchTable = new Object[20][readerTableHead.length];
			//i--用于在表格中进行列举
			int i = 0;
			int flag = 0;
			while(rs.next())
			{
				flag = 1;
				readerSearchTable[i][0] = rs.getString("r_readerId");
				readerSearchTable[i][1] = rs.getString("r_readerName");
				readerSearchTable[i][2] = rs.getString("r_readerSex");
				readerSearchTable[i][3] = rs.getString("r_readerDays");
				i++;
			}
			if(flag == 0)
			{
				JOptionPane.showMessageDialog(null, "没有找到相对应的读者");
			}
			JTable table = new JTable(readerSearchTable, readerTableHead);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(20, 140, 760, 300);
			flag = 0;
			add(scrollPane);
		}
		catch(SQLException c)
		{
			JOptionPane.showMessageDialog(null, "数据库访问错误！");
			System.exit(0);
		}
	}
}
