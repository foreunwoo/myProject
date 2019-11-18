class Rect implements Shape { //Shape 인터페이스에 선언된 추상 메소드 구현ㅍ
	private int width; //가로
	private int height; //세로
 	public Rect(int width, int height) { this.width=width; this.height=height; } //Rect 클래스 생성자
	
	public void redraw() { //디폴트 메소드
		System.out.print("--- 다시 그립니다. ");
		draw();
}
	@Override
	public void draw() { //도형을 그리는 메소드
		System.out.println(width+"x"+height+"크기의 사각형 입니다."); 
		
	}
	@Override
	public double getArea() { //도형의 면적을 리턴하는 메소드
		return width*height;
	}
}
