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
	int choice = -1; // ��� =0, ���� = 1, ���� = 2
	
	// ��Ȳ �ε���
	
	static int index = 0;
	static int random = (int) (Math.random() * 9);
	
	static String answer = "";
	static boolean alert = false; // �Է¾ȳ�

	public luck_suri() {

		// ������ ����
		JFrame frame = new JFrame("������� ä����");

		// ������ ũ�� ����
		frame.setSize(1980, 1080);

		// �������� ȭ�� ����� ��ġ
		frame.setLocationRelativeTo(null);

		// �������� �ݾ��� �� �޸𸮿��� ���ŵǵ��� ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ��Ʈ����
		Font font = new Font("�������", Font.PLAIN, 25); // ��ư�κ�
		Font font1 = new Font("�������", Font.PLAIN, 28); // �Էºκ�
		Font font2 = new Font("�������", Font.PLAIN, 28); // ä�úκ�

		// �ؽ�Ʈarea ����(ä��)
		ta1 = new JTextArea(10, 20);

		// ��ũ�� ����
		JScrollPane scrollPane = new JScrollPane(ta1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		ta1.setFont(font2);

		scrollPane.setBounds(700, 120, 1000, 600);
		frame.add(scrollPane);
		scrollPane.setVisible(true);

		// �ڵ��ٹٲ�

		// ���� ����
		ta1.setForeground(Color.black);
		// �ؽ�Ʈ�ʵ� ����
		msg = new RoundJTextField(30);
		frame.getContentPane().add(msg);
		msg.setLayout(null);
		msg.setBounds(720, 805, 900, 40);
		msg.setFont(font1);
		msg.setEnabled(false);

		// �ʹ� ��ư ���� ����
		String ans1 = "�ݰ���! ";
		String ans2 = "��� ";
		String ans3 = "���� � ����";
		// ��ư ����
		exit = new RoundedButton("����", 1);
		send = new RoundedButton("��");
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
		// ��ư����
		exit.setBounds(50, 50, 120, 50);
		exit.setFont(font);
		exit.setBackground(new Color(241, 76, 76));
		frame.getContentPane().add(exit);

		send.setBounds(1630, 800, 50, 50);
		send.setFont(font);
		frame.getContentPane().add(send);

		// ���
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

	     ImageIcon suri1 = new ImageIcon(choice.class.getResource("../img/�������.png"));
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

		// �������� ���̵��� ����
		frame.setVisible(true);

		// ����
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
				// ��Ȯ�� ����� �����ϱ�~
				ta1.setCaretPosition(ta1.getDocument().getLength());
				ta1.append("\n\t\t\t\t" + birth + "\n\n");
				msg.setEnabled(false);
				send.setEnabled(false);
				answer1.setEnabled(true);
				answer2.setEnabled(true);
				answer3.setEnabled(true);
				ta1.append(" �� ���ҿ�!! �� ���� ��� Ȯ���� �����~?");
				answer1.setText("�����ڰ�! ");
				answer2.setText("�� ");
				answer3.setText("��������");
		
				//index++;

			}
		});
		
		send.addActionListener(event -> {
			String birth = msg.getText();
			// ��Ȯ�� ����� �����ϱ�~
			ta1.setCaretPosition(ta1.getDocument().getLength());
			ta1.append("\n\t\t\t\t" + birth + "\n\n");
			msg.setEnabled(false);
			send.setEnabled(false);
			answer1.setEnabled(true);
			answer2.setEnabled(true);
			answer3.setEnabled(true);
			ta1.append(" �� ���ҿ�!! �� ���� ��� Ȯ���� �����~?");
			
			ta1.append("\n (�������������������������)");
			
			answer1.setText("�����ڰ�! ");
			answer2.setText("�� ");
			answer3.setText("��������");
			//index++;
		});

		
		
		send.setEnabled(false);
		// ��ư�̺�Ʈ
		ta1.setText("�ȳ� "+nName+" ����� �̸��ξ������� ��� �ξ��̵��� ��\n ��� ���ְ� ����� ����ִ� ���̶��\n ���� ���, ����, ������� ���ִ� ������� �ؿ�");

		

		// ���� ��ư!
		answer1.addActionListener(event->{
			switch(index) {
			case 0:
				ta1.append("\n\t\t\t\t" + ans1 + "\n\n"); // �ݰ�
				allMent(index);
				index++;
				break;
			case 1:
				choice=0;
				ta1.append("\n\n\t\t\t\t���\n");
				ta1.append("\n ������� �ñ��߿�? ���� ���� �˾ƺ��ڿ�!");
				allMent(index); // �г�
				index++;
				break;
			case 2:	
				ta1.append("\n\t\t\t\t1�г�");
				ta1.append("\n\n ǲǲ�� ���̿�~ �η��ٿ�");
				allMent(index);
				index++;
				break;
			case 3:
				ta1.append("\n (�������������������������)");
				FileRead(choice);
				ta1.setCaretPosition(ta1.getDocument().getLength());
				allMent(index);
				index++;
				break;
			case 4:
				ta1.append("\n\t\t\t\t�̰� ����;");
				ta1.append("\n\n ����� ������ ���� �ʾҳ�����..");
				
				ta1.append("\n �ʹ� ������ ��Ƶ��� ���ÿ�.. (���� Ƣ�����)");
				ta1.append("\n ���� �Ϸ� ������ �������� �� ������� ã���ָ� ���ڿ�!");
				
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
				ta1.append("\n\n\t\t\t\t����\n");
				choice = 1;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ta1.append(" ���ֿ��̶�.. ������ ���� �����̶��~^^");
				allMent(index);
				index++;
				break;
			case 2:
				ta1.append("\n\t\t\t\t2�г�");
				ta1.append("\n\n ǲǲ�� ���̿�~ �η��ٿ�");
				allMent(index);
				index++;
				break;
			case 3:
				ta1.append("\n (�������ǳ�ε��ص���)");
				FileRead(choice);
				
				ta1.setCaretPosition(ta1.getDocument().getLength());
				allMent(index);
				index++;
				break;
			case 4:
				ta1.append("\n\t\t\t\t������ ���!");
				ta1.append("\n\n ��ȫȫ ������ ��ٴ� ���� ��е� �ſ� ��������~~");
				ta1.append("\n �������� �� ������� ã���شٸ� �� �Ĳ��ϰ� �ڼ��ϰ�\n" +"��� ���ְڿ�! ");
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
				ta1.append("\n\n\t\t\t\t�����!!\n");
				choice = 2;
				ta1.append(" �̷� ������ ��������.. �˾ƺ��� �����ھƾƿ�!");
				allMent(index);
				index++;
				break;
			case 2:
				ta1.append("\n\t\t\t\t3�г�");
				//ta1.append("\n\n ���� ã�� ���� ���̿�~");
				allMent(index);
				index++;
				break;
			case 3:
				ta1.append("\n (�յ��������¦��������)");				
				FileRead(choice);
				ta1.setCaretPosition(ta1.getDocument().getLength());
				allMent(index);
				index++;
				break;
			case 4:
				
				ta1.append("\n\t\t\t\t(�Ҹ�����)");
				ta1.append("\n\n ��.. �˰ڿ�.. ��ſ������� �����Ͽ�!");
				ta1.append("\n �������� �� ������� ã���شٸ� ���ڿ�..");
				ta1.append("\n ���� �Ϸ� �����ÿ�!!");
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
	
	// ��ο��� ������ ��Ʈ ��Ƶα�
	public void allMent(int index) {
		
		switch(index) {
		case 0:
			ta1.append(" ��ȫȫ.. ���� Ư�⸦ ��� ���� ������ ��� ���ְڿ�!\n ������ � ��� �����Կ�?");
			answer1.setText("���");
			answer2.setText("����");
			answer3.setText("����");
			break;
		case 1:
			ta1.append("\n ����� �г��� ��� �ǿ�?");
			answer1.setText("1�г�");
			answer2.setText("2�г�  ");
			answer3.setText("3�г� ");
			break;
		case 2:
			ta1.append("\n ��������� �˷��ֽÿ�!");
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
			ta1.append("\n\n ���� ��� ���??");
			answer1.setText("�̰� ����;");
			answer2.setText("������ ���!");
			answer3.setText("(�Ҹ�����)");

			break;
		}
		
		
	}
	
	// ���� �о����
	public void FileRead(int choice) {

		int[] line_start = null; // ó����
		int[] line_finish = null; // ��������
		
		
		// 0. ���� �غ�
		Path path = Paths.get("src/text/luckEmployment_answer.txt");
		Path realpath=path.toAbsolutePath();
		realpath.toString();
		
String name="";
		//Path pathHusband = Paths.get("C:/Users/luckSuri_husband.txt");	
		switch (choice) {
		case 0: // ���
			name="���";
			path =Paths.get("src/text/luckEmployment_answer.txt");
			line_start = new int[]{ 0, 5, 10, 15, 20, 25, 29, 33, 38, 41};
			line_finish = new int[]{3, 8, 13, 18, 23, 27, 31, 36, 39, 42};
		
			
			break;
		case 1:
			name="����";
			path = Paths.get("src/text/luckLove_answer.txt");
			line_start = new int[]{ 0, 7, 14, 20, 26, 31, 36, 42, 47, 52};
			line_finish = new int[]{ 5, 12, 18, 24, 29, 24, 40, 45, 50, 69}; //��������
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
			try { // 1. ���� ��ü �б� 
				List<String> allLines = Files.readAllLines(path); // 2.
				 // 3��° ���� �б� 
				for(int i=line_start[random]; i<=line_finish[random]; i++) { 
					answer +=allLines.get(i)+"\n"; }
				 // 3. ��� ��� 
				System.out.println(answer); // line 3 
				} catch (IOException e) {
				 e.printStackTrace(); 
				 
			}
			JOptionPane.showMessageDialog(null, answer, name+"����~", JOptionPane.INFORMATION_MESSAGE);
		}	
	}
	
	public static void main(String[] args) {
		new luck_suri();
	}
}


