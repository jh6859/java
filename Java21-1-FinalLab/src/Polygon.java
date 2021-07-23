// 1�й�, 2021-06-10, 32181046 ������

public abstract class Polygon implements IPolygonCalculator{  // IPolygonCalculator�������̽��� ��ӹ޴� �߻�Ŭ���� Polygon
	Point[] points;  // ������
	double[] sides;  // �𼭸�
	double[] diagonals;  // �밢��
	double[] angles;  // ����
	Bound bound; 
	PolygonType type;  // Ÿ��
	
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

	// points�� �̿��� ������ sides, diagonals, angles, bound, type �� �����ϴ� �޼ҵ�
	public void setPoints(Point[] points) {
		this.sides = PolygonMath.findSides(points);
		this.diagonals = PolygonMath.findDiagonals(points);
		this.angles = PolygonMath.findAngles(points);
		this.bound = Bound.findBound(points);
		this.type = PolygonType.valueOf(points.length);
	}
}
