// 1�й�, 2021-06-10, 32181046 ������

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;


public class PolygonMapManager {
	private Map<PolygonType, Polygon> polygons = null;
	
	// ������
	public PolygonMapManager() {
		this.polygons = new HashMap<> ();
	}
	
	// �ʿ� ���� �߰�
	public void add(Polygon c) {
		this.polygons.put(PolygonType.valueOf(c.getPoints().length), c);
	}
	
	// �ʿ��� �ش� Value ����
	public void remove(PolygonType c) {
		this.polygons.remove(c);
	}
	
	// ���� ũ�� ��ȯ
	public int size() {
		return this.polygons.size();
	} 
		
	// �ʿ��� ������ Ű�� ���εǴ� �� ����
	public Polygon get(PolygonType type) {
		return this.polygons.get(type);
	}
	
	// ���ڷ� �Ѱ��� ����Ʈ���� �����ϰ� �ϳ� �����ؼ� ��ȯ
	public static Polygon getRandom(Map<PolygonType, Polygon> list) {
		List<Polygon> list1 = new ArrayList<>(list.values());  // hashmap��  Value������ list�� ����
		int rand = (int) Math.round((Math.random()*(list1.size()-1)));  // Math Ŭ������ �̿��� ���� �ε��� ��ȯ
		return list1.get(rand);
	}
	
	// Predicate �������̽��� ����Ͽ� �ش� ���� �´� polygons ���鸸 Map<PolygonType, Polygon>������ ��ȯ
	public Map<PolygonType, Polygon> select(Predicate<? super Polygon> predicate) {  // ����Ÿ�� ���ϵ�ī��
		// ����Ʈ���� �ش� predicate ���ǿ� �´� ��� polygons ����Ʈ ��ȯ - poly �÷����� ������ �ش� ������ ��ü�� ������ ��ȯ.
		Map<PolygonType, Polygon> poly = new HashMap<> ();
		Iterator<Polygon> iter = polygons.values().iterator();
		while (iter.hasNext()) {
			Polygon iterNext = iter.next();
			if (predicate.test(iterNext)) {
				poly.put(PolygonType.valueOf(iterNext.getPoints().length), iterNext);
			}
		}
		return poly;
	}
	

	// ��ü �� ����Ʈ
	public void print() {
		System.out.println(polygons);
	} 
}
