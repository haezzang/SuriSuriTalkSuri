package chat;


import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import chat.luck_suri;
import chat.today_suri;
import chat.worry_suri;


public class husband extends JFrame {
 

	public husband() {
		int random = (int) (Math.random() * 9)+1;
 	   // ★ 라벨에 넣을 아이콘 생성
     ImageIcon h = new ImageIcon(husband.class.getResource("../img/h"+random+".jpg"));

     
     
     
     // 프레임 생성
     JFrame frm = new JFrame("남편이라오~");

     
   	JLabel imgLbl1 = new JLabel();

     
  
  



     frm.getContentPane().add(imgLbl1);

     
     // 프레임 크기 설정
     frm.setSize(600, 600);

     // 프레임을 화면 가운데에 배치
     frm.setLocationRelativeTo(null);
     


  
     
     // ★ 라벨에 아이콘 설정
     imgLbl1.setIcon(h);



     // ★ 기타 설정
     imgLbl1.setBounds(0, 0, 500, 500);

     		
     
   
	
     // 프레임이 보이도록 설정
     frm.setVisible(true);


 }

    public static void main(String[] args) {
    	new husband();

    
}
}


