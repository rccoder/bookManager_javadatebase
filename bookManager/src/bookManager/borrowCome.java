package bookManager;
/*
 * ͼ��黹ģ��
 */
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class borrowCome extends JFrame 
{
		Label borrowIdSearchLabel;
		Label borrowIdLabel;
		Label borrowNameLabel;
		Label borrowBookLabel;
		Label borrowDayLabel;
		Label borrowDaysLabel;
		TextField  borrowIdSearchText;
		TextField borrowIdText;
		TextField borrowNameText;
		TextField borrowBookText;
		TextField borrowDayText;
		TextField borrowDaysText;
		Button borrowIdSearchButton;
		Button borrowComeButton;
		Button borrowComeCloseButton;
		/*
		 * ���췽��
		 */
		public borrowCome()
		{
			this.setTitle("���Ĺ黹|���ũ������ͼ����Ĺ���ϵͳ");
			this.setSize(800, 500);
			this.setLayout(null);
			this.setVisible(true);
			borrowIdSearchLabel = new Label("����ID");
			borrowIdLabel = new Label("����ID");
			borrowNameLabel = new Label("������");
			borrowBookLabel = new Label("�����鼮");
			borrowDayLabel = new Label("��������");
			borrowDaysLabel = new Label("�ɽ�������");
			borrowIdSearchButton = new Button("�� ѯ");
			borrowComeButton  = new Button("ȷ���黹");
			borrowComeCloseButton = new Button("��    ��");
			borrowIdSearchText = new TextField("");
			borrowIdText = new TextField("");
			borrowNameText = new TextField("");
			borrowBookText = new TextField("");
			borrowDayText = new TextField("");
			borrowDaysText = new TextField("");
			borrowIdSearchLabel.setBounds(240, 50, 50, 20);
			borrowIdLabel.setBounds(140, 160, 50, 20);
			borrowNameLabel.setBounds(400, 160, 50, 20);
			borrowBookLabel.setBounds(140, 190, 50, 20);
			borrowDayLabel.setBounds(400, 190, 50, 20);
			borrowDaysLabel.setBounds(140, 220, 50, 20);
			borrowIdSearchText.setBounds(310, 50, 160, 20);
			borrowIdText.setBounds(210, 160, 160, 20);
			borrowNameText.setBounds(470, 160, 160, 20);
			borrowBookText.setBounds(210, 190, 160, 20);
			borrowDayText.setBounds(470, 190, 160, 20);
			borrowDaysText.setBounds(210, 220, 160, 20);
			borrowIdSearchButton.setBounds(490, 80, 85, 25);
			borrowComeButton.setBounds(220, 330, 85,25);
			borrowComeCloseButton.setBounds(440, 330, 85, 25);
			add(borrowIdSearchLabel);
			add(borrowIdLabel);
			add(borrowNameLabel);
			add(borrowBookLabel);
			add(borrowDayLabel);
			add(borrowDaysLabel);
			add(borrowIdSearchText);
			add(borrowIdText);
			add(borrowNameText);
			add(borrowBookText);
			add(borrowDayText);
			add(borrowDaysText);
			add(borrowIdSearchButton);
			add(borrowComeButton);
			add(borrowComeCloseButton);
			borrowIdText.setEnabled(false);
			borrowNameText.setEnabled(false);
			borrowBookText.setEnabled(false);
			borrowDayText.setEnabled(false);
			borrowDaysText.setEnabled(false);
			/*
			 * Ϊ����ID��ѯ��ť��Ӽ�أ�ִ��borrowIdSearchButtonActionPerformed(ActionEvent e)����
			 */
			borrowIdSearchButton.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							borrowIdSearchButtonActionPerformed(e);
						}
					}
					);
			/*
			 * Ϊ�黹��ť��Ӽ�أ�ִ��borrowComeButtonActionPerformed(ActionEvent e)����
			 */
			borrowComeButton.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							borrowComeButtonActionPerformed(e);
						}
					}
					);
			/*
			 * Ϊ�˳���ť��Ӽ�أ�ִ���ͷŴ��ڲ���
			 */
			borrowComeCloseButton.addActionListener(
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
		 * ִ�в�ѯ�����ķ���
		 */
		public void borrowIdSearchButtonActionPerformed(ActionEvent e)
		{
			//�õ�ID
			String borrowId = borrowIdSearchText.getText();
			//IDΪ�յ����
			if(borrowId.equals(""))
			{
				JOptionPane.showMessageDialog(null, "��ѯID����Ϊ��");
			}
			//ִ�в�ѯ������sql���
			String sql = "select * from borrow where r_borrowId='"+borrowId+"'";
			//ִ�����ݿ��ѯ
			ResultSet rs = dateBase.executeQuery(sql);
			try
			{
				//�鵽�����
				if(rs.next())
				{
					borrowIdText.setText(rs.getString("r_borrowId"));
					borrowNameText.setText(rs.getString("r_borrowName"));
					borrowBookText.setText(rs.getString("r_borrowBook"));
					borrowDayText.setText(rs.getString("r_borrowDay"));
					borrowDaysText.setText(rs.getString("r_borrowDays"));
				}
				//�鲻�������
				else
				{
					JOptionPane.showMessageDialog(null, "�鲻���ôν��ļ�¼");
				}
			}
			//�׳�SQL�쳣
			catch(SQLException e1)
			{
				JOptionPane.showMessageDialog(null, "���ݿ����Ӵ���");
			}
		}
		/*
		 * ִ�й黹��ɾ�����ļ�¼�ķ���
		 */
		public void borrowComeButtonActionPerformed(ActionEvent e)
		{
			//�õ�borrowId
			String borrowId = borrowIdText.getText();
			//ִ��ɾ��������sql���
			String sql = "delete from borrow where r_borrowId='"+borrowId+"'";
			if(dateBase.executeUpdate(sql) == 1)
			{
				JOptionPane.showMessageDialog(null, "����ɹ�");
			}
		}
}
