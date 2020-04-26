import java.util.Scanner;

//***************************
//파일명: MergeSortTest
//작성자: 201814011 김은우
//작성일: 2020-04-11
//내용: [hw4_5] merge sort
//***************************

interface Shape2 {
	public abstract double getArea(); // 추상 메소드

}

class Circle2 implements Shape2 {
	private double radius;
	final double PI = 3.14;
	
	public Circle2() { // 생성자
		
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

class Triangle2 implements Shape2 {
	private double base;
	private double height;
	
	public Triangle2() { // 생성자
		
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

class FigureSortService2 {
	
	public static void mergeSort(Shape[] a) {
		mergeSort(a, 0, a.length-1);
	}
	
	public static void mergeSort(Shape[] a, int p, int r) {
		if(p<r) {
			int q = (p+r)/2;
			mergeSort(a, p, q);
			mergeSort(a, q+1, r);
			merge(a, p, q, r);
		}
	}
	
	public static void merge(Shape[] a, int p, int q, int r) {
		int i = p;
		int j = q+1;
		int t = 0;
		Shape[] tmp = new Shape[r-p+1];
		
		while (i<=q && j<=r) {
			if((a[i].getArea() <= a[j].getArea())) { // 면적 비교
				tmp[t++] = a[i++];
			} else {
				tmp[t++] = a[j++];
			}
		}
		
		while (i<=q) { // 왼쪽 부분 배열이 남은 경우
			tmp[t++] = a[i++];
		}
		
		while (j<=r) { // 오른쪽 부분 배열이 남은 경우
			tmp[t++] = a[j++];
		}
		
		i = p;
		t = 0;
		
		while (i<=r) {
			a[i++] = tmp[t++];
		}
	}


}

public class MergeSortTest {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		
		System.out.println("hw4_5: 김은우");
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
		
		FigureSortService2.mergeSort(figureArray);
		
		System.out.println("병합 정렬 결과 "+figureArray.length+"개의 도형 정보와 면적 =");
		for (int k=0; k < figureArray.length; k++) { 
			System.out.println(figureArray[k]);
			}
		
		scanner.close();
	}
}
