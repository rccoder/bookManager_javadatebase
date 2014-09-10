package bookManager;
/*
 * �޸�ͼ��ģ��
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class bookChange extends JFrame
{
	Label bookIdSearchLabel;
	Label bookIdLabel;
	Label bookNameLabel;
	Label bookAuthorLabel;
	Label bookTypeLabel;
	Label bookPublishLabel;
	Label bookDateLabel;
	Label bookTranslatorLabel;
	Label bookPriceLabel;
	Label bookNumberLabel;
	TextField bookIdSearchText;
	TextField bookIdText;
	TextField bookNameText;
	TextField bookAuthorText;
	TextField bookTypeText;
	TextField bookPublishText;
	TextField bookDateText;
	TextField bookTranslatorText;
	TextField bookPriceText;
	TextField bookNumberText;
	Button bookChangeSearchButton;
	Button bookChangeSaveButton;
	Button bookChangeCloseButton;
	public bookChange()
	{
		/*
		 * GUI���
		 */
		this.setTitle("�޸�ͼ��|���ũ������ͼ����Ĺ���ϵͳ");
		this.setSize(800, 500);
		this.setLayout(null);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		bookIdSearchLabel = new Label("ͼ��ID");
		bookIdLabel = new Label("ͼ��ID");
		bookNameLabel = new Label("ͼ������");
		bookAuthorLabel = new Label("��    ��");
		bookTypeLabel = new Label("ͼ�����");
		bookPublishLabel = new Label("�� �� ��");
		bookDateLabel = new Label("��������");
		bookTranslatorLabel = new Label("��    ��");
		bookPriceLabel = new Label("��    ��");
		bookNumberLabel = new Label("ͼ������");
		bookIdSearchText = new TextField("");
		bookIdText = new TextField("");
		bookNameText = new TextField("");
		bookAuthorText = new TextField("");
		bookTypeText = new TextField("");
		bookPublishText = new TextField("");
		bookDateText = new TextField("");
		bookTranslatorText = new TextField("");
		bookPriceText = new TextField("");
		bookNumberText = new TextField("");
		bookChangeSaveButton = new Button("ȷ���޸�");
		bookChangeCloseButton = new Button("��   ��");
		bookChangeSearchButton = new Button("��    ѯ");
		bookIdSearchLabel.setBounds(280, 50, 50, 20);
		bookIdLabel.setBounds(170, 170, 50, 20);
		bookNameLabel.setBounds(410, 170, 50, 20);
		bookAuthorLabel.setBounds(170, 200, 50, 20);
		bookTypeLabel.setBounds(410, 200, 50, 20);
		bookPublishLabel.setBounds(170, 230, 50, 20);
		bookDateLabel.setBounds(410, 230, 50, 20);
		bookTranslatorLabel.setBounds(170, 260, 50, 20);
		bookPriceLabel.setBounds(410, 260, 50, 20);
		bookNumberLabel.setBounds(170, 290, 50, 20);
		bookIdSearchText.setBounds(340, 50, 160, 20);
		bookIdText.setBounds(230, 170, 160, 20);
		bookNameText.setBounds(470, 170, 160, 20);
		bookAuthorText.setBounds(230, 200, 160, 20);
		bookTypeText.setBounds(470, 200, 160, 20);
		bookPublishText.setBounds(230, 230, 160, 20);
		bookDateText.setBounds(470, 230, 160, 20);
		bookTranslatorText.setBounds(230, 260, 160, 20);
		bookPriceText.setBounds(470, 260, 160, 20);
		bookNumberText.setBounds(230, 290, 160, 20);
		bookChangeSearchButton.setBounds(460, 90, 80, 25);
		bookChangeSaveButton.setBounds(300, 330, 80, 25);
		bookChangeCloseButton.setBounds(420, 330, 80, 25);
		add(bookIdSearchLabel);
		add(bookIdLabel);
		add(bookNameLabel);
		add(bookAuthorLabel);
		add(bookTypeLabel);
		add(bookPublishLabel);
		add(bookDateLabel);
		add(bookTranslatorLabel);
		add(bookPriceLabel);
		add(bookNumberLabel);
		add(bookIdSearchText);
		add(bookIdText);
		add(bookNameText);
		add(bookAuthorText);
		add(bookTypeText);
		add(bookPublishText);
		add(bookDateText);
		add(bookTranslatorText);
		add(bookPriceText);
		add(bookNumberText);
		add(bookChangeSearchButton);
		add(bookChangeSaveButton);
		add(bookChangeCloseButton);
		//��ѯ��bookIdText����д
		bookIdText.setEditable(false);
		/*
		 * Ϊ����ID���в�ѯ�İ�ť��Ӽ�أ�ִ��bookChangeSearchActionPerformed(ActionEvent e)����
		 */
		bookChangeSearchButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						bookChangeSearchActionPerformed(e);
					}
				}
				);
		/*
		 * ��ѯ������޸ģ��ύ���棬��Ӽ�أ�ִ��bookChangeSaveActionPerformed(ActionEvent e)����
		 */
		bookChangeSaveButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						bookChangeSaveActionPerformed(e);
					}
				}
				);
		/*
		 * ���ڹرհ�ť
		 */
		bookChangeCloseButton.addActionListener(
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
	 * �������а���ID��ѯ�ķ���
	 */
	public void bookChangeSearchActionPerformed(ActionEvent e)
	{
		//����Ҫ��ѯ��ID
		String searchId = bookIdSearchText.getText();
		if(searchId.equals(""))
		{
			JOptionPane.showMessageDialog(null, "��ѯʱͼ���Ų�����Ϊ��");
			return;
		}
		try
		{
			String sql = "select * from book where r_bookId='"+searchId+"'";
			//���ݿ��ѯ
			ResultSet rs = dateBase.executeQuery(sql);
			//�鵽���ݣ����и���
			if(rs.next())
			{
				bookIdText.setText(rs.getString("r_bookId"));
				bookNameText.setText(rs.getString("r_bookName"));
				bookAuthorText.setText(rs.getString("r_bookAuthor"));
				bookTypeText.setText(rs.getString("r_bookType"));
				bookPublishText.setText(rs.getString("r_bookPublish"));
				bookDateText.setText(rs.getString("r_bookDate"));
				bookTranslatorText.setText(rs.getString("r_bookTranslator"));
				bookPriceText.setText(rs.getString("r_bookPrice"));
				bookNumberText.setText(rs.getString("r_bookNumber"));
			}
			//û�и�ͼ�飬������ʾ
			else
			{
				JOptionPane.showMessageDialog(null, "�����ݿ���û�з��ֱ��Ϊ" + searchId + "��ͼ��");
			}
		}
		catch(SQLException g)
		{
			JOptionPane.showMessageDialog(null, "����·�޷����ӣ�");
		}
	}
	/*
	 * �������ݺ������ύ�ķ���
	 */
	public void bookChangeSaveActionPerformed(ActionEvent e)
	{
		//��������ֵ
		String bookId = bookIdText.getText();
		String bookName = bookNameText.getText();
		String bookAuthor = bookAuthorText.getText();
		String bookType = bookTypeText.getText();
		String bookPublish = bookPublishText.getText();
		String bookDate = bookDateText.getText();
		String bookTranslator = bookTranslatorText.getText();
		String bookPrice = bookPriceText.getText();
		String bookNumber = bookNumberText.getText();
		float price;
		int number;
		try
		{
			//�ձ�ʾĬ�ϣ���Ϊת��Ϊ��Ӧ����
			if(bookPrice.equals(""))
			{
				price = 58;
			}
			else
			{
				price = Float.parseFloat(bookPrice);
			}
			if(bookNumber.equals(""))
			{
				number = 10;
			}
			else
			{
				number = Integer.parseInt(bookNumber);
			}
			//�������ݿ��sql���
			String sql = "update book set r_bookName='"+bookName+"'"
					+ ",r_bookType='"+bookType+"',r_bookPublish='"+bookPublish+"',"
							+ "r_bookDate='"+bookDate+"', r_bookTranslator='"+bookTranslator+"',"
									+ "r_bookPrice='"+price+"', r_bookAuthor='"+bookAuthor+"',"
											+ "r_bookNumber='"+number+"' where r_bookId='"+bookId+"'";
			//���³ɹ�������1
			if(dateBase.executeUpdate(sql) == 1)
			{
				JOptionPane.showMessageDialog(null, "ͼ���޸ĳɹ���");
				bookIdText.setText("");
				bookNameText.setText("");
				bookAuthorText.setText("");
				bookTypeText.setText("");
				bookPublishText.setText("");
				bookDateText.setText("");
				bookTranslatorText.setText("");
				bookPriceText.setText("");
				bookNumberText.setText("");
			}
		}
		catch(NumberFormatException f1)
		{
			JOptionPane.showMessageDialog(null, "ͼ��۸��ͼ��������д������ȷӦ��Ϊ���֣�");
		}
		catch(Exception f2)
		{
			System.out.println(f2);
		}
	}
}
