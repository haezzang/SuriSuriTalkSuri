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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import choice.choice;


public class worry_suri extends JFrame  {

	// 상황 인덱스
	static int index = 0;
	static int random = (int) (Math.random() * 10);
	static String answer="";

	



	
		public worry_suri() {

			// 0. 파일 준비
			Path path = Paths.get("C:\\Users\\82108\\Desktop\\text\\worry\\answer.txt");
			try {
				// 1. 파일 전체 읽기
				List<String> allLines = Files.readAllLines(path);
				// 2. 3번째 라인 읽기
				answer = allLines.get(random);
				// 3. 결과 출력
				System.out.println(answer); // line 3
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		// 프레임 생성
		JFrame frm = new JFrame("고민수리와 채팅중");

		// 프레임 크기 설정
		frm.setSize(1980, 1080);

		// 프레임을 화면 가운데에 배치
		frm.setLocationRelativeTo(null);

		// 프레임을 닫았을 때 메모리에서 제거되도록 설정
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 폰트설정
		Font font = new Font("나눔고딕", Font.PLAIN, 25); // 버튼부분
		Font font1 = new Font("나눔고딕", Font.PLAIN, 35); // 입력부분
		Font font2 = new Font("나눔고딕", Font.PLAIN, 28); // 채팅부분

		// 텍스트area 생성(채팅)
		JTextArea ta1 = new JTextArea(10, 20);

		// 스크롤 길이
		JScrollPane scrollPane = new JScrollPane(ta1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		ta1.setFont(font2);

		scrollPane.setBounds(700, 120, 1000, 600);
		frm.add(scrollPane);
		scrollPane.setVisible(true);

		// 자동줄바꿈


		// 글자 색깔
		ta1.setForeground(Color.black);
		// 텍스트필드 생성
		RoundJTextField msg = new RoundJTextField(30);
		frm.getContentPane().add(msg);
		msg.setLayout(null);
		msg.setBounds(720, 805, 900, 40);
		msg.setFont(font1);
		msg.setEnabled(false);

		// 초반 버튼 내용 설정
		String ans1 = "어 그래;;";
		String ans2 = "안녕!!";
		String ans3 = "됐고 고민 들어줘!";
		// 버튼 생성
		RoundedButton exit = new RoundedButton("이전", 1);
		RoundedButton send = new RoundedButton("▲");
		RoundedButton answer1 = new RoundedButton(ans1, 2);
		answer1.setBounds(900, 740, 200, 50);
		frm.getContentPane().add(answer1);
		answer1.setFont(font);

		RoundedButton answer2 = new RoundedButton(ans2, 2);
		answer2.setBounds(1120, 740, 200, 50);
		frm.getContentPane().add(answer2);
		answer2.setFont(font);

		RoundedButton answer3 = new RoundedButton(ans3, 2);
		answer3.setBounds(1340, 740, 200, 50);
		frm.getContentPane().add(answer3);
		answer3.setFont(font);
		// 버튼설정
		exit.setBounds(50, 50, 120, 50);
		exit.setFont(font);
		exit.setBackground(new Color(241, 76, 76));
		frm.getContentPane().add(exit);

		send.setBounds(1630, 800, 50, 50);
		send.setFont(font);
		frm.getContentPane().add(send);

		// 배경
		JLabel grayback = new JLabel();
		grayback.setOpaque(true);
		grayback.setBackground(Color.LIGHT_GRAY);
		grayback.setBounds(700, 800, 1000, 50);
		grayback.setHorizontalAlignment(JLabel.RIGHT);
		frm.getContentPane().add(grayback);

		JLabel whiteback = new JLabel();
		whiteback.setOpaque(true);
		whiteback.setBackground(new Color(255, 255, 255));
		whiteback.setBounds(700, 120, 1000, 600);
		whiteback.setHorizontalAlignment(JLabel.RIGHT);
		frm.getContentPane().add(whiteback);

		JLabel back = new JLabel();
		back.setOpaque(true);
		back.setBackground(new Color(4, 34, 83));
		back.setBounds(0, 0, 1980, 1080);
		back.setHorizontalAlignment(JLabel.CENTER);
		frm.getContentPane().add(back);

		// 프레임이 보이도록 설정
		frm.setVisible(true);

		
		
		//이전
		exit.addActionListener(event -> {
			new choice();
			frm.setVisible(false);
	       
	        });  
	
		//버튼이벤트
		ta1.setText("흐흐흐흐흫흐흐흫흫\r\n" + "안녕하부엉?\r\n" + "나는 고민을 상담해주는 고민수리부엉이라네!");
		// 답장 버튼!
		answer1.addActionListener(event -> {

				switch (index) {
				case 0:
					// 사용자 대답
					answer1.setEnabled(false);
					answer2.setEnabled(false);
					answer3.setEnabled(false);
					ta1.append("\n\t\t\t\t" + ans1 + "\n\n");
					ta1.append("(너의 마음을 궁예보다.. 마음을 잘 꿰뚫어볼 수 있다네..)\n" + "고민이 있부엉?\n");
					answer1.setEnabled(true);
					answer2.setEnabled(true);
					answer3.setEnabled(true);
					answer1.setText("응");
					answer2.setText("아니");
					answer3.setText("그냥 들어와봤어");	
					ta1.setForeground(Color.black);
					index++;
					break;

				case 1:		
					answer1.setEnabled(false);
					answer2.setEnabled(false);
					answer3.setEnabled(false);
					ta1.append("\n\t\t\t\t응\n\n");
					ta1.append("그래 내가 들어주지부엉!\n너의 마음속으로 고민을 생각하면\n내가 해결책을 제시해주겠부엉\n생각이 끝나면 버튼을 눌러라 부엉!");
					answer1.setEnabled(true);
					answer2.setEnabled(true);
					answer3.setEnabled(true);
					answer1.setText("생각끝났어!");
					answer2.setText("그냥 안볼래");
					answer3.setText("생각완료.."); 
					index++;
					break;

				case 2:			
					ta1.append("\n\t\t\t\t생각끝났어!\n\n");
					
					answer1.setEnabled(false);
					answer2.setEnabled(false);
					answer3.setEnabled(false);
					//팝업창 띄우기
					JOptionPane.showMessageDialog(null, answer,"해결책은?", JOptionPane.INFORMATION_MESSAGE);
					ta1.setCaretPosition(ta1.getDocument().getLength());
					answer1.setEnabled(true);
					answer2.setEnabled(true);
					answer3.setEnabled(true);

					answer1.setText("고마워!");
					answer2.setText("사기꾼이니?");
					answer3.setText("잘가~");
			

					index++;
					break;

				case 3:
					ta1.append("\n\t\t\t\t고마워\n\n");
					answer1.setEnabled(false);
					answer2.setEnabled(false);
					answer3.setEnabled(false);

					
					ta1.append("어떻게.. 고민은 해결 됐부엉? \r\n" + "도움이 되지 못했다면.. 크흠.. 그렇군.. \n다음 번에는 더욱더 꿰뚫어보겠부엉!\r\n"
							+ "다음에도 고민이 있다면 찾아오시게나~");
					break;
				}

			}

		);


	
		answer2.addActionListener(event -> {

				int random = (int) (Math.random() * 10);
				switch (index) {
				case 0:
					ta1.append("\n\t\t\t\t안녕!!" + "\n\n");
					answer1.setEnabled(false);
					answer2.setEnabled(false);
					answer3.setEnabled(false);

				
					ta1.append("(너의 마음을 궁예보다.. 마음을 잘 꿰뚫어볼 수 있다네..)\r\n" + "고민이 있부엉?\r\n" + "");
					answer1.setEnabled(true);
					answer2.setEnabled(true);
					answer3.setEnabled(true);

					answer1.setText("응");
					answer2.setText("아니");
					answer3.setText("그냥 들어와봤어");
					index++;
					break;

				case 1:
					ta1.append("\n\t\t\t\t아니\n\n");
					answer1.setEnabled(false);
					answer2.setEnabled(false);
					answer3.setEnabled(false);

					ta1.append(".. 알겠부엉.. 다음에도 찾아주길 바라네..");
					
					index++;
					break;

				case 2:
					ta1.append("\n\t\t\t\t그냥 안볼래\n\n");
					answer1.setEnabled(false);
					answer2.setEnabled(false);
					answer3.setEnabled(false);
					ta1.append("..(왜저러는거야.. 재수없어;;)ㅎㅎ알겠부엉 잘가시게나!");
					index++;
					break;
				case 3:
					ta1.setCaretPosition(ta1.getDocument().getLength());
					ta1.append("\n\t\t\t\t사기꾼이니?\n\n");
					answer1.setEnabled(false);
					answer2.setEnabled(false);
					answer3.setEnabled(false);
	
					ta1.append("어떻게.. 고민은 해결 됐부엉? \r\n" + "도움이 되지 못했다면.. 크흠.. 그렇군.. \n다음 번에는 더욱더 꿰뚫어보겠부엉!\r\n"
							+ "다음에도 고민이 있다면 찾아오시게나~");

					break;
				}

			}
		);



		answer3.addActionListener(event -> {
		

	
				switch (index) {
				case 0:
					// 사용자 대답
					ta1.append("\n\t\t\t                " + ans3 + "\n\n");
					answer1.setEnabled(false);
					answer2.setEnabled(false);
					answer3.setEnabled(false);

				
					ta1.append("(너의 마음을 궁예보다.. 마음을 잘 꿰뚫어볼 수 있다네..)\r\n" + "고민이 있부엉?\r\n" + "");
					answer1.setEnabled(true);
					answer2.setEnabled(true);
					answer3.setEnabled(true);

					answer1.setText("응");
					answer2.setText("아니");
					answer3.setText("그냥 들어와봤어");
					index++;
					break;

				case 1:
					ta1.append("\n\t\t\t                그냥 들어와봤어\n\n");
					answer1.setEnabled(false);
					answer2.setEnabled(false);
					answer3.setEnabled(false);

		
					ta1.append(".. 알겠부엉.. 다음에도 찾아주길 바라네..");
					index++;
					break;

				case 2:
					ta1.append("\n\t\t\t\t생각완료..\n\n");
					answer1.setEnabled(false);
					answer2.setEnabled(false);
					answer3.setEnabled(false);


					JOptionPane.showMessageDialog(null, answer,"해결책은?", JOptionPane.INFORMATION_MESSAGE);
					ta1.setCaretPosition(ta1.getDocument().getLength());
					answer1.setEnabled(true);
					answer2.setEnabled(true);
					answer3.setEnabled(true);

					answer1.setText("고마워!");
					answer2.setText("사기꾼이니?");
					answer3.setText("잘가~");
					index++;
					break;

				case 3:
					ta1.append("\n\t\t\t\t고마워\n\n");
					answer1.setEnabled(false);
					answer2.setEnabled(false);
					answer3.setEnabled(false);

					ta1.append("어떻게.. 고민은 해결 됐부엉? \r\n" + "도움이 되지 못했다면.. 크흠.. 그렇군.. \n다음 번에는 더욱더 꿰뚫어보겠부엉!\r\n"
							+ "다음에도 고민이 있다면 찾아오시게나~");
					break;
				}
			}
		);
	}

		
	
	public static void main(String[] args) {
		new worry_suri();
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
		g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
	}

	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		}
		return shape.contains(x, y);
	}
}

//둥근 버튼
class RoundedButton extends JButton {

	Color c; // 배경색 초기화
	int r; // 둥근 길이

	public RoundedButton(String text, int i) {
		super(text);

		if (i == 1) {
			c = new Color(241, 76, 76); // 빨강
		} else
			c = new Color(67, 168, 255); // 파랑

		r = 50;
		decorate();
	}

	public RoundedButton(String text) {
		super(text);
		c = new Color(67, 168, 255); // 파랑
		r = 100;
		decorate();
	}

	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Color o = new Color(255, 255, 255); // 글자색 결정
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
		graphics.setColor(o); // 버튼 배경색 결졍
		graphics.setFont(getFont());
		graphics.drawString(getText(), textX, textY);
		graphics.dispose();
		super.paintComponent(g);
	}
}
