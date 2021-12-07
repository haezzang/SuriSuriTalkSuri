package chat;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import choice.choice;
import static chat.main_suri.nName;
public class luck_suri extends JFrame {

	JTextArea ta1;
	RoundedButton answer1;
	RoundedButton answer2;
	RoundedButton answer3;
	
	RoundJTextField msg;
	RoundedButton exit;
	RoundedButton send;
	int choice = -1; // 취업 =0, 연애 = 1, 남편 = 2
	
	// 상황 인덱스
	
	static int index = 0;
	static int random = (int) (Math.random() * 9);
	
	static String answer = "";
	static boolean alert = false; // 입력안내

	public luck_suri() {

		// 프레임 생성
		JFrame frame = new JFrame("운세수리와 채팅중");

		// 프레임 크기 설정
		frame.setSize(1980, 1080);

		// 프레임을 화면 가운데에 배치
		frame.setLocationRelativeTo(null);

		// 프레임을 닫았을 때 메모리에서 제거되도록 설정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 폰트설정
		Font font = new Font("나눔고딕", Font.PLAIN, 25); // 버튼부분
		Font font1 = new Font("나눔고딕", Font.PLAIN, 28); // 입력부분
		Font font2 = new Font("나눔고딕", Font.PLAIN, 28); // 채팅부분

		// 텍스트area 생성(채팅)
		ta1 = new JTextArea(10, 20);

		// 스크롤 길이
		JScrollPane scrollPane = new JScrollPane(ta1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		ta1.setFont(font2);

		scrollPane.setBounds(700, 120, 1000, 600);
		frame.add(scrollPane);
		scrollPane.setVisible(true);

		// 자동줄바꿈

		// 글자 색깔
		ta1.setForeground(Color.black);
		// 텍스트필드 생성
		msg = new RoundJTextField(30);
		frame.getContentPane().add(msg);
		msg.setLayout(null);
		msg.setBounds(720, 805, 900, 40);
		msg.setFont(font1);
		msg.setEnabled(false);

		// 초반 버튼 내용 설정
		String ans1 = "반가워! ";
		String ans2 = "우왕 ";
		String ans3 = "빨리 운세 볼래";
		// 버튼 생성
		exit = new RoundedButton("이전", 1);
		send = new RoundedButton("▲");
		answer1 = new RoundedButton(ans1, 2);
		answer1.setBounds(900, 740, 200, 50);
		frame.getContentPane().add(answer1);
		answer1.setFont(font);

		answer2 = new RoundedButton(ans2, 2);
		answer2.setBounds(1120, 740, 200, 50);
		frame.getContentPane().add(answer2);
		answer2.setFont(font);

		answer3 = new RoundedButton(ans3, 2);
		answer3.setBounds(1340, 740, 200, 50);
		frame.getContentPane().add(answer3);
		answer3.setFont(font);
		// 버튼설정
		exit.setBounds(50, 50, 120, 50);
		exit.setFont(font);
		exit.setBackground(new Color(241, 76, 76));
		frame.getContentPane().add(exit);

		send.setBounds(1630, 800, 50, 50);
		send.setFont(font);
		frame.getContentPane().add(send);

		// 배경
		JLabel grayback = new JLabel();
		grayback.setOpaque(true);
		grayback.setBackground(Color.LIGHT_GRAY);
		grayback.setBounds(700, 800, 1000, 50);
		grayback.setHorizontalAlignment(JLabel.RIGHT);
		frame.getContentPane().add(grayback);

		JLabel whiteback = new JLabel();
		whiteback.setOpaque(true);
		whiteback.setBackground(new Color(255, 255, 255));
		whiteback.setBounds(700, 120, 1000, 600);
		whiteback.setHorizontalAlignment(JLabel.RIGHT);
		frame.getContentPane().add(whiteback);

	     ImageIcon suri1 = new ImageIcon(choice.class.getResource("../img/운세수리리.png"));
	      JLabel imgLbl1 = new JLabel();
	      frame.getContentPane().add(imgLbl1);
	      imgLbl1.setIcon(suri1);
	      imgLbl1.setBounds(80, 150, 1000, 700);
	      imgLbl1.setHorizontalAlignment(JLabel.LEFT);
		
		
		JLabel back = new JLabel();
		back.setOpaque(true);
		back.setBackground(new Color(4, 34, 83));
		back.setBounds(0, 0, 1980, 1080);
		back.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(back);

		// 프레임이 보이도록 설정
		frame.setVisible(true);

		// 이전
		exit.addActionListener(event -> {
			 random = (int) (Math.random() * 9);
			index=0;
			choice=-1;
			answer="";
			new choice();
			frame.setVisible(false);

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
				ta1.append(" 오 좋았옹!! 자 이제 운세를 확인해 볼까옹~?");
				answer1.setText("가보자고! ");
				answer2.setText("ㄱ ");
				answer3.setText("현기증나");
		
				//index++;

			}
		});
		
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
			ta1.append(" 오 좋았옹!! 자 이제 운세를 확인해 볼까옹~?");
			
			ta1.append("\n (수리수리톡수리수리수리수리)");
			
			answer1.setText("가보자고! ");
			answer2.setText("ㄱ ");
			answer3.setText("현기증나");
			//index++;
		});

		
		
		send.setEnabled(false);
		// 버튼이벤트
		ta1.setText("안녕 "+nName+" 여기는 미림부엉마을에 사는 부엉이들이 모여\n 운세를 봐주고 고민을 들어주는 곳이라옹\n 나는 취업, 연애, 남편운을 봐주는 운세수리라 해옹");

		

		// 답장 버튼!
		answer1.addActionListener(event->{
			switch(index) {
			case 0:
				ta1.append("\n\t\t\t\t" + ans1 + "\n\n"); // 반갑
				allMent(index);
				index++;
				break;
			case 1:
				choice=0;
				ta1.append("\n\n\t\t\t\t취업\n");
				ta1.append("\n 취업운이 궁금했옹? 지금 당장 알아보자옹!");
				allMent(index); // 학년
				index++;
				break;
			case 2:	
				ta1.append("\n\t\t\t\t1학년");
				ta1.append("\n\n 풋풋한 나이옹~ 부럽다옹");
				allMent(index);
				index++;
				break;
			case 3:
				ta1.append("\n (수리수리톡수리수리수리수리)");
				FileRead(choice);
				ta1.setCaretPosition(ta1.getDocument().getLength());
				allMent(index);
				index++;
				break;
			case 4:
				ta1.append("\n\t\t\t\t이게 뭐야;");
				ta1.append("\n\n 결과가 마음에 들지 않았나보옹..");
				
				ta1.append("\n 너무 마음에 담아두지 마시옹.. (빨리 튀어야지)");
				ta1.append("\n 좋은 하루 보내고 다음에도 나 운세수리를 찾아주면 고맙겠옹!");
				
				answer1.setText("");
				answer2.setText("");
				answer3.setText("");
				answer1.setEnabled(false);
				answer2.setEnabled(false);
				answer3.setEnabled(false);
				break;
			}
			
			
		});
		
		answer2.addActionListener(event->{
			switch(index) {
			case 0:
				ta1.append("\n\t\t\t\t" + ans2 + "\n\n");
				allMent(index);
				index++;
				break;
			case 1:
				ta1.append("\n\n\t\t\t\t연애\n");
				choice = 1;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ta1.append(" 연애운이라.. 이쪽은 내가 전문이라옹~^^");
				allMent(index);
				index++;
				break;
			case 2:
				ta1.append("\n\t\t\t\t2학년");
				ta1.append("\n\n 풋풋한 나이옹~ 부럽다옹");
				allMent(index);
				index++;
				break;
			case 3:
				ta1.append("\n (쿵파콩딱풍팡두준두준)");
				FileRead(choice);
				
				ta1.setCaretPosition(ta1.getDocument().getLength());
				allMent(index);
				index++;
				break;
			case 4:
				ta1.append("\n\t\t\t\t마음에 들어!");
				ta1.append("\n\n 옹홍홍 마음에 든다니 나의 기분도 매우 좋아졌옹~~");
				ta1.append("\n 다음에도 나 운세수리를 찾아준다면 더 꼼꼼하고 자세하게\n" +"운세를 봐주겠옹! ");
				answer1.setText("");
				answer2.setText("");
				answer3.setText("");
				answer1.setEnabled(false);
				answer2.setEnabled(false);
				answer3.setEnabled(false);
				break;
			}
		});
		
		answer3.addActionListener(event->{
			switch(index) {
			case 0:
				ta1.append("\n\t\t\t\t" + ans3 + "\n\n");
				allMent(index);
				index++;
				break;
			case 1:
				ta1.append("\n\n\t\t\t\t남편운!!\n");
				choice = 2;
				ta1.append(" 미래 남편은 누구일지.. 알아보러 가보자아아옹!");
				allMent(index);
				index++;
				break;
			case 2:
				ta1.append("\n\t\t\t\t3학년");
				//ta1.append("\n\n 남편 찾기 좋은 나이옹~");
				allMent(index);
				index++;
				break;
			case 3:
				ta1.append("\n (둥둥쿠당탕쿵짝쿵따핑퐁)");				
				FileRead(choice);
				ta1.setCaretPosition(ta1.getDocument().getLength());
				allMent(index);
				index++;
				break;
			case 4:
				
				ta1.append("\n\t\t\t\t(할말없음)");
				ta1.append("\n\n ㅎ.. 알겠옹.. 즐거웠으리라 생각하옹!");
				ta1.append("\n 다음에도 나 운세수리를 찾아준다면 고맙겠옹..");
				ta1.append("\n 좋은 하루 보내시옹!!");
				answer1.setText("");
				answer2.setText("");
				answer3.setText("");
				answer1.setEnabled(false);
				answer2.setEnabled(false);
				answer3.setEnabled(false);
				break;
			}
		});
	}
	
	// 모두에게 동일한 멘트 모아두기
	public void allMent(int index) {
		
		switch(index) {
		case 0:
			ta1.append(" 옹홍홍.. 나의 특기를 살려 아주 빠르게 운세를 봐주겠옹!\n 오늘은 어떤 운세를 보러왔옹?");
			answer1.setText("취업");
			answer2.setText("연애");
			answer3.setText("남편");
			break;
		case 1:
			ta1.append("\n 당신의 학년은 어떻게 되옹?");
			answer1.setText("1학년");
			answer2.setText("2학년  ");
			answer3.setText("3학년 ");
			break;
		case 2:
			ta1.append("\n 생년월일을 알려주시옹!");
			answer1.setText("");
			answer2.setText("");
			answer3.setText("");
			msg.setEnabled(true);
			msg.setText("ex) 040602");
			msg.setForeground(Color.lightGray);
		
			send.setEnabled(true);
			answer1.setEnabled(false);
			answer2.setEnabled(false);
			answer3.setEnabled(false);
			break;
			
		case 3:
			ta1.append("\n\n 오늘 운세는 어땠옹??");
			answer1.setText("이게 뭐야;");
			answer2.setText("마음에 들어!");
			answer3.setText("(할말없음)");

			break;
		}
		
		
	}
	
	// 파일 읽어오기
	public void FileRead(int choice) {

		int[] line_start = null; // 처음줄
		int[] line_finish = null; // 마지막줄
		
		
		// 0. 파일 준비
		Path path = Paths.get("src/text/luckEmployment_answer.txt");
		Path realpath=path.toAbsolutePath();
		realpath.toString();
		
String name="";
		//Path pathHusband = Paths.get("C:/Users/luckSuri_husband.txt");	
		switch (choice) {
		case 0: // 취업
			name="취업";
			path =Paths.get("src/text/luckEmployment_answer.txt");
			line_start = new int[]{ 0, 5, 10, 15, 20, 25, 29, 33, 38, 41};
			line_finish = new int[]{3, 8, 13, 18, 23, 27, 31, 36, 39, 42};
		
			
			break;
		case 1:
			name="연애";
			path = Paths.get("src/text/luckLove_answer.txt");
			line_start = new int[]{ 0, 7, 14, 20, 26, 31, 36, 42, 47, 52};
			line_finish = new int[]{ 5, 12, 18, 24, 29, 24, 40, 45, 50, 69}; //마지막줄
			break;
		case 2:
			break;
		default:
			break;
		}
		if(choice==2) {
			new husband();
		}
		else {
			try { // 1. 파일 전체 읽기 
				List<String> allLines = Files.readAllLines(path); // 2.
				 // 3번째 라인 읽기 
				for(int i=line_start[random]; i<=line_finish[random]; i++) { 
					answer +=allLines.get(i)+"\n"; }
				 // 3. 결과 출력 
				System.out.println(answer); // line 3 
				} catch (IOException e) {
				 e.printStackTrace(); 
				 
			}
			JOptionPane.showMessageDialog(null, answer, name+"운세라오~", JOptionPane.INFORMATION_MESSAGE);
		}	
	}
	
	public static void main(String[] args) {
		new luck_suri();
	}
}


