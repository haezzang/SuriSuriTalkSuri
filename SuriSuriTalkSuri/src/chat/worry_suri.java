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
import java.awt.Shape;
import java.awt.TextField;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import choice.choice;

public class worry_suri {

    public static void main(String[] args) {
    	
        // ������ ����
        JFrame frm = new JFrame("���� �����ϱ�");
 
        // ������ ũ�� ����
        frm.setSize(1980, 1080);

        // �������� ȭ�� ����� ��ġ
        frm.setLocationRelativeTo(null);
        
        // �������� �ݾ��� �� �޸𸮿��� ���ŵǵ��� ����
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        
        //��Ʈ����
        Font font=new Font("�������",Font.PLAIN,28); //��ư�κ�
        Font font1=new Font("�������",Font.PLAIN,35); //�Էºκ�
        Font font2=new Font("�������",Font.PLAIN,30); //ä�úκ�

        // ���̾ƿ� ����
        //frm.getContentPane().setLayout(null);
        
        
        //�ؽ�Ʈarea ����(ä��)       
        JTextArea ta1=new JTextArea(10,20);
        JScrollPane scrollPane=new JScrollPane(ta1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        ta1.setFont(font2); 
        
        scrollPane.setBounds(700,150,1000,650);
        frm.add(scrollPane);
        scrollPane.setVisible(true);
     
        
        
        //�ؽ�Ʈ�ʵ� ����
        RoundJTextField tf1=new RoundJTextField(30);
        frm.getContentPane().add(tf1);
		tf1.setLayout(null);
		tf1.setBounds(720, 805, 900, 40);
		tf1.setFont(font1); 

    	RoundedButton exit = new RoundedButton("����", 0);    
    	RoundedButton send = new RoundedButton("��");    
    	
    	
        //��ư����
        exit.setBounds( 50, 50, 120, 50);
        exit.setFont(font); 
        exit.setBackground(new Color(241,76,76));      
		frm.getContentPane().add(exit);
		send.setBounds( 1630, 800, 50, 50);
		send.setFont(font); 
		frm.getContentPane().add(send);

		
		 /* ImageIcon chatimg = new
		  ImageIcon(worry_suri.class.getResource("../testimage/ä��ȭ��.png")); JLabel
		  chatview = new JLabel(); chatview.setBounds(0, 0, 1980, 1080);
		  frm.getContentPane().add(chatview); chatview.setIcon(chatimg);
		  chatview.setBounds(700, 150, 1000, 700);
		  chatview.setHorizontalAlignment(JLabel.RIGHT);*/
		  
		
		  JLabel grayback = new JLabel(); grayback.setOpaque(true); 
		  grayback.setBackground(Color.LIGHT_GRAY); 
		  grayback.setBounds(700, 800, 1000, 50);
		  grayback.setHorizontalAlignment(JLabel.RIGHT);
		  frm.getContentPane().add(grayback);

		  

		  JLabel whiteback = new JLabel(); whiteback.setOpaque(true); 
		  whiteback.setBackground(new Color(255,255,255)); 
		  whiteback.setBounds(700, 150, 1000, 700);
		  whiteback.setHorizontalAlignment(JLabel.RIGHT);
		  frm.getContentPane().add(whiteback);


		 
		 
	//���

		  JLabel back = new JLabel(); back.setOpaque(true); back.setBackground(new
		  Color(4,34,83)); back.setBounds(0, 0, 1980, 1080);
		 back.setHorizontalAlignment(JLabel.CENTER); frm.getContentPane().add(back);

	



	 // �������� ���̵��� ����
frm.setVisible(true);

       
    }
    

 
}


class RoundJTextField extends JTextField {
    private Shape shape;
    public RoundJTextField(int size) {
        super(size);
        setOpaque(false); // As suggested by @AVD in comment.
    }
    protected void paintComponent(Graphics g) {
         g.setColor(getBackground());
         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
         super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
         g.setColor(getForeground());
         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
    }
    public boolean contains(int x, int y) {
         if (shape == null || !shape.getBounds().equals(getBounds())) {
             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
         }
         return shape.contains(x, y);
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