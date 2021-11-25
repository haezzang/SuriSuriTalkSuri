package main;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Program extends JFrame{
	private Image background = new ImageIcon(MainView.class.getResource("../img/background.png")).getImage(); // 베경
	
	public Program() {
		setTitle("메인화면");
		setSize(1500,1000); // 컴퓨터 사이즈
		setResizable(false); // 창의 크기 조절 불가능
		setVisible(true); // 창을 화면에 나타낼 것인지 설정
		setLayout(null);//레이아웃을 내맘대로 설정가능하게 해줌.
		setLocationRelativeTo(null); // 창이 가운데 나오게 하기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // JFrame이 정상적으로 종료되게
		
	}
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null); // background를 그려줌
	}
}
