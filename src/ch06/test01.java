package ch06;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class test01 extends JFrame {

	private JLabel backgroundMap;
	private JLabel player1;
	private JLabel player2;
	private JLabel player3;

	private int playerX = 100;
	private int playerY = 100;

	public test01() {
		initData();
		setInitData();
		setEventListner();
	}

	public void setEventListner() {

		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_UP) {
					playerY -= 10;

				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

					playerX -= 10;

				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					playerX += 10;

				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					playerY += 10;

				}

				player1.setLocation(playerX, playerY);
				player2.setLocation(playerX, playerY);

			}
		});
	}

	public void initData() {

		setTitle("Swing 6");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		Icon icon = new ImageIcon("images2/backgroundMap.png"); // 업 캐스팅 된 상태
//		backgroundMap = new JLabel(icon);
		backgroundMap = new JLabel(new ImageIcon("images2/backgroundMap.png"));

		backgroundMap.setSize(1000, 600); // 그림 사이즈 1000 600
		backgroundMap.setLocation(0, 0); // x좌표 0 y 좌표 0 부터 그림을 그려라

//		Icon icon2 = new ImageIcon("images2/playerR.png"); // 업 캐스팅 된 상태
//		player = new JLabel(icon2);
		player1 = new JLabel(new ImageIcon("images2/playerR.png"));

		player1.setSize(100, 45);
		player1.setLocation(300, 180);

		Icon icon3 = new ImageIcon("images2/playerL.png");
		player2 = new JLabel(icon3);

	}

	public void setInitData() {
		// 좌표 기반으로 배치관리자 설정
		setLayout(null);
		add(backgroundMap);
		backgroundMap.add(player1, player2);
		setVisible(true);
		player1.setLocation(playerX, playerY);

	}

	public static void main(String[] args) {
		new test01();
	}
}
