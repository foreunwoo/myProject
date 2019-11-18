class Circle implements Shape { //Shape 인터페이스에 선언된 추상 메소드 구현
	private int radius;
	public Circle(int radius) { this.radius=radius; } //circle 클래스 생성자
	
	public void redraw() { //디폴트 메소드
		System.out.print("--- 다시 그립니다. ");
		draw(); }

	@Override
	public void draw() { //도형을 그리는 메소드
		System.out.println("반지름이 "+radius+"인 원입니다.");
	}

	@Override
	public double getArea() 
		{ return radius*radius*PI; } //도형의 면적을 리턴하는 메소드
}
