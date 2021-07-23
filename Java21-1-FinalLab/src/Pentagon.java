// 1분반, 2021-06-10, 32181046 김준하

import java.util.Arrays;

// Polygon 추상클래스를 상속받은 오각형 클래스
public class Pentagon extends Polygon{

	// 4.1 생성자
	public Pentagon(Point[] points) {
		super();
		this.points = points;
	}
	public Pentagon() {
		Point[] pt = {new Point(), new Point(), new Point(), new Point(), new Point()};
		this.points = pt;
	}
	
	// 4.2 다각형의 넓이를 삼각형으로 나누어 삼각형의 합으로 계산하는 메소드이다.
	@Override
	public double getArea() {
		int triangleCount = points.length - 2;  // 삼각형의 개수 : 꼭짓점-2개
		double[] sides = PolygonMath.findSides(points);  // 해당 다각형의 모서리 배열
		double[] diagonals = PolygonMath.findDiagonals(points);  // 해당 다각형의 대각선 배열
		double area = 0;  // 넓이를 구해서 더할 변수
		for (int i = 0, j = 0; i < triangleCount; i += 2, j++) {
			double[] newSides = {sides[i], sides[i+1], diagonals[j]};  // 새로운 삼각형의 모서리
			area += PolygonMath.area(newSides[0], newSides[1], newSides[2]);  // 새로운 삼각형의 모서리로 넓이 계산 후 area에 누적 덧셈
		}
		return area;
	}
	
	// 4.3 다각형의 둘레를 구해 반환하는 메소드이다.
	@Override
	public double getPerimeter() {
		double[] sides = PolygonMath.findSides(points);  // 다각형의 모서리 배열
		double perimeter = 0;  // 둘레
		for (int i = 0; i < points.length; i++) {  // 모든 모서리의 합을 perimeter에 저장
			perimeter += sides[i];
		}
		return perimeter;
	}
	
	// 4.5 다각형이 정다각형이면 true를 반환하고 아니면 false를 반환하는 검사 메소드이다. 모든 모서리의 길이와, 모든 각도의 크기가 같으면 정다각형인 점을 이용한다.
	@Override
	public boolean isRegular() {
		double[] angles = PolygonMath.findAngles(points);  // 각도
		double[] sides = PolygonMath.findSides(points);  // 모서리
		double fAngle = angles[0];  // 0번째 인덱스의 각도
		double fSide = sides[0];  // 0번째 인덱스의 모서리 길이
		for (int i = 1; i < points.length; i++) {
			if (angles[i] != fAngle || sides[i] != fSide) return false;  // 0번째 인덱스의 각도와 모서리와 비교해 다른값이 있으면 정다면체가 아니므로 false 반환
		}
		return true;  // 다른값이 나오지 않는다면 true 반환
	}
	
	// 4.4 사용자의 입력을 받아 points의 X, Y 값을 변경하는 메소드이다.
	@Override
	public void getUserInput() {
		Point[] userPoints = new Point[points.length];
		for (int i = 0; i < userPoints.length; i++) {
			System.out.println(i + "번째 X값: ");
			this.points[i].setX(UserInput.getDouble());  // i번째 X값을 변경
			System.out.println(i + "번째 Y값: ");
			this.points[i].setY(UserInput.getDouble());  // i번째 Y값을 변경
		}
	}
	
	// 4.6 toString 메소드
	@Override
	public String toString() {
		return "Pentagon [points=" + Arrays.toString(points) + ", sides=" + Arrays.toString(sides) + ", diagonals="
				+ Arrays.toString(diagonals) + ", angles=" + Arrays.toString(angles) + ", bound=" + bound + ", type="
				+ type + "]";
	}
}
