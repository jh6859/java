// 1분반, 2021-06-10, 32181046 김준하

// Point 클래스의 필드 값 지정.
public class Point {
	private double x;  // x값
	private double y;  // y값
	private static int count = 0;  // x,y의 값을 저장할 떄 마다 1 증가시키기 위한 int형 필드 count
	private static final Point Zero = new Point(0.0, 0.0);  // x와 y의 값이 모두 0인 객체 생성
	private static final Point One = new Point(1.0, 1.0);  // x와 y의 값이 모두 1.0인 객체 생성

	//생성자 오버로딩
	//아무 값도 입력받지 않았을 때 x와 y의 값을 모두 0으로 하는 생성자.
	public Point() { 
		this(0.0, 0.0);
	}
	// x와 y의 값을 입력받아 각각 x와 y에 저장 후 count의 값을 1 증가시키는 생성자.
	public Point(double x, double y) { 
		set(x, y); 
		count++; 
	}
    // x, y의 값을 각각 배열로 입력받아 저장 후 count의 값을 1 증가시키는 생성자.
	public Point(double[] xy) { 
		set(xy); 
		count++; 
	}
	// x,y 값에 다른 Point 객체의 값을 저장하는 생성자.
	public Point(Point other) { 
		set(other);
		count++; 
	}
	// x의 값을 반환하는 getter
	public double getX() {
		return x;
	}
	// x의 값을 지정하는 setter
	public void setX(double x) {
		this.x = x;
	}
	// y의 값을 반환하는 getter
	public double getY() {
		return y;
	}
	// y의 값을 지정하는 setter
	public void setY(double y) {
		this.y = y;
	}
	// Zero 객체를 반환하는 getter
	public static Point getZero() {
		return Zero;
	}
	// One 객체를 반환하는 getter
	public static Point getOne() {
		return One;
	}
	// count 값을 반환하는 getter
	public static int getCount() {
    	return count; 
	}
	// count값을 지정하는 setter
	public static void setCount(int count) {
		Point.count = count;
	}

	// 현재 저장된 x, y 값과 같은 Point 클래스의 객체 p를 반환하는 메소드
	public Point clone() {
		Point p = new Point(this.x, this.y);  // Point 객체 p를 생성하여 현재 저장된 필드값의 x,y 값을 지정
		System.out.println("Point clone(): " + p.toString());
		return p;
	}

	// x,y의 값을 배열로 반환하는 메소드
	public double[] get() {
		double[] xy = new double[2];
		xy[0] = this.x;
		xy[1] = this.y;
		//System.out.println("get(): " + "(" + xy[0] + ", " + xy[1] + ")");
		return xy;
	}

	// xy 배열의 크기가 2인 경우(x,y의 값만을 입력받았을 때) x에 xy[0]의 값 저장, y에 xy[1]의 값 저장하는 메소드
	public void set(double[] xy) {
		if (xy.length == 2) {
			this.x = xy[0];
			this.y = xy[1];
			//System.out.println("set(xy[]): " + this);    		
		}
	}
	
	// x,y의 값을 지정하는 메소드
	public void set(double x, double y) { 
		this.x = x; 
		this.y = y; 
		//System.out.println("Point::set(x,y): " + this);
	}

	// x,y의 값을 각각 1.0f, 2.0f으로 지정하는 메소드
	public void set() {
		this.x = 1.0f;
		this.y = 2.0f;
		//System.out.println("Point::set(): " + this);
	}
    
	// x,y의 값을 다른 Point 객체의 값으로 저장하는 메소드
	public void set(Point other) {
		this.x = other.x;
		this.y = other.y;
		//System.out.println("Point::set(Point): " + this);
	}

	// x,y의 값을 모두 입력받은 double형 값으로 저장하는 메소드
	public Point set(double d) {
		Point point = new Point(d, d);
		//System.out.println("Point::set(i): " + point.toString());
		return point;
	}

	// x,y의 값을 각각 매개변수로 받은 값만큼 증가시키는 메소드
	public void move(double x, double y) { 
		this.x += x; 
		this.y += y; 
	}

	// x,y의 값을 각각 매개변수로 받은 다른 Point 객체의 x,y 값만큼 증가시키는 메소드
	public void move(Point other) { 
		this.x += other.x; 
		this.y += other.y; 
	}
 
	// 두 Point 객체의 x,y값을 이용해 두 점의 거리를 구해 반환하는 메소드
	public static double getDistance(Point p, Point q) { 
		return Math.sqrt((p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y));  // Math 클래스의 sqrt 메소드를 통해 제곱근을 이용한다.
	}
	
	// 현재 객체의 x,y 값과 다른 입력받은 객체를 이용해 두 점의 거리를 구해 반환하는 메소드 
	public double getDistance(Point other) { 
		return getDistance(this, other); 
	}

	// 원점에서부터 현재 객체까지의 거리인 규모를 구하여 반환하는 메소드
	public double getMagnitude() {
		return getDistance(this, Zero);
	}

	// 2. 두 객체를 입력받아 각각의 x,y값을 바꾸는 swap 메소드
	public static void swap(Point p, Point q) { 
		Point temp = new Point(p);
		p.set(q);
		q.set(temp);
	}
	
	// 2. 두 객체를 입력받아 각각의 x,y값을 바꾸는 swap 메소드
	public static void mySwap(Point p, Point q) { 
		// 각 포인트의 x,y값을 각각의 변수에 저장
		double firstX = p.getX();
		double firstY = p.getY();
		double secondX = q.getX();
		double secondY = q.getY();
		
		// 서로 반대로 swap하여 set한다.
		p.setX(secondX);
		p.setY(secondY);
		q.setX(firstX);
		q.setY(firstY);				
	}

	// toString 메소드
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}
