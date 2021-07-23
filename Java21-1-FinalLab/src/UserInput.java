// 1분반, 2021-06-10, 32181046 김준하

import java.util.Scanner;  // Scanner 클래스 import

// 사용자 입력을 받기 위한 UserInput 클래스 사용
public class UserInput {  
	static Scanner scan = new Scanner(System.in); 
	public static double getDouble() {  // 다음 한 줄을 double형으로 입력받는 메소드
		System.out.println("double형 값을 입력하시오.");
		return Double.parseDouble(scan.nextLine());
	}
	public static int getInteger() {  // 다음 한 줄을 integer형으로 입력받는 메소드
		System.out.println("integer형 값을 입력하시오.");
		return  Integer.parseInt(scan.nextLine());
	}

	public static int getIntegerBetween(int min, int max) {  // 정수 min과 max사이의 값만을 입력받기 위한 메소드
		int i;

		// 일단 문장을 수행하고 min과 max사이의 값이 아닐 경우 반복하는 do-while문
		do {  
			i = getInteger();
			if (i >= min && i <= max)  // 입력받은 수가 min과 max사이의 값일 경우 do-while문에서 break
				break;
			else {  
				System.out.println(min + " 과" + max + " 사이의 값을 입력하시오.");
			}
		} while (i >= min && i <= max);  
		return i;
		
	}

	public static boolean getExitKey() {  // 입력받은 문자열 s의 값이 "q"일 경우 true 반환, 그렇지 않으면 false 반환하는 boolean형 메소드
		System.out.print("Press q-key to exit or enter-key to continue: ");
		String s = scan.nextLine();
		if (s.contentEquals("q"))
			return true;
		else
			return false;
	}
	
	// 사용자의 정수형 입력을 통해 PolygonType를 반환하는 메소드
	public static PolygonType getUserPolygonType() {
		System.out.println("다각형을 선택하시오, 삼각형: 3, 사각형: 4, 오각형: 5, 육각형: 6, 칠각형: 7, 팔각형: 8");
		int n = 0;
		n = getInteger();
		switch (n) {
		case 1:
		case 2:
			return null;
		case 3: 
			return PolygonType.TRIANGLE;
		case 4:
			return PolygonType.RECTANGLE;
		case 5:
			return PolygonType.PENTAGON;
		case 6:
			return PolygonType.HEPTAGON;
		case 7:
			return PolygonType.HEXAGON;
		case 8:
			return PolygonType.OCTAGON;
		}
		return null;
	}
}
