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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import choice.choice;

public class worry_suri  {
	
	//상황 인덱스
	static int index=0;
	   
	   
	
	//답장 내용
	   static String[] answer= {"후련하게 멋진 선택하고 돌아오는거야!",
			   			"행운의 메세지에 당첨된 너. 오늘은 너의 날이야. 마음껏 즐겨!!",
			   			"전혀 생각지 못했던 즐거움이 찾아올거야. 그동안 쌓였던 스트레스를 한 방에 날려버릴 만한 기분 좋은 소식!!",
			   			"긍정적인 생각을 많이해봐. 좋은 에너지가 너에게 힘을 줄거야. 긍정의 힘은 생각보다 대단해!",
			   			"다부진 너의 손 끝에서 많은 일들이 진행돼. 너 없이는 안될 일이야. 자부심을 갖고 진행해봐! 분명 눈에 띄는 성과가 나타날거야!",
			   			"힘든 나날을 보내고 있다면, 이제 너에 대해 공부해보는건 어때?",
			   			"매일 세 가지 일을 할 때마다 나 자신을 칭찬해봐! 산책을 하거나 즐겁게 놀거나! 마지막에 큰 보상을 기다리지 말고 모든 단계에서 나를 칭찬해봐",
			   			"미루는 것은 최악의 적이 될 수 있어. 지금이라도 시작해보는 건 어때?",
			   			"열심히 지금처럼만 하다보면 다른 사람들보다 더 나은 날이 올 거야! ",
			   			"너의 감정을 솔직하게 나눠봐. 너가 신뢰하는 다른 사람들에게 먼저 마음을 열어보는 것도 나쁘지 않아"};
	   
