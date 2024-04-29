package ch02;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

// 내부 클래스를 활용해서 코드를 완성해 주세요
public class PaintFrame extends JFrame {

	MyDrawPanel myDrawPanel;

	// 생성자
	public PaintFrame() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("그림 그리기");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		myDrawPanel = new MyDrawPanel();
	}

	private void setInitLayout() {
		add(myDrawPanel);
		setVisible(true);
	}

	class MyDrawPanel extends JPanel {

		// paint = o;

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			
			g.drawRect(100, 100, 300, 300);

			g.drawLine(130, 220, 230, 220);
			g.drawLine(130, 220, 130, 300);
			
			g.drawLine(230, 220, 230, 300);
			g.drawLine(300, 220, 300, 220);
			
			
			
	
		} // end of inner class

	}
}
