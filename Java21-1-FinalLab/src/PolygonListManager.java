// 1�й�, 2021-06-10, 32181046 ������

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PolygonListManager {
	private List<Polygon> polygons = null;
	
	// ������
	public PolygonListManager() {
		this.polygons = new ArrayList<> ();
	}
	
	// ����Ʈ�� ���� �߰�
	public void add(Polygon c) {
		this.polygons.add(c);
	}
	
	// ����Ʈ���� �ش� polygons ����
	public void remove(Polygon c) {
		this.polygons.remove(c);
	}
	
	// ����Ʈ���� �ش� polygons�� index ��ȯ
	public int indexOf(Polygon c) {
		return this.polygons.indexOf(c);
	}
	
	// ����Ʈ�� ũ�� ��ȯ
	public int size() {
		return this.polygons.size();
	} 
	
	// ����Ʈ���� index�� polygons�� ��ü
	public void set(int index, Polygon c) {
		this.polygons.remove(index);
		this.polygons.add(index, c);
	}
		
	// ����Ʈ���� index�� polygons ��ȯ
	public Polygon get(int index) {
		return this.polygons.get(index);
	}
	
	// Predicate �������̽��� ����Ͽ� �ش� ���� �´� polygons ���鸸 List<Polygon>������ ��ȯ
	public List<Polygon> select(Predicate<? super Polygon> predicate) {  // ����Ÿ�� ���ϵ�ī��
		// ����Ʈ���� �ش� predicate ���ǿ� �´� ��� polygons ����Ʈ ��ȯ - poly �÷����� ������ �ش� ������ ��ü�� ������ ��ȯ.
		List<Polygon> poly = new ArrayList<> ();
		for (Polygon weatherc: this.polygons) {
			if (predicate.test(weatherc)) {
				poly.add(weatherc);
			}
		}
		return poly;
	}
	
	// ��ü ����Ʈ ����Ʈ
	public void print() {
		for (int i = 0; i < this.polygons.size(); i++) {
			System.out.println(this.polygons.get(i));
		}
	} 
}
