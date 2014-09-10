package bookManager;
/*
 * �����޸�ģ��
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;
import java.text.*;
import java.util.*;
public class readerChange extends JFrame 
{
	Label readerIdSearchLabel;
	Label readerIdLabel;
	Label readerNameLabel;
	Label readerSexLabel;
	Label readerDayLabel;
	TextField readerIdSearchText;
	TextField readerIdText;
	TextField readerNameText;
	TextField readerSexText;
	TextField readerDayText;
	Button readerChangeSearchButton;
	Button readerChangeButton;
	Button readerChangeCloseButton;
	/*
	 * ���췽��
	 */
	public readerChange()
	{
		//GUI���
		this.setTitle("�����޸�|���ũ������ͼ����Ĺ���ϵͳ");
		this.setSize(800, 500);
		this.setLayout(null);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		readerIdSearchLabel = new Label("����ID");
		readerIdLabel = new Label("����ID");
		readerNameLabel = new Label("��������");
		readerSexLabel = new Label("��   ��");
		readerDayLabel = new Label("�ɽ�������");
		readerChangeSearchButton = new Button("��   ѯ");
		readerChangeButton = new Button("�޸�");
		readerChangeCloseButton = new Button("��  ��");
		readerIdSearchText = new TextField("");
		readerIdText = new TextField("");
		readerNameText = new TextField("");
		readerSexText = new TextField("");
		readerDayText = new TextField("");
		readerIdSearchLabel.setBounds(280, 100, 50, 20);
		readerIdLabel.setBounds(170, 220, 50 ,20);
		readerNameLabel.setBounds(410, 220, 50, 20);
		readerSexLabel.setBounds(170, 250, 50, 20);
		readerDayLabel.setBounds(410, 250, 50, 20);
		readerIdSearchText.setBounds(340, 100, 160, 20);
		readerIdText.setBounds(230, 220, 160, 20);
		readerNameText.setBounds(470, 220, 160, 20);
		readerSexText.setBounds(230, 250, 160, 20);
		readerDayText.setBounds(470, 250, 160, 20);
		readerChangeSearchButton.setBounds(460, 140, 80, 25);
		readerChangeButton.setBounds(300, 320, 80, 25);
		readerChangeCloseButton.setBounds(420, 320, 80, 25);
		add(readerIdSearchLabel);
		add(readerIdLabel);
		add(readerNameLabel);
		add(readerSexLabel);
		add(readerDayLabel);
		add(readerIdSearchText);
		add(readerIdText);
		add(readerNameText);
		add(readerSexText);
		add(readerDayText);
		add(readerChangeSearchButton);
		add(readerChangeButton);
		add(readerChangeCloseButton);
		readerIdText.setEditable(false);
		/*
		 * Ϊ��ѯ��ť��Ӽ��,ִ��readerChangeSearchActionPerformed(ActionEvent e)����
		 */
		readerChangeSearchButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						readerChangeSearchActionPerformed(e);
					}
				}
				);
		/*
		 * Ϊ�޸İ�ť��Ӽ�أ�ִ��readerChangeActionPerformed(ActionEvent e)����
		 */
		readerChangeButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						readerChangeActionPerformed(e);
					}
				}
				);
		/*
		 * Ϊ�˳���ť��Ӽ�أ��ͷŴ���
		 */
		readerChangeCloseButton.addActionListener(
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
	 * ������ѯ�ķ���
	 */
	public void readerChangeSearchActionPerformed(ActionEvent e)
	{
		//�õ���ѯ�ı��������
		String readerIdSearch = readerIdSearchText.getText();
		//��ѯ���Ϊ�յ������������ʾ
		if(readerIdSearch.equals(""))
		{
			JOptionPane.showMessageDialog(null, "��ѯʱ���߱�Ų�����Ϊ��");
			return;
		}
		try
		{
			//ִ�в�ѯ��sql���
			String sql = "select * from reader where r_readerId='"+readerIdSearch+"'";
			ResultSet rs = dateBase.executeQuery(sql);
			//�鵽�����
			if(rs.next())
			{
				readerIdText.setText(rs.getString("r_readerId"));
				readerNameText.setText(rs.getString("r_readerName"));
				readerSexText.setText(rs.getString("r_readerSex"));
				readerDayText.setText(rs.getString("r_readerDays"));
			}
			//û�в鵽��������ʾ
			else
			{
				JOptionPane.showMessageDialog(null, "�����ݿ���û�з��ֱ��Ϊ" + readerIdSearch + "�Ķ���");
			}
		}
		catch(SQLException g)
		{
			JOptionPane.showMessageDialog(null, "����·�޷����ӣ�");
		}
	}
	/*
	 * ����ִ�������޸ĵķ���
	 */
	public void readerChangeActionPerformed(ActionEvent e)
	{
		//�õ��ı��������
		String readerId = readerIdText.getText();
		String readerName = readerNameText.getText();
		String readerSex = readerSexText.getText();
		String readerDay = readerDayText.getText();
		int day;
		//Ĭ�����ɽ�������Ϊ30���շ���30�������Ļ�ת��Ϊ���֣������׳��쳣
		try
		{
		if(readerDay.equals(""))
		{
			day = 30;
		}
		else
		{
			day = Integer.parseInt(readerDay);
		}
		//ִ�����ݿ���µ�sql���
		String sql = "update reader set r_readerName='"+readerName+"'"
				+ ",r_readerSex='"+readerSex+"',r_readerDays='"+day+"' where "
						+ "r_readerId='"+readerId+"'";
		//�������ݿ����
		if(dateBase.executeUpdate(sql) == 1)
		{
			JOptionPane.showMessageDialog(null, "���� "+readerId+"�޸ĳɹ���");
		}
		}
		//�׳�ת���쳣
		catch(NumberFormatException f1)
		{
			JOptionPane.showMessageDialog(null, "���ɽ���������д������ȷӦ��Ϊ���֣�");
		}
		catch(Exception e8)
		{
			
		}
	}
}
