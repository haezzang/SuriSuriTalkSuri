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
 	   // �� �󺧿� ���� ������ ����
     ImageIcon h = new ImageIcon(husband.class.getResource("../img/h"+random+".jpg"));

     
     
     
     // ������ ����
     JFrame frm = new JFrame("�����̶��~");

     
   	JLabel imgLbl1 = new JLabel();

     
  
  



     frm.getContentPane().add(imgLbl1);

     
     // ������ ũ�� ����
     frm.setSize(600, 600);

     // �������� ȭ�� ����� ��ġ
     frm.setLocationRelativeTo(null);
     


  
     
     // �� �󺧿� ������ ����
     imgLbl1.setIcon(h);



     // �� ��Ÿ ����
     imgLbl1.setBounds(0, 0, 500, 500);

     		
     
   
	
     // �������� ���̵��� ����
     frm.setVisible(true);


 }

    public static void main(String[] args) {
    	new husband();

    
}
}


