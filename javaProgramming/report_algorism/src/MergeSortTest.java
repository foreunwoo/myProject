import java.util.Scanner;

//***************************
//���ϸ�: MergeSortTest
//�ۼ���: 201814011 ������
//�ۼ���: 2020-04-11
//����: [hw4_5] merge sort
//***************************

interface Shape2 {
	public abstract double getArea(); // �߻� �޼ҵ�

}

class Circle2 implements Shape2 {
	private double radius;
	final double PI = 3.14;
	
	public Circle2() { // ������
		
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
		return "�� ������=" + radius + " ����=" + getArea();
	}
}

class Triangle2 implements Shape2 {
	private double base;
	private double height;
	
	public Triangle2() { // ������
		
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
		return "�ﰢ�� �غ�=" + base + " ����=" + height + " ����="+getArea();
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
			if((a[i].getArea() <= a[j].getArea())) { // ���� ��
				tmp[t++] = a[i++];
			} else {
				tmp[t++] = a[j++];
			}
		}
		
		while (i<=q) { // ���� �κ� �迭�� ���� ���
			tmp[t++] = a[i++];
		}
		
		while (j<=r) { // ������ �κ� �迭�� ���� ���
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
		
		System.out.println("hw4_5: ������");
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
		
		FigureSortService2.mergeSort(figureArray);
		
		System.out.println("���� ���� ��� "+figureArray.length+"���� ���� ������ ���� =");
		for (int k=0; k < figureArray.length; k++) { 
			System.out.println(figureArray[k]);
			}
		
		scanner.close();
	}
}
