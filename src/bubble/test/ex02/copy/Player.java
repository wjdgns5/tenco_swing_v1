package bubble.test.ex02.copy;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {

	private int x; // 플레이어의 x 좌표
	private int y; // 플레이어의 y 좌표
	private ImageIcon playerR, playerL;

	// 플레이어의 움직임의 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

	// 플레이어 속도 상태
	private final int SPEED = 4;
	private final int JUMPSPEED = 2;

	// setter
	public void setLeft(boolean left) {
		this.left = left;
	}

	// setter
	public void setRight(boolean right) {
		this.right = right;
	}

	// setter
	public void setUp(boolean up) {
		this.up = up;
	}

	public Player() {
		initData();
		setInitLayout();
	}

	private void initData() {
		playerR = new ImageIcon("img/playerR.png"); // 플레이어R 이미지 생성
		playerL = new ImageIcon("img/playerL.png"); // 플레이어L 이미지 생성

		// 처음 실행 시 초기값 셋팅
		x = 55;
		y = 535;

		// 플레이어가 가만이 멈춤 상태
		left = false;
		right = false;
		up = false;
		down = false;

		setIcon(playerR); // setIcon 은 JLabel의 기능이다.
		setSize(50, 50); // 크기
		setLocation(x, y); // 좌표

	}

	private void setInitLayout() {

	}

	@Override
	public void left() {
		// 왼쪽 방향키 이벤트 발생 시
		// 이미지를 왼쪽으로 보는 이미지로 셋팅

		// 왼쪽으로 가고 있는 상태
		// 멈춰 있는 상태란 개념이 필요하다.

		left = true;
		setIcon(playerL);
		// <- <- <- 반복문을 돌린다.
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (left) {
					x = x - SPEED;
					setLocation(x, y); // x와 y의 좌표값으로 위치를 다시 찍어준다.
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}).start();
	}

	@Override
	public void right() {

		right = true;
		setIcon(playerR);

		new Thread(new Runnable() {

			@Override
			public void run() {

				while (right) {
					x = x + SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} // 0.01초
				}
			}
		}).start();
	} // end of right

	@Override
	public void up() {
		// setIcon(playerR);
		System.out.println("점프");

		up = true;
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 120 / JUMPSPEED; i++) {
					y = y - JUMPSPEED;
					setLocation(x, y);

					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				// 객체의 상태값을 잘 조절해야 한다.
				up = false;
				down();
			}
		}).start();


	} // end of up()

	@Override
	public void down() {
		System.out.println("다운");
		down = true;
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 120 / JUMPSPEED; i++) {
					y = y + JUMPSPEED;
					setLocation(x, y);

					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}).start();
		// 상태 값 처리를 확실히 해야한다.
		down = false; // down 은 비활성화
	}

}
