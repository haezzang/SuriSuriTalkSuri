package main;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class main_view  {
	public static void main(String[] args) {
		Frame f=new Frame();
		f.setTitle("수리수리톡수리");
		f.setLocation(500,200);
		f.setSize(1500, 1000);
		f.setVisible(true);
		//창닫기 
		f.addWindowListener(new WindowHandler());

	}

}


//창닫기 클래스
class WindowHandler extends WindowAdapter{
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
