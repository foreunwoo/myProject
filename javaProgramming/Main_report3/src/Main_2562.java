import java.util.Scanner;

class Main_2562 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a[]= new int[9]; 
		int max[] = new int[2];
		for (int i = 0; i < 9; i++) {
			a[i]=scanner.nextInt();
		}
		max[0] = a[0];

		for (int j = 1; j < 9; j++) {
			if (max[0] < a[j]) {
				max[0] = a[j];
				max[1] = j;
			}
		}
		System.out.println(max[0]);
		System.out.print(max[1]+1);

	 scanner.close();
	}
	
	}


