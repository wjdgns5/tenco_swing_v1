package bubble.test.ex01;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	// 포함관계 - 콤포지션
	private Player player; // 포함관계

	public BubbleFrame() {
		initData();
		setInitData();
		addEventListener();
	}

	private void initData() {

		backgroundMap = new JLabel(new ImageIcon("img/backgroundMap.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 전체 프레임 안에 루트 패널이 있다.
		// Frame --> root Panel
		setContentPane(backgroundMap); // add 처리
		setSize(1000, 640);

		player = new Player();

	}

	private void setInitData() {

		// 좌표 값으로 배치
		setLayout(null);
		setResizable(false); // 프레임 크기 조절 여부
		setLocationRelativeTo(null); // JFrame 여러개 모니터 가운데 자동 배치
		setVisible(true);

		add(player); // 좌표와 크키가 없어서 나타나지 않음

	}

	private void addEventListener() {

		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("key code : " + e.getKeyCode());

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.left();
					// 구현
					break;

				case KeyEvent.VK_RIGHT:
					player.right();
					// 구현
					break;

				case KeyEvent.VK_UP:
					player.up();
					// 구현
					break;
				}

				// super.keyPressed(e);
			}
		});

	}
	
	//코드 테스트
	public static void main(String[] args) {
		new BubbleFrame();
	}

}
