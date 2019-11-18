import java.util.Scanner;

class Main_8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());
		int[] sum = new int[n];
		
		for (int i = 0; i < n; i++) {
			char[] ox = sc.nextLine().toCharArray();
			int[] score = new int[ox.length];

			if (ox[0] == 'O')
				sum[i] = score[0] = 1;

			for (int j = 1; j < ox.length; j++) {
				if (ox[j] == 'O') {
					score[j] = score[j - 1] + 1;
					sum[i] += score[j];
				}
				else score[j] = 0;
			}
			System.out.println(sum[i]);
		}
		sc.close();
	}
}

