package bubble.test.ex01;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {

	private int x; // 플레이어의 x 좌표
	private int y; // 플레이어의 y 좌표
	private ImageIcon playerR, playerL;

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
		setIcon(playerL);
		x = x - 10;
		setLocation(x, y); // x와 y의 좌표값으로 위치를 다시 찍어준다.
	}

	@Override
	public void right() {

		setIcon(playerR);
		x = x + 10;
		setLocation(x, y); // x와 y의 좌표값으로 위치를 다시 찍어준다.

	}

	@Override
	public void up() {
		setIcon(playerR);
		System.out.println("점프");

	}

	@Override
	public void down() {
		System.out.println("다운");
	}

}
