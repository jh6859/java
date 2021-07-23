// 1분반, 2021-06-10, 32181046 김준하

// 인터페이스인 IPolygonCalculator
public interface IPolygonCalculator {
	abstract double getArea();  // 넒이
	abstract double getPerimeter();  // 둘레
	abstract boolean isRegular();
	abstract void getUserInput();
}
