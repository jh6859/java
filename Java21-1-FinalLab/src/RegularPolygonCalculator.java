// 1�й�, 2021-06-10, 32181046 ������

// ���ٰ��� ��� Ŭ����
public class RegularPolygonCalculator {
	private int degree = 5;  // ���� ��
	private double radius;  // ������
	private Point center;  // ����
	private double angle;  // ����
	private Point[] points;  // ������
   
	// degree ���� �־����� �� �������� 1, ������ ������ 0,0���� �����ϴ� ������ 
	public RegularPolygonCalculator(int degree) {
		this(degree, 1.0, Point.getZero());
	}
    
	// degree ����, �������� ���� �־����� �� ������ ������ 0,0���� �����ϴ� ������. 
    public RegularPolygonCalculator(int degree, double radius) {
        this(degree, radius, Point.getZero());
    }
    
    // degree, ������, ������ ���� �־����� ���� ������
    public RegularPolygonCalculator(int degree, double radius, Point center) {
        this.degree = Math.max(3, Math.min(8, degree));  // degree�� ���� 3���� 8 ������ ������ ������.
        this.radius = radius;
        this.center = center;       
    	this.angle = 2 * Math.PI / degree;  // angle�� 2*PI/degree ���� ����
        this.points = createPoints();  // �� �������� points�� ����
    }
    
    // �� �������� Point�� ��ȯ�ϴ� �޼ҵ�
    private Point[] createPoints() {
        Point[] points = new Point[degree];  // ���� ����ŭ points�迭 ũ�� ����

        // �ٰ����� ������ ����ŭ �ݺ��Ͽ� �������� ��ǥ���� �����Ѵ�.
        double radian = Math.PI / 2.0; // -90
        for (int i = 0; i < degree; i++) {  // ���� ����ŭ �ݺ�
        	points[i] = getPoint(radian, radius, center);  // point �迭�� ������ �������� �� ����
        	radian += angle;
        }
        return points;
    }
    
    // radian ����, radius, offset�� Point�� �־��������� �� �������� ��ȯ�ϴ� �޼ҵ�
    private static Point getPoint(double radian, double radius, Point offset) {
        return new Point(radius * Math.cos(radian) + offset.getX(), radius * Math.sin(radian) + offset.getY());
    }
    
    // ���� ���� ���� PolygonType �������� ��ȯ�ϴ� �޼ҵ�
    public PolygonType getPolygonType() {
    	return PolygonType.valueOf(degree);
    }
    
    // points �迭�� ��ȯ�ϴ� getter
    public Point[] getPoints() {
    	return points;
    }
    
    // Bound.findBound �޼ҵ带 �̿��� Bound ���� ��ȯ�ϴ� �޼ҵ�
    public Bound getBound() {
    	return Bound.findBound(points);
    }

    // ������, ���� ��, ������ ������ �̿��� ���̸� ��ȯ�ϴ� Ŭ�����̴�
    public double getArea() {
        return radius * radius * degree * Math.sin(angle) / 2.0;
    }
    
    //toString �޼ҵ�
    @Override
    public String toString() { 
    	String s = getPolygonType().toString() + " [radius=" + radius + ", center=" + center.toString() + "]\n";  // PolygonType��, ������, ���� ���
        for (int i = 0; i < degree; i++) {  // �� �������� �� ���
        	s += (points[i].toString() + "\n");
        }
    	return s; 
    }
}
