import java.util.Scanner;

//***************************
//���ϸ�: HeapSortTest
//�ۼ���: 201814011 ������
//�ۼ���: 2020-04-13
//����: [hw4_6] heap sort
//***************************

interface Shape {
	public abstract double getArea(); // �߻� �޼ҵ�
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
		return "�� ������=" + radius + " ����=" + getArea();
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
		return "�ﰢ�� �غ�=" + base + " ����=" + height + " ����="+getArea();
	}
	
}

class FigureSortService {
	
	public static void heapSort(Shape [] a) {
		
	    buildheap(a); // �� ����
	    int sizeOfHeap = a.length - 1;
	    for(int i = sizeOfHeap; i > 0; i--) {
	        exchange(a, 0, i); // ��Ʈ�� ������ ��带 �ٲ۴�.
	        sizeOfHeap = sizeOfHeap - 1; // �ִ밪�� ������ �������� ������
	        heapify(a, 0, sizeOfHeap); // �ٽ� �ִ����� ����
	    }

	}

	public static void buildheap(Shape [] a) {
	    for(int i = (a.length - 1) / 2; i >= 0; i--) { // ��� ���ں��� �����Ѵ�.
	        heapify(a, i, a.length - 1);
	    }
	}

	public static void heapify(Shape [] a, int i, int size) {
	    int left = 2 * i + 1; // ���� �ڽ�
	    int right = 2* i + 2; // ������ �ڽ�
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
		
		System.out.println("hw4_6: ������");
		System.out.println("");
		System.out.print("�� ���� �Է�: ");
		int n1 = scanner.nextInt();
		System.out.print("�ﰢ�� ���� �Է�: ");
		int n2 = scanner.nextInt();
		System.out.println("");
		
		Shape[] figureArray = new Shape[n1+n2]; // ��, �ﰢ�� ��ü�� �� �迭 ����
		
		System.out.println(n1+"���� �� ����(������)�� �Է��ϼ���: ");
		for(int i=0; i<n1; i++) {
			Circle c = new Circle(); // Circle() ��ü ����
			c.setRadius(scanner.nextDouble());
			figureArray[i] = c;
		}
		
		System.out.println(n2+"���� �ﰢ�� ����(�غ��� ����)�� �Է��ϼ���: ");
		for(int i=0; i<n2; i++) {
			Triangle t = new Triangle(); // Triangle() ��ü ����
			t.setBase(scanner.nextDouble());
			t.setHeight(scanner.nextDouble());
			figureArray[n1+i] = t;
		}
		
        FigureSortService.heapSort(figureArray);
		
		System.out.println("�� ���� ��� "+figureArray.length+"���� ���� ������ ���� =");
		for (int k=0; k < figureArray.length; k++) { 
			System.out.println(figureArray[k]);
			}
		
		scanner.close();
	}
}


