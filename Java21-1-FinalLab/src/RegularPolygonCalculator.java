// 1분반, 2021-06-10, 32181046 김준하

// 정다각형 계산 클래스
public class RegularPolygonCalculator {
	private int degree = 5;  // 각의 수
	private double radius;  // 반지름
	private Point center;  // 원점
	private double angle;  // 각도
	private Point[] points;  // 꼭짓점
   
	// degree 값만 주어졌을 때 반지름은 1, 도형의 원점을 0,0으로 지정하는 생성자 
	public RegularPolygonCalculator(int degree) {
		this(degree, 1.0, Point.getZero());
	}
    
	// degree 값과, 반지름의 값이 주어졌을 때 도형의 원점을 0,0으로 지정하는 생성자. 
    public RegularPolygonCalculator(int degree, double radius) {
        this(degree, radius, Point.getZero());
    }
    
    // degree, 반지름, 원점의 값이 주어졌을 때의 생성자
    public RegularPolygonCalculator(int degree, double radius, Point center) {
        this.degree = Math.max(3, Math.min(8, degree));  // degree의 값은 3에서 8 사이의 값만을 가진다.
        this.radius = radius;
        this.center = center;       
    	this.angle = 2 * Math.PI / degree;  // angle은 2*PI/degree 값을 저장
        this.points = createPoints();  // 각 꼭짓점을 points에 저장
    }
    
    // 각 꼭짓점의 Point를 반환하는 메소드
    private Point[] createPoints() {
        Point[] points = new Point[degree];  // 각의 수만큼 points배열 크기 지정

        // 다각형의 꼭짓점 수만큼 반복하여 꼭짓점의 좌표값을 지정한다.
        double radian = Math.PI / 2.0; // -90
        for (int i = 0; i < degree; i++) {  // 각의 수만큼 반복
        	points[i] = getPoint(radian, radius, center);  // point 배열에 각각의 꼭짓점의 값 대입
        	radian += angle;
        }
        return points;
    }
    
    // radian 값과, radius, offset의 Point가 주어졌을때의 한 꼭짓점을 반환하는 메소드
    private static Point getPoint(double radian, double radius, Point offset) {
        return new Point(radius * Math.cos(radian) + offset.getX(), radius * Math.sin(radian) + offset.getY());
    }
    
    // 각의 수에 따라 PolygonType 열거형을 반환하는 메소드
    public PolygonType getPolygonType() {
    	return PolygonType.valueOf(degree);
    }
    
    // points 배열을 반환하는 getter
    public Point[] getPoints() {
    	return points;
    }
    
    // Bound.findBound 메소드를 이용해 Bound 값을 반환하는 메소드
    public Bound getBound() {
    	return Bound.findBound(points);
    }

    // 반지름, 각의 수, 각도를 공식을 이용해 넓이를 반환하는 클래스이다
    public double getArea() {
        return radius * radius * degree * Math.sin(angle) / 2.0;
    }
    
    //toString 메소드
    @Override
    public String toString() { 
    	String s = getPolygonType().toString() + " [radius=" + radius + ", center=" + center.toString() + "]\n";  // PolygonType과, 반지름, 원점 출력
        for (int i = 0; i < degree; i++) {  // 각 꼭짓점의 값 출력
        	s += (points[i].toString() + "\n");
        }
    	return s; 
    }
}
