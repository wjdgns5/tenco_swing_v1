package ch05;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
// 이벤트 리스너를 사용하는 방법
// 1. implements ActionListener 사용 하는 방법 
// ActionListener --> 운영 체제가 제어하는 이벤트를 등록할 수 있다.

public class ColorChangeFrame extends JFrame implements ActionListener {

	// 이벤트 리스너에 대한 개념을 이해하자.

	private JButton button1;

	public ColorChangeFrame() {
		initData();
		setInitLayou();
		addEventListener();
	}

	private void initData() {
		setTitle("Swing5");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button1 = new JButton("button1");
	}

	private void setInitLayou() {
		setLayout(new FlowLayout());
		add(button1);
		setVisible(true);
	}

	private void addEventListener() {
		// button1이 눌러지는지 계속 이벤트를 지켜 보고 있어
		// 이벤트 등록
		// this가 사용되는 이유 인터페이스 implements ActionListener로 인해 this가 사용된다.
		button1.addActionListener(this);

	}

	// 코드 테스트
	public static void main(String[] args) {
		new ColorChangeFrame();

	} // end of main
		// 약속 되어 있던 추상 메서드를 오버라이드 했다.
		// 이벤트가 발생 되면 이 메서드를 수행해 약속 되어 있음
		// 단, 어떤 컴포넌트가 이벤트가 할당 되었는지 등록을 먼저 해주어야 한다.

	@Override
	public void actionPerformed(ActionEvent e) {
		// 매개변수 e
		System.out.println("actionPerformed 메서드 호출() ");
		System.out.println(e.toString());
	}

} // end of class
