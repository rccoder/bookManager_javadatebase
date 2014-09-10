package bookManager;
/*
 * ���Ӷ��ߵ�ģ��
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class readerAdd extends JFrame 
{
	Label readerIdLabel;
	Label readerNameLabel;
	Label readerSexLabel;
	Label  readerDayLabel;
	TextField readerIdText;
	TextField readerNameText;
	TextField readerSexText;
	TextField readerDayText;
	Button readerAddButton;
	Button readerAddCloseButton;
	public readerAdd()
	{
		//GUI���
		this.setTitle("����ע��|���ũ������ͼ����Ĺ���ϵͳ");
		this.setSize(800, 500);
		this.setLayout(null);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		readerIdLabel = new Label("����ID");
		readerNameLabel = new Label("��������");
		readerSexLabel = new Label("�����Ա�");
		readerDayLabel = new Label("�ɽ�������");
		readerIdText = new TextField("");
		readerNameText = new TextField("");
		readerSexText = new TextField("");
		readerDayText = new TextField("");
		readerAddButton = new Button("ȷ��ע��");
		readerAddCloseButton = new Button("ȡ   ��");
		readerIdLabel.setBounds(170, 100, 50, 20);
		readerNameLabel.setBounds(410, 100, 50, 20);
		readerSexLabel.setBounds(170, 130, 50, 20);
		readerDayLabel.setBounds(410, 130, 50, 20);
		readerIdText.setBounds(230, 100, 160, 20);
		readerNameText.setBounds(470, 100, 160, 20);
		readerSexText.setBounds(230, 130, 160, 20);
		readerDayText.setBounds(470, 130, 160, 20);
		readerAddButton.setBounds(300, 200, 80, 25);
		readerAddCloseButton.setBounds(420, 200, 80, 25);
		add(readerIdLabel);
		add(readerNameLabel);
		add(readerSexLabel);
		add(readerDayLabel);
		add(readerIdText);
		add(readerNameText);
		add(readerSexText);
		add(readerDayText);
		add(readerAddButton);
		add(readerAddCloseButton);
		/*
		 * �������Ӱ�ť���еļ�أ�ִ��readerAddActionPerformed(ActionEvent e)�ķ���
		 */
		readerAddButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						readerAddActionPerformed(e);
					}
				}
				);
		/*
		 * Ϊ�˳���ť��Ӽ��
		 */
		readerAddCloseButton.addActionListener(
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
	 * ������Ӻ�ִ�еķ���
	 */
	public void readerAddActionPerformed(ActionEvent e)
	{
		//�������Ҫ���ı�
		String readerId = readerIdText.getText();
		String readerName = readerNameText.getText();
		String readerSex = readerSexText.getText();
		String readerDay = readerDayText.getText();
		int day;
		//����IDΪ�ձ�������ʾ
		if(readerId.equals(""))
		{

			JOptionPane.showMessageDialog(null, "����ID����Ϊ�գ�");
			return;
		}
		//����ID�ظ���ִ�з��ز������ķ���readerIdExitJudge(boolean readerId)
		if(readerIdExitJudge(readerId))
		{
			JOptionPane.showMessageDialog(null, "����ID�����ظ���");
			return;
		}
		try
		{
		//Ĭ�����ɽ�������Ϊ30�������ַ���ת��Ϊ����
		if(readerDay.equals(""))
		{
			day = 30;
		}
		else
		{
			day = Integer.parseInt(readerDay);
		}
		//�������ݿ��sql���
		String sql = "insert into reader(r_readerId, r_readerName, r_readerSex, r_readerDays)"
				+ " values ('"+readerId+"', '"+readerName+"', '"+readerSex+"'"
						+ ",'"+day+"')";
		//���³ɹ�����1�����������Ļ�ı�������
		if(dateBase.executeUpdate(sql) == 1)
		{
			JOptionPane.showMessageDialog(null, "������ӳɹ���");
		    readerIdText.setText("");
			readerNameText.setText("");
			readerSexText.setText("");
			readerSexText.setText("");
		}
	}
	//���ɽ��������������⣬�׳�����
	catch(NumberFormatException f1)
	{
		JOptionPane.showMessageDialog(null, "�ɽ�������������ȷӦ��Ϊ���֣�");
	}
	catch(Exception f2)
	{
		System.out.println(f2);
	}
	}
	/*
	 * �ж϶���ID�Ƿ��ظ������ز�����
	 */
	public boolean readerIdExitJudge(String readerId)
	{
		String sql = "select * from reader where r_readerId='"+readerId+"'";
		ResultSet rs = dateBase.executeQuery(sql);
		try
		{
			//�ظ����������ݿ����ҵ����ID������true,���򷵻�false
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(SQLException f3)
		{
			JOptionPane.showMessageDialog(null, "���ݿ��޷��������ӣ�");
		}
		return false;
	}
}
