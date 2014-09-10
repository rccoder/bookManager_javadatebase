package bookManager;
import java.awt.*;
import java.awt.event.*;
/*
 * �û���¼��Ľ��棬������ϵͳ����������
 */
public class show extends Frame
{
	MenuBar menuBar;
	Menu menu1, menu2, menu3, menu4, menu5, menu6;
	/*
	 * menu1����ѯ   | menu2������| menu3: �ҵ�ϵͳ |menu4:��ͼ
	 * menu1{�����ѯ|���߲�ѯ}
	 * menu2{����|����}
	 * menu3{�޸�����|��ȫ�˳�}
	 * menu4{menu5 ͼ��  |menu6����}
	 * menu5{���|�޸�|ɾ��}
	 * menu6{���|�޸�|ɾ��}
	 */
	MenuItem menu1_menuItem1, menu1_menuItem2, menu2_menuItem1, menu2_menuItem2,
	menu3_menuItem1, menu3_menuItem2, menu4_menu5_menuItem1, menu4_menu5_menuItem2,
	 menu4_menu5_menuItem3, menu4_menu6_menuItem1, menu4_menu6_menuItem2,
	 menu4_menu6_menuItem3;
	/*
	 * ������ǹ���Ա�����ֹmenu2&&menu4
	 * ������login.java�д���
	 */
	public void adminJudge(String is_admin)
	{
		if(is_admin == null || (!is_admin.equals("��")))
		{
			menu2.setEnabled(false);
			menu4.setEnabled(false);
		}
	}
	public show()
	{
		this.setTitle("������|���ũ������ͼ����Ĺ���ϵͳ");
		this.setSize(640, 480);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		menuBar = new MenuBar();
		menu1 = new Menu("ϵͳ��ѯ");
			menu1_menuItem1 = new MenuItem("�鼮��ѯ");
			menu1_menuItem2 = new MenuItem("���߲�ѯ");
		menu2 = new Menu("�鼮����");
			menu2_menuItem1 = new MenuItem("����ϵͳ");
			menu2_menuItem2 = new MenuItem("����ϵͳ");
		menu3 = new Menu("�ҵ�ϵͳ");
			menu3_menuItem1 = new MenuItem("�޸�����");
			menu3_menuItem2 = new MenuItem("��ȫ�˳�");
		menu4 = new Menu("������ͼ");
			menu5 = new Menu("ͼ����ͼ");
				menu4_menu5_menuItem1 = new MenuItem("���ͼ��");
				menu4_menu5_menuItem2 = new MenuItem("�޸�ͼ��");
				menu4_menu5_menuItem3 = new MenuItem("ɾ��ͼ��");
			menu6 = new Menu("������ͼ");
				menu4_menu6_menuItem1 = new MenuItem("����ע��");
				menu4_menu6_menuItem2 = new MenuItem("�޸Ķ���");
				menu4_menu6_menuItem3 = new MenuItem("ע������");
		
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
		 * Ϊ�������Ӽ���
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
		 * ͼ���ѯ
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
		 * ���߲�ѯ
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
		 * �����鼮����Ҫ����Ա��¼ 
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
		 * �黹�鼮����Ҫ����Ա��¼
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
		 * �޸��û�����
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
		 * ��ȫ�˳�ϵͳ
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
		 * ͼ����Ϣ�ı༭����������ͼ�飬�޸�ͼ�飬ɾ��ͼ��
		 */
		/*
		 * ����ͼ��
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
		 * �޸�ͼ����Ϣ
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
		 * ɾ��ͼ��
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
		 * ������Ϣ�ı༭���������ߵ����ӣ��޸ĺ�ɾ��
		 */
		/*
		 * ���ߵ�ע��
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
		 * ���ߵ��޸�
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
		 * ���ߵ�ע��
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
