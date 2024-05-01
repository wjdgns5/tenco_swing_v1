package ch06;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniGame3 extends JFrame {

	private JLabel jPlayer;

	// 변수는 --> 변하는 수이기도 하다.
	private int jPlayerX = 100;
	private int jPlayerY = 100;
	private final int MOVDE_DISTANCE = 10;
	private final int FRAME_WIDTH = 500;
	private final int FRAME_HEIGHT = 500;
	private final String PLAYER_NAME = "야스오";
	private final int PLAYER_WEIGHT = 100;
	private final int PLAYER_HEIGHT = 100;

	public MiniGame3() {
		initData(); // 메서드
		setInitLayout(); // 메서드
		setEventListener(); // 메서드
	} // 생성자

	private void initData() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT); //
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jPlayer = new JLabel("플레이어1");
		jPlayer.setSize(PLAYER_WEIGHT, PLAYER_HEIGHT);
	}

	private void setInitLayout() {
		// 좌표 기반으로 배치관리자 변경
		setLayout(null);
		add(jPlayer);
		jPlayer.setLocation(jPlayerX, jPlayerY);
		setVisible(true);
	}

	private void setEventListener() {

		// jPlayer 객체에게서만 keyListener 동작을 시키고자 한다면
		// 익명 구현 클래스로 KeyListener 인터페이스를 재 정의할 수 있다.
		// jPlayer.addKeyListener(this); // 인터페이스 없어서 안됨
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
					jPlayerY -= MOVDE_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					jPlayerX -= MOVDE_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					jPlayerX += MOVDE_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					jPlayerY += MOVDE_DISTANCE;
				}

				jPlayer.setLocation(jPlayerX, jPlayerY);
			}
		});

	}

	public static void main(String[] args) {
		new MiniGame3();
	}

}
