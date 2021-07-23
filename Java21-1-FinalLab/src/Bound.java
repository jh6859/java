// 1분반, 2021-06-10, 32181046 김준하

// Bound를 지정하는 클래스
public class Bound {
	private Point bottomLeft;  // 하단 왼쪽의 값
	private Point bottomRight;  // 하단 오른쪽의 값
	private Point topLeft;  // 상단 왼쪽의 값
	private Point topRight;  // 상단 오른쪽의 값

	// Bound 객체의 bottomLeft, bottomRight 값는 0.0으로, topLeft, topRight 값은 1.0으로 지정하는 생성자
	public Bound()	{
		this(new Point(0.0, 0.0), 1.0, 1.0);
	}

	// Bound 객체와 너비, 높이를 입력받아 연산결과에 따른 각각의 Bound 필드값 저장
	public Bound(Point origin, double width, double height)	{
		this.bottomLeft = origin;
		this.bottomRight = new Point(origin.getX() + width, origin.getY());
		this.topLeft = new Point(origin.getX(), origin.getY() + height);
		this.topRight = new Point(origin.getX() + width, origin.getY() + height);
	}
	
	// 하단 왼쪽 값과 너비, 높이를 입력받아 연산결과에 따른 각각의 필드값 저장
	public Bound(double x, double y, double width, double height) {
		this.bottomLeft = new Point(x, y);
		this.bottomRight = new Point(x + width, y);
		this.topLeft = new Point(x, y + height);
		this.topRight = new Point(x + width, y + height);
	}
	
	// 하단 왼쪽 값, 상단 오른쪽 값을 입력받아 연산결과에 따른 각각의 필드값 저장
	public Bound(Point bottomLeft, Point topRight) {
		this.bottomLeft = bottomLeft;
		this.bottomRight = new Point(topRight.getX(), bottomLeft.getY());
		this.topLeft = new Point(bottomLeft.getX(), topRight.getY());
		this.topRight = topRight;
	}

	//getter 메소드
	public Point getBottomLeft() {  // 하단 왼쪽
		return bottomLeft;
	}
	public Point getBottomRight() {  // 하단 오른쪽
		return bottomRight;
	}
	public Point getTopLeft() {  // 상단 왼쪽
		return topLeft;
	}
	public Point getTopRight() {  // 상단 오른쪽
		return topRight;
	}
	public double getWidth() {  // 너비
		return topRight.getX() - bottomLeft.getX();
	}
	public double getHeight() {  // 높이
		return topRight.getY() - bottomLeft.getY();
	}

	// Point 객체의 배열을 입력받아 x,y의 최대값과 최소값을 구한 값을 이용해 Bound를 찾아 반환하는 메소드
	public static Bound findBound(Point[] points) {
		if (points == null) return null;  // 배열이 없으면 null값을 반환한다.
		
		//일단 0번째 배열의 x,y값을 최대, 최소값으로 지정
		double xmin = points[0].getX();
		double xmax = points[0].getX();
		double ymin = points[0].getY();
		double ymax = points[0].getY();
		
		// 배열 수 만큼 반복하여, 새로운 최대, 최소 값이 나오면 새로 대입한다.
		for (int i = 0; i < points.length; i++) {
			xmin = Math.min(points[i].getX(), xmin);
			xmax = Math.max(points[i].getX(), xmax);
			ymin = Math.min(points[i].getY(), ymin);
			ymax = Math.max(points[i].getY(), ymax);
		}
		return new Bound(xmin, ymin, xmax - xmin, ymax - ymin);
	}

	// toString 메소드
	@Override
	public String toString() {
		return "Bound [bottomLeft=" + bottomLeft + ", bottomRight=" + bottomRight + ", topLeft=" + topLeft
				+ ", topRight=" + topRight + "]";
	}
}
