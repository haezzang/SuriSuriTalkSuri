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
public class today_suri extends JFrame {

	// ��Ȳ �ε���
	static int index = 0;
	static int random = (int) (Math.random() * 9);
	static String answer = "";
	static int[] line1= {0,7,13,19,25,37,44,51,58}; //ó����
	static int[] line2= {5,11,17,23,35,42,49,57,65}; //��������

	static boolean alert = false; // �Է¾ȳ�

	public today_suri() {

		// 0. ���� �غ�
		Path path = Paths.get("src/text/today_answer.txt");
		Path realpath=path.toAbsolutePath();
		realpath.toString();
		try {
			// 1. ���� ��ü �б�
			List<String> allLines = Files.readAllLines(realpath);
			// 2. 3��° ���� �б�
			for(int i=line1[random]; i<=line2[random]; i++) {
				answer += allLines.get(i)+"\n";
			}
			
			// 3. ��� ���
			System.out.println(answer); // line 3
		} catch (IOException e) {
			e.printStackTrace();
		}

		// ������ ����
		JFrame frm = new JFrame("���ü����� ä����");

		// ������ ũ�� ����
		frm.setSize(1980, 1080);

		// �������� ȭ�� ����� ��ġ
		frm.setLocationRelativeTo(null);

		// �������� �ݾ��� �� �޸𸮿��� ���ŵǵ��� ����
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ��Ʈ����
		Font font = new Font("�������", Font.PLAIN, 25); // ��ư�κ�
		Font font1 = new Font("�������", Font.PLAIN, 28); // �Էºκ�
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
		String ans1 = "���";
		String ans2 = "�ϰ���;";
		String ans3 = "�ư� �Ⱥ���";
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

	     ImageIcon suri1 = new ImageIcon(choice.class.getResource("../img/���ü�����.png"));
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

		// ����
		exit.addActionListener(event -> {
			new choice();
			random = (int) (Math.random() * 9);
			answer = "";
			index=0;
			frm.setVisible(false);

		});

		send.setEnabled(false);
		// ��ư�̺�Ʈ
		ta1.setText(nName+" �ȳ��Ͻÿ�\n������ ��� ���ִ� ���ü����� �Ͽ�\n�״밡 ���⸸�� ��ٸ��� �־���");

		send.addActionListener(event -> {
			String birth = msg.getText();
			// ��Ȯ�� ����� �����ϱ�~
			ta1.append("\n\t\t\t\t" + birth + "\n\n");
			msg.setEnabled(false);
			send.setEnabled(false);
			answer1.setEnabled(true);
			answer2.setEnabled(true);
			answer3.setEnabled(true);
			ta1.append("�״��� ���������� ������ ��� Ȯ���ϴ� ��� �ı�� �����̿�.");
			answer1.setText("��");
			answer2.setText("�˰ھ�");
			answer3.setText("�׷���");
			index++;

		});

		msg.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String birth = msg.getText();
				// ��Ȯ�� ����� �����ϱ�~
				ta1.append("\n\t\t\t\t" + birth + "\n\n");
				msg.setEnabled(false);
				send.setEnabled(false);
				answer1.setEnabled(true);
				answer2.setEnabled(true);
				answer3.setEnabled(true);
				ta1.append("�״��� ���������� ������ ��� Ȯ���ϴ� ��� �ı�� �����̿�.");
				answer1.setText("��");
				answer2.setText("�˰ھ�");
				answer3.setText("�׷���");
				index++;

			}
		});

		// ���� ��ư!
		answer1.addActionListener(event -> {

			switch (index) {
			case 0:
				// ����� ���
				ta1.append("\n\t\t\t\t" + ans1 + "\n\n");
				ta1.append("����.. �ϴ� �״��� ������ �Է����־����� �Ͽ�");
				alert = true;
				msg.setEnabled(true);
				msg.setText("ex)040624");
				msg.setForeground(Color.lightGray);
				send.setEnabled(true);
				answer1.setEnabled(false);
				answer2.setEnabled(false);
				answer3.setEnabled(false);
				break;
			case 1:
				ta1.append("\n\n\t\t\t\t��\n");
				ta1.append("���� ��ư�� ������ �״��� ������ ��� Ȯ���� �� �ּ�.\n���� ���� ���ʿ�!!!");
				answer1.setText("�αٵα�");
				answer2.setText("���� ������ ");
				answer3.setText("������");
				index++;
				break;

			case 2:
				ta1.append("\n\t\t\t\t�αٵα�");
				JOptionPane.showMessageDialog(null, answer, "���ÿ���~", JOptionPane.INFORMATION_MESSAGE);
				ta1.setCaretPosition(ta1.getDocument().getLength());
				ta1.append("\n\n���� ��� ������ �����??");
				answer1.setText("�� �ƴ� ��;");
				answer2.setText("�ʹ� �޾� ����");
				answer3.setText("����");

				index++;
				break;

			case 3:
				ta1.setCaretPosition(ta1.getDocument().getLength());
				ta1.append("\n\n\t\t\t\t�� �ƴ� ��;\n\n");
				ta1.append("..�״븦 �Ǹ����� �ƽ�����..(�� ���� ���� ���� �� ��¼��°ž�..)\n������ �� ���� ���� ������ �ٶ�ڼ�!! ");
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
				// ����� ���
				ta1.append("\n\t\t\t\t" + ans2 + "\n\n");
				ta1.append("����.. �ϴ� �״��� �г�� ������ �Է����־����� �Ͽ�");
				alert = true;
				msg.setEnabled(true);
				msg.setText("ex)040624");
				msg.setForeground(Color.lightGray);
				send.setEnabled(true);
				answer1.setEnabled(false);
				answer2.setEnabled(false);
				answer3.setEnabled(false);
				break;
			case 1:
				ta1.append("\n\t\t\t\t�˰ھ�\n\n");
				ta1.append("���� ��ư�� ������ �״��� ������ ��� Ȯ���� �� �ּ�.\n���� ���� ���ʿ�!!!");
				answer1.setText("�αٵα�");
				answer2.setText("���� ������ ");
				answer3.setText("������");
				index++;
				break;

			case 2:
				ta1.append("\n\t\t\t\t���� ������"
						+ "");
				JOptionPane.showMessageDialog(null, answer, "���ÿ���~", JOptionPane.INFORMATION_MESSAGE);
				ta1.setCaretPosition(ta1.getDocument().getLength());
				ta1.append("\n\n���� ��� ������ �����??");
				answer1.setText("�� �ƴ� ��;");
				answer2.setText("�ʹ� �޾� ����");
				answer3.setText("����");
				index++;
				break;

			case 3:
				ta1.setCaretPosition(ta1.getDocument().getLength());
				ta1.append("\n\t\t\t\t�ʹ� �޾� ����\n\n");
				ta1.append("���ó�~~ �״븦 ��ٸ� ������ �ּ� ���õ� ���� �Ϸ簡 �Ǿ����� ���ڱ���\n�� ���ü����� �״븦 ���� �Ϸ縦 �����ڼ�!!");
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
				// ����� ���
				ta1.append("\n\t\t\t                " + ans3 + "\n\n");
				answer1.setEnabled(false);
				answer2.setEnabled(false);
				answer3.setEnabled(false);
				ta1.append("�˰ڼ��̴� ���߿��� �״��� ��� �˰� ���� ���� �Ǹ� ã�ƿ��ñ��� ");
				break;

			case 1:
				ta1.append("\n\t\t\t\t�׷���\n\n");
				ta1.append("���� ��ư�� ������ �״��� ������ ��� Ȯ���� �� �ּ�.\n���� ���� ���ʿ�!!!");
				answer1.setText("�αٵα�");
				answer2.setText("���� ������ ");
				answer3.setText("������");
				index++;
				break;

			case 2:

				JOptionPane.showMessageDialog(null, answer, "���ÿ���~", JOptionPane.INFORMATION_MESSAGE);
				ta1.append("\n\t\t\t\t������");
				ta1.setCaretPosition(ta1.getDocument().getLength());
				ta1.append("\n\n���� ��� ������ �����??");
				answer1.setText("�� �ƴ� ��;");
				answer2.setText("�ʹ� �޾� ����");
				answer3.setText("����");
				index++;
				break;

			case 3:
				ta1.setCaretPosition(ta1.getDocument().getLength());
				ta1.append("\n\t\t\t\t����\n\n");
				ta1.append("���ó�~~ �״븦 ��ٸ� ������ �ּ� ���õ� ���� �Ϸ簡 �Ǿ����� ���ڱ���\n�� ���ü����� �״븦 ���� �Ϸ縦 �����ڼ�!!");
				answer1.setEnabled(false);
				answer2.setEnabled(false);
				answer3.setEnabled(false);
				break;
			}
		});
	}

	public static void main(String[] args) {
		
		new today_suri();
		
	}
}

