// 1분반, 2021-06-10, 32181046 김준하


// My Code  -- 두 Polygon을 비교하여 더 큰 값을 반환하고, 두 값의 차이를 출력한다.
public class PolygonCompare {
	
	
	// Point의 수(꼭짓점의 수)가 더 많은 것을 반환, 같으면 null 반환
	public static Polygon comparePoints(Polygon poly1, Polygon poly2) {
		int len1 = poly1.getPoints().length;
		int len2 = poly2.getPoints().length;
		if (len1 > len2) {
			System.out.println("왼쪽 polygon의 Point 크기가 " + (len1-len2) + "만큼 큽니다.");
			return poly1;
		}
		else if (len1 < len2) {
			System.out.println("오른쪽 polygon의 Point 크기가 " + (len2-len1) + "만큼 큽니다.");
			return poly1;
		}
		else {
			System.out.println("두 Polygon의 Point 크기가 같습니다.");
			return null;
		}
	}
	
	// Side의 수가 더 많은 것을 반환, 같으면 null 반환
	public static Polygon compareSides(Polygon poly1, Polygon poly2) {
		int len1 = poly1.getSides().length;
		int len2 = poly2.getSides().length;
		if (len1 > len2) {
			System.out.println("왼쪽 polygon의 Side 크기가 " + (len1-len2) + "만큼 큽니다.");
			return poly1;
		}
		else if (len1 < len2) {
			System.out.println("오른쪽 polygon의 Side 크기가 " + (len2-len1) + "만큼 큽니다.");
			return poly1;
		}
		else {
			System.out.println("두 Polygon의 Side 크기가 같습니다.");
			return null;
		}
	}
	
	// Diagonal의 수가 더 많은 것을 반환, 같으면 null 반환
	public static Polygon compareAngles(Polygon poly1, Polygon poly2) {
		int len1 = poly1.getAngles().length;
		int len2 = poly2.getAngles().length;
		if (len1 > len2) {
			System.out.println("왼쪽 polygon의 Angle 크기가 " + (len1-len2) + "만큼 큽니다.");
			return poly1;
		}
		else if (len1 < len2) {
			System.out.println("오른쪽 polygon의 Angle 크기가 " + (len2-len1) + "만큼 큽니다.");
			return poly1;
		}
		else {
			System.out.println("두 Polygon의 Angle 크기가 같습니다.");
			return null;
		}
	}
	
}
