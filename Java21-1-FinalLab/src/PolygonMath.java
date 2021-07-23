// 1�й�, 2021-06-10, 32181046 ������

public class PolygonMath {
	private PolygonMath() {}
	
	// �� ���� double�� ���̸� �޾Ƽ� double�� ���̷� ��ȯ�ϴ� ���� �޼ҵ�  (����� ���� �̿�)
	public static double area(double a, double b, double c) {
		double s = (a + b + c) /2.0;
		return Math.sqrt(s * (s-a) * (s-b) * (s-c));
	}

	// Point��ü �迭�� �޾� double���� �𼭸� ���� �迭 ��ȯ �޼ҵ�
	public static double[] findSides(Point[] points) {
		if (points == null) return null;  // points�� ������ null ��ȯ
		double[] sides = new double[points.length];  // points ���̿� ���� double�� sides �迭 ����
		for (int i = 0; i < points.length; i++) {  // points ���̸�ŭ �ݺ�
			int nextIndex = (i + 1) % points.length;
			sides[i] = Point.getDistance(points[i], points[nextIndex]);  // �ٷ� �� ���������� �Ÿ�(����)�� sides �迭�� ����
		}
		return sides;
	}

	// Point��ü �迭�� �޾� double���� ������ 0������ �� ������������ �밢�� ���� �迭 ��ȯ �޼ҵ�
	public static double[] findDiagonals(Point[] points) {
		if (points == null) return null;  // points�� ������ null ��ȯ
		if (points.length < 4) return null;  // �簢�� �̸��� �밢���� �����Ƿ� null ��ȯ
		double[] diagonals = new double[points.length - 3];  // �밢���� ������ (�������� ����) - 3 ��
		for (int i = 2; i < points.length - 1; i++) {  // ������0�� 2���� �����Ͽ� 0������ �밢�� ���̸� diagonals�� ����
			diagonals[i-2] = Point.getDistance(points[0], points[i]);
		}
		return diagonals;
	}

	// Points��ü �迭�� �޾� double���� ���� ũ�� �迭 ��ȯ �޼ҵ�
	public static double[] findAngles(Point[] points) {
		if (points == null) return null;  // points�� ������ null ��ȯ
		double[] angles = new double[points.length];  // points ���̿� ���� double�� angles �迭 ����
		for (int i = 0; i < points.length; i++) {  // ���̸�ŭ �ݺ�
			int prevIndex = i==0 ? (i + points.length - 1) : (i - 1);  // i�� 0�̸� i+pointsũ��-1(������ �迭 �ε���)�� prevIndex�� ����, �ƴϸ� i-1(���� �ε���)�� ����
			int nextIndex = (i + 1) % points.length;  // �ٷ� ���� �ε����� nextIndex�� ����
			angles[i] = innerAngle(points[prevIndex], points[i], points[nextIndex]);  // ���� �ε���, ������ �ε���, ���� �ε����� �̿��� ���� ũ�⸦ angles�� ����
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
		return Math.toDegrees(angrad);  // Math Ŭ������ toDegrees�� �̿��� ���� ���� ���������� ��ȯ�Ͽ� ��ȯ
	}

}
