// 1�й�, 2021-06-10, 32181046 ������

import java.util.Scanner;  // Scanner Ŭ���� import

// ����� �Է��� �ޱ� ���� UserInput Ŭ���� ���
public class UserInput {  
	static Scanner scan = new Scanner(System.in); 
	public static double getDouble() {  // ���� �� ���� double������ �Է¹޴� �޼ҵ�
		System.out.println("double�� ���� �Է��Ͻÿ�.");
		return Double.parseDouble(scan.nextLine());
	}
	public static int getInteger() {  // ���� �� ���� integer������ �Է¹޴� �޼ҵ�
		System.out.println("integer�� ���� �Է��Ͻÿ�.");
		return  Integer.parseInt(scan.nextLine());
	}

	public static int getIntegerBetween(int min, int max) {  // ���� min�� max������ ������ �Է¹ޱ� ���� �޼ҵ�
		int i;

		// �ϴ� ������ �����ϰ� min�� max������ ���� �ƴ� ��� �ݺ��ϴ� do-while��
		do {  
			i = getInteger();
			if (i >= min && i <= max)  // �Է¹��� ���� min�� max������ ���� ��� do-while������ break
				break;
			else {  
				System.out.println(min + " ��" + max + " ������ ���� �Է��Ͻÿ�.");
			}
		} while (i >= min && i <= max);  
		return i;
		
	}

	public static boolean getExitKey() {  // �Է¹��� ���ڿ� s�� ���� "q"�� ��� true ��ȯ, �׷��� ������ false ��ȯ�ϴ� boolean�� �޼ҵ�
		System.out.print("Press q-key to exit or enter-key to continue: ");
		String s = scan.nextLine();
		if (s.contentEquals("q"))
			return true;
		else
			return false;
	}
	
	// ������� ������ �Է��� ���� PolygonType�� ��ȯ�ϴ� �޼ҵ�
	public static PolygonType getUserPolygonType() {
		System.out.println("�ٰ����� �����Ͻÿ�, �ﰢ��: 3, �簢��: 4, ������: 5, ������: 6, ĥ����: 7, �Ȱ���: 8");
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
