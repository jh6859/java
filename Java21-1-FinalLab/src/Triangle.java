// 1�й�, 2021-06-10, 32181046 ������

import java.util.Arrays;

public class Triangle extends Polygon{

	// 4.1 ������
	public Triangle(Point[] points) {
		super();
		this.points = points;
	}
	public Triangle() {
		Point[] pt = {new Point(), new Point(), new Point()};
		this.points = pt;
	}

	// 8. PolygonCalculator���� �̿��� ���� ������ �� �������� �Է¹޴� ������.
	public Triangle(Point centerPoint, Point point, Point point2) {
		Point[] pt = {centerPoint, point, point2};
		this.points = pt;
	}
	// 4.2 �ٰ����� ���̸� �ﰢ������ ������ �ﰢ���� ������ ����ϴ� �޼ҵ��̴�.
	@Override
	public double getArea() {
		double[] sides = PolygonMath.findSides(points);  // �ش� �ٰ����� �𼭸� �迭
		double area = PolygonMath.area(sides[0], sides[1], sides[2]);
		return area;
	}

	// 4.3 �ٰ����� �ѷ��� ���� ��ȯ�ϴ� �޼ҵ��̴�.
	@Override
	public double getPerimeter() {
		double[] sides = PolygonMath.findSides(points);  // �ٰ����� �𼭸� �迭
		double perimeter = 0;  // �ѷ�
		for (int i = 0; i < points.length; i++) {  // ��� �𼭸��� ���� perimeter�� ����
			perimeter += sides[i];
		}
		return perimeter;
	}

	// 4.5 �ٰ����� ���ٰ����̸� true�� ��ȯ�ϰ� �ƴϸ� false�� ��ȯ�ϴ� �˻� �޼ҵ��̴�. ��� �𼭸��� ���̿�, ��� ������ ũ�Ⱑ ������ ���ٰ����� ���� �̿��Ѵ�.
	@Override
	public boolean isRegular() {
		double[] angles = PolygonMath.findAngles(points);  // ����
		double[] sides = PolygonMath.findSides(points);  // �𼭸�
		double fAngle = angles[0];  // 0��° �ε����� ����
		double fSide = sides[0];  // 0��° �ε����� �𼭸� ����
		for (int i = 1; i < points.length; i++) {
			if (angles[i] != fAngle || sides[i] != fSide) return false;  // 0��° �ε����� ������ �𼭸��� ���� �ٸ����� ������ ���ٸ�ü�� �ƴϹǷ� false ��ȯ
		}
		return true;  // �ٸ����� ������ �ʴ´ٸ� true ��ȯ
	}

	// 4.4 ������� �Է��� �޾� points�� X, Y ���� �����ϴ� �޼ҵ��̴�.
	@Override
	public void getUserInput() {
		Point[] userPoints = new Point[points.length];
		for (int i = 0; i < userPoints.length; i++) {
			System.out.println(i + "��° X��: ");
			this.points[i].setX(UserInput.getDouble());  // i��° X���� ����
			System.out.println(i + "��° Y��: ");
			this.points[i].setY(UserInput.getDouble());  // i��° Y���� ����
		}
		
	}

	// 4.6 toString �޼ҵ�
	@Override
	public String toString() {
		return "Triangle [points=" + Arrays.toString(points) + ", sides=" + Arrays.toString(sides) + ", diagonals="
				+ Arrays.toString(diagonals) + ", angles=" + Arrays.toString(angles) + ", bound=" + bound + ", type="
				+ type + "]";
	}
	
}
