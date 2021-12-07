package chat;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import choice.choice;

public class main_suri{


	private static JTextField textField;
	public static String nName;
	
	public main_suri() {
		// ������ ����
		JFrame frame = new JFrame("�������������");

		// ������ ũ�� ����
		frame.setSize(1980, 1080);

		// �������� ȭ�� ����� ��ġ
		frame.setLocationRelativeTo(null);

		// �������� �ݾ��� �� �޸𸮿��� ���ŵǵ��� ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ��Ʈ����
		Font font = new Font("�������", Font.PLAIN, 30); // ��ư�κ�
				
		textField = new JTextField("�г����� �Է����ּ���");
		
		textField.setBounds(245, 696, 551, 47);
		textField.setColumns(10);
		frame.add(textField);
		textField.setFont(font);
		
		
		RoundedButton startBtn = new RoundedButton("GO",2);
		startBtn.setBounds(827, 696, 100, 47);
		startBtn.setFont(font);	
		frame.getContentPane().add(startBtn);

		
		//�ΰ�
		ImageIcon logo = new ImageIcon(main_suri.class.getResource("../img/logo.png"));
		JLabel imgLbl2 = new JLabel();
		imgLbl2.setBounds(100, 120, 1000, 600);
		imgLbl2.setIcon(logo);
		frame.add(imgLbl2);
		
		//����
	     ImageIcon suri1 = new ImageIcon(choice.class.getResource("../img/���ü�����.png"));
	     JLabel imgLbl1 = new JLabel();
	     frame.getContentPane().add(imgLbl1);
	     imgLbl1.setIcon(suri1);
	     imgLbl1.setBounds(700, 150, 1000, 700);
	     imgLbl1.setHorizontalAlignment(JLabel.RIGHT);		

				
//		JLabel imgLbl = new JLabel();
//		imgLbl.setBounds(1300, 300, 470, 351);
//		imgLbl.setIcon(mainSuri);
				
//		frame.add(imgLbl);
		
		JLabel back = new JLabel();
		back.setOpaque(true);
		back.setBackground(new Color(4, 34, 83));
		back.setBounds(0, 0, 1980, 1080);
		back.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(back);
	

		startBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				nName=textField.getText();
				System.out.println(nName);
				frame.dispose();
				new choice();
			}
		});
		frame.setVisible(true);
	}
		
	
	

	public static void main(String[] args) {		
		new main_suri();
	}

	
}
