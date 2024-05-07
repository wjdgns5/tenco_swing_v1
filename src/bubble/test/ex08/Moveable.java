package bubble.test.ex08;

public interface Moveable {
	
	// public abstract 생략 가능 
	public abstract void left();
	public abstract void right();
	public abstract void up();
	// 인터페이스 추가 기능 default 사용해보기
	// 인터페이스의 모든 메서드는 추상 메서드이어야 한다.
	// 단 default 메서드를 제외하고
	
	// public abstract void down();
	default void down() {};
	// 마지막에 default는 세미콜론 추가 해야 한다.
	
	// default로 지정하면 오버라이딩 하는 메서드를 삭제해도 문제가 되지 않는다.
	
}
