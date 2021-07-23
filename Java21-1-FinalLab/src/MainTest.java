// 1분반, 2021-06-10, 32181046 김준하

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
		// 정다각형 계산 후 타입, Bound, Area 출력
		RegularPolygonCalculator poly = new RegularPolygonCalculator(degree, radius, center);
		System.out.println(poly);
		System.out.println(poly.getPolygonType());
		System.out.println(poly.getBound());
		System.out.println(poly.getArea());
		System.out.println("\n\n");
		
		// 위에서의 정다각형의 꼭짓점을 이용하여 똑같이 계산한 뒤 출력
		PolygonCalculator poly2 = new PolygonCalculator(poly.getPoints());
		System.out.println(poly2);
		System.out.println(poly2.getPolygonType());
		System.out.println(poly2.getArea());
		System.out.println(poly2.getBound());

		// 정다각형의 꼭짓점을 이용해 꼭짓점 지정 후 type, bound, area, perimeter, sides, angles 값 출력
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
		// 1. PolygonMath 클래스 테스트  -- 삼각형 polygons[1]으로 테스트해본다.
		Point[] testPoint = polygons[1];
		// area() 테스트
		System.out.println("area() 테스트 ----");
		System.out.println(PolygonMath.area(testPoint[0].getDistance(testPoint[1]), testPoint[1].getDistance(testPoint[2]), testPoint[2].getDistance(testPoint[0])));
		// findSides 테스트  -- polygons[3]으로 테스트
		System.out.println("findSides() 테스트 ----");
		for (int i = 0; i < PolygonMath.findSides(polygons[3]).length; i++) {
			System.out.println(PolygonMath.findSides(polygons[3])[i]);
		}
		// findDiagonals 테스트  -- polygons[3]으로 테스트
		System.out.println("findDiagonals() 테스트 ----");
		for (int i = 0; i < PolygonMath.findDiagonals(polygons[3]).length; i++) {
			System.out.println(PolygonMath.findDiagonals(polygons[3])[i]);
		}
		// findAngles 테스트
		System.out.println("findAngles() 테스트 ----");
		for (int i = 0; i < PolygonMath.findAngles(polygons[3]).length; i++) {
			System.out.println(PolygonMath.findAngles(polygons[3])[i]);
		}
		
		// polygons를 이용한 컬렉션 테스트
		System.out.println("\npolygons data test\n");
		PolygonListManager listManager = new PolygonListManager();  // List
		PolygonMapManager mapManager = new PolygonMapManager();  // Map
		for (Point[] points : polygons) {  		// 모든 polygons를 출력한 뒤 컬렉션 list와 Map에 추가.
			System.out.println(Arrays.toString(points));
			Polygon polygon = PolygonFactory.getInstance(points);
			polygon.setPoints(points);
			System.out.println("polygon: " + polygon);
			listManager.add(polygon);
			mapManager.add(polygon);
			System.out.println("\n\n");
		}
		
		// list 출력
		System.out.println("\nlistManager print..");		
		listManager.print();
		List<Polygon> resultList = listManager.select(e -> e.isRegular());  // 람다식을 이용해 정다각형을 resultList에 추가 후 출력
		System.out.println("\nRegular Polygon resultList print..");		
		resultList.forEach(System.out::println);
		
		// Map 출력
		System.out.println("\nmapManager print..");		
		mapManager.print();
		Map<PolygonType, Polygon> resultMap = mapManager.select(e -> e.isRegular());  // 람다식을 이용해 정다각형을 resultMap에 추가 후 출력
		System.out.println("\nresultMap print..");		
		resultMap.forEach((k, v) -> System.out.println("Key : " + k + ", Value : " + v));

		// 사용자에 의해 X, Y 값 입력받은 뒤 계산
		System.out.println("\nUser Input Polygon\n");
		do {
			PolygonType type = UserInput.getUserPolygonType();
			Polygon polygon = PolygonFactory.getInstance(type); 
			polygon.getUserInput();
			polygon.setPoints(polygon.getPoints());  // getPoint() 메소드를 통해 각각의 값 계산 후 저장
			System.out.println(polygon);
		} while (!UserInput.getExitKey());
		System.out.println("\n\n");
		
		
		// 사용자의 입력으로 정다각형의 각의수, 반지름, 원점 입력받아 계산
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
		// 두 Polygon을 이용해 각 값을 비교하는 클래스  -- polygons[1]과 polygons[5]를 이용하여 Test
		System.out.println("My Code 실행");
		Polygon poly1 = PolygonFactory.getInstance(polygons[1]);
		Polygon poly2 = PolygonFactory.getInstance(polygons[5]);
		poly1.setPoints(poly1.getPoints());
		poly2.setPoints(poly2.getPoints());
		System.out.println(PolygonCompare.comparePoints(poly1, poly2));  // 두 Polygon 중 더 꼭짓점이 많은 것을 출력
		System.out.println(PolygonCompare.compareSides(poly1, poly2));  // 두 Polygon 중 더 면이 많은 것을 출력
		System.out.println(PolygonCompare.compareAngles(poly1, poly2));  // 두 Polygon 중 더 각이 많은 것을 출력
		
		System.out.println("\n\nExit the program.");

	}
}
