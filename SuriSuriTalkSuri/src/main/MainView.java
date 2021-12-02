package main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import choice.choice;


public class MainView {

//	Image backgound = null;
    public static void main(String[] args) {
 
    	   // ★ 라벨에 넣을 아이콘 생성
        ImageIcon mainSuri = new ImageIcon(MainView.class.getResource("../testimage/mainSuri.png"));
      //  Image backgound = n
        
        // 프레임 생성
        JFrame frame = new JFrame("메인화면");
 
      	JLabel imgLblMain = new JLabel();
     
        // ★ 라벨에 아이콘 설정
        imgLblMain.setIcon(mainSuri);
          
        imgLblMain.setBounds(450, 150, 1000, 700);
        imgLblMain.setHorizontalAlignment(JLabel.RIGHT);
        
        // 수리부엉이
        frame.getContentPane().add(imgLblMain);
        
        // 프레임 크기 설정
        frame.setSize(1980, 1080);

        // 프레임을 화면 가운데에 배치
        frame.setLocationRelativeTo(null);
        
        // 프레임을 닫았을 때 메모리에서 제거되도록 설정
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        // 프레임이 보이도록 설정
        frame.setVisible(true);
        
        FlowLayout fLay = new FlowLayout();
        frame.getContentPane().setLayout(fLay);
        
        // 레이아웃 설정
        frame.getContentPane().setLayout(null);
        
		RoundedButton start = new RoundedButton("시작");
       
		 Font font=new Font("나눔고딕",Font.PLAIN,28);
       
        //버튼위치
        start.setBounds( 500, 800, 300, 80);

        //폰트 설정
        start.setFont(font);
        start.setBackground(new Color(51,203,51));
        frame.getContentPane().add(start);
		

		//그림넣기
//		 JLabel main = new JLabel();
//		 main.setOpaque(true);
//		 main.setBackground(new Color(4,34,83));

//		 main.setBounds(0, 0, 1980, 1080); 
//		 main.setHorizontalAlignment(JLabel.CENTER); 
//		 frame.getContentPane().add(main);
        // 배경 Panel
//		JLayeredPane layeredPane = new JLayeredPane();
//		layeredPane.setSize(1980,1080);
//		layeredPane.setLayout(null);
//		
		// 이미지 삽입
/*		myPanel panel = new myPanel();
		panel.setSize(1980,1080);*/
//		layerdPane.add(panel);
//		
//		setLayout(null);
//		
//		add(layerdPane);
//		
//		setBounds(720,220,480,640);
//		set
        
	
        // 프레임이 보이도록 설정
		 frame.setVisible(true);
        
     	new choice();

        start.addActionListener(event -> {
        	new choice();
            frame.setVisible(true);  	
        });
    }
 
//    class myPanel extends JPanel{
//    	public void paint(Graphics g) {
//    		g.drawImage(img, 0, 0,null);
//    	}
//    }
}

