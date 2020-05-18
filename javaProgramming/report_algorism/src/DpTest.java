import java.util.Scanner;

public class DpTest {
	public int matrixPath(int n) {
		int [][] c = {};
		
		for(int i=0; i<n; i++) {
			c[i][0] = 0;
		}
		for(int j=1; j<n; j++) {
			c[0][j] = 0;
		}
		/*for(int i=1; i<n; i++) {
			for(int j=1; j<n; j++) {
				c[i][j] = 
			}
		} */
		
		return c[n][n];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("hw8_1: 김은우");
		System.out.print("행의 크기 입력 : ");
		int size = scanner.nextInt();
		
		int [][] table = new int [size][size]; 
		int n = table.length;
		
		System.out.println(size+"x"+size+"크기의 행렬 원소 입력 :");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) 
				table[i][j] = scanner.nextInt();
		}

		System.out.print("최대 점수 = ");
		scanner.close();
	}

}
