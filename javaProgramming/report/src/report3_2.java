import java.util.Scanner;

public class report3_2 { //피보나치 순환
	public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	    System.out.print("정수 : ");
	    int n = sc.nextInt();
	    fibonacci(n);
	  
	    System.out.println(fibonacci(n));
	    System.out.printf("시간복잡도 2^n");
	}

	static int fibonacci(int n) {
		 if(n==0) {
		      return 0;
		   } else if(n==1) {
			   return 1;
		   } 
		 else {
		      return (fibonacci(n-1) + fibonacci(n-2));
		   }
		
	}

}
