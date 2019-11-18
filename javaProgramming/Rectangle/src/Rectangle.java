 public class Rectangle {
int x, y, width, height; //int 타입의 멤버변수 설정

public Rectangle(int x, int y, int width, int height) { //매개변수로 받아 필드를 초기화 하는 생성자
	this.x = x; 
    this.y = y; 
    this.width = width; 
    this.height = height; 
}

public int square() { //사각형 넓이 리턴
	return width*height;
}

public void show() { //사각형의 좌표와 넓이를 화면에 출력
	System.out.println("("+ x + ","+ y +")"+"에서 크기가 "+width+"x"+height+"인 사각형");
}

public boolean contains(Rectangle r) { //매개변수로 받은 r이 포함되면 true 불포함시 false 리턴
	if((r.x>x && r.y>y)&&(r.width<width && r.height<height))
	{ 
		return true; 
  } 
return false; 

}
	
}
