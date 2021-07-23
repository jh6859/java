// 1�й�, 2021-06-10, 32181046 ������


// My Code  -- �� Polygon�� ���Ͽ� �� ū ���� ��ȯ�ϰ�, �� ���� ���̸� ����Ѵ�.
public class PolygonCompare {
	
	
	// Point�� ��(�������� ��)�� �� ���� ���� ��ȯ, ������ null ��ȯ
	public static Polygon comparePoints(Polygon poly1, Polygon poly2) {
		int len1 = poly1.getPoints().length;
		int len2 = poly2.getPoints().length;
		if (len1 > len2) {
			System.out.println("���� polygon�� Point ũ�Ⱑ " + (len1-len2) + "��ŭ Ů�ϴ�.");
			return poly1;
		}
		else if (len1 < len2) {
			System.out.println("������ polygon�� Point ũ�Ⱑ " + (len2-len1) + "��ŭ Ů�ϴ�.");
			return poly1;
		}
		else {
			System.out.println("�� Polygon�� Point ũ�Ⱑ �����ϴ�.");
			return null;
		}
	}
	
	// Side�� ���� �� ���� ���� ��ȯ, ������ null ��ȯ
	public static Polygon compareSides(Polygon poly1, Polygon poly2) {
		int len1 = poly1.getSides().length;
		int len2 = poly2.getSides().length;
		if (len1 > len2) {
			System.out.println("���� polygon�� Side ũ�Ⱑ " + (len1-len2) + "��ŭ Ů�ϴ�.");
			return poly1;
		}
		else if (len1 < len2) {
			System.out.println("������ polygon�� Side ũ�Ⱑ " + (len2-len1) + "��ŭ Ů�ϴ�.");
			return poly1;
		}
		else {
			System.out.println("�� Polygon�� Side ũ�Ⱑ �����ϴ�.");
			return null;
		}
	}
	
	// Diagonal�� ���� �� ���� ���� ��ȯ, ������ null ��ȯ
	public static Polygon compareAngles(Polygon poly1, Polygon poly2) {
		int len1 = poly1.getAngles().length;
		int len2 = poly2.getAngles().length;
		if (len1 > len2) {
			System.out.println("���� polygon�� Angle ũ�Ⱑ " + (len1-len2) + "��ŭ Ů�ϴ�.");
			return poly1;
		}
		else if (len1 < len2) {
			System.out.println("������ polygon�� Angle ũ�Ⱑ " + (len2-len1) + "��ŭ Ů�ϴ�.");
			return poly1;
		}
		else {
			System.out.println("�� Polygon�� Angle ũ�Ⱑ �����ϴ�.");
			return null;
		}
	}
	
}
