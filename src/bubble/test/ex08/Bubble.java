package bubble.test.ex08;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel implements Moveable {

	// 의존성 컴포지션 관계
	private Player player; // 포함관계
	private BackgroundBubbleService backgroundBubbleService;

	private int x;
	private int y;

	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;

	// 적군을 맞춘 상태
	private int state; // 0번은 (기본 물방울), 1번은 (적을 가둔 상태 물방울)

	private ImageIcon bubble; // 기본 물방울
	private ImageIcon bubbled; // 적을 가둔 물방울
	private ImageIcon bomb; // 물방울 팡 !!

	// 연관관계, 의존성 컴포지션 관계, 생성자 의존 (DI)
	public Bubble(Player player) {
		this.player = player;
		initData();
		setInitLayout();
		initLayout();
		// 객체 생성 시 무조건 쓰레드 시작
		initThread();
	}

	private void initData() {

		bubble = new ImageIcon("img/bubble.png");
		bubbled = new ImageIcon("img/bubbled.png");
		bomb = new ImageIcon("img/bomb.png");
		backgroundBubbleService = new BackgroundBubbleService(this);

		left = false;
		right = false;
		up = false;
		// state = false;

	}

	// GET, SET

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public ImageIcon getBubble() {
		return bubble;
	}

	public void setBubble(ImageIcon bubble) {
		this.bubble = bubble;
	}

	public ImageIcon getBubbled() {
		return bubbled;
	}

	public void setBubbled(ImageIcon bubbled) {
		this.bubbled = bubbled;
	}

	public ImageIcon getBumb() {
		return bomb;
	}

	public void setBumb(ImageIcon bumb) {
		this.bomb = bumb;
	}

	private void setInitLayout() {
		// x, y, setIcon(bubble), setSize(50, ),setLocation(x, y);

		x = player.getX();
		y = player.getY();

		setIcon(bubble);
		setSize(50, 50);
		setLocation(x, y);
	}

	private void initLayout() {
	}

	// 공통으로 사용하는 부분을 메서드로 만들어 보자.
	// 이 메서드는 내부에서만 사용할 예정
	private void initThread() {
		// 버블은 쓰레드가 하나면 된다.
		// 익명 클래스,
		new Thread(new Runnable() {

			@Override
			public void run() {

				if (player.playerWay == player.playerWay.LEFT) {
					left();
				} else {
					right();
				}

			}
		}).start();
	}

	@Override
	public void left() {
		left = true;
		for (int i = 0; i < 400; i++) {
			x--;
			setLocation(x, y);
			// 만약 왼쪽벽에 부딪혔다면 --> up() 메서드
			if (backgroundBubbleService.leftWall()) {
				// 만약 true 라면 부딪힘
				break;
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		up();

	}

	@Override
	public void right() {
		left = true;
		for (int i = 0; i < 400; i++) {
			x++;
			setLocation(x, y);
			if (backgroundBubbleService.rightWall()) {
				break;
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		up();

	}

	@Override
	public void up() {

		up = true;
		while (true) {
			y--;
			setLocation(x, y);
			if (backgroundBubbleService.topWall()) {
				break;
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
