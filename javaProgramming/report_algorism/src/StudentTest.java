import java.util.Scanner;

//***************************
//���ϸ�: StudentTest
//�ۼ���: 201814011 ������
//�ۼ���: 2020-3-30
//����: [hw3_1] �л� �迭
//***************************

public class StudentTest {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("hw3_1: ������");
		System.out.println("");
		System.out.print("�л��� �Է�: ");
		int n = scanner.nextInt();
		System.out.println("");
		
		Student[] st; // Student Ÿ������ ���۷��� ���� st ����
		st = new Student[n]; // Student ��ü�� ���� ���۷��� n�� ����
		double sum = 0; // ���� �ջ� ��
		double max = 0; // ���� �ִ밪
		String top = ""; // // �ְ��� �л��� ����
		
		System.out.println(n+"���� �л� ������ �Է��ϼ���: ");
		for(int i=0; i<st.length; i++) {
			st[i] = new Student(); // Student() ��ü ����
			st[i].setName(scanner.next());
			st[i].setStudent_Num(scanner.nextInt());
			st[i].setScore(scanner.nextDouble());
			
			sum += st[i].getScore();
			
			if(max < st[i].getScore()) {
				max = st[i].getScore();
				top = st[i].getName();
			}
			
		}
		System.out.println("");
		System.out.println("���� ��� = "+sum/n);
		System.out.println("");
		System.out.println("���� �л� ���� = "+top);
		
		scanner.close();
	}
}

class Student {
	private String name; // ����
	private int student_Num; // �й�
	private double score; // ����
	
	public Student() { // ������
		
	}

	public String getName() { // setName �޼ҵ忡�� �Ҵ��� name ���� �ܺη� �������ִ� public �޼ҵ� �߰�
		return name;
	}
	
	public void setName(String name) { // name�� �޾Ƽ� private ������ name�� ���� �Ҵ����ִ� public �޼ҵ� �߰�
		this.name = name;
	}

	public int getStudent_Num() {
		return student_Num;
	}

	public void setStudent_Num(int student_Num) {
		this.student_Num = student_Num;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
}
