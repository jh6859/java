// 1분반, 2021-06-10, 32181046 김준하

public abstract class Polygon implements IPolygonCalculator{  // IPolygonCalculator인터페이스를 상속받는 추상클래스 Polygon
	Point[] points;  // 꼭짓점
	double[] sides;  // 모서리
	double[] diagonals;  // 대각선
	double[] angles;  // 각도
	Bound bound; 
	PolygonType type;  // 타입
	
	// getter
	public Point[] getPoints() {
		return points;
	}
	public double[] getSides() {
		return sides;
	}
	public double[] getDiagonals() {
		return diagonals;
	}
	public double[] getAngles() {
		return angles;
	}
	public Bound getBound() {
		return bound;
	}
	public PolygonType getType() {
		return type;
	}

	// points를 이용해 각각의 sides, diagonals, angles, bound, type 값 지정하는 메소드
	public void setPoints(Point[] points) {
		this.sides = PolygonMath.findSides(points);
		this.diagonals = PolygonMath.findDiagonals(points);
		this.angles = PolygonMath.findAngles(points);
		this.bound = Bound.findBound(points);
		this.type = PolygonType.valueOf(points.length);
	}
}
