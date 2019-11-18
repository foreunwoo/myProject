import java.util.Scanner;

class Main_2739 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int n = sc.nextInt();
		
		int s=0;
		for(int i=1; i<10; i++) {
			s=n*i;
			System.out.println(n+" * "+i+" = "+s);
		}
		sc.close();
	}
	
}
