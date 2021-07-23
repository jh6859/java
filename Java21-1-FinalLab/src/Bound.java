// 1�й�, 2021-06-10, 32181046 ������

// Bound�� �����ϴ� Ŭ����
public class Bound {
	private Point bottomLeft;  // �ϴ� ������ ��
	private Point bottomRight;  // �ϴ� �������� ��
	private Point topLeft;  // ��� ������ ��
	private Point topRight;  // ��� �������� ��

	// Bound ��ü�� bottomLeft, bottomRight ���� 0.0����, topLeft, topRight ���� 1.0���� �����ϴ� ������
	public Bound()	{
		this(new Point(0.0, 0.0), 1.0, 1.0);
	}

	// Bound ��ü�� �ʺ�, ���̸� �Է¹޾� �������� ���� ������ Bound �ʵ尪 ����
	public Bound(Point origin, double width, double height)	{
		this.bottomLeft = origin;
		this.bottomRight = new Point(origin.getX() + width, origin.getY());
		this.topLeft = new Point(origin.getX(), origin.getY() + height);
		this.topRight = new Point(origin.getX() + width, origin.getY() + height);
	}
	
	// �ϴ� ���� ���� �ʺ�, ���̸� �Է¹޾� �������� ���� ������ �ʵ尪 ����
	public Bound(double x, double y, double width, double height) {
		this.bottomLeft = new Point(x, y);
		this.bottomRight = new Point(x + width, y);
		this.topLeft = new Point(x, y + height);
		this.topRight = new Point(x + width, y + height);
	}
	
	// �ϴ� ���� ��, ��� ������ ���� �Է¹޾� �������� ���� ������ �ʵ尪 ����
	public Bound(Point bottomLeft, Point topRight) {
		this.bottomLeft = bottomLeft;
		this.bottomRight = new Point(topRight.getX(), bottomLeft.getY());
		this.topLeft = new Point(bottomLeft.getX(), topRight.getY());
		this.topRight = topRight;
	}

	//getter �޼ҵ�
	public Point getBottomLeft() {  // �ϴ� ����
		return bottomLeft;
	}
	public Point getBottomRight() {  // �ϴ� ������
		return bottomRight;
	}
	public Point getTopLeft() {  // ��� ����
		return topLeft;
	}
	public Point getTopRight() {  // ��� ������
		return topRight;
	}
	public double getWidth() {  // �ʺ�
		return topRight.getX() - bottomLeft.getX();
	}
	public double getHeight() {  // ����
		return topRight.getY() - bottomLeft.getY();
	}

	// Point ��ü�� �迭�� �Է¹޾� x,y�� �ִ밪�� �ּҰ��� ���� ���� �̿��� Bound�� ã�� ��ȯ�ϴ� �޼ҵ�
	public static Bound findBound(Point[] points) {
		if (points == null) return null;  // �迭�� ������ null���� ��ȯ�Ѵ�.
		
		//�ϴ� 0��° �迭�� x,y���� �ִ�, �ּҰ����� ����
		double xmin = points[0].getX();
		double xmax = points[0].getX();
		double ymin = points[0].getY();
		double ymax = points[0].getY();
		
		// �迭 �� ��ŭ �ݺ��Ͽ�, ���ο� �ִ�, �ּ� ���� ������ ���� �����Ѵ�.
		for (int i = 0; i < points.length; i++) {
			xmin = Math.min(points[i].getX(), xmin);
			xmax = Math.max(points[i].getX(), xmax);
			ymin = Math.min(points[i].getY(), ymin);
			ymax = Math.max(points[i].getY(), ymax);
		}
		return new Bound(xmin, ymin, xmax - xmin, ymax - ymin);
	}

	// toString �޼ҵ�
	@Override
	public String toString() {
		return "Bound [bottomLeft=" + bottomLeft + ", bottomRight=" + bottomRight + ", topLeft=" + topLeft
				+ ", topRight=" + topRight + "]";
	}
}
