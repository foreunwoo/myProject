import java.util.Scanner;

//***************************
//파일명: MyHashtableTest2
//작성자: 201814011 김은우
//작성일: 2020-05-11
//내용: 	[hw7_2] 학번-성적 hash table
//***************************

class MyHashtable<K, V> {
	private Student[] table; // 해시테이블
	private int m; // 해시테이블 크기

	public static class Student { // 학번과 성적이 저장될 Student 클래스
		private Object student_Num; // 학번(key)
		private Object score; // 성적(value)
		private Student next;

		public Student(Object key, Object value, Student ref) {
			student_Num = key;
			score = value;
			next = ref;
		}

		public Object getStudent_Num() {
			return student_Num;
		}

		public void setStudent_Num(int student_Num) {
			this.student_Num = student_Num;
		}

		public Object getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

	}

	public MyHashtable(int size) {
		table = new Student[size];
		m = size;
	}

	public V contains(K key) { // 해시테이블에서 key 값을 검색하고 성적 리턴
		int i = hash(key);
		for (Student x = table[i]; x != null; x = x.next) // 연결리스트 탐색
			if (key.equals(x.student_Num))
				return (V) x.score; // 탐색 성공
		return null; // 탐색 실패
	}

	public boolean put(K key, V data) { // 삽입 연산
		int i = hash(key);
		for (Student x = table[i]; x != null; x = x.next)
			if (key.equals(x.student_Num)) { // 이미 key 존재
				x.score = data; // 데이터만 갱신
				return false;
			}
		table[i] = new Student(key, data, table[i]); // 연결 리스트의 첫 노드로 삽입
		return true;
	}
	
	public boolean remove(K key) { // 삭제 연산
		int i = hash(key);
		
        for (Student x = table[i]; x != null; x = x.next)
        	if (key.equals(x.student_Num)) {
        		x.student_Num = null;
        		x.score = null;
        		
        		return true;	 
        	}
        return false;
    }

	public void print() {
		System.out.println("해시 테이블 내용");
		for (int i = 0; i < m; ++i) {
			System.out.print(String.format("%2d", i));
			Student x = table[i];
			while (x != null) {
				System.out.print("-->[" + x.getStudent_Num() + ", " + x.getScore() + "]");
				x = x.next;
			}
			System.out.println();
		}
	}

	private int hash(K key) { // 해시 함수
		return (key.hashCode() & 0x7fffffff) % m;
	}

}

public class MyHashtableTest2 {

	public static void main(String[] args) {
		System.out.println("hw7_2: 김은우");

		// 해시테이블 크기(size)를 입력 받음
		Scanner scanner = new Scanner(System.in);
		System.out.print("해시테이블 크기 입력: ");
		int size = scanner.nextInt();

		MyHashtable studentTable = new MyHashtable(size);

		int menu = 0;
		do {
			System.out.print("1:삽입 2:검색 3:삭제 4:테이블 출력 5:종료 ---> ");
			menu = scanner.nextInt();

			switch (menu) {
			case 1:
				System.out.print("삽입할 학번, 성적(정수값)을 입력하세요: ");
				int id = scanner.nextInt();
				int score = scanner.nextInt();
				if (studentTable.put(id, score))
					System.out.println(id + "," + score + " 삽입 성공");
				else
					System.out.println(id + "," + score + " 성적 갱신");
				break;
			case 2:
				System.out.print("검색할 학번(정수값)을 입력하세요: ");
				id = scanner.nextInt();
				if (studentTable.contains(id) != null)
					System.out.println(id + " 학생의 점수는 " + studentTable.contains(id) + " 입니다.");
				else
					System.out.println(id + " 학생을 찾을 수 없습니다.");
				break;
			case 3:
				System.out.print("삭제할 학번(정수값)을 입력하세요: ");
				id = scanner.nextInt();
				if (studentTable.remove(id)) 
					System.out.println(id + " 삭제 성공"); 
				else
					System.out.println(id + " 삭제 실패");
				break;
			case 4:
				studentTable.print();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("메뉴 번호가 잘못되었습니다. 다시 입력하세요.");
			}
		} while (menu != 5);
		scanner.close();
	}

}
