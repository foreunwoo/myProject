import java.util.Scanner;

public class Quiz { 
	public static void number(int n) {
		int a[] = {-30, -15, 1, 40, 50, 200, 315, 800, 9000, 12345}; // 정수 배열
		int score = 100; // 점수
		int max = -30; // 현재 최댓값
		int min = 12345; // 현재 최솟값
		
		for(int i=0; i<a.length; i++) { 
			if(n > a[i]) { // 배열 원소 중 n보다 작은 값 찾기
				if(max < a[i]) { //찾은 원소 중 가장 큰 값 찾기
					max=a[i];
				}
			} else if(n < a[i]) {
				if(min > a[i]) { // 배열 원소 중 n보다 큰 원소들 찾기
					min=a[i]; // 찾은 원소 중 가장 작은 값 찾기
				}
			} else {
				System.out.println("점수 = "+ 100); //입력한 값이 배열의 원소와 같을 경우
			}
		} 
		
		int result = max-n; // n보다 작은 원소 중 가장 큰 값을 찾아 n을 뺀 결과 대입
		int result2 = min-n; // n보다 큰 원소 중 가장 작은 값을 찾아 n을 뺀 결과 대입
		System.out.println(max);
		System.out.println(min);
		
		int re = Math.min(result,result2); //두 인자 중 작은 값을 대입함
		
		if(re > 0) { // 위에서 리턴한 값이 0보다 클 경우 100에서 뺀 결과를 score에 삽입
		   score = 100 - re; 
		   if(score > 100) { // 100 이상 차이날 경우 0점
			   System.out.println("점수@ = "+ 0);
		   } else {
		   System.out.println("점수1 = "+ score);
		   }
		} else { // 0보다 작을 경우 100을 더한 값을 score에 삽입
			score = 100 + re;
			if(score < -1) { // // 100 이상 차이날 경우 0점
				   System.out.println("점수# = "+ 0);
			   } else {
	       System.out.println("점수2 = "+ score);
			   }
		}
	} 
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("hw0_1 : 김은우");
		System.out.println("숫자 맞추기 프로그램입니다.");
		System.out.print("하나의 정수값을 입력하세요: ");
		int n = scanner.nextInt();
		
		number(n);  
	}
}
