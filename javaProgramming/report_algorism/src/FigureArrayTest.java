import java.util.Scanner;

//***************************
//파일명: FigureArrayTest
//작성자: 201814011 김은우
//작성일: 2020-04-09
//내용: [hw4_4] 도형 배열
//***************************

public class FigureArrayTest {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		
		System.out.println("hw4_4: 김은우");
		System.out.println("");
		System.out.print("원 갯수 입력: ");
		int n1 = scanner.nextInt();
		System.out.print("삼각형 갯수 입력: ");
		int n2 = scanner.nextInt();
		System.out.println("");
		
		Shape[] figureArray = new Shape[n1+n2]; // 원, 삼각형 객체가 들어갈 배열 생성
		
		System.out.println(n1+"개의 원 정보(반지름)를 입력하세요: ");
		for(int i=0; i<n1; i++) {
			Circle c = new Circle(); // Circle() 객체 생성
			c.setRadius(scanner.nextDouble());
			figureArray[i] = c;
		}
		
		System.out.println(n2+"개의 삼각형 정보(밑변과 높이)를 입력하세요: ");
		for(int i=0; i<n2; i++) {
			Triangle t = new Triangle(); // Triangle() 객체 생성
			t.setBase(scanner.nextDouble());
			t.setHeight(scanner.nextDouble());
			figureArray[n1+i] = t;
		}
		
		System.out.println(figureArray.length+"개의 도형 정보와 면적 =");
		for (int k=0; k < figureArray.length; k++) { 
			System.out.println(figureArray[k]);
			}
		
		scanner.close();
	}
}

interface Shape1 {
	public abstract double getArea(); // 추상 메소드
}

class Circle1 implements Shape {
	private double radius;
	final double PI = 3.14;
	
	public Circle1() { // 생성자
		
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return radius*radius*PI;
	}
	
	@Override
	public String toString() {
		return "원 반지름=" + radius + " 면적=" + getArea();
	}
}

class Triangle1 implements Shape {
	private double base;
	private double height;
	
	public Triangle1() { // 생성자
		
	}
	
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public double getArea() {
		return base*height/2;
	}
	
	@Override
	public String toString() {
		return "삼각형 밑변=" + base + " 높이=" + height + " 면적="+getArea();
	}
	
}


