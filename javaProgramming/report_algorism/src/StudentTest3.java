import java.util.Scanner;

//***************************
//파일명: StudentTest3
//작성자: 201814011 김은우
//작성일: 2020-04-06
//내용: [hw3_3] bubble sort
//***************************

public class StudentTest3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("hw3_3: 김은우");
		System.out.println("");
		System.out.print("학생수 입력: ");
		int n = scanner.nextInt();
		System.out.println("");
		
		Student[] st; // Student 타입으로 레퍼런스 변수 st 선언
		st = new Student[n]; // Student 객체에 대한 레퍼런스 n개 생성
		
		
		System.out.println(n+"명의 학생 정보를 입력하세요: ");
		for(int i=0; i<st.length; i++) {
			st[i] = new Student(); // Student() 객체 생성
			st[i].setName(scanner.next());
			st[i].setStudent_Num(scanner.nextInt());
			st[i].setScore(scanner.nextDouble());
			
		}
		System.out.println("");
		System.out.println("성적 내림차순 정렬 결과  = ");
		
		double tmp; 
		int tmp2; 
		String tmp3;
		
	
		for (int i=0; i<n-1; i++) { // 정렬할 배열의 크기를 한 번에 하나씩 줄여나감
			  for (int j=i+1; j<n; j++) { // 내림차순 정렬
				  if (st[i].getScore() < st[j].getScore()) {
					tmp= st[i].getScore();
					st[i].setScore(st[j].getScore());
					st[j].setScore(tmp);
					
					tmp2= st[i].getStudent_Num(); // 성적에 따라 학번도 정렬
					st[i].setStudent_Num(st[j].getStudent_Num());
					st[j].setStudent_Num(tmp2);
					
					tmp3= st[i].getName(); // 성적에 따라 이름도 정렬
					st[i].setName(st[j].getName());
					st[j].setName(tmp3);
					
				  }
			  }
		}
			
		
		for (int k=0; k < n; k++) { // 성적 내림차순 정렬 후 결과 출력
			System.out.println(st[k].getName() + " " + st[k].getStudent_Num()+ " " + st[k].getScore()); 
			}
		
		scanner.close();
	}
}

class Student3 {
	public int length;
	private String name; // 성명
	private int student_Num; // 학번
	private double score; // 점수
	
	public Student3() { // 생성자
		
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

