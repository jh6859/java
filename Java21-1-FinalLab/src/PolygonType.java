// 1분반, 2021-06-10, 32181046 김준하

// 다각형의 타입 열거형 생성, 
public enum PolygonType {
	TRIANGLE(3),  // 삼각형
	RECTANGLE(4),  // 사각형
	PENTAGON(5),  // 오각형
	HEXAGON(6),  // 육각형
	HEPTAGON(7),  // 칠각형
	OCTAGON(8);  // 팔각형
	
	// private를 통해 다른 곳에서 접근이 불가능 하게 한다. final을 통해 생성된 필드는 값을 변경할 수 없다.
	private final int type;	
	
	// 정수형 값을 받아 type 변수에 대입하는 메소드
	private PolygonType(int type) {
		this.type = type;
	}
		
	// 정수형 type의 값을 반환하는 getter
	public int getType() {
		return type;
	}
	
	// 정수 값을 받아 그 값에 따라 PolygonType 열거형을 반환하는 메소드이다. static으로 생성되었으므로 다른 모든 클래스에서도 사용 가능하다.
	public static PolygonType valueOf(int type) {
		
		// switch문을 통해 정수형 값에 따라 PolygonType 열거형을 반환한다.
		switch(type) {
		case 3:
			return TRIANGLE;
		case 4:
			return RECTANGLE;
		case 5:
			return PENTAGON;
		case 6:
			return HEXAGON;
		case 7:
			return HEPTAGON;
		case 8:
			return OCTAGON;
		default:
			return null;
		}
	}
}