    public static void main(String[] args) throws Exception {


    
        // 프레임 생성
        JFrame frm = new JFrame("수리 선택하기");
 
        // 프레임 크기 설정
        frm.setSize(1980, 1080);

        // 프레임을 화면 가운데에 배치
        frm.setLocationRelativeTo(null);
        
        // 프레임을 닫았을 때 메모리에서 제거되도록 설정
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        
        //폰트설정
        Font font=new Font("나눔고딕",Font.PLAIN,25); //버튼부분
        Font font1=new Font("나눔고딕",Font.PLAIN,35); //입력부분
        Font font2=new Font("나눔고딕",Font.PLAIN,30); //채팅부분

        
        

          
        //텍스트area 생성(채팅)       
        JTextArea ta1=new JTextArea(10,20);
        
        //스크롤 길이
        JScrollPane scrollPane=new JScrollPane(ta1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        		JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ta1.setFont(font2); 
        
        scrollPane.setBounds(700,120,1000,600);
        frm.add(scrollPane);
        scrollPane.setVisible(true);
        
        //자동줄바꿈
        ta1.setCaretPosition(ta1.getDocument().getLength());


        //글자 색깔
        ta1.setForeground(Color.blue);
        
        //텍스트필드 생성
        RoundJTextField msg=new RoundJTextField(30);
        frm.getContentPane().add(msg);
        msg.setLayout(null);
        msg.setBounds(720, 805, 900, 40);
        msg.setFont(font1); 

    
        //초반 버튼 내용 설정
        String ans1="어 그래;;";
        String ans2="안녕!!";
        String ans3="됐고 고민 들어줘!";
        //버튼 생성
    	RoundedButton exit = new RoundedButton("이전", 0);    
    	RoundedButton send = new RoundedButton("▲"); 
     	RoundedButton answer1 = new RoundedButton(ans1,2); 
    		answer1.setBounds(900,740,200,50);
    		frm.getContentPane().add(answer1);
    		answer1.setFont(font);
    		
    		RoundedButton answer2 = new RoundedButton(ans2,2); 
    		answer2.setBounds(1120,740,200,50);
    		frm.getContentPane().add(answer2);
    		answer2.setFont(font);
    		
    		RoundedButton answer3 = new RoundedButton(ans3,2); 
    		answer3.setBounds(1340,740,200,50);
    		frm.getContentPane().add(answer3);
    		answer3.setFont(font);
        //버튼설정
        exit.setBounds( 50, 50, 120, 50);
        exit.setFont(font); 
        exit.setBackground(new Color(241,76,76));      
		frm.getContentPane().add(exit);
		
		send.setBounds( 1630, 800, 50, 50);
		send.setFont(font); 
		frm.getContentPane().add(send);

		//배경
		  JLabel grayback = new JLabel(); grayback.setOpaque(true); 
		  grayback.setBackground(Color.LIGHT_GRAY); 
		  grayback.setBounds(700, 800, 1000, 50);
		  grayback.setHorizontalAlignment(JLabel.RIGHT);
		  frm.getContentPane().add(grayback);

		
		  JLabel whiteback = new JLabel(); whiteback.setOpaque(true); 
		  whiteback.setBackground(new Color(255,255,255)); 
		  whiteback.setBounds(700, 120, 1000, 600);
		  whiteback.setHorizontalAlignment(JLabel.RIGHT);
		  frm.getContentPane().add(whiteback);
		 
		 

		  JLabel back = new JLabel(); back.setOpaque(true); back.setBackground(new
		  Color(4,34,83)); back.setBounds(0, 0, 1980, 1080);
		  back.setHorizontalAlignment(JLabel.CENTER); frm.getContentPane().add(back);

	


	 // 프레임이 보이도록 설정
frm.setVisible(true);

//버튼이벤트
ta1.setText("흐흐흐흐흫흐흐흫흫\r\n" + 
		"안녕하부엉?\r\n" + 
		"나는 고민을 상담해주는 고민수리부엉이라네!");

// 답장 버튼!
answer1.addActionListener(new ActionListener() {
	int random=(int)(Math.random() * 100);
	public void actionPerformed(ActionEvent e) {
		
		switch (index) {
		case 0:
			//사용자 대답
			ta1.append("\n\t\t\t"+ans1+"\n\n");
			answer1.setEnabled(false);
			answer2.setEnabled(false);
			answer3.setEnabled(false);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	ta1.append("(너의 마음을 궁예보다.. 마음을 잘 꿰뚫어볼 수 있다네..)\r\n" + 
	    			"고민이 있부엉?\r\n" + 
	    			"");	
	     	answer1.setEnabled(true);
			answer2.setEnabled(true);
			answer3.setEnabled(true);
			
	    	answer1.setText("응");
			answer2.setText("아니");
			answer3.setText("그냥 들어와봤어");
			index++;
			break;
			
		case 1:
			ta1.append("\n\t\t\t응\n\n");
			answer1.setEnabled(false);
			answer2.setEnabled(false);
			answer3.setEnabled(false);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	ta1.append(""
	    			+ "그래 내가 들어주지부엉!\r\n" + 
	    			"너의 마음속으로 고민을 생각하면\r\n" + 
	    			"내가 해결책을 제시해주겠부엉\r\n" + 
	    			"생각이 끝나면 버튼을 눌러라 부엉!");
	    	answer1.setEnabled(true);
			answer2.setEnabled(true);
			answer3.setEnabled(true);
			
	    	answer1.setText("생각끝났어!");
			answer2.setText("그냥 안볼래");
			answer3.setText("생각완료..");
			index++;
			break;
			
		case 2:
			ta1.append("\n\t\t\t생각끝났어!\n\n");
			answer1.setEnabled(false);
			answer2.setEnabled(false);
			answer3.setEnabled(false);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, answer[index]);
	    	answer1.setEnabled(true);
			answer2.setEnabled(true);
			answer3.setEnabled(true);
			
	    	answer1.setText("고마워!");
			answer2.setText("사기꾼이니?");
			answer3.setText("잘가~");
			index++;
			break;
			
		case 3:
			ta1.append("\n\t\t\t고마워\n\n");
			answer1.setEnabled(false);
			answer2.setEnabled(false);
			answer3.setEnabled(false);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	ta1.append("어떻게.. 고민은 해결 됐부엉? \r\n" + 
	    			"도움이 되지 못했다면.. 크흠.. 그렇군.. \n다음 번에는 더욱더 꿰뚫어보겠부엉!\r\n" + 
	    			"다음에도 고민이 있다면 찾아오시게나~");		
			break;
		}

	}
	
});

answer2.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
		int random=(int)(Math.random() * 100);
		switch (index) {
		case 0:
			ta1.append("\n\t\t\t안녕!!"+"\n\n");
			answer1.setEnabled(false);
			answer2.setEnabled(false);
			answer3.setEnabled(false);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	ta1.append("(너의 마음을 궁예보다.. 마음을 잘 꿰뚫어볼 수 있다네..)\r\n" + 
	    			"고민이 있부엉?\r\n" + 
	    			"");	
	     	answer1.setEnabled(true);
			answer2.setEnabled(true);
			answer3.setEnabled(true);
			
	    	answer1.setText("응");
			answer2.setText("아니");
			answer3.setText("그냥 들어와봤어");
			index++;
			break;
			
		case 1:
			ta1.append("\n\t\t\t아니\n\n");
			answer1.setEnabled(false);
			answer2.setEnabled(false);
			answer3.setEnabled(false);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	ta1.append(".. 알겠부엉.. 다음에도 찾아주길 바라네..");
			index++;
			break;
			
		case 2:
			ta1.append("\n\t\t\t그냥 안볼래\n\n");
			answer1.setEnabled(false);
			answer2.setEnabled(false);
			answer3.setEnabled(false);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	ta1.append("..(왜저러는거야.. 재수없어;;)ㅎㅎ알겠부엉 잘가시게나!");
	    	index++;
			break;
		}
	
	}
});



