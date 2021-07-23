// 1�й�, 2021-06-10, 32181046 ������

import java.util.Arrays;

// ������ �ٰ��� Ŭ������ Point[] points�� Triangle[] triangles ����ʵ�
public class PolygonCalculator {
	private Point[] points;
	private Triangle[] triangles;
	
	// �ٰ����� ���� points���� �ﰢ�� �迭 triangles�� �����ϴ� ������ 
	public PolygonCalculator(Point[] points) {
		
		// x,y������ �߾Ӱ��� �̿��� ���� ���ϱ�
		double xCenter = 0, yCenter = 0;
		for (int i = 0; i < points.length; i++) {
			xCenter += points[i].getX();
			yCenter += points[i].getY();
		}
		xCenter /= points.length;  // x���� �߾�
		yCenter /= points.length;  // y���� �߾�
		Point centerPoint = new Point(xCenter, yCenter);  // ���� Point ��ü
		
		// ������ �� ���������� �ϰ� ������ �� ���� ���������� �ϴ� ������ �ﰢ�� ��ü ���� (���ڸ�� ó��)
		Triangle[] triangles = new Triangle[points.length];
		for (int i = 0; i < points.length - 1; i++) 
			triangles[i] = new Triangle(centerPoint, points[i], points[i+1]);
		triangles[points.length-1] = new Triangle(centerPoint, points[points.length-1], points[0]);  // ������ �迭�� 0�� �Բ� �̾���
		
		this.points = points;
		this.triangles = triangles;
	}
	
	// �ٰ����� ����κ��� �ﰢ�� �迭 �����ϴ� static Triangle[] findTriangles(Point[] points) �����޼ҵ� (���� �ٰ����� ���� ���� �ﰢ������ ������)
	static Triangle[] findTriangles(Point[] points) {
		
		// x,y������ �߾Ӱ��� �̿��� ���� ���ϱ�
		double xCenter = 0, yCenter = 0;
		for (int i = 0; i < points.length; i++) {
			xCenter += points[i].getX();
			yCenter += points[i].getY();
		}
		xCenter /= points.length;  // x���� �߾�
		yCenter /= points.length;  // y���� �߾�
		Point centerPoint = new Point(xCenter, yCenter);  // ���� Point ��ü
		
		// ������ �� ���������� �ϰ� ������ �� ���� ���������� �ϴ� ������ �ﰢ�� ��ü ���� (���ڸ�� ó��)
		Triangle[] triangles = new Triangle[points.length];
		for (int i = 0; i < points.length - 1; i++) 
			triangles[i] = new Triangle(centerPoint, points[i], points[i+1]);
		triangles[points.length] = new Triangle(centerPoint, points[points.length], points[0]);  // ������ �迭�� 0�� �Բ� �̾���
				
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
	// �ﰢ�� �迭�κ��� �� �ﰢ�� ������ ������ �ٰ��� ������ ����ϴ� �޼ҵ�
	public double getArea() {
		double sumArea = 0;  // �� �ﰢ�� area�� ���� ������ ����
		for (int i = 0; i < points.length; i++) 
			sumArea += triangles[i].getArea();
		
		return sumArea;
	}

	@Override
	public String toString() {
		String s = getPolygonType().toString() + " PolygonCalculator [points=" + Arrays.toString(points) + ", triangles=" + Arrays.toString(triangles)+ "]\n";  // points, triangles ���
			for (int j = 0; j < points.length; j++) {  // �� �������� �� ���
				s += (points[j].toString() + "\n");
			}
			s+= "Polygon's Area=" + getArea();  // �ٰ����� ���� ���
		
    	return s; 
	}
	
	
	
}
