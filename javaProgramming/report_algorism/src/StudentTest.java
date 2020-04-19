import java.util.Scanner;

//***************************
//파일명: StudentTest
//작성자: 201814011 김은우
//작성일: 2020-3-30
//내용: [hw3_1] 학생 배열
//***************************

public class StudentTest {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("hw3_1: 김은우");
		System.out.println("");
		System.out.print("학생수 입력: ");
		int n = scanner.nextInt();
		System.out.println("");
		
		Student[] st; // Student 타입으로 레퍼런스 변수 st 선언
		st = new Student[n]; // Student 객체에 대한 레퍼런스 n개 생성
		double sum = 0; // 성적 합산 값
		double max = 0; // 성적 최대값
		String top = ""; // // 최고점 학생의 성명
		
		System.out.println(n+"명의 학생 정보를 입력하세요: ");
		for(int i=0; i<st.length; i++) {
			st[i] = new Student(); // Student() 객체 생성
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
		System.out.println("성적 평균 = "+sum/n);
		System.out.println("");
		System.out.println("수석 학생 성명 = "+top);
		
		scanner.close();
	}
}

class Student {
	private String name; // 성명
	private int student_Num; // 학번
	private double score; // 점수
	
	public Student() { // 생성자
		
	}

	public String getName() { // setName 메소드에서 할당한 name 값을 외부로 리턴해주는 public 메소드 추가
		return name;
	}
	
	public void setName(String name) { // name을 받아서 private 변수인 name에 값을 할당해주는 public 메소드 추가
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
