import java.util.Scanner;

//***************************
//파일명: DpTest
//작성자: 201814011 김은우
//작성일: 2020-05-23
//내용: [hw8_1] 행렬 경로 문제
//***************************

public class DpTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("hw8_1: 김은우");
		System.out.print("행의 크기 입력 : ");
		int size = scanner.nextInt();
		
		int [][] table = new int [size][size]; 
		int [][] cache = new int [size][size];
		int n = table.length;
		
		System.out.println(size+" x "+size+" 크기의 행렬 원소 입력 :");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				table[i][j] = scanner.nextInt();
			}
		}
		cache[0][0] = table[0][0];
		
		System.out.println("");
		System.out.println("최대 점수 = "+matrixPath(table, n-1, n-1, cache));
		
		scanner.close();
	}
	
	
	private static int matrixPath(int c [][], int i, int j, int cache [][]) {
		if(i==0 && j==0) return cache[0][0]; // i와 j 둘 다 0일 경우 i, j 반환
		
		if(i==0) { // i가 0일 경우
			cache[i][j] = (cache[0][j-1] != 0) ? (cache[0][j-1] + c[0][j]) // 계산된 결과값을 캐시에 저장
					: (matrixPath(c, 0, j-1, cache) + c[0][j]);
			
			return cache[i][j]; // 캐시에 저장된 값을 리턴
		}
		
		if(j==0) { // j가 0일 경우
			cache[i][j] = (cache[i-1][0] != 0) ? (cache[i-1][0] + c[i][0])
					: (matrixPath(c, i-1, 0, cache) + c[i][0]);
			
			return cache[i][j];
		}
		
		int a = (cache[i-1][j] != 0) ? (cache[i-1][j]) : (matrixPath(c, i-1, j, cache));
		int b = (cache[i][j-1] != 0) ? (cache[i][j-1]) : (matrixPath(c, i, j-1, cache));
		cache[i][j] = Math.max(a, b) + c[i][j]; // 최대 점수
		
		return cache[i][j];
	}
	
	 
}

