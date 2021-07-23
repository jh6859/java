// 1분반, 2021-06-10, 32181046 김준하

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PolygonListManager {
	private List<Polygon> polygons = null;
	
	// 생성자
	public PolygonListManager() {
		this.polygons = new ArrayList<> ();
	}
	
	// 리스트에 새로 추가
	public void add(Polygon c) {
		this.polygons.add(c);
	}
	
	// 리스트에서 해당 polygons 삭제
	public void remove(Polygon c) {
		this.polygons.remove(c);
	}
	
	// 리스트에서 해당 polygons의 index 반환
	public int indexOf(Polygon c) {
		return this.polygons.indexOf(c);
	}
	
	// 리스트의 크기 반환
	public int size() {
		return this.polygons.size();
	} 
	
	// 리스트에서 index에 polygons로 교체
	public void set(int index, Polygon c) {
		this.polygons.remove(index);
		this.polygons.add(index, c);
	}
		
	// 리스트에서 index의 polygons 반환
	public Polygon get(int index) {
		return this.polygons.get(index);
	}
	
	// Predicate 인터페이스를 사용하여 해당 값에 맞는 polygons 값들만 List<Polygon>형으로 반환
	public List<Polygon> select(Predicate<? super Polygon> predicate) {  // 슈퍼타입 와일드카드
		// 리스트에서 해당 predicate 조건에 맞는 모든 polygons 리스트 반환 - poly 컬렉션을 생성해 해당 조건의 객체를 저장해 반환.
		List<Polygon> poly = new ArrayList<> ();
		for (Polygon weatherc: this.polygons) {
			if (predicate.test(weatherc)) {
				poly.add(weatherc);
			}
		}
		return poly;
	}
	
	// 전체 리스트 프린트
	public void print() {
		for (int i = 0; i < this.polygons.size(); i++) {
			System.out.println(this.polygons.get(i));
		}
	} 
}
