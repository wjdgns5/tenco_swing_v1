package bubble.test.ex08;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 현재 메인 쓰레드는 너~무 빠쁨 백그라운드에서 계속 Player 에 움직임을 관찰할 예정
 */
public class BackgroundPlayerService implements Runnable {

	private BufferedImage image;
	private Player player;

	// 생성자 의존 주입 DI
	public BackgroundPlayerService(Player player) {
		this.player = player;

		try {
			image = ImageIO.read(new File("img/backgroundMapService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		while (true) {
			// 색상 확인 todo (보정값 필요)
			Color leftColor = new Color(image.getRGB(player.getX() + 10, player.getY() + 25));
			Color rightColor = new Color(image.getRGB(player.getX() + 50 + 10, player.getY() + 25));

			// Color bottomColor = new Color(image.getRGB(player.getX(), player.getY()));

			// 흰색이면 바닥 RGB 값이 ==> 255 255 255
			// 바닥인 경우 --> 255 0 0 (바닥이라고 판단 가능) --> 빨간색
			// 바닥인 경우 --> 0 0 255 (바닥이라고 판단 가능) --> 파란색
			int bottomColorLeft = image.getRGB(player.getX() + 20, player.getY() + 50 + 5);
			int bottomColorRight = image.getRGB(player.getX() + 40, player.getY() + 50 + 5);

			// 하얀색 -----> int 값이 원래 -1 이다.
			// 하얀색 -----> int 값 -1 + -1 = -2
			if (bottomColorLeft + bottomColorRight != -2) {
				// 여기는 멈추어야 한다. (빨간 바닥 또는 파란색 바닥)
				player.setDown(false);
			} else {
				// 플레이어가 올라가는 상태가 아니라면 
				// 그리고
				// 플레이어가 내려가는 상태가 아니라면
				// down() 메서드 호출
				if (!player.isUp() && !player.isDown()) {
					player.down();
				}

			}

			// 왼쪽에 충돌함
			if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				System.out.println("왼쪽벽에 충돌 함.");
				player.setLeftWallCrash(true);
				player.setLeft(false);

			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				System.out.println("오른쪽벽에 충돌 함.");
				player.setRightWallCrash(true);
				player.setRight(false);
			} else {
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
			}

			// 위 두 조건이 아니면 player 마음대로 움직일 수 있다.
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
