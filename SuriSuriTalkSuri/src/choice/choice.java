package choice;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import chat.*;

public class choice {
 
    public static void main(String[] args) {
 
        // ������ ����
        JFrame frm = new JFrame("���� �����ϱ�");
 
        // ������ ũ�� ����
        frm.setSize(1980, 1080);

        // �������� ȭ�� ����� ��ġ
        frm.setLocationRelativeTo(null);
        
        // �������� �ݾ��� �� �޸𸮿��� ���ŵǵ��� ����
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        // �������� ���̵��� ����
        frm.setVisible(true);
        
        FlowLayout fLay = new FlowLayout();
        frm.getContentPane().setLayout(fLay);
        
        // ���̾ƿ� ����
        frm.getContentPane().setLayout(null);
        
    	RoundedButton exit = new RoundedButton("����", 0);
		RoundedButton b1 = new RoundedButton("���ϱ�");
		RoundedButton b2 = new RoundedButton("���ϱ�");
		RoundedButton b3 = new RoundedButton("���ϱ�");
       
		 Font font=new Font("�������",Font.PLAIN,28);


		
        
        //��ư��ġ
        exit.setBounds( 50, 50, 120, 50);
        b1.setBounds( 200, 800, 300, 80);
        b2.setBounds( 800, 800, 300, 80);
        b3.setBounds( 1400, 800, 300, 80);
        //��Ʈ ����
        exit.setFont(font);
        b1.setFont(font);
        b2.setFont(font);
        b3.setFont(font);
        
        exit.setBackground(new Color(241,76,76));
        b1.setBackground(new Color(51,203,51));
        b2.setBackground(new Color(51,203,51));
        b3.setBackground(new Color(51,203,51));
        
		frm.getContentPane().add(exit);
		frm.getContentPane().add(b1);
		frm.getContentPane().add(b2);
		frm.getContentPane().add(b3);
        
		
		
		//�׸��ֱ�
		
	       	JLabel imgLbl1 = new JLabel();
	    	JLabel imgLbl2 = new JLabel();
	    	JLabel imgLbl3 = new JLabel();
	        
	        // �� �󺧿� ���� ������ ����
	        ImageIcon suri1 = new ImageIcon(choice.class.getResource("../testimage/���ü���.png"));
	        ImageIcon suri2 = new ImageIcon(choice.class.getResource("../testimage/��μ���.png"));
	        ImageIcon suri3 = new ImageIcon(choice.class.getResource("../testimage/�����.png"));
	        // �� �󺧿� ������ ����
	        imgLbl1.setIcon(suri1);
	        imgLbl2.setIcon(suri2);
	        imgLbl3.setIcon(suri3);
	        
	        // �� ��Ÿ ����
	        imgLbl1.setBounds(200, 150, 300, 600);
	        imgLbl1.setHorizontalAlignment(JLabel.CENTER);
	        
	        imgLbl2.setBounds(800, 150, 300, 600);
	        imgLbl2.setHorizontalAlignment(JLabel.CENTER);
	        
	        imgLbl2.setBounds(1400, 150, 300, 600);
	        imgLbl3.setHorizontalAlignment(JLabel.CENTER);
	        frm.getContentPane().add(imgLbl1);
	        frm.getContentPane().add(imgLbl2);
	        frm.getContentPane().add(imgLbl3);
	        
	        
	        // ��ư�� ��������
	        b1.addActionListener(event -> {
	        	new worry_suri();
	        	frm.setVisible(false);  	
	        });
	 
	        b2.addActionListener(event -> {

	            frm.setVisible(false);  	
	        });
	        
	        b3.addActionListener(event -> {
	  
	            frm.setVisible(false);  	
	        });
	        
			 JLabel choiceview = new JLabel();
			 choiceview.setOpaque(true);
			 choiceview.setBackground(new Color(4,34,83));

			 choiceview.setBounds(0, 0, 1980, 1080); 
			 choiceview.setHorizontalAlignment(JLabel.CENTER); 
			 frm.getContentPane().add(choiceview);
        // �������� ���̵��� ����
        frm.setVisible(true);
    }
 
}




class RoundedButton extends JButton {

	Color c; //���� �ʱ�ȭ
	int r;
	public RoundedButton(String string, int i) {
		super("����");
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
		Color o = new Color(255,255,255); // ���ڻ� ����
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