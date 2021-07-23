// 1분반, 2021-06-10, 32181046 김준하

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;


public class PolygonMapManager {
	private Map<PolygonType, Polygon> polygons = null;
	
	// 생성자
	public PolygonMapManager() {
		this.polygons = new HashMap<> ();
	}
	
	// 맵에 새로 추가
	public void add(Polygon c) {
		this.polygons.put(PolygonType.valueOf(c.getPoints().length), c);
	}
	
	// 맵에서 해당 Value 삭제
	public void remove(PolygonType c) {
		this.polygons.remove(c);
	}
	
	// 맵의 크기 반환
	public int size() {
		return this.polygons.size();
	} 
		
	// 맵에서 지정된 키에 매핑되는 값 리턴
	public Polygon get(PolygonType type) {
		return this.polygons.get(type);
	}
	
	// 인자로 넘겨준 리스트에서 랜덤하게 하나 선택해서 반환
	public static Polygon getRandom(Map<PolygonType, Polygon> list) {
		List<Polygon> list1 = new ArrayList<>(list.values());  // hashmap의  Value값들을 list로 변경
		int rand = (int) Math.round((Math.random()*(list1.size()-1)));  // Math 클래스를 이용해 랜덤 인덱스 반환
		return list1.get(rand);
	}
	
	// Predicate 인터페이스를 사용하여 해당 값에 맞는 polygons 값들만 Map<PolygonType, Polygon>형으로 반환
	public Map<PolygonType, Polygon> select(Predicate<? super Polygon> predicate) {  // 슈퍼타입 와일드카드
		// 리스트에서 해당 predicate 조건에 맞는 모든 polygons 리스트 반환 - poly 컬렉션을 생성해 해당 조건의 객체를 저장해 반환.
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
	

	// 전체 맵 프린트
	public void print() {
		System.out.println(polygons);
	} 
}
