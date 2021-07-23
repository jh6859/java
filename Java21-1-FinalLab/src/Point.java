// 1�й�, 2021-06-10, 32181046 ������

// Point Ŭ������ �ʵ� �� ����.
public class Point {
	private double x;  // x��
	private double y;  // y��
	private static int count = 0;  // x,y�� ���� ������ �� ���� 1 ������Ű�� ���� int�� �ʵ� count
	private static final Point Zero = new Point(0.0, 0.0);  // x�� y�� ���� ��� 0�� ��ü ����
	private static final Point One = new Point(1.0, 1.0);  // x�� y�� ���� ��� 1.0�� ��ü ����

	//������ �����ε�
	//�ƹ� ���� �Է¹��� �ʾ��� �� x�� y�� ���� ��� 0���� �ϴ� ������.
	public Point() { 
		this(0.0, 0.0);
	}
	// x�� y�� ���� �Է¹޾� ���� x�� y�� ���� �� count�� ���� 1 ������Ű�� ������.
	public Point(double x, double y) { 
		set(x, y); 
		count++; 
	}
    // x, y�� ���� ���� �迭�� �Է¹޾� ���� �� count�� ���� 1 ������Ű�� ������.
	public Point(double[] xy) { 
		set(xy); 
		count++; 
	}
	// x,y ���� �ٸ� Point ��ü�� ���� �����ϴ� ������.
	public Point(Point other) { 
		set(other);
		count++; 
	}
	// x�� ���� ��ȯ�ϴ� getter
	public double getX() {
		return x;
	}
	// x�� ���� �����ϴ� setter
	public void setX(double x) {
		this.x = x;
	}
	// y�� ���� ��ȯ�ϴ� getter
	public double getY() {
		return y;
	}
	// y�� ���� �����ϴ� setter
	public void setY(double y) {
		this.y = y;
	}
	// Zero ��ü�� ��ȯ�ϴ� getter
	public static Point getZero() {
		return Zero;
	}
	// One ��ü�� ��ȯ�ϴ� getter
	public static Point getOne() {
		return One;
	}
	// count ���� ��ȯ�ϴ� getter
	public static int getCount() {
    	return count; 
	}
	// count���� �����ϴ� setter
	public static void setCount(int count) {
		Point.count = count;
	}

	// ���� ����� x, y ���� ���� Point Ŭ������ ��ü p�� ��ȯ�ϴ� �޼ҵ�
	public Point clone() {
		Point p = new Point(this.x, this.y);  // Point ��ü p�� �����Ͽ� ���� ����� �ʵ尪�� x,y ���� ����
		System.out.println("Point clone(): " + p.toString());
		return p;
	}

	// x,y�� ���� �迭�� ��ȯ�ϴ� �޼ҵ�
	public double[] get() {
		double[] xy = new double[2];
		xy[0] = this.x;
		xy[1] = this.y;
		//System.out.println("get(): " + "(" + xy[0] + ", " + xy[1] + ")");
		return xy;
	}

	// xy �迭�� ũ�Ⱑ 2�� ���(x,y�� ������ �Է¹޾��� ��) x�� xy[0]�� �� ����, y�� xy[1]�� �� �����ϴ� �޼ҵ�
	public void set(double[] xy) {
		if (xy.length == 2) {
			this.x = xy[0];
			this.y = xy[1];
			//System.out.println("set(xy[]): " + this);    		
		}
	}
	
	// x,y�� ���� �����ϴ� �޼ҵ�
	public void set(double x, double y) { 
		this.x = x; 
		this.y = y; 
		//System.out.println("Point::set(x,y): " + this);
	}

	// x,y�� ���� ���� 1.0f, 2.0f���� �����ϴ� �޼ҵ�
	public void set() {
		this.x = 1.0f;
		this.y = 2.0f;
		//System.out.println("Point::set(): " + this);
	}
    
	// x,y�� ���� �ٸ� Point ��ü�� ������ �����ϴ� �޼ҵ�
	public void set(Point other) {
		this.x = other.x;
		this.y = other.y;
		//System.out.println("Point::set(Point): " + this);
	}

	// x,y�� ���� ��� �Է¹��� double�� ������ �����ϴ� �޼ҵ�
	public Point set(double d) {
		Point point = new Point(d, d);
		//System.out.println("Point::set(i): " + point.toString());
		return point;
	}

	// x,y�� ���� ���� �Ű������� ���� ����ŭ ������Ű�� �޼ҵ�
	public void move(double x, double y) { 
		this.x += x; 
		this.y += y; 
	}

	// x,y�� ���� ���� �Ű������� ���� �ٸ� Point ��ü�� x,y ����ŭ ������Ű�� �޼ҵ�
	public void move(Point other) { 
		this.x += other.x; 
		this.y += other.y; 
	}
 
	// �� Point ��ü�� x,y���� �̿��� �� ���� �Ÿ��� ���� ��ȯ�ϴ� �޼ҵ�
	public static double getDistance(Point p, Point q) { 
		return Math.sqrt((p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y));  // Math Ŭ������ sqrt �޼ҵ带 ���� �������� �̿��Ѵ�.
	}
	
	// ���� ��ü�� x,y ���� �ٸ� �Է¹��� ��ü�� �̿��� �� ���� �Ÿ��� ���� ��ȯ�ϴ� �޼ҵ� 
	public double getDistance(Point other) { 
		return getDistance(this, other); 
	}

	// ������������ ���� ��ü������ �Ÿ��� �Ը� ���Ͽ� ��ȯ�ϴ� �޼ҵ�
	public double getMagnitude() {
		return getDistance(this, Zero);
	}

	// 2. �� ��ü�� �Է¹޾� ������ x,y���� �ٲٴ� swap �޼ҵ�
	public static void swap(Point p, Point q) { 
		Point temp = new Point(p);
		p.set(q);
		q.set(temp);
	}
	
	// 2. �� ��ü�� �Է¹޾� ������ x,y���� �ٲٴ� swap �޼ҵ�
	public static void mySwap(Point p, Point q) { 
		// �� ����Ʈ�� x,y���� ������ ������ ����
		double firstX = p.getX();
		double firstY = p.getY();
		double secondX = q.getX();
		double secondY = q.getY();
		
		// ���� �ݴ�� swap�Ͽ� set�Ѵ�.
		p.setX(secondX);
		p.setY(secondY);
		q.setX(firstX);
		q.setY(firstY);				
	}

	// toString �޼ҵ�
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}
