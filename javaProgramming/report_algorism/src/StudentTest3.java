import java.util.Scanner;

//***************************
//���ϸ�: StudentTest3
//�ۼ���: 201814011 ������
//�ۼ���: 2020-04-06
//����: [hw3_3] bubble sort
//***************************

public class StudentTest3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("hw3_3: ������");
		System.out.println("");
		System.out.print("�л��� �Է�: ");
		int n = scanner.nextInt();
		System.out.println("");
		
		Student[] st; // Student Ÿ������ ���۷��� ���� st ����
		st = new Student[n]; // Student ��ü�� ���� ���۷��� n�� ����
		
		
		System.out.println(n+"���� �л� ������ �Է��ϼ���: ");
		for(int i=0; i<st.length; i++) {
			st[i] = new Student(); // Student() ��ü ����
			st[i].setName(scanner.next());
			st[i].setStudent_Num(scanner.nextInt());
			st[i].setScore(scanner.nextDouble());
			
		}
		System.out.println("");
		System.out.println("���� �������� ���� ���  = ");
		
		double tmp; 
		int tmp2; 
		String tmp3;
		
	
		for (int i=0; i<n-1; i++) { // ������ �迭�� ũ�⸦ �� ���� �ϳ��� �ٿ�����
			  for (int j=i+1; j<n; j++) { // �������� ����
				  if (st[i].getScore() < st[j].getScore()) {
					tmp= st[i].getScore();
					st[i].setScore(st[j].getScore());
					st[j].setScore(tmp);
					
					tmp2= st[i].getStudent_Num(); // ������ ���� �й��� ����
					st[i].setStudent_Num(st[j].getStudent_Num());
					st[j].setStudent_Num(tmp2);
					
					tmp3= st[i].getName(); // ������ ���� �̸��� ����
					st[i].setName(st[j].getName());
					st[j].setName(tmp3);
					
				  }
			  }
		}
			
		
		for (int k=0; k < n; k++) { // ���� �������� ���� �� ��� ���
			System.out.println(st[k].getName() + " " + st[k].getStudent_Num()+ " " + st[k].getScore()); 
			}
		
		scanner.close();
	}
}

class Student3 {
	public int length;
	private String name; // ����
	private int student_Num; // �й�
	private double score; // ����
	
	public Student3() { // ������
		
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

