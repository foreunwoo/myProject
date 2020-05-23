//***************************
//파일명: PebbleTest
//작성자: 201814011 김은우
//작성일: 2020-05-23
//내용: [hw8_2] 동적 프로그래밍
//***************************

public class PebbleTest {
	static int n = 5; // 테이블 행의 수
	static int w [][] = { 
			{ 5, 3, -20, 10, 10},
			{ 2, 5, 10, 5, -5},
			{10, 6, 1, -10, 5} 
			};
	
	private static int Pebble(int k, int p) {
		int max, tmp = 0;
		int q;
		
		if(k==0) return Weight(k, p);
		else {
			max = -999;
			for(q=0; q<4; q++) {
				if(Compare(p, q)) { // 패턴 p와 q를 비교
					tmp = Pebble(k-1, q);
					if(tmp > max)
						max = tmp;
				}
			}
		}
		return max + Weight(k, p);
	}
	
	private static boolean Compare(int op, int cp) {
		if(op == 0) { // 패턴 1번일 경우
			if(cp == 1 || cp == 2) // 양립 가능한 패턴 2, 3
				return true;
			else
				return false;
		} else if(op == 1) { // 패턴 2번일 경우
			if(cp == 0 || cp == 2 || cp == 3) // 양립 가능한 패턴 1, 3, 4
				return true;
			else 
				return false;
		} else if(op == 2) { // 패턴 3번일 경우
			if(cp == 0 || cp == 1) // 양립 가능한 패턴 1, 2
				return true;
			else 
				return false;
		} else if(op == 3) { // 패턴 4번일 경우
			if(cp == 1) // 양립 가능한 패턴 2
				return true;
			else
				return false;
		} else {
			return false;
		}
	}
	
	private static int Weight(int k, int p) {
		if(p < 3) // 4를 제외한 1, 2, 3 패턴일 경우
			return w[p][k];
		else // 패턴 4일 경우, 1, 3행을 더함
			return w[0][k] + w[2][k];
	}
	

	public static void main(String[] args) {
		System.out.println("hw8_2: 김은우");
		
		int value, max = -999;
		for(int p=0; p<4; p++) {
			value = Pebble(n-1, p); 
			if(max < value)
				max = value; // 최대 점수
		}
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<n; j++) 
				System.out.print(w[i][j]+" "); // 테이블 출력
			System.out.println();			
		}
		
		System.out.println();
		System.out.println("최대 점수= "+max);
	}

}
