// 1분반, 2021-06-10, 32181046 김준하

public class PolygonMath {
	private PolygonMath() {}
	
	// 세 변의 double형 길이를 받아서 double형 넓이로 반환하는 정적 메소드  (헤론의 공식 이용)
	public static double area(double a, double b, double c) {
		double s = (a + b + c) /2.0;
		return Math.sqrt(s * (s-a) * (s-b) * (s-c));
	}

	// Point객체 배열을 받아 double형의 모서리 길이 배열 반환 메소드
	public static double[] findSides(Point[] points) {
		if (points == null) return null;  // points가 없으면 null 반환
		double[] sides = new double[points.length];  // points 길이와 같은 double형 sides 배열 생성
		for (int i = 0; i < points.length; i++) {  // points 길이만큼 반복
			int nextIndex = (i + 1) % points.length;
			sides[i] = Point.getDistance(points[i], points[nextIndex]);  // 바로 옆 꼭짓점과의 거리(길이)를 sides 배열에 저장
		}
		return sides;
	}

	// Point객체 배열을 받아 double형의 꼭짓점 0번에서 각 꼭짓점까지의 대각선 길이 배열 반환 메소드
	public static double[] findDiagonals(Point[] points) {
		if (points == null) return null;  // points가 없으면 null 반환
		if (points.length < 4) return null;  // 사각형 미만은 대각선이 없으므로 null 반환
		double[] diagonals = new double[points.length - 3];  // 대각선의 개수는 (꼭짓점의 개수) - 3 개
		for (int i = 2; i < points.length - 1; i++) {  // 꼭짓점0과 2부터 시작하여 0부터의 대각선 길이를 diagonals에 저장
			diagonals[i-2] = Point.getDistance(points[0], points[i]);
		}
		return diagonals;
	}

	// Points객체 배열을 받아 double형의 각의 크기 배열 반환 메소드
	public static double[] findAngles(Point[] points) {
		if (points == null) return null;  // points가 없으면 null 반환
		double[] angles = new double[points.length];  // points 길이와 같은 double형 angles 배열 생성
		for (int i = 0; i < points.length; i++) {  // 길이만큼 반복
			int prevIndex = i==0 ? (i + points.length - 1) : (i - 1);  // i가 0이면 i+points크기-1(마지막 배열 인덱스)을 prevIndex에 저장, 아니면 i-1(이전 인덱스)을 저장
			int nextIndex = (i + 1) % points.length;  // 바로 다음 인덱스를 nextIndex에 저장
			angles[i] = innerAngle(points[prevIndex], points[i], points[nextIndex]);  // 이전 인덱스, 현재의 인덱스, 다음 인덱스를 이용해 각의 크기를 angles에 저장
		}
		return angles;
	}
	
	// dot = p1.x * p2. x + p1.y * p2.y
	public static double dot(Point p1, Point p2) {
		return p1.getX()*p2.getX() + p1.getY()*p2.getY();
	}

	// Angle between two vectors = acos(dot(v1, v2)/|v1|*|v2|)
	public static double innerAngle(Point p1, Point p2, Point p3) {
		Point v1 = new Point(p1.getX() - p2.getX(), p1.getY() - p2.getY());
		Point v2 = new Point(p3.getX() - p2.getX(), p3.getY() - p2.getY());
		double len1 = Math.sqrt(v1.getX()*v1.getX() + v1.getY()*v1.getY());
		double len2 = Math.sqrt(v2.getX()*v2.getX() + v2.getY()*v2.getY());
		double angrad = Math.acos(dot(v1, v2)/(len1 * len2));
		return Math.toDegrees(angrad);  // Math 클래스의 toDegrees를 이용해 라디안 값을 측정값으로 변환하여 반환
	}

}
