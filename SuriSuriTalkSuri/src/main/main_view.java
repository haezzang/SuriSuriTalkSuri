package main;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class main_view extends JFrame {
	
	/*�̹��� ������*/
	private Image background=new ImageIcon(main_view.class.getResource("C:/school2/�������������/img/background.png")).getImage();//����̹���
		
	public main_view() {
		homeframe();
	}
		
	public void homeframe() {
		
		setTitle("�������������");
		setLocation(500,200);
		setSize(1500, 1000);
		setVisible(true);
		setResizable(false);//â�� ũ�⸦ �������� ���ϰ�
		setLocationRelativeTo(null);//â�� ��� ������
		//â�ݱ� 
		setLayout(null);//���̾ƿ��� ������� ���������ϰ� ����.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame�� ���������� ����ǰ�
	}
		
	public void paine(Graphics g) {
		g.drawImage(background, 0, 0, null);//background�� �׷���
	}
	public static void main(String[] args){
		new main_view();
	}
}