answer3.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	
		int random=(int)(Math.random() * 100);
		switch (index) {
		case 0:
			//사용자 대답
			ta1.append("\n\t\t\t"+ans1+"\n\n");
			answer1.setEnabled(false);
			answer2.setEnabled(false);
			answer3.setEnabled(false);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	ta1.append("(너의 마음을 궁예보다.. 마음을 잘 꿰뚫어볼 수 있다네..)\r\n" + 
	    			"고민이 있부엉?\r\n" + 
	    			"");	
	     	answer1.setEnabled(true);
			answer2.setEnabled(true);
			answer3.setEnabled(true);
			
	    	answer1.setText("응");
			answer2.setText("아니");
			answer3.setText("그냥 들어와봤어");
			index++;
			break;
			
		case 1:
			ta1.append("\n\t\t\t그냥 들어와봤어\n\n");
			answer1.setEnabled(false);
			answer2.setEnabled(false);
			answer3.setEnabled(false);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	ta1.append(".. 알겠부엉.. 다음에도 찾아주길 바라네..");
			index++;
			break;
			
		case 2:
			ta1.append("\n\t\t\t생각완료..\n\n");
			answer1.setEnabled(false);
			answer2.setEnabled(false);
			answer3.setEnabled(false);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, answer[index]);
	    	answer1.setEnabled(true);
			answer2.setEnabled(true);
			answer3.setEnabled(true);
			
	    	answer1.setText("고마워!");
			answer2.setText("사기꾼이니?");
			answer3.setText("잘가~");
			index++;
			break;
			
		case 3:
			ta1.append("\n\t\t\t고마워\n\n");
			answer1.setEnabled(false);
			answer2.setEnabled(false);
			answer3.setEnabled(false);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	ta1.append("어떻게.. 고민은 해결 됐부엉? \r\n" + 
	    			"도움이 되지 못했다면.. 크흠.. 그렇군.. \n다음 번에는 더욱더 꿰뚫어보겠부엉!\r\n" + 
	    			"다음에도 고민이 있다면 찾아오시게나~");		
			break;
		}
				
	}
});

       
    }
    
 
  	
  	
}






//둥근 텍스트필드
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

//둥근 버튼
class RoundedButton extends JButton {

	Color c; //배경색 초기화
	int r; //둥근 길이
	public RoundedButton(String text, int i) {
		super(text);

		if(i==1) {
			c=new Color(241,76,76); //빨강
		}
		else 	c=new Color(67,168,255); //파랑
	
		r=50;
		decorate();
	}

	public RoundedButton(String text) {
		super(text);
		c=new Color(67,168,255); //파랑
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
		graphics.setColor(o); //버튼 배경색 결졍
		graphics.setFont(getFont());
		graphics.drawString(getText(), textX, textY);
		graphics.dispose();
		super.paintComponent(g);
	}
}
