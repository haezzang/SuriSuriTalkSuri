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

	// 雌伐 昔畿什
	static int index = 0;
	static int random = (int) (Math.random() * 9);
	static String answer = "";
	static int[] line1= {0,7,13,19,25,37,44,51,58}; //坦製匝
	static int[] line2= {5,11,17,23,35,42,49,57,65}; //原走厳匝

	static boolean alert = false; // 脊径照鎧

	public today_suri() {

		// 0. 督析 層搾
		Path path = Paths.get("src/text/today_answer.txt");
		Path realpath=path.toAbsolutePath();
		realpath.toString();
		try {
			// 1. 督析 穿端 石奄
			List<String> allLines = Files.readAllLines(realpath);
			// 2. 3腰属 虞昔 石奄
			for(int i=line1[random]; i<=line2[random]; i++) {
				answer += allLines.get(i)+"\n";
			}
			
			// 3. 衣引 窒径
			System.out.println(answer); // line 3
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 覗傾績 持失
		JFrame frm = new JFrame("神潅呪軒人 辰特掻");

		// 覗傾績 滴奄 竺舛
		frm.setSize(1980, 1080);

		// 覗傾績聖 鉢檎 亜錘汽拭 壕帖
		frm.setLocationRelativeTo(null);

		// 覗傾績聖 丸紹聖 凶 五乞軒拭辞 薦暗鞠亀系 竺舛
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 肉闘竺舛
		Font font = new Font("蟹堪壱拒", Font.PLAIN, 25); // 獄動採歳
		Font font1 = new Font("蟹堪壱拒", Font.PLAIN, 28); // 脊径採歳
		Font font2 = new Font("蟹堪壱拒", Font.PLAIN, 28); // 辰特採歳

		// 努什闘area 持失(辰特)
		JTextArea ta1 = new JTextArea(10, 20);

		// 什滴継 掩戚
		JScrollPane scrollPane = new JScrollPane(ta1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		ta1.setFont(font2);

		scrollPane.setBounds(700, 120, 1000, 600);
		frm.add(scrollPane);
		scrollPane.setVisible(true);

		// 切疑匝郊嘩

		// 越切 事薗
		ta1.setForeground(Color.black);
		// 努什闘琶球 持失
		RoundJTextField msg = new RoundJTextField(30);
		frm.getContentPane().add(msg);
		msg.setLayout(null);
		msg.setBounds(720, 805, 900, 40);
		msg.setFont(font1);
		msg.setEnabled(false);

		// 段鋼 獄動 鎧遂 竺舛
		String ans1 = "酔腎";
		String ans2 = "艦亜訊;";
		String ans3 = "菊壱 照瑳掘";
		// 獄動 持失
		RoundedButton exit = new RoundedButton("戚穿", 1);
		RoundedButton send = new RoundedButton("＜");
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
		// 獄動竺舛
		exit.setBounds(50, 50, 120, 50);
		exit.setFont(font);
		exit.setBackground(new Color(241, 76, 76));
		frm.getContentPane().add(exit);

		send.setBounds(1630, 800, 50, 50);
		send.setFont(font);
		frm.getContentPane().add(send);

		// 壕井
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

	     ImageIcon suri1 = new ImageIcon(choice.class.getResource("../img/神潅呪軒軒.png"));
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

		// 覗傾績戚 左戚亀系 竺舛
		frm.setVisible(true);

		// 戚穿
		exit.addActionListener(event -> {
			new choice();
			random = (int) (Math.random() * 9);
			answer = "";
			index=0;
			frm.setVisible(false);

		});

		send.setEnabled(false);
		// 獄動戚坤闘
		ta1.setText(nName+" 照括馬獣神\n神潅税 錘室研 坐爽澗 神潅呪軒虞 馬神\n益企亜 神奄幻聖 奄陥軒壱 赤醸社");

		send.addActionListener(event -> {
			String birth = msg.getText();
			// 舛溌備 処澗走 姥歳馬奄~
			ta1.append("\n\t\t\t\t" + birth + "\n\n");
			msg.setEnabled(false);
			send.setEnabled(false);
			answer1.setEnabled(true);
			answer2.setEnabled(true);
			answer3.setEnabled(true);
			ta1.append("益企税 鯵昔舛左澗 神潅税 錘室研 溌昔馬澗 聡獣 督奄吃 森舛戚神.");
			answer1.setText("誓");
			answer2.setText("硝畏嬢");
			answer3.setText("益掘虞");
			index++;

		});

		msg.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String birth = msg.getText();
				// 舛溌備 処澗走 姥歳馬奄~
				ta1.append("\n\t\t\t\t" + birth + "\n\n");
				msg.setEnabled(false);
				send.setEnabled(false);
				answer1.setEnabled(true);
				answer2.setEnabled(true);
				answer3.setEnabled(true);
				ta1.append("益企税 鯵昔舛左澗 神潅税 錘室研 溌昔馬澗 聡獣 督奄吃 森舛戚神.");
				answer1.setText("誓");
				answer2.setText("硝畏嬢");
				answer3.setText("益掘虞");
				index++;

			}
		});

		// 岩舌 獄動!
		answer1.addActionListener(event -> {

			switch (index) {
			case 0:
				// 紫遂切 企岩
				ta1.append("\n\t\t\t\t" + ans1 + "\n\n");
				ta1.append("買買.. 析舘 益企税 持析聖 脊径背爽醸生檎 馬神");
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
				ta1.append("\n\n\t\t\t\t誓\n");
				ta1.append("板板 獄動聖 刊牽檎 益企税 神潅税 錘室研 溌昔拝 呪 赤社.\n戚薦 刊研 託景神!!!");
				answer1.setText("砧悦砧悦");
				answer2.setText("雁舌 左食操 ");
				answer3.setText("竺兄陥");
				index++;
				break;

			case 2:
				ta1.append("\n\t\t\t\t砧悦砧悦");
				JOptionPane.showMessageDialog(null, answer, "神潅錘室虞神~", JOptionPane.INFORMATION_MESSAGE);
				ta1.setCaretPosition(ta1.getDocument().getLength());
				ta1.append("\n\n神潅 錘室澗 原製拭 級醸社??");
				answer1.setText("馬 菊陥 袷;");
				answer2.setText("格巷 袋焼 ぞぞ");
				answer3.setText("しし");

				index++;
				break;

			case 3:
				ta1.setCaretPosition(ta1.getDocument().getLength());
				ta1.append("\n\n\t\t\t\t馬 菊陥 袷;\n\n");
				ta1.append("..益企研 叔諺獣佃 焼襲姥形..(走 錘戚 益走 旭精 杏 嬢村虞澗暗醤..)\n鎧析精 希 疏精 錘戚 魚牽掩 郊虞畏社!! ");
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
				// 紫遂切 企岩
				ta1.append("\n\t\t\t\t" + ans2 + "\n\n");
				ta1.append("買買.. 析舘 益企税 俳鰍引 持析聖 脊径背爽醸生檎 馬神");
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
				ta1.append("\n\t\t\t\t硝畏嬢\n\n");
				ta1.append("板板 獄動聖 刊牽檎 益企税 神潅税 錘室研 溌昔拝 呪 赤社.\n戚薦 刊研 託景神!!!");
				answer1.setText("砧悦砧悦");
				answer2.setText("雁舌 左食操 ");
				answer3.setText("竺兄陥");
				index++;
				break;

			case 2:
				ta1.append("\n\t\t\t\t雁舌 左食操"
						+ "");
				JOptionPane.showMessageDialog(null, answer, "神潅錘室虞神~", JOptionPane.INFORMATION_MESSAGE);
				ta1.setCaretPosition(ta1.getDocument().getLength());
				ta1.append("\n\n神潅 錘室澗 原製拭 級醸社??");
				answer1.setText("馬 菊陥 袷;");
				answer2.setText("格巷 袋焼 ぞぞ");
				answer3.setText("しし");
				index++;
				break;

			case 3:
				ta1.setCaretPosition(ta1.getDocument().getLength());
				ta1.append("\n\t\t\t\t格巷 袋焼 ぞぞ\n\n");
				ta1.append("蝕獣蟹~~ 益企研 奄陥鍵 左寓戚 赤社 神潅亀 疏精 馬欠亜 鞠醸生檎 疏畏姥形\n蟹 神潅呪軒亀 益企研 是廃 馬欠研 左鎧畏社!!");
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
				// 紫遂切 企岩
				ta1.append("\n\t\t\t                " + ans3 + "\n\n");
				answer1.setEnabled(false);
				answer2.setEnabled(false);
				answer3.setEnabled(false);
				ta1.append("硝畏社戚陥 蟹掻拭虞亀 益企税 錘室研 硝壱 粛聖 凶亜 鞠檎 達焼神獣姥形 ");
				break;

			case 1:
				ta1.append("\n\t\t\t\t益掘虞\n\n");
				ta1.append("板板 獄動聖 刊牽檎 益企税 神潅税 錘室研 溌昔拝 呪 赤社.\n戚薦 刊研 託景神!!!");
				answer1.setText("砧悦砧悦");
				answer2.setText("雁舌 左食操 ");
				answer3.setText("竺兄陥");
				index++;
				break;

			case 2:

				JOptionPane.showMessageDialog(null, answer, "神潅錘室虞神~", JOptionPane.INFORMATION_MESSAGE);
				ta1.append("\n\t\t\t\t竺兄陥");
				ta1.setCaretPosition(ta1.getDocument().getLength());
				ta1.append("\n\n神潅 錘室澗 原製拭 級醸社??");
				answer1.setText("馬 菊陥 袷;");
				answer2.setText("格巷 袋焼 ぞぞ");
				answer3.setText("しし");
				index++;
				break;

			case 3:
				ta1.setCaretPosition(ta1.getDocument().getLength());
				ta1.append("\n\t\t\t\tしし\n\n");
				ta1.append("蝕獣蟹~~ 益企研 奄陥鍵 左寓戚 赤社 神潅亀 疏精 馬欠亜 鞠醸生檎 疏畏姥形\n蟹 神潅呪軒亀 益企研 是廃 馬欠研 左鎧畏社!!");
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

