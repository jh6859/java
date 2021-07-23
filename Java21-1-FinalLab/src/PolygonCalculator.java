// 1분반, 2021-06-10, 32181046 김준하

import java.util.Arrays;

// 임의의 다각형 클래스로 Point[] points와 Triangle[] triangles 멤버필드
public class PolygonCalculator {
	private Point[] points;
	private Triangle[] triangles;
	
	// 다각형의 점들 points으로 삼각형 배열 triangles을 지정하는 생성자 
	public PolygonCalculator(Point[] points) {
		
		// x,y값들의 중앙값을 이용해 중점 구하기
		double xCenter = 0, yCenter = 0;
		for (int i = 0; i < points.length; i++) {
			xCenter += points[i].getX();
			yCenter += points[i].getY();
		}
		xCenter /= points.length;  // x점의 중앙
		yCenter /= points.length;  // y점의 중앙
		Point centerPoint = new Point(xCenter, yCenter);  // 중점 Point 객체
		
		// 중점을 한 꼭짓점으로 하고 연속한 두 개의 꼭짓점으로 하는 각각의 삼각형 객체 생성 (피자모양 처럼)
		Triangle[] triangles = new Triangle[points.length];
		for (int i = 0; i < points.length - 1; i++) 
			triangles[i] = new Triangle(centerPoint, points[i], points[i+1]);
		triangles[points.length-1] = new Triangle(centerPoint, points[points.length-1], points[0]);  // 마지막 배열은 0과 함께 이어줌
		
		this.points = points;
		this.triangles = triangles;
	}
	
	// 다각형의 점들로부터 삼각형 배열 생성하는 static Triangle[] findTriangles(Point[] points) 정적메소드 (현재 다각형을 여러 개의 삼각형으로 나눠줌)
	static Triangle[] findTriangles(Point[] points) {
		
		// x,y값들의 중앙값을 이용해 중점 구하기
		double xCenter = 0, yCenter = 0;
		for (int i = 0; i < points.length; i++) {
			xCenter += points[i].getX();
			yCenter += points[i].getY();
		}
		xCenter /= points.length;  // x점의 중앙
		yCenter /= points.length;  // y점의 중앙
		Point centerPoint = new Point(xCenter, yCenter);  // 중점 Point 객체
		
		// 중점을 한 꼭짓점으로 하고 연속한 두 개의 꼭짓점으로 하는 각각의 삼각형 객체 생성 (피자모양 처럼)
		Triangle[] triangles = new Triangle[points.length];
		for (int i = 0; i < points.length - 1; i++) 
			triangles[i] = new Triangle(centerPoint, points[i], points[i+1]);
		triangles[points.length] = new Triangle(centerPoint, points[points.length], points[0]);  // 마지막 배열은 0과 함께 이어줌
				
		return triangles;		
	}

	// getter
	public Point[] getPoints() {
		return points;
	}
	public Triangle[] getTriangles() {
		return triangles;
	}
	public PolygonType getPolygonType() {
    	return PolygonType.valueOf(points.length);
	}
	public Bound getBound() {
		return Bound.findBound(points);
	}
	// 삼각형 배열로부터 각 삼각형 영역의 합으로 다각형 영역을 계산하는 메소드
	public double getArea() {
		double sumArea = 0;  // 각 삼각형 area의 합을 저장할 변수
		for (int i = 0; i < points.length; i++) 
			sumArea += triangles[i].getArea();
		
		return sumArea;
	}

	@Override
	public String toString() {
		String s = getPolygonType().toString() + " PolygonCalculator [points=" + Arrays.toString(points) + ", triangles=" + Arrays.toString(triangles)+ "]\n";  // points, triangles 출력
			for (int j = 0; j < points.length; j++) {  // 각 꼭짓점의 값 출력
				s += (points[j].toString() + "\n");
			}
			s+= "Polygon's Area=" + getArea();  // 다각형의 넓이 출력
		
    	return s; 
	}
	
	
	
}
