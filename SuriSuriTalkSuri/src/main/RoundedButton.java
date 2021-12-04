package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JButton;

public class RoundedButton extends JButton {

	Color color; //배경색 초기화
	int round;
	
	public RoundedButton(String text) {
		super(text);
		color=new Color(51,203,51);
		round=40;
		decorate();
	}
	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Color o = new Color(255,255,255); // 글자색 결정
		int width = getWidth() /2;
		int height = getHeight();
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		
		if (getModel().isArmed()) {
			graphics.setColor(color.darker());
		} else if (getModel().isRollover()) {
			graphics.setColor(color.brighter());
		} else {
			graphics.setColor(color);
		}
		
		// 버튼 크기
		graphics.fillRoundRect(0, 0, width, height, round, round);
		FontMetrics fontMetrics = graphics.getFontMetrics();
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();
		
		// 버튼 안의 글자 위치
		int textX = (width - stringBounds.width) / 2;
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();
		graphics.setColor(o);
		graphics.setFont(new Font("휴먼엑스포", Font.BOLD, 23));
		//graphics.setFont(getFont());
		graphics.drawString(getText(), textX-10, textY+5);
		graphics.dispose();
		super.paintComponent(g);
	}
}
