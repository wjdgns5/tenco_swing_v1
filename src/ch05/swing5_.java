package ch05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class swing5_ extends JFrame implements ActionListener {
	// 버튼
	private JButton button1;
	private JButton button2;

	// 패널
	private JPanel panel1;
	private JPanel panel2;

	public swing5_() {
		initData();
		setInitLayout();
		addEventListener();
	} // 생성자

	private void initData() {

		setTitle("Swing5_ 도전연습");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel1 = new JPanel();
		panel1.setBackground(Color.blue);

		panel2 = new JPanel();
		panel2.setBackground(Color.green);

		button1 = new JButton("button1");
		button2 = new JButton("button2");
	}

	private void setInitLayout() {
		// 루트 패널 --> BorderLayout
		add(panel1, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);

		panel2.add(button1);

		panel2.add(button2);

		setVisible(true);
	}

	public void addEventListener() {

		button1.addActionListener(this);
		button2.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();

		if (object == button1) {
			panel1.setBackground(Color.black);
		} else if (object == button2) {
			panel1.setBackground(Color.yellow);
		}

	}

	public static void main(String[] args) {
		new swing5_();
	}

}
