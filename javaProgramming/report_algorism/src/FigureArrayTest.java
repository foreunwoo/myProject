import java.util.Scanner;

//***************************
//���ϸ�: FigureArrayTest
//�ۼ���: 201814011 ������
//�ۼ���: 2020-04-09
//����: [hw4_4] ���� �迭
//***************************

public class FigureArrayTest {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		
		System.out.println("hw4_4: ������");
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
		
		System.out.println(figureArray.length+"���� ���� ������ ���� =");
		for (int k=0; k < figureArray.length; k++) { 
			System.out.println(figureArray[k]);
			}
		
		scanner.close();
	}
}

interface Shape1 {
	public abstract double getArea(); // �߻� �޼ҵ�
}

class Circle1 implements Shape {
	private double radius;
	final double PI = 3.14;
	
	public Circle1() { // ������
		
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

class Triangle1 implements Shape {
	private double base;
	private double height;
	
	public Triangle1() { // ������
		
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


