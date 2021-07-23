// 1�й�, 2021-06-10, 32181046 ������

// �ٰ����� Ÿ�� ������ ����, 
public enum PolygonType {
	TRIANGLE(3),  // �ﰢ��
	RECTANGLE(4),  // �簢��
	PENTAGON(5),  // ������
	HEXAGON(6),  // ������
	HEPTAGON(7),  // ĥ����
	OCTAGON(8);  // �Ȱ���
	
	// private�� ���� �ٸ� ������ ������ �Ұ��� �ϰ� �Ѵ�. final�� ���� ������ �ʵ�� ���� ������ �� ����.
	private final int type;	
	
	// ������ ���� �޾� type ������ �����ϴ� �޼ҵ�
	private PolygonType(int type) {
		this.type = type;
	}
		
	// ������ type�� ���� ��ȯ�ϴ� getter
	public int getType() {
		return type;
	}
	
	// ���� ���� �޾� �� ���� ���� PolygonType �������� ��ȯ�ϴ� �޼ҵ��̴�. static���� �����Ǿ����Ƿ� �ٸ� ��� Ŭ���������� ��� �����ϴ�.
	public static PolygonType valueOf(int type) {
		
		// switch���� ���� ������ ���� ���� PolygonType �������� ��ȯ�Ѵ�.
		switch(type) {
		case 3:
			return TRIANGLE;
		case 4:
			return RECTANGLE;
		case 5:
			return PENTAGON;
		case 6:
			return HEXAGON;
		case 7:
			return HEPTAGON;
		case 8:
			return OCTAGON;
		default:
			return null;
		}
	}
}