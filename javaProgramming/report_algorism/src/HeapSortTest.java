import java.util.Scanner;

//***************************
//파일명: HeapSortTest
//작성자: 201814011 김은우
//작성일: 2020-04-13
//내용: [hw4_6] heap sort
//***************************

interface Shape {
	public abstract double getArea(); // 추상 메소드
}

class Circle implements Shape {
	private double radius;
	final double PI = 3.14;
	
	public Circle() {}

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

class Triangle implements Shape {
	private double base;
	private double height;
	
	public Triangle() {}
	
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

class FigureSortService {
	
	public static void heapSort(Shape [] a) {
		
	    buildheap(a); // 힙 구성
	    int sizeOfHeap = a.length - 1;
	    for(int i = sizeOfHeap; i > 0; i--) {
	        exchange(a, 0, i); // 루트와 마지막 노드를 바꾼다.
	        sizeOfHeap = sizeOfHeap - 1; // 최대값을 제외한 나머지를 가지고
	        heapify(a, 0, sizeOfHeap); // 다시 최대힙을 구성
	    }

	}

	public static void buildheap(Shape [] a) {
	    for(int i = (a.length - 1) / 2; i >= 0; i--) { // 가운데 숫자부터 진행한다.
	        heapify(a, i, a.length - 1);
	    }
	}

	public static void heapify(Shape [] a, int i, int size) {
	    int left = 2 * i + 1; // 왼쪽 자식
	    int right = 2* i + 2; // 오른쪽 자식
	    int max;

	    if(left <= size && a[left].getArea() > a[i].getArea()) {
	        max = left;
	    } else {
	        max = i;
	    }

	    if(right <= size && a[right].getArea() > a[max].getArea()) {
	        max = right;
	    }

	    if(max != i) {
	        exchange(a, i, max);
	        heapify(a, max, size); 
	    }
	}

	public static void exchange(Shape [] a, int i, int max) { // swap
	    Shape temp = a[i];
	    a[i] = a[max];
	    a[max] = temp;
	}
}

public class HeapSortTest {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		
		System.out.println("hw4_6: 김은우");
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
		
        FigureSortService.heapSort(figureArray);
		
		System.out.println("힙 정렬 결과 "+figureArray.length+"개의 도형 정보와 면적 =");
		for (int k=0; k < figureArray.length; k++) { 
			System.out.println(figureArray[k]);
			}
		
		scanner.close();
	}
}


