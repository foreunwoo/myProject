import java.util.*;

public class Main_4344 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int test_num = input.nextInt();
		input.nextLine();
		// 테스트 케이스 개수
		double[] ratios = new double[test_num];
		// 테스트 케이스 개수만큼 비율을 메모리에 저장할 배열 선언
		
		for(int i=0 ; i<test_num ; i++) {
			String std_scores = input.nextLine();
			// 두 번째 줄부터 입력될 학생 수와 학생 수만큼의 점수
			
			String[] values = std_scores.split(" ");
			// 공백을 기준으로 문자열을 자르면 학생 수와 각각의 점수들이 values배열에 String형으로 저장된다.
			
			if (1 <= Integer.parseInt(values[0]) && Integer.parseInt(values[0]) <= 1000) {
				//values[0] : 학생 수
				int sum = 0;	// 점수의 총합 변수
				int over_avg_std = 0;	// 점수가 평균보다 높은 학생 수를 나타내는 변수
				
				for(int j=1 ; j<values.length ; j++) {
					sum += Integer.parseInt(values[j]);
				}
				// 점수의 총합 구하기
				double avg = sum / (double) Integer.parseInt(values[0]);
				// 평균구하기
				for(int j=1 ; j<values.length ; j++) {
					if (Integer.parseInt(values[j]) > avg)
						over_avg_std++;
				}
				// 점수가 평균보다 높은 학생 수 구하기
				
				ratios[i] = Math.round(( over_avg_std / (double) Integer.parseInt(values[0])  * 100) * 1000) / 1000.0 ;
				// 평균을 넘는 학생들의 비율(%)을 배열에 저장
			}else {
				System.out.println("error");
				break;
			}
			
		}
		
		for(double val : ratios) {
			System.out.printf("%.3f%%\n",val);
		}
		// 각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력
	}
}