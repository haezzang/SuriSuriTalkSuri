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
 
    	   // �� �󺧿� ���� ������ ����
        ImageIcon mainSuri = new ImageIcon(MainView.class.getResource("../testimage/mainSuri.png"));
      //  Image backgound = n
        
        // ������ ����
        JFrame frame = new JFrame("����ȭ��");
 
      	JLabel imgLblMain = new JLabel();
     
        // �� �󺧿� ������ ����
        imgLblMain.setIcon(mainSuri);
          
        imgLblMain.setBounds(450, 150, 1000, 700);
        imgLblMain.setHorizontalAlignment(JLabel.RIGHT);
        
        // �����ξ���
        frame.getContentPane().add(imgLblMain);
        
        // ������ ũ�� ����
        frame.setSize(1980, 1080);

        // �������� ȭ�� ����� ��ġ
        frame.setLocationRelativeTo(null);
        
        // �������� �ݾ��� �� �޸𸮿��� ���ŵǵ��� ����
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        // �������� ���̵��� ����
        frame.setVisible(true);
        
        FlowLayout fLay = new FlowLayout();
        frame.getContentPane().setLayout(fLay);
        
        // ���̾ƿ� ����
        frame.getContentPane().setLayout(null);
        
		RoundedButton start = new RoundedButton("����");
       
		 Font font=new Font("�������",Font.PLAIN,28);
       
        //��ư��ġ
        start.setBounds( 500, 800, 300, 80);

        //��Ʈ ����
        start.setFont(font);
        start.setBackground(new Color(51,203,51));
        frame.getContentPane().add(start);
		

		//�׸��ֱ�
//		 JLabel main = new JLabel();
//		 main.setOpaque(true);
//		 main.setBackground(new Color(4,34,83));

//		 main.setBounds(0, 0, 1980, 1080); 
//		 main.setHorizontalAlignment(JLabel.CENTER); 
//		 frame.getContentPane().add(main);
        // ��� Panel
//		JLayeredPane layeredPane = new JLayeredPane();
//		layeredPane.setSize(1980,1080);
//		layeredPane.setLayout(null);
//		
		// �̹��� ����
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
        
	
        // �������� ���̵��� ����
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

