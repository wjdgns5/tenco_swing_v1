package ch02;

import java.awt.Graphics;

/*
 * 패널에 그림을 그리는 방법
 * 자바 문법 - 중첩 클래스 ( 클래스 안에 클래스를 만드는 것)
 * 외부 클래스, 내부 클래스, outer class, inner class
 */
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyDrawFrame extends JFrame {

	// 내부 클래스를 외부 클래스에 사용하려면 멤버로 가지고 있어야 한다.
	MyDrawPanel myDrawPanel;

	public MyDrawFrame() {
		initData();
		setInitLayout();
	} // 생성자

	private void initData() {
		setTitle("내부 클래스를 활용한 그림 그리는 연습");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		myDrawPanel = new MyDrawPanel();
	}

	private void setInitLayout() {
		add(myDrawPanel);
		setVisible(true);
	}

	// 내부 클래스 만들어 보기
	// paint --> 좌표값으로 x = 0 , y = 0
	// JPanel 에 있는 기능을 확장해 보자.
	class MyDrawPanel extends JPanel {

		// paint = o;

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawRect(100, 100, 50, 100);
			g.drawRect(200, 200, 150, 150);
			// int x1, int y1, int x2, int y2
			g.drawLine(250, 300, 300, 300);
			g.drawOval(100, 150, 200, 300);
			g.drawString("반가워", 400, 400);
			g.drawString("🤩", 500, 500);
		} // end of inner class

	}
}
