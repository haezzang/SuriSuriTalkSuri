package SuriChoice;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;



public class surichoice {     


	static Image background;
     public static void main(String[] args) {   
    	 Font font=new Font("나눔고딕",Font.PLAIN,28);
    	 
    	background=new ImageIcon(surichoice.class.getResource("../testimage/background.png")).getImage();
    	 
    	
    	
        JFrame f = new JFrame();        
        f.setVisible(true);             
        f.setTitle("수리수리톡수리");
		f.setLocation(500,200);
		f.setSize(1980, 1080);
		f.setVisible(true);

		RoundedButton exit = new RoundedButton("이전", 0);
		RoundedButton b1 = new RoundedButton("톡하기");
		RoundedButton b2 = new RoundedButton("톡하기");
		RoundedButton b3 = new RoundedButton("톡하기");
       
      
		f.add(exit);
		f.add(b1);
		f.add(b2);
		f.add(b3);
        f.setLayout( null );
        
        exit.setBounds( 50, 50, 120, 50);
        b1.setBounds( 200, 800, 300, 80);
        b2.setBounds( 800, 800, 300, 80);
        b3.setBounds( 1400, 800, 300, 80);
        
        exit.setFont(font);
        b1.setFont(font);
        b2.setFont(font);
        b3.setFont(font);
        
        exit.setBackground(new Color(241,76,76));
        b1.setBackground(new Color(51,203,51));
        b2.setBackground(new Color(51,203,51));
        b3.setBackground(new Color(51,203,51));
    }   
     public void paint(Graphics g) {//그리는 함수
 	
		g.drawImage(background, 0, 0, null);//background를 그려줌
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
		c=new Color(51,203,51);
		r=80;
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

