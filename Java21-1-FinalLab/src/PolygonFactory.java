// 1�й�, 2021-06-10, 32181046 ������

public class PolygonFactory {
	// 5.1 Point[]�� ���ڷ� �޾Ƽ� Polygon�� ��ȯ�ϴ� �޼ҵ�
	static Polygon getInstance(Point[] points) {
		switch (points.length) {
		case 1:
		case 2: {
			return null;
		}
		case 3:
			return new Triangle(points);
		case 4:
			return new Quadrilateral(points);
		case 5:
			return new Pentagon(points);
		case 6:
			return new Hexagon(points);
		case 7:
			return new Heptagon(points);
		case 8:
			return new Octagon(points);
		}
		return null;
	}
	
	// 5.2 PolygonType ���ڷ� �޾Ƽ� Polygon�� ��ȯ�ϴ� �޼ҵ� (�޼ҵ� �����ε�)
	static Polygon getInstance(PolygonType type) {
		switch (type) {
		case TRIANGLE:
			return new Triangle();
		case RECTANGLE:
			return new Quadrilateral();
		case PENTAGON:
			return new Pentagon();
		case HEXAGON:
			return new Hexagon();
		case HEPTAGON:
			return new Heptagon();
		case OCTAGON:
			return new Octagon();
		}
		return null;
	}
}
