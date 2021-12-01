package chat;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.TextField;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import choice.choice;

public class worry_suri {

    public static void main(String[] args) {
    	
        // 프레임 생성
        JFrame frm = new JFrame("수리 선택하기");
 
        // 프레임 크기 설정
        frm.setSize(1980, 1080);

        // 프레임을 화면 가운데에 배치
        frm.setLocationRelativeTo(null);
        
        // 프레임을 닫았을 때 메모리에서 제거되도록 설정
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        Font font=new Font("나눔고딕",Font.PLAIN,28);
		 
        FlowLayout fLay = new FlowLayout();
        frm.getContentPane().setLayout(fLay);
        
        // 레이아웃 설정
        frm.getContentPane().setLayout(null);
        //텍스트필드 생성
        JTextField tf1=new JTextField(15);
        frm.getContentPane().add(tf1);
        

    	RoundedButton exit = new RoundedButton("이전", 0);    
    	RoundedButton send = new RoundedButton("▲");    
        //버튼위치
        exit.setBounds( 50, 50, 120, 50);
        exit.setFont(font); 
        exit.setBackground(new Color(241,76,76));      
		frm.getContentPane().add(exit);
		send.setBounds( 300, 0, 50, 50);
		send.setFont(font); 
		frm.getContentPane().add(send);

		
		  ImageIcon chatimg = new
		  ImageIcon(worry_suri.class.getResource("../testimage/채팅화면.png")); JLabel
		  chatview = new JLabel(); chatview.setBounds(0, 0, 1980, 1080);
		  frm.getContentPane().add(chatview); chatview.setIcon(chatimg);
		  chatview.setBounds(150, 150, 1000, 700);
		  chatview.setHorizontalAlignment(JLabel.RIGHT);

		 
		 
	//배경

		  JLabel back = new JLabel(); back.setOpaque(true); back.setBackground(new
		  Color(4,34,83)); back.setBounds(0, 0, 1980, 1080);
		 back.setHorizontalAlignment(JLabel.CENTER); frm.getContentPane().add(back);

	



	 // 프레임이 보이도록 설정
frm.setVisible(true);

       
    }
    

 
}




class RoundedButton extends JButton {

	Color c; //배경색 초기화
	int r;
	public RoundedButton(String string, int i) {
		super("이전");
		c=new Color(241,76,76);
		r=50;
		decorate();
	}

	public RoundedButton(String text) {
		super(text);
		c=new Color(67,168,255);
		r=100;
		decorate();
	}




	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Color o = new Color(255,255,255); // 글자색 결정
		int width = getWidth();
		int height = getHeight();
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if (getModel().isArmed()) {
			graphics.setColor(c.darker());
		} else if (getModel().isRollover()) {
			graphics.setColor(c.brighter());
		} else {
			graphics.setColor(c);
		}
		graphics.fillRoundRect(0, 0, width, height, r, r);
		FontMetrics fontMetrics = graphics.getFontMetrics();
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();
		int textX = (width - stringBounds.width) / 2;
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();
		graphics.setColor(o);
		graphics.setFont(getFont());
		graphics.drawString(getText(), textX, textY);
		graphics.dispose();
		super.paintComponent(g);
	}
}