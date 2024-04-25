package ch01;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// Swinig 배치 관리자 : FlowLayout
// 컴포넌트들을 (버튼, 라벨) 등을 수평, 수직으로 배치를 해주는 클래스 이다.
public class FlowLayoutEx2 extends JFrame {

	// 배열 활용 - 하나의 변수로 여러개 통으로 관리하고 싶다면 배열을 써보자.

	private JButton button[];

	// 생성자
	public FlowLayoutEx2() {
		super.setTitle("FlowLayout 연습");
		super.setSize(500, 500); // 프레임 사이즈
		super.setVisible(true); // 프레임 보이게 한다.
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 생성자에서 메서드 호출 가능하다.
		initData();
		setInitLayout();

	}

	// 멤버 변수를 초기화 하는 기능 (값을 넣다.)

	public void initData() {
		// 반복문 활용
		button = new JButton[6]; // 공간만 선언 [][][][][][]
								//				0 1 2 3 4 5
		for (int i = 0; i < button.length; i++) {
			button[i] = new JButton("[ button" + (i+1) + " ]");
		}

	}

	// 컴포넌트들을 배치하는 기능
	public void setInitLayout() {
		// 배치 관리자 --> BorderLayout 이라는 배치관리자가 기본으로 활용 된다.
		// FlowLayout flowLayout = new FlowLayout();
		// super.setLayout(flowLayout); // 배치관리자 --> FlowLayout

		// 배치 관리자 생성 및 JFrame 셋팅
		super.setLayout(new FlowLayout(FlowLayout.LEADING, 50, 50));

		// 컴포넌트를 붙이다.
		// 반복문 활용
		for (int i = 0; i < button.length; i++) {
			super.add(button[i]);
		}

	}

	// 코드 테스트
	public static void main(String[] args) {
		new FlowLayoutEx2(); // <--- 주소값, 참조값이 없기에 '익명 클래스' 이다.
		// 다시 접근해서 사용할 일 없으면 new 라고 선언만 해도 된다.
	} // end of main

}
