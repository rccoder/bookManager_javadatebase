package bookManager;
/*
 * ����ע��ģ��
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class readerDelete extends JFrame 
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
	Button readerDeleteSearchButton;
	Button readerDeleteButton;
	Button readerDeleteCloseButton;
	
	public readerDelete()
	{
		//GUI���
		this.setTitle("����ע��|���ũ������ͼ����Ĺ���ϵͳ");
		this.setSize(800, 500);
		this.setLayout(null);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		readerIdSearchLabel = new Label("����ID");
		readerIdLabel = new Label("����ID");
		readerNameLabel = new Label("��������");
		readerSexLabel = new Label("��   ��");
		readerDayLabel = new Label("�ɽ�������");
		readerDeleteSearchButton = new Button("��   ѯ");
		readerDeleteButton = new Button("ȷ��ɾ��");
		readerDeleteCloseButton = new Button("��  ��");
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
		readerDeleteSearchButton.setBounds(460, 140, 80, 25);
		readerDeleteButton.setBounds(300, 320, 80, 25);
		readerDeleteCloseButton.setBounds(420, 320, 80, 25);
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
		add(readerDeleteSearchButton);
		add(readerDeleteButton);
		add(readerDeleteCloseButton);
		readerIdText.setEditable(false);
		readerNameText.setEditable(false);
		readerSexText.setEditable(false);
		readerDayText.setEditable(false);
		/*
		 * Ϊ��ѯ��ť��Ӽ�أ�ִ��readerDeleteSearchActionPerformed(ActionEvent e)����
		 */
		readerDeleteSearchButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						readerDeleteSearchActionPerformed(e);
					}
				}
				);
		/*
		 * Ϊɾ����ť��Ӽ�أ�ִ��readerDeleteActionPerformed(ActionEvent e)����
		 */
		readerDeleteButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						readerDeleteActionPerformed(e);
					}
				}
				);
		/*
		 * Ϊ�˳���ť��Ӽ�أ��ͷŴ���
		 */
		readerDeleteCloseButton.addActionListener(
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
	 *����ִ�����ݲ�ѯ�ķ���
	 */
	public void readerDeleteSearchActionPerformed(ActionEvent e)
	{
		//�õ���ѯID
		String readerIdSearch = readerIdSearchText.getText();
		//IDΪ�յ�ʱ�򣬵�����ʾ
		if(readerIdSearch.equals(""))
		{
			JOptionPane.showMessageDialog(null, "��ѯʱͼ���Ų�����Ϊ��");
			return;
		}
		try
		{
			//ִ�в�ѯ���ݿ��sql���
			String sql = "select * from reader where r_readerId='"+readerIdSearch+"'";
			ResultSet rs = dateBase.executeQuery(sql);
			//�鵽������������ı���
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
				JOptionPane.showMessageDialog(null, "û���ҵ������Ķ���");
			}
		}
		//�׳�SQL�쳣
		catch(SQLException g)
		{
			JOptionPane.showMessageDialog(null, "����·�޷����ӣ�");
		}
	}
	/*
	 * ����ִ��ɾ���ķ���
	 */
	public void readerDeleteActionPerformed(ActionEvent e)
	{
		//���ID
		String readerId = readerIdText.getText();
		//ִ��ɾ����sql���
		String sql = "delete from reader where r_readerId='"+readerId+"'";
		//���ݿ���³ɹ�������1
		if(dateBase.executeUpdate(sql) == 1)
		{
			JOptionPane.showMessageDialog(null, "���� "+readerId+"ɾ���ɹ���");
			readerIdText.setText("");
			readerNameText.setText("");
			readerSexText.setText("");
			readerDayText.setText("");
		}
	}
}
