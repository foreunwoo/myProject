import java.util.Scanner;

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
			for(int j=0; j<n; j++) 
				table[i][j] = scanner.nextInt();
		}
		cache[0][0] = table[0][0];
		
		System.out.println("");
		System.out.print("최대 점수 = "+matrixPath(table, n-1, n-1, cache));
		scanner.close();
	}
	
	
	private static int matrixPath(int c [][], int i, int j, int cache [][]) {
		if(i==0 && j==0) return cache[0][0];
		
		if(i==0) {
			cache[i][j] = (cache[0][j-1] != 0) ? (cache[0][j-1] + c[0][j])
					: (matrixPath(c, 0, j-1, cache) + c[0][j]);
			return cache[i][j];
		}
		
		if(j==0) {
			cache[i][j] = (cache[i-1][0] != 0) ? (cache[i-1][0] + c[i][0])
					: (matrixPath(c, i-1, 0, cache) + c[i][0]);
			return cache[i][j];
		}
		
		int a = (cache[i-1][j] != 0) ? (cache[i-1][j]) : (matrixPath(c, i-1, j, cache));
		int b = (cache[i][j-1] != 0) ? (cache[i][j-1]) : (matrixPath(c, i, j-1, cache));
		cache[i][j] = Math.max(a, b) + c[i][j];
		return cache[i][j];
	}
}


























