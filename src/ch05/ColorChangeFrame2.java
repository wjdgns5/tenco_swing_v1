package ch05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ColorChangeFrame2 extends JFrame implements ActionListener {

	private JPanel panel;
	private JButton button1;
	private JButton button2;

	public ColorChangeFrame2() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {

		setTitle("Swing 5");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout()); // BorderLayout
		panel = new JPanel();
		panel.setBackground(Color.yellow);

		button1 = new JButton("click1");
		button2 = new JButton("click2");
	}

	private void setInitLayout() {
		add(button1, BorderLayout.NORTH);
		add(button2, BorderLayout.SOUTH);
		add(panel, BorderLayout.CENTER);
		setVisible(true);
	}

	// 이 메서드에 책임은 이벤트 리스너만 등록
	private void addEventListener() {
		button1.addActionListener(this);
		button2.addActionListener(this);
	}

	// 콜백 메서드
	// ex) 알람예약을 4시에 맞춰놓고 4시에 집에갈 예정이다.
	// 시간이 지나 4시가 되면 알람이 울려서 집에간다.

	// 콜백 메서드이다.
	// 오버라이드 : 이벤트가 일어나면 호출 되어지는 메서드
	@Override
	public void actionPerformed(ActionEvent e) {

		Object object = e.getSource();

		JButton selectedButton = (JButton) e.getSource();

		if (object == button1) {
			System.out.println("버튼1 ");
			panel.setBackground(Color.black);
		} else if (object == button2) {
			System.out.println("버튼2 ");
			panel.setBackground(Color.yellow);
		}

		// System.out.println(object);
		// System.out.println(button1);
		// System.out.println(button2);
		// System.out.println(e.getSource().toString());
	}

	// 코드 테스트
	public static void main(String[] args) {
		new ColorChangeFrame2();
	}

}
