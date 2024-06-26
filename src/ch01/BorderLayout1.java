package ch01;

// 단축키
//Ctrl + shift + o;
// Ctrl + shift + s;
// ctrl + shift + f;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayout1 extends JFrame {

	// 생성자
	public BorderLayout1() {

		initData();
		setInitLayout();

	}

	public void initData() {
		setTitle("borderLayout 연습");
		setSize(600, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 끄면 프로그램 종료 해

	}

	public void setInitLayout() {
		// 배치 관리자 선정 (컨테이너)
		// BorderLayout -- 컴포넌트들을 동,서,남,북,가운데 로 배치 시켜주는 레이아웃이다.
		setLayout(new BorderLayout());
		add(new JButton("동"), BorderLayout.EAST);
		add(new JButton("서"), BorderLayout.WEST);
		add(new JButton("남"), BorderLayout.SOUTH);
		add(new JButton("북"), BorderLayout.NORTH);
		add(new JButton("센터"), BorderLayout.CENTER);
	}

	// 코드 테스트
	public static void main(String[] args) {
		new BorderLayout1(); // <--- 주소값, 참조값이 없기에 '익명 클래스' 이다.
		// 다시 접근해서 사용할 일 없으면 new 라고 선언만 해도 된다.
	} // end of main

}
