import java.util.Scanner;

//***************************
//파일명: MyHashtableTest
//작성자: 201814011 김은우
//작성일: 2020-05-10
//내용: [hw7_1] 학번 hash table
//***************************

class MyHashtable {
	private int [] table; // 해시테이블
	private int m; // 해시테이블 크기
	private static final int EMPTY = -1;
	private static final int DELETED = -2;

	public MyHashtable(int size) {
		table = new int[size];
		m = size; 
		
		for(int i=0; i<size; i++) {
			table[i] = EMPTY;
		}
	}
	
	public boolean put(int key) {
		int index=hash(key); // index 초기 위치
		int i=index, j=1; 
		
		do {
			if(table[i] == EMPTY || table[i] == DELETED) { // 삽입 위치 발견
				table[i] = key; // key를 해시테이블에 저장
				return true;
			} 
			if(table[i] == key) { // 이미 key가 존재하는 경우
				return false;
		    }
		
			i = (index + j++) % m; // i = 다음 위치
		} while(i != index); // 현재 i가 초기 위치와 같게 되면 루프 종료
		
		return false; // 테이블 오버플로우
	}
	
	// 해시테이블에 key 값을 검색하여 인덱스를 리턴, 검색 실패시 -1 리턴
	public int search(int key) {
		int index=hash(key);
		int i=index, j=1;
		
		while(table[i] != EMPTY || table[i] != DELETED) { // 테이블 i번째가 empty 또는 deleted가 아닐 때까지
			if(table[i] == key) 
				return i; // 검색 성공
			i = (index + j++) % m; 
			if(table[i] == EMPTY) { // 테이블 i번째가 비었을 때
				return EMPTY;
			}
		}
		
		return EMPTY; // 검색 실패
	}
	
	// 해시테이블에서 key 값을 검색하고 성공 여부를 리턴
	public boolean contains(int key) {
		int index = search(key);
		return (index >= 0);
	}
	
	public boolean remove(int key) {
		int index=hash(key);
		int i=index, j=1;
		
		while(table[i] != EMPTY || table[i] != DELETED) { 
			if(table[i] == key) {
				table[i] = DELETED;
				return true;		
			}
			i = (index + j++) % m; 
			
			if(table[i] == EMPTY) { 
				return false;
			}

		}
		return false; // 삭제 실패
	}
	
	public void print() {
		System.out.println("해시 테이블 내용");
		for(int i=0; i<m; i++) {
			if(table[i] == EMPTY) {
				System.out.println("["+i+"]");
			} else if(table[i] == DELETED) {
				System.out.println("["+i+"] DELETED");
			} else {
				System.out.println("["+i+"] "+table[i]);
			}
		}
	}
	
	private int hash(int x) {
		return x % m;
	}
	
}

public class MyHashtableTest {

	public static void main(String[] args) {
		System.out.println("hw7_1: 김은우");
		
		// 해시테이블 크기(size)를 입력 받음
		Scanner scanner = new Scanner(System.in);
		System.out.print("해시테이블 크기 입력: ");
		int size = scanner.nextInt();
		
		MyHashtable studentTable = new MyHashtable(size);
		
		int menu = 0;
		do {
			System.out.print("1:삽입 2:검색 3:삭제 4:테이블 출력 5:종료 ---> ");
			menu = scanner.nextInt();
			
			switch(menu) {
			case 1:
				System.out.print("삽입할 학번(정수값)을 입력하세요: ");
				int id = scanner.nextInt();
				if(studentTable.put(id))
					System.out.println(id + " 삽입 성공");
				else
					System.out.println(id + " 삽입 실패");
				break;
			case 2:
				System.out.print("검색할 학번(정수값)을 입력하세요: ");
				id = scanner.nextInt();
				if(studentTable.contains(id))
					System.out.println(id + " 학생을 찾았습니다.");
				else
					System.out.println(id + " 학생을 찾을 수 없습니다.");
				break;
			case 3:
				System.out.print("삭제할 학번(정수값)을 입력하세요: ");
				id = scanner.nextInt();
				if(studentTable.remove(id))
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
		} while(menu!=5);
		scanner.close();
	}

}
