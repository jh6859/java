// 1�й�, 2021-06-10, 32181046 ������

import java.util.Arrays;

// Polygon �߻�Ŭ������ ��ӹ��� ������ Ŭ����
public class Pentagon extends Polygon{

	// 4.1 ������
	public Pentagon(Point[] points) {
		super();
		this.points = points;
	}
	public Pentagon() {
		Point[] pt = {new Point(), new Point(), new Point(), new Point(), new Point()};
		this.points = pt;
	}
	
	// 4.2 �ٰ����� ���̸� �ﰢ������ ������ �ﰢ���� ������ ����ϴ� �޼ҵ��̴�.
	@Override
	public double getArea() {
		int triangleCount = points.length - 2;  // �ﰢ���� ���� : ������-2��
		double[] sides = PolygonMath.findSides(points);  // �ش� �ٰ����� �𼭸� �迭
		double[] diagonals = PolygonMath.findDiagonals(points);  // �ش� �ٰ����� �밢�� �迭
		double area = 0;  // ���̸� ���ؼ� ���� ����
		for (int i = 0, j = 0; i < triangleCount; i += 2, j++) {
			double[] newSides = {sides[i], sides[i+1], diagonals[j]};  // ���ο� �ﰢ���� �𼭸�
			area += PolygonMath.area(newSides[0], newSides[1], newSides[2]);  // ���ο� �ﰢ���� �𼭸��� ���� ��� �� area�� ���� ����
		}
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
		return "Pentagon [points=" + Arrays.toString(points) + ", sides=" + Arrays.toString(sides) + ", diagonals="
				+ Arrays.toString(diagonals) + ", angles=" + Arrays.toString(angles) + ", bound=" + bound + ", type="
				+ type + "]";
	}
}
