package ch01;

//Ctrl + shift + o;
// Ctrl + shift + s;
// ctrl + shift + f;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayout2 extends JFrame {

	final int WIDTH = 600;
	final int HEIGHT = 600;

	JButton[] buttons;
	String[] directions = { BorderLayout.EAST, BorderLayout.WEST, BorderLayout.NORTH, BorderLayout.SOUTH,
			BorderLayout.CENTER };

	// Ctrl + shift + o;

	// 생성자
	public BorderLayout2() {

		initData();
		setInitLayout();

	}

	public void initData() {
		setTitle("borderLayout 연습");
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 끄면 프로그램 종료 해
	}

	public void setInitLayout() {
		// 배치 관리자 선정 (컨테이너)
		// BorderLayout -- 컴포넌트들을 동,서,남,북,가운데 로 배치 시켜주는 레이아웃이다.
		setLayout(new BorderLayout());

		// 반복문을 활용해서 코드를 완성하세요.
		buttons = new JButton[directions.length];
		for (int i = 0; i < buttons.length; i++) {
			add(buttons[i] = new JButton(directions[i]), directions[i]);

		}
	}

	// 코드 테스트
	public static void main(String[] args) {
		new BorderLayout2(); // <--- 주소값, 참조값이 없기에 '익명 클래스' 이다.
		// 다시 접근해서 사용할 일 없으면 new 라고 선언만 해도 된다.
	} // end of main

}
