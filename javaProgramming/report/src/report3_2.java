import java.util.Scanner;

public class report3_2 { //�Ǻ���ġ ��ȯ
	public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	    System.out.print("���� : ");
	    int n = sc.nextInt();
	    fibonacci(n);
	  
	    System.out.println(fibonacci(n));
	    System.out.printf("�ð����⵵ 2^n");
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
