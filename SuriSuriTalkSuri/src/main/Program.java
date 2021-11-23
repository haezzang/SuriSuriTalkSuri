package main;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Program extends JFrame{
	private Image background = new ImageIcon(MainView.class.getResource("../img/background.png")).getImage(); // ����
	
	public Program() {
		setTitle("����ȭ��");
		setSize(1500,1000); // ��ǻ�� ������
		setResizable(false); // â�� ũ�� ���� �Ұ���
		setVisible(true); // â�� ȭ�鿡 ��Ÿ�� ������ ����
		setLayout(null);//���̾ƿ��� ������� ���������ϰ� ����.
		setLocationRelativeTo(null); // â�� ��� ������ �ϱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // JFrame�� ���������� ����ǰ�
		
	}
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null); // background�� �׷���
	}
}
