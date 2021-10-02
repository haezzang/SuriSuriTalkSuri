package main;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class main_view extends JFrame {
	
	/*이미지 프레임*/
	private Image background=new ImageIcon(main_view.class.getResource("C:/school2/수리수리톡수리/img/background.png")).getImage();//배경이미지
		
	public main_view() {
		homeframe();
	}
		
	public void homeframe() {
		
		setTitle("수리수리톡수리");
		setLocation(500,200);
		setSize(1500, 1000);
		setVisible(true);
		setResizable(false);//창의 크기를 변경하지 못하게
		setLocationRelativeTo(null);//창이 가운데 나오게
		//창닫기 
		setLayout(null);//레이아웃을 내맘대로 설정가능하게 해줌.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame이 정상적으로 종료되게
	}
		
	public void paine(Graphics g) {
		g.drawImage(background, 0, 0, null);//background를 그려줌
	}
	public static void main(String[] args){
		new main_view();
	}
}



