import java.util.*;
public class ArrayListTest {

	public static void main(String[] args) {
		//문자만 삽입 가능한 Character형의 ArrayList 생성
		ArrayList<Character> a = new ArrayList<Character>(); 
		Scanner scanner = new Scanner(System.in); //Scanner 객체 생성
		
		// 키보드로부터 6개의 문자를 입력받아 ArrayList에 삽입
		System.out.print("6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/F)>>");
		for(int i=0; i<6; i++) {
			String s = scanner.next(); //키보드로부터 문자를 입력
			if(s.length() > 1) {
				System.out.println("Not character");
				scanner.close();
				return;
			}
			char ch = s.charAt(0);
			if((ch >= 'A' && ch <= 'D') || ch == 'F')
				a.add(ch); //ArrayList 컬렉션에 삽입
			else {
				System.out.println("Invalid");
				scanner.close();
				return;
			}
		}
		
		//학점을 점수로 변환하는 for문과 switch문 생성
		double score=0.0;
		for(int i=0; i<a.size(); i++) {
			char ch = a.get(i);
			switch(ch) {
				case 'A' : score += 4.0; break;
				case 'B' : score += 3.0; break;
				case 'C' : score += 2.0; break;
				case 'D' : score += 1.0; break;
				case 'F' : score += 0.0; break;			
			}
		}
		//평균 점수 출력
		System.out.print(score/a.size());
		scanner.close();
	}

}
