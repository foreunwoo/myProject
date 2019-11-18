public class Circle {
	private int x;
	private int y;
	private int radius;
	
	public Circle(int x, int y, int radius) { //생성자로 3개의 인자를 받아 필드 초기화
		this.x=x;
		this.y=y;
		this.radius=radius;
	}
	
	public String toString() { //Circle 객체를 문자열로 리턴하는 toString() 작성
		return "Circle("+x+","+y+")반지름"+radius;}
	
	public boolean equals(Object obj) { //equals() 오버라이딩 -> 업캐스팅
		Circle c = (Circle)obj; // 객체 obj를 Circle 타입으로 다운 캐스팅
		if(this.x==c.x && this.y==c.y) return true;
		else return false;
	 }

	public static void main(String[] args) {
		Circle a = new Circle(2,3,5); //중심 (2,3)에 반지름 5인 원
		Circle b = new Circle(2,3,30); //중심 (2,3)에 반지름 30인 원
		System.out.println("원 a : " +a); //toString 오버라이딩
		System.out.println("원 b : " +b); //toString 오버라이딩
		
		if(a.equals(b)) //true
			System.out.println("같은 원");
		else //false
			System.out.println("서로 다른 원");

	}

}
