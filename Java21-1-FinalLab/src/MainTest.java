// 1�й�, 2021-06-10, 32181046 ������

import java.util.Arrays;
import java.util.List;
import java.util.Map;

// MainTest class - java21-1 final
public class MainTest {
	private static Point[][] polygons = {
		{new Point(1, 0), new Point(0, 3), new Point(-4, 0)},
		{new Point(2, 0), new Point(0, 2), new Point(0, 0)},
		{new Point(1, 0), new Point(-1, 4), new Point(0, 3), new Point(-4, 0)},
		{new Point(2, 2), new Point(-2, 2), new Point(-2, -2), new Point(2, -2)},
		{new Point(2, 0), new Point(0, 2), new Point(-2, 0), new Point(0, -2)},
		{new Point(2, 0), new Point(2, 2), new Point(0, 4), new Point(-2, 2), new Point(-2, 0)},
		{new Point(0, 4), new Point(-2, 2), new Point(-2, -2), new Point(0, -4), new Point(2, -2), new Point(2, 2)},
		{new Point(4, 0), new Point(2, 2), new Point(-2, 2), new Point(-4, 0), new Point(-2, -2), new Point(2, -2)},
		{new Point(5, 0), new Point(0, 5), new Point(-5, 0), new Point(-4, -2), new Point(-2, -4), new Point(2, -4), new Point(4, -2)},
		{new Point(5, 0), new Point(2.5, 2.5), new Point(0, 5), new Point(-2.5, 2.5), new Point(-5, 0), new Point(-2.5, -2.5), new Point(0, -5), new Point(2.5, -2.5)}
	};

	
	public static void calculate(int degree, double radius, Point center) {
		// ���ٰ��� ��� �� Ÿ��, Bound, Area ���
		RegularPolygonCalculator poly = new RegularPolygonCalculator(degree, radius, center);
		System.out.println(poly);
		System.out.println(poly.getPolygonType());
		System.out.println(poly.getBound());
		System.out.println(poly.getArea());
		System.out.println("\n\n");
		
		// �������� ���ٰ����� �������� �̿��Ͽ� �Ȱ��� ����� �� ���
		PolygonCalculator poly2 = new PolygonCalculator(poly.getPoints());
		System.out.println(poly2);
		System.out.println(poly2.getPolygonType());
		System.out.println(poly2.getArea());
		System.out.println(poly2.getBound());

		// ���ٰ����� �������� �̿��� ������ ���� �� type, bound, area, perimeter, sides, angles �� ���
		Polygon poly3 = PolygonFactory.getInstance(poly.getPoints());
		poly3.setPoints(poly.getPoints());
		System.out.println(poly3);
		System.out.println(poly3.getType());
		System.out.println(poly3.getBound());
		System.out.println("area=" + poly3.getArea());
		System.out.println("perimeter=" + poly3.getPerimeter());
		System.out.println("sides=" + Arrays.toString(poly3.getSides()));
		System.out.println("angles=" + Arrays.toString(poly3.getAngles()));
		if (poly3.isRegular()) System.out.println("REGULAR " + poly3.getType());
	}
		
