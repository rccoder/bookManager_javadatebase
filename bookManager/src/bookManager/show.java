package bookManager;
import java.awt.*;
import java.awt.event.*;
/*
 * 用户登录后的界面，是整个系统的引导界面
 */
public class show extends Frame
{
	MenuBar menuBar;
	Menu menu1, menu2, menu3, menu4, menu5, menu6;
	/*
	 * menu1：查询   | menu2：借阅| menu3: 我的系统 |menu4:视图
	 * menu1{读书查询|读者查询}
	 * menu2{借书|还书}
	 * menu3{修改密码|安全退出}
	 * menu4{menu5 图书  |menu6读者}
	 * menu5{添加|修改|删除}
	 * menu6{添加|修改|删除}
	 */
	MenuItem menu1_menuItem1, menu1_menuItem2, menu2_menuItem1, menu2_menuItem2,
	menu3_menuItem1, menu3_menuItem2, menu4_menu5_menuItem1, menu4_menu5_menuItem2,
	 menu4_menu5_menuItem3, menu4_menu6_menuItem1, menu4_menu6_menuItem2,
	 menu4_menu6_menuItem3;
	/*
	 * 如果不是管理员，则禁止menu2&&menu4
	 * 参数有login.java中传递
	 */
	public void adminJudge(String is_admin)
	{
		if(is_admin == null || (!is_admin.equals("是")))
		{
			menu2.setEnabled(false);
			menu4.setEnabled(false);
		}
	}
	public show()
	{
		this.setTitle("主界面|乡村农家书屋图书借阅管理系统");
		this.setSize(640, 480);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		menuBar = new MenuBar();
		menu1 = new Menu("系统查询");
			menu1_menuItem1 = new MenuItem("书籍查询");
			menu1_menuItem2 = new MenuItem("读者查询");
		menu2 = new Menu("书籍借阅");
			menu2_menuItem1 = new MenuItem("借书系统");
			menu2_menuItem2 = new MenuItem("还书系统");
		menu3 = new Menu("我的系统");
			menu3_menuItem1 = new MenuItem("修改密码");
			menu3_menuItem2 = new MenuItem("安全退出");
		menu4 = new Menu("管理视图");
			menu5 = new Menu("图书视图");
				menu4_menu5_menuItem1 = new MenuItem("添加图书");
				menu4_menu5_menuItem2 = new MenuItem("修改图书");
				menu4_menu5_menuItem3 = new MenuItem("删除图书");
			menu6 = new Menu("读者视图");
				menu4_menu6_menuItem1 = new MenuItem("读者注册");
				menu4_menu6_menuItem2 = new MenuItem("修改读者");
				menu4_menu6_menuItem3 = new MenuItem("注销读者");
		
		this.setMenuBar(menuBar);
		menuBar.add(menu1);
			menu1.add(menu1_menuItem1);
			menu1.add(menu1_menuItem2);
		menuBar.add(menu2);
			menu2.add(menu2_menuItem1);
			menu2.add(menu2_menuItem2);
		menuBar.add(menu3);
			menu3.add(menu3_menuItem1);
			menu3.add(menu3_menuItem2);
		menuBar.add(menu4);
			menu4.add(menu5);
				menu5.add(menu4_menu5_menuItem1);
				menu5.add(menu4_menu5_menuItem2);
				menu5.add(menu4_menu5_menuItem3);
			menu4.add(menu6);
				menu6.add(menu4_menu6_menuItem1);
				menu6.add(menu4_menu6_menuItem2);
				menu6.add(menu4_menu6_menuItem3);
		/*
		 * 为各项功能添加监听
		 */
		this.addWindowListener(
				new WindowAdapter()
				{
					public void windowClosing(WindowEvent e)
					{
						dateBase.Close();
						System.exit(0);
					}
				}
				);
		/*
		 * 图书查询
		 */
		menu1_menuItem1.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						new bookSearch();
					}
				}
				);
		/*
		 * 读者查询
		 */
		menu1_menuItem2.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						new userSearch();
					}
				}
				);
		/*
		 * 借阅书籍，需要管理员登录 
		 */
		menu2_menuItem1.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						new bookLeave();
					}
				}
				);
		/*
		 * 归还书籍，需要管理员登录
		 */
		menu2_menuItem2.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						new borrowCome();
					}
				}
				);
		/*
		 * 修改用户密码
		 */
		menu3_menuItem1.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						new changePassword();
					}
				}
				);
		/*
		 * 安全退出系统
		 */
		menu3_menuItem2.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						System.exit(0);
					}
				}
				);
		/*
		 * 图书信息的编辑，包括增加图书，修改图书，删除图书
		 */
		/*
		 * 增加图书
		 */
		menu4_menu5_menuItem1.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						new bookAdd();
					}
				}
				);
		/*
		 * 修改图书信息
		 */
		menu4_menu5_menuItem2.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						new bookChange();
					}
				}
				);
		/*
		 * 删除图书
		 */
		menu4_menu5_menuItem3.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						new bookDelete();
					}
				}
				);
		/*
		 * 读者信息的编辑，包括读者的增加，修改和删除
		 */
		/*
		 * 读者的注册
		 */
		menu4_menu6_menuItem1.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						new readerAdd();
					}
				}
				);
		/*
		 * 读者的修改
		 */
		menu4_menu6_menuItem2.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						new readerChange();
					}
				}
				);
		/*
		 * 读者的注销
		 */
		menu4_menu6_menuItem3.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						new readerDelete();
					}
				}
				);
		
	}
}
