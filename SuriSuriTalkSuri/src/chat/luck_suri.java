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

public class luck_suri extends JFrame {

	// 상황 인덱스
	static int index = 0;
	static int random = (int) (Math.random() * 9);
	static int[] line1= {0,7,13,19,25,37,44,51,58}; //처음줄
	static int[] line2= {5,11,17,23,35,42,49,57,65}; //마지막줄
	static String answer = "";
	static boolean alert = false; // 입력안내

	public luck_suri() {

		// 0. 파일 준비
		Path path = Paths.get("C:\\Users\\82108\\Desktop\\text\\today\\answer.txt");
		try {
			// 1. 파일 전체 읽기
			List<String> allLines = Files.readAllLines(path);
			// 2. 3번째 라인 읽기
			for(int i=line1[random]; i<=line2[random]; i++) {
				answer += allLines.get(i)+"\n";
			}
			
			// 3. 결과 출력
			System.out.println(answer); // line 3
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 프레임 생성
		JFrame frm = new JFrame("운세수리와 채팅중");

		// 프레임 크기 설정
		frm.setSize(1980, 1080);

		// 프레임을 화면 가운데에 배치
		frm.setLocationRelativeTo(null);

		// 프레임을 닫았을 때 메모리에서 제거되도록 설정
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 폰트설정
		Font font = new Font("나눔고딕", Font.PLAIN, 25); // 버튼부분
		Font font1 = new Font("나눔고딕", Font.PLAIN, 28); // 입력부분
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
		String ans1 = "반가워! ";
		String ans2 = "우왕 ";
		String ans3 = "빨리 운세 볼래";
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

		// 이전
		exit.addActionListener(event -> {
			new choice();
			frm.setVisible(false);

		});

		send.setEnabled(false);
		// 버튼이벤트
		ta1.setText("여기는 미림부엉마을에 사는 부엉이들이 모여\n 운세를 봐주고 고민을 들어주는 곳이라옹\n나는 취업, 연애, 남편운 봐주는 운세수리라 해옹");

		send.addActionListener(event -> {
			String birth = msg.getText();
			// 정확히 썼는지 구분하기~
			ta1.setCaretPosition(ta1.getDocument().getLength());
			ta1.append("\n\t\t\t\t" + birth + "\n\n");
			msg.setEnabled(false);
			send.setEnabled(false);
			answer1.setEnabled(true);
			answer2.setEnabled(true);
			answer3.setEnabled(true);
			ta1.append("오 좋았옹!! 자 이제 운세를 볼까옹~?");
			answer1.setText("가보자고! ");
			answer2.setText("ㄱ ");
			answer3.setText("현기증나 빨리 말해");
			index++;

		});

		msg.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String birth = msg.getText();
				// 정확히 썼는지 구분하기~
				ta1.setCaretPosition(ta1.getDocument().getLength());
				ta1.append("\n\t\t\t\t" + birth + "\n\n");
				msg.setEnabled(false);
				send.setEnabled(false);
				answer1.setEnabled(true);
				answer2.setEnabled(true);
				answer3.setEnabled(true);
				ta1.append("오 좋았옹!! 자 이제 운세를 볼까옹~?");
				answer1.setText("가보자고! ");
				answer2.setText("ㄱ ");
				answer3.setText("현기증나 빨리 말해");
				index++;

			}
		});

		// 답장 버튼!
		answer1.addActionListener(event -> {

			switch (index) {
			case 0:
				// 사용자 대답
				ta1.append("\n\t\t\t\t" + ans1 + "\n\n");
				ta1.append("옹홍홍.. 나의 특기를 살려 아주 빠르게 운세를 봐주겠옹!\n오늘은 어떤 운세를 보러왔옹?");
				answer1.setText("취업");
				answer2.setText("연애");
				answer3.setText("남편");
				index++;
				break;
			case 1:
				ta1.append("\n\n\t\t\t\t취업\n");
				ta1.append("\n취업운이 궁금했옹? 지금 당장 알아보자옹!");
				ta1.append("\n당신의 학년은 어떻게 되옹?");
				answer1.setText("1학년");
				answer2.setText("2학년  ");
				answer3.setText("3학년 ");
				index++;
				break;

			case 2:
				ta1.append("\n\t\t\t\t1학년");
				ta1.append("\n\n풋풋한 나이옹~ 부럽다옹");
				ta1.append("\n생년월일을 알려주시옹!");
				msg.setEnabled(true);
				msg.setText("ex) 040602");
				msg.setForeground(Color.lightGray);
			
				send.setEnabled(true);
				answer1.setEnabled(false);
				answer2.setEnabled(false);
				answer3.setEnabled(false);
				break;

			case 3:
				ta1.setCaretPosition(ta1.getDocument().getLength());
				ta1.append("\n\n\t\t\t\t가보자고!\n\n");
				ta1.append("(아소미미키키 우우 굼바라 움치락 꿈치락)");
				answer1.setEnabled(false);
				answer2.setEnabled(false);
				answer3.setEnabled(false);
				break;
			}
		}

		);

		answer2.addActionListener(event -> {

			switch (index) {
			case 0:
				// 사용자 대답
				ta1.append("\n\t\t\t\t" + ans2 + "\n\n");
				ta1.append("옹홍홍.. 나의 특기를 살려 아주 빠르게 운세를 봐주겠옹!\n오늘은 어떤 운세를 보러왔옹?");
				answer1.setText("취업");
				answer2.setText("연애");
				answer3.setText("남편");
				break;
			case 1:
				ta1.append("\n\t\t\t\t연애\n\n");
				ta1.append("연애운이라.. 이쪽은 내가 전문이라옹~^^\n당신의 학년은 어떻게 되옹?");
				answer1.setText("두근두근");
				answer2.setText("당장 보여줘 ");
				answer3.setText("설렌다");
				index++;
				break;

			case 2:
				ta1.append("\n\t\t\t\t당장 보여줘"
						+ "");
				JOptionPane.showMessageDialog(null, answer, "오늘운세라오~", JOptionPane.INFORMATION_MESSAGE);
				ta1.setCaretPosition(ta1.getDocument().getLength());
				ta1.append("\n\n오늘 운세는 마음에 들었소??");
				answer1.setText("하 됐다 걍;");
				answer2.setText("너무 쭈아 ㅎㅎ");
				answer3.setText("ㅇㅇ");
				index++;
				break;

			case 3:
				ta1.setCaretPosition(ta1.getDocument().getLength());
				ta1.append("\n\t\t\t\t너무 쭈아 ㅎㅎ\n\n");
				ta1.append("역시나~~ 그대를 기다린 보람이 있소 오늘도 좋은 하루가 되었으면 좋겠구려\n나 오늘수리도 그대를 위한 하루를 보내겠소!!");
				answer1.setEnabled(false);
				answer2.setEnabled(false);
				answer3.setEnabled(false);
				break;
			}
		}

		);

		answer3.addActionListener(event -> {

			switch (index) {
			case 0:
				// 사용자 대답
				ta1.append("\n\t\t\t                " + ans3 + "\n\n");
				ta1.append("옹홍홍.. 나의 특기를 살려 아주 빠르게 운세를 봐주겠옹!\n오늘은 어떤 운세를 보러왔옹?");
				answer1.setText("취업");
				answer2.setText("연애");
				answer3.setText("남편");
				break;

			case 1:
				ta1.append("\n\t\t\t\t남편\n\n");
				ta1.append("남편운!!! 미래 남편은 누구일지.. 알아보러 가보자아아옹!");
				answer1.setText("두근두근");
				answer2.setText("당장 보여줘 ");
				answer3.setText("설렌다");
				index++;
				break;

			case 2:

				JOptionPane.showMessageDialog(null, answer, "오늘운세라오~", JOptionPane.INFORMATION_MESSAGE);
				ta1.append("\n\t\t\t\t설렌다");
				ta1.setCaretPosition(ta1.getDocument().getLength());
				ta1.append("\n\n오늘 운세는 마음에 들었소??");
				answer1.setText("하 됐다 걍;");
				answer2.setText("너무 쭈아 ㅎㅎ");
				answer3.setText("ㅇㅇ");
				index++;
				break;

			case 3:
				ta1.setCaretPosition(ta1.getDocument().getLength());
				ta1.append("\n\t\t\t\tㅇㅇ\n\n");
				ta1.append("역시나~~ 그대를 기다린 보람이 있소 오늘도 좋은 하루가 되었으면 좋겠구려\n나 오늘수리도 그대를 위한 하루를 보내겠소!!");
				answer1.setEnabled(false);
				answer2.setEnabled(false);
				answer3.setEnabled(false);
				break;
			}
		});
	}

	public static void main(String[] args) {
		new luck_suri();
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
