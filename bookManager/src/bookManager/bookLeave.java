package bookManager;
/*
 * �������Ķ����ģ��
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;
import java.util.*;
public class bookLeave extends JFrame 
{
	Label bookIdSearchLabel;
	Label bookIdLabel;
	Label bookNameLabel;
	Label bookPublishLabel;
	Label bookAuthorLabel;
	Label bookDateLabel;
	Label bookTranslatorLabel;
	TextField  bookIdSearchText;
	TextField bookIdText;
	TextField bookNameText;
	TextField bookPublishText;
	TextField bookAuthorText;
	TextField bookDateText;
	TextField bookTranslatorText;
	Label readerIdSearchLabel;
	Label readerIdLabel;
	Label readerNameLabel;
	Label readerSexLabel;
	Label  readerDayLabel;
	TextField readerIdSearchText;
	TextField readerIdText;
	TextField readerNameText;
	TextField readerSexText;
	TextField readerDayText;
	Label borrowIdLabel;
	Label borrowDayLabel;
	TextField borrowIdText;
	TextField borrowDayText;
	Button bookSearchButton;
	Button readerSearchButton;
	Button borrowButton;
	Button borrowCloseButton;
	/*
	 * ���췽��
	 */
	public bookLeave()
	{
		this.setTitle("�������|���ũ������ͼ����Ĺ���ϵͳ");
		this.setSize(800, 500);
		this.setLayout(null);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		bookIdSearchLabel = new Label("����ID");
		bookIdLabel = new Label("����ID");
		bookNameLabel = new Label("��������");
		bookPublishLabel = new Label("������");
		bookAuthorLabel = new Label("��   ��");
		bookDateLabel = new Label("��������");
		bookTranslatorLabel = new Label("����");
		bookIdSearchText = new TextField("");
		bookIdText = new TextField("");
		bookNameText = new TextField("");
		bookPublishText = new TextField("");
		bookAuthorText = new TextField("");
		bookDateText = new TextField("");
		bookTranslatorText = new TextField("");
		readerIdSearchLabel = new Label("����ID");
		readerIdLabel  = new Label("����ID");
		readerNameLabel  = new Label("��������");
		readerSexLabel = new Label("��   ��");
		readerDayLabel = new Label("����\n��������");
		readerIdSearchText = new TextField("");
		readerIdText = new TextField("");
		readerNameText = new TextField("");
		readerSexText = new TextField("");
		readerDayText = new TextField("");
		borrowIdLabel = new Label("����ID");
		borrowDayLabel = new Label("��������");
		borrowIdText = new TextField("");
		borrowDayText = new TextField("");
		bookSearchButton = new Button("��   ѯ");
		readerSearchButton = new Button("��   ѯ");
		borrowButton = new Button("ȷ������");
		borrowCloseButton = new Button("ȡ  ��");
		bookIdSearchLabel.setBounds(70, 30, 50, 20);
		bookIdLabel.setBounds(100, 90, 50, 20);
		bookNameLabel.setBounds(100, 120, 50, 20);
		bookPublishLabel.setBounds(100, 150, 50, 20);
		bookAuthorLabel.setBounds(100, 180, 50, 20);
		bookDateLabel.setBounds(100, 210, 50, 20);
		bookTranslatorLabel.setBounds(100, 240, 50, 20);
		readerIdSearchLabel.setBounds(400, 30, 50, 20);
		readerIdLabel.setBounds(430, 90, 50, 20);
		readerNameLabel.setBounds(430, 120, 50, 20);
		readerSexLabel.setBounds(430, 150, 50, 20);
		readerDayLabel.setBounds(430, 180, 90, 20);
		borrowIdLabel.setBounds(120, 330, 50, 20);
		borrowDayLabel.setBounds(400, 330, 50, 20);
		bookIdSearchText.setBounds(140, 30, 160, 20);
		bookIdText.setBounds(170, 90, 160, 20);
		bookNameText.setBounds(170, 120, 160, 20);
		bookPublishText.setBounds(170, 150, 160, 20);
		bookAuthorText.setBounds(170, 180, 160, 20);
		bookDateText.setBounds(170, 210, 160, 20);
		bookTranslatorText.setBounds(170, 240, 160, 20);
		readerIdSearchText.setBounds(470, 30, 160, 20);
		readerIdText.setBounds(530, 90, 160, 20);
		readerNameText.setBounds(530, 120, 160, 20);
		readerSexText.setBounds(530, 150, 160, 20);
		readerDayText.setBounds(530, 180, 160, 20);
		borrowIdText.setBounds(190, 330, 160, 20);
		borrowDayText.setBounds(470, 330, 160, 20);
		bookSearchButton.setBounds(310, 30, 80, 25);
		readerSearchButton.setBounds(640, 30, 80, 25);
		borrowButton.setBounds(220, 390, 80, 25);
		borrowCloseButton.setBounds(440, 390, 80, 25);
		add(bookIdSearchLabel);
		add(bookIdLabel);
		add(bookNameLabel);
		add(bookPublishLabel);
		add(bookAuthorLabel);
		add(bookDateLabel);
		add(bookTranslatorLabel);
		add(bookIdSearchText);
		add(bookIdText);
		add(bookNameText);
		add(bookPublishText);
		add(bookAuthorText);
		add(bookDateText);
		add(bookTranslatorText);
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
		add(borrowIdLabel);
		add(borrowDayLabel);
		add(borrowIdText);
		add(borrowDayText);
		add(bookSearchButton);
		add(readerSearchButton);
		add(borrowButton);
		add(borrowCloseButton);
		//TextField���ɱ��༭
		bookIdText.setEnabled(false);
		bookNameText.setEnabled(false);
		bookPublishText.setEnabled(false);
		bookAuthorText.setEnabled(false);
		bookDateText.setEnabled(false);
		bookTranslatorText.setEnabled(false);
		readerIdText.setEnabled(false);
		readerNameText.setEnabled(false);
		readerSexText.setEnabled(false);
		readerDayText.setEnabled(false);
		/*
		 * Ϊ�鼮��ѯ��ť��Ӽ�أ�ִ��bookSearchButtonActionPerformed(ActionEvent e)����
		 */
		bookSearchButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						bookSearchButtonActionPerformed(e);
					}
				}
				);
		/*
		 * Ϊ���߲�ѯ��Ӽ�أ�ִ��readerSearchButtonActionPerformed(ActionEvent e)����
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
		 * Ϊ���İ�ť��Ӽ�أ�ִ��borrowButtonActionPerformed(ActionEvent e)����
		 */
		borrowButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						borrowButtonActionPerformed(e);
					}
				}
				);
		/*
		 * Ϊ�˳���ť��Ӽ�أ�ִ���ͷŴ��ڲ���
		 */
		borrowCloseButton.addActionListener(
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
	 * ������ѯ�鼮�ķ���
	 */
	public void bookSearchButtonActionPerformed(ActionEvent e)
	{
		//�õ��鼮ID
		String bookId = bookIdSearchText.getText();
		//�鼮IDΪ�յ������������ʾ
		if(bookId.equals(""))
		{
			JOptionPane.showMessageDialog(null, "��ѯʱͼ���Ų�����Ϊ��");
			return;
		}
		//������ѯ��sql���
		String sql = "select * from book where r_bookId='"+bookId+"'";
		try
		{
			//ִ�����ݿ��ѯ
			ResultSet rs = dateBase.executeQuery(sql);
			//�鵽�����
			if(rs.next())
			{
				bookIdText.setText(rs.getString("r_bookId"));
				bookNameText.setText(rs.getString("r_bookName"));
				bookPublishText.setText(rs.getString("r_bookPublish"));
				bookAuthorText.setText(rs.getString("r_bookAuthor"));
				bookDateText.setText(rs.getString("r_bookDate"));
				bookTranslatorText.setText(rs.getString("r_bookTranslator"));
			}
			//û�в鵽�����
			else
			{
				JOptionPane.showMessageDialog(null, "û�в鵽���鼮");
			}
		}
		//�׳�SQL�쳣
		catch(SQLException g)
		{
			JOptionPane.showMessageDialog(null, "����·�޷����ӣ�");
		}
	}
	/*
	 * ����ִ�ж��߲�ѯ�ķ�����������ǰ��������ѯ����ķ���һ��
	 */
	public void readerSearchButtonActionPerformed(ActionEvent e)
	{
		//�õ�ID
		String readerId = readerIdSearchText.getText();
		//IDΪ�յ����
		if(readerId.equals(""))
		{
			JOptionPane.showMessageDialog(null, "���߲�ѯʱ������Ϊ��");
			return;
		}
		//ִ�в�ѯ������sql���
		String sql = "select * from reader where r_readerId='"+readerId+"'";
		try
		{
			//ִ�����ݿ��ѯ
			ResultSet rs = dateBase.executeQuery(sql);
			//�鵽�����
			if(rs.next())
			{
				readerIdText.setText(rs.getString("r_readerId"));
				readerNameText.setText(rs.getString("r_readerName"));
				readerSexText.setText(rs.getString("r_readerSex"));
				readerDayText.setText(rs.getString("r_readerDays"));
			}
			//ûӴ�鵽�����
			else
			{
				JOptionPane.showMessageDialog(null, "û�в�ѯ����ͼ��");
			}
		}
		//�׳����ݿ��쳣
		catch(SQLException e1)
		{
			JOptionPane.showMessageDialog(null, "����·�޷����ӣ�" + e1);
		}
	}
	/*
	 * ����ִ�н�����һ�����ķ���
	 */
	public void borrowButtonActionPerformed(ActionEvent e)
	{
		//�õ�����Ҫ�Ĳ���
		String borrowId = borrowIdText.getText();
		String borrowDay = borrowDayText.getText();
		String borrowName = readerNameText.getText();
		String borrowBook = bookNameText.getText();
		String borrowDays = readerDayText.getText();
		//borrowIdΪ�յ������������ʾ
		if(borrowId.equals(""))
		{
			JOptionPane.showMessageDialog(null, "����ID����Ϊ�գ�");
			return;
		}
		//�ж�borrowId�Ƿ��Ѿ�����
		if(borrowIdJudgeExit(borrowId))
		{
			JOptionPane.showMessageDialog(null, "�Ľ���ID�Ѿ�����");
			return;
		}
		//Ĭ�Ͻ�������Ϊ2014/08/01
		if(borrowDay.equals(""))
		{
			borrowDay = "2014/08/01";	
		}
		//ִ�в����sql���
		String sql = "insert into borrow(r_borrowId, r_borrowName,"
				+ "r_borrowBook, r_borrowDay, r_borrowDays) "
				+ " values ('"+borrowId+"', '"+borrowName+"', '"+borrowBook+"',"
						+ "'"+borrowDay+"', '"+borrowDays+"')";
		//���ݿ���³ɹ�������1
		if(dateBase.executeUpdate(sql) == 1)
		{
			JOptionPane.showMessageDialog(null, "�����¼��ӳɹ���");
		}
	}
	public boolean borrowIdJudgeExit(String borrowId)
	{
		/*
		 * ������ѯ��sql���
		 */
		String sql = "select * from borrow where r_borrowId='"+borrowId+"'";
		ResultSet rs = dateBase.executeQuery(sql);
		/*
		 * �ҵ�return TRUE������return FALSE
		 */
		try
		{
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
