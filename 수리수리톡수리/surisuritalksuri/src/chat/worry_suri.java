package chat;

import java.awt.Color;
import java.awt.Font;
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

public class worry_suri extends JFrame  {

	// ��Ȳ �ε���
	static int index = 0;
	static int random = (int) (Math.random() * 10);
	static String answer="";

	



	
		public worry_suri() {

			// 0. ���� �غ�
			Path path = Paths.get("src/text/worry_answer.txt");
			Path realpath=path.toAbsolutePath();
			realpath.toString();
			try {
				// 1. ���� ��ü �б�
				List<String> allLines = Files.readAllLines(path);
				// 2. 3��° ���� �б�
				answer = allLines.get(random);
				// 3. ��� ���
				System.out.println(answer); // line 3
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		// ������ ����
		JFrame frm = new JFrame("��μ����� ä����");

		// ������ ũ�� ����
		frm.setSize(1980, 1080);

		// �������� ȭ�� ����� ��ġ
		frm.setLocationRelativeTo(null);

		// �������� �ݾ��� �� �޸𸮿��� ���ŵǵ��� ����
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ��Ʈ����
		Font font = new Font("�������", Font.PLAIN, 25); // ��ư�κ�
		Font font1 = new Font("�������", Font.PLAIN, 35); // �Էºκ�
		Font font2 = new Font("�������", Font.PLAIN, 28); // ä�úκ�

		// �ؽ�Ʈarea ����(ä��)
		JTextArea ta1 = new JTextArea(10, 20);

		// ��ũ�� ����
		JScrollPane scrollPane = new JScrollPane(ta1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		ta1.setFont(font2);

		scrollPane.setBounds(700, 120, 1000, 600);
		frm.add(scrollPane);
		scrollPane.setVisible(true);

		// �ڵ��ٹٲ�


		// ���� ����
		ta1.setForeground(Color.black);
		// �ؽ�Ʈ�ʵ� ����
		RoundJTextField msg = new RoundJTextField(30);
		frm.getContentPane().add(msg);
		msg.setLayout(null);
		msg.setBounds(720, 805, 900, 40);
		msg.setFont(font1);
		msg.setEnabled(false);

		// �ʹ� ��ư ���� ����
		String ans1 = "�� �׷�;;";
		String ans2 = "�ȳ�!!";
		String ans3 = "�ư� ��� �����!";
		// ��ư ����
		RoundedButton exit = new RoundedButton("����", 1);
		RoundedButton send = new RoundedButton("��");
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
		// ��ư����
		exit.setBounds(50, 50, 120, 50);
		exit.setFont(font);
		exit.setBackground(new Color(241, 76, 76));
		frm.getContentPane().add(exit);

		send.setBounds(1630, 800, 50, 50);
		send.setFont(font);
		frm.getContentPane().add(send);

		// ���
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

		
		
	     ImageIcon suri1 = new ImageIcon(choice.class.getResource("../img/��μ�����.png"));
	      JLabel imgLbl1 = new JLabel();
	      frm.getContentPane().add(imgLbl1);
	      imgLbl1.setIcon(suri1);
	      imgLbl1.setBounds(80, 150, 1000, 700);
	      imgLbl1.setHorizontalAlignment(JLabel.LEFT);
		
		
		
		
		JLabel back = new JLabel();
		back.setOpaque(true);
		back.setBackground(new Color(4, 34, 83));
		back.setBounds(0, 0, 1980, 1080);
		back.setHorizontalAlignment(JLabel.CENTER);
		frm.getContentPane().add(back);

		// �������� ���̵��� ����
		frm.setVisible(true);

		
		
		//����
		exit.addActionListener(event -> {
			new choice();
			frm.setVisible(false);
			random = (int) (Math.random() * 9);
			answer = "";
			index=0;
	        });  
	
		//��ư�̺�Ʈ
		ta1.setText("��������ň����ňň\r\n" +nName+" �ȳ��Ϻξ�?\r\n" + "���� ����� ������ִ� ��μ����ξ��̶��!");
		// ���� ��ư!
		answer1.addActionListener(event -> {

				switch (index) {
				case 0:
					// ����� ���
					answer1.setEnabled(false);
					answer2.setEnabled(false);
					answer3.setEnabled(false);
					ta1.append("\n\t\t\t\t" + ans1 + "\n\n");
					ta1.append("(���� ������ �ÿ�����.. ������ �� ��վ �� �ִٳ�..)\n" + "����� �ֺξ�?\n");
					answer1.setEnabled(true);
					answer2.setEnabled(true);
					answer3.setEnabled(true);
					answer1.setText("��");
					answer2.setText("�ƴ�");
					answer3.setText("�׳� ���ͺþ�");	
					ta1.setForeground(Color.black);
					index++;
					break;

				case 1:		
					answer1.setEnabled(false);
					answer2.setEnabled(false);
					answer3.setEnabled(false);
					ta1.append("\n\t\t\t\t��\n\n");
					ta1.append("�׷� ���� ��������ξ�!\n���� ���������� ����� �����ϸ�\n���� �ذ�å�� �������ְںξ�\n������ ������ ��ư�� ������ �ξ�!");
					answer1.setEnabled(true);
					answer2.setEnabled(true);
					answer3.setEnabled(true);
					answer1.setText("����������!");
					answer2.setText("�׳� �Ⱥ���");
					answer3.setText("�����Ϸ�.."); 
					index++;
					break;

				case 2:			
					ta1.append("\n\t\t\t\t����������!\n\n");
					
					answer1.setEnabled(false);
					answer2.setEnabled(false);
					answer3.setEnabled(false);
					//�˾�â ����
					JOptionPane.showMessageDialog(null, answer,"�ذ�å��?", JOptionPane.INFORMATION_MESSAGE);
					ta1.setCaretPosition(ta1.getDocument().getLength());
					answer1.setEnabled(true);
					answer2.setEnabled(true);
					answer3.setEnabled(true);

					answer1.setText("����!");
					answer2.setText("�����̴�?");
					answer3.setText("�߰�~");
			

					index++;
					break;

				case 3:
					ta1.append("\n\t\t\t\t����\n\n");
					answer1.setEnabled(false);
					answer2.setEnabled(false);
					answer3.setEnabled(false);

					
					ta1.append("���.. ����� �ذ� �ƺξ�? \r\n" + "������ ���� ���ߴٸ�.. ũ��.. �׷���.. \n���� ������ ����� ��վ�ںξ�!\r\n"
							+ "�������� ����� �ִٸ� ã�ƿ��ðԳ�~");
					break;
				}

			}

		);


	
		answer2.addActionListener(event -> {

				int random = (int) (Math.random() * 10);
				switch (index) {
				case 0:
					ta1.append("\n\t\t\t\t�ȳ�!!" + "\n\n");
					answer1.setEnabled(false);
					answer2.setEnabled(false);
					answer3.setEnabled(false);

				
					ta1.append("(���� ������ �ÿ�����.. ������ �� ��վ �� �ִٳ�..)\r\n" + "����� �ֺξ�?\r\n" + "");
					answer1.setEnabled(true);
					answer2.setEnabled(true);
					answer3.setEnabled(true);

					answer1.setText("��");
					answer2.setText("�ƴ�");
					answer3.setText("�׳� ���ͺþ�");
					index++;
					break;

				case 1:
					ta1.append("\n\t\t\t\t�ƴ�\n\n");
					answer1.setEnabled(false);
					answer2.setEnabled(false);
					answer3.setEnabled(false);

					ta1.append(".. �˰ںξ�.. �������� ã���ֱ� �ٶ��..");
					
					index++;
					break;

				case 2:
					ta1.append("\n\t\t\t\t�׳� �Ⱥ���\n\n");
					answer1.setEnabled(false);
					answer2.setEnabled(false);
					answer3.setEnabled(false);
					ta1.append("..(�������°ž�.. �������;;)�����˰ںξ� �߰��ðԳ�!");
					index++;
					break;
				case 3:
					ta1.setCaretPosition(ta1.getDocument().getLength());
					ta1.append("\n\t\t\t\t�����̴�?\n\n");
					answer1.setEnabled(false);
					answer2.setEnabled(false);
					answer3.setEnabled(false);
	
					ta1.append("���.. ����� �ذ� �ƺξ�? \r\n" + "������ ���� ���ߴٸ�.. ũ��.. �׷���.. \n���� ������ ����� ��վ�ںξ�!\r\n"
							+ "�������� ����� �ִٸ� ã�ƿ��ðԳ�~");

					break;
				}

			}
		);



		answer3.addActionListener(event -> {
		

	
				switch (index) {
				case 0:
					// ����� ���
					ta1.append("\n\t\t\t                " + ans3 + "\n\n");
					answer1.setEnabled(false);
					answer2.setEnabled(false);
					answer3.setEnabled(false);

				
					ta1.append("(���� ������ �ÿ�����.. ������ �� ��վ �� �ִٳ�..)\r\n" + "����� �ֺξ�?\r\n" + "");
					answer1.setEnabled(true);
					answer2.setEnabled(true);
					answer3.setEnabled(true);

					answer1.setText("��");
					answer2.setText("�ƴ�");
					answer3.setText("�׳� ���ͺþ�");
					index++;
					break;

				case 1:
					ta1.append("\n\t\t\t                �׳� ���ͺþ�\n\n");
					answer1.setEnabled(false);
					answer2.setEnabled(false);
					answer3.setEnabled(false);

		
					ta1.append(".. �˰ںξ�.. �������� ã���ֱ� �ٶ��..");
					index++;
					break;

				case 2:
					ta1.append("\n\t\t\t\t�����Ϸ�..\n\n");
					answer1.setEnabled(false);
					answer2.setEnabled(false);
					answer3.setEnabled(false);


					JOptionPane.showMessageDialog(null, answer,"�ذ�å��?", JOptionPane.INFORMATION_MESSAGE);
					ta1.setCaretPosition(ta1.getDocument().getLength());
					answer1.setEnabled(true);
					answer2.setEnabled(true);
					answer3.setEnabled(true);

					answer1.setText("����!");
					answer2.setText("�����̴�?");
					answer3.setText("�߰�~");
					index++;
					break;

				case 3:
					ta1.append("\n\t\t\t\t����\n\n");
					answer1.setEnabled(false);
					answer2.setEnabled(false);
					answer3.setEnabled(false);

					ta1.append("���.. ����� �ذ� �ƺξ�? \r\n" + "������ ���� ���ߴٸ�.. ũ��.. �׷���.. \n���� ������ ����� ��վ�ںξ�!\r\n"
							+ "�������� ����� �ִٸ� ã�ƿ��ðԳ�~");
					break;
				}
			}
		);
	}

		
	



	public static void main(String[] args) {
		new worry_suri();
	}
}



