package main;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class main_view  {
	public static void main(String[] args) {
		Frame f=new Frame();
		f.setTitle("�������������");
		f.setLocation(500,200);
		f.setSize(1500, 1000);
		f.setVisible(true);
		//â�ݱ� 
		f.addWindowListener(new WindowHandler());

	}

}


//â�ݱ� Ŭ����
class WindowHandler extends WindowAdapter{
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