	public static void main(String[] args) {
		// 1. PolygonMath Ŭ���� �׽�Ʈ  -- �ﰢ�� polygons[1]���� �׽�Ʈ�غ���.
		Point[] testPoint = polygons[1];
		// area() �׽�Ʈ
		System.out.println("area() �׽�Ʈ ----");
		System.out.println(PolygonMath.area(testPoint[0].getDistance(testPoint[1]), testPoint[1].getDistance(testPoint[2]), testPoint[2].getDistance(testPoint[0])));
		// findSides �׽�Ʈ  -- polygons[3]���� �׽�Ʈ
		System.out.println("findSides() �׽�Ʈ ----");
		for (int i = 0; i < PolygonMath.findSides(polygons[3]).length; i++) {
			System.out.println(PolygonMath.findSides(polygons[3])[i]);
		}
		// findDiagonals �׽�Ʈ  -- polygons[3]���� �׽�Ʈ
		System.out.println("findDiagonals() �׽�Ʈ ----");
		for (int i = 0; i < PolygonMath.findDiagonals(polygons[3]).length; i++) {
			System.out.println(PolygonMath.findDiagonals(polygons[3])[i]);
		}
		// findAngles �׽�Ʈ
		System.out.println("findAngles() �׽�Ʈ ----");
		for (int i = 0; i < PolygonMath.findAngles(polygons[3]).length; i++) {
			System.out.println(PolygonMath.findAngles(polygons[3])[i]);
		}
		
		// polygons�� �̿��� �÷��� �׽�Ʈ
		System.out.println("\npolygons data test\n");
		PolygonListManager listManager = new PolygonListManager();  // List
		PolygonMapManager mapManager = new PolygonMapManager();  // Map
		for (Point[] points : polygons) {  		// ��� polygons�� ����� �� �÷��� list�� Map�� �߰�.
			System.out.println(Arrays.toString(points));
			Polygon polygon = PolygonFactory.getInstance(points);
			polygon.setPoints(points);
			System.out.println("polygon: " + polygon);
			listManager.add(polygon);
			mapManager.add(polygon);
			System.out.println("\n\n");
		}
		
		// list ���
		System.out.println("\nlistManager print..");		
		listManager.print();
		List<Polygon> resultList = listManager.select(e -> e.isRegular());  // ���ٽ��� �̿��� ���ٰ����� resultList�� �߰� �� ���
		System.out.println("\nRegular Polygon resultList print..");		
		resultList.forEach(System.out::println);
		
		// Map ���
		System.out.println("\nmapManager print..");		
		mapManager.print();
		Map<PolygonType, Polygon> resultMap = mapManager.select(e -> e.isRegular());  // ���ٽ��� �̿��� ���ٰ����� resultMap�� �߰� �� ���
		System.out.println("\nresultMap print..");		
		resultMap.forEach((k, v) -> System.out.println("Key : " + k + ", Value : " + v));

		// ����ڿ� ���� X, Y �� �Է¹��� �� ���
		System.out.println("\nUser Input Polygon\n");
		do {
			PolygonType type = UserInput.getUserPolygonType();
			Polygon polygon = PolygonFactory.getInstance(type); 
			polygon.getUserInput();
			polygon.setPoints(polygon.getPoints());  // getPoint() �޼ҵ带 ���� ������ �� ��� �� ����
			System.out.println(polygon);
		} while (!UserInput.getExitKey());
		System.out.println("\n\n");
		
		
		// ������� �Է����� ���ٰ����� ���Ǽ�, ������, ���� �Է¹޾� ���
		System.out.println("\nregular polygon test\n");		
		do {
			System.out.print("Please enter the Polygon numberOfSides: ");
			int degree = UserInput.getIntegerBetween(3, 8);
			System.out.print("Please enter the Polygon radius: ");
			double radius = UserInput.getDouble();
			Point center = new Point();
			System.out.print("Please enter the Polygon center.x: ");
			center.setX(UserInput.getDouble());
			System.out.print("Please enter the Polygon center.y: ");
			center.setY(UserInput.getDouble());	        
			calculate(degree, radius, center);
		} while (!UserInput.getExitKey());
				
		// your polygon-related class test code...
		// �� Polygon�� �̿��� �� ���� ���ϴ� Ŭ����  -- polygons[1]�� polygons[5]�� �̿��Ͽ� Test
		System.out.println("My Code ����");
		Polygon poly1 = PolygonFactory.getInstance(polygons[1]);
		Polygon poly2 = PolygonFactory.getInstance(polygons[5]);
		poly1.setPoints(poly1.getPoints());
		poly2.setPoints(poly2.getPoints());
		System.out.println(PolygonCompare.comparePoints(poly1, poly2));  // �� Polygon �� �� �������� ���� ���� ���
		System.out.println(PolygonCompare.compareSides(poly1, poly2));  // �� Polygon �� �� ���� ���� ���� ���
		System.out.println(PolygonCompare.compareAngles(poly1, poly2));  // �� Polygon �� �� ���� ���� ���� ���
		
		System.out.println("\n\nExit the program.");

	}
}
