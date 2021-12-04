package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Canvas;

public class main extends JFrame {

	private JPanel contentPane;
	private Image backgournd;
	private ImageIcon mainSuri = new ImageIcon(main.class.getResource("../testimage/mainSuri.png"));
	private JTextField name;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1980, 1080);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.setBackground(new Color(4,34,83));
		
		name = new HintTextField("닉네임을 입력해주세요.");
		name.setBounds(245, 696, 551, 47);
		
		//HintTextField hint = new HintTextField(name, "닉네임을 입력해주세요");
		panel.add(name);
		name.setColumns(10);
		
		RoundedButton startBtn = new RoundedButton("\uC2DC\uC791");
		startBtn.setBounds(827, 696, 222, 47);
		panel.add(startBtn);
		
		JLabel label = new JLabel("<html><body>수리수리<br/>톡수리</body></html>");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("휴먼엑스포", Font.BOLD, 150));
		label.setBounds(245, 175, 701, 346);
		panel.add(label);
		
		ImageIcon mainSuri = new ImageIcon(main.class.getResource("../testimage/mainSuri.png"));
		
		JLabel imgLbl = new JLabel();
		imgLbl.setBounds(1300, 300, 470, 351);
		imgLbl.setIcon(mainSuri);
		
		panel.add(imgLbl);
		
	}
}
