import java.util.Scanner;

public class report2_1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		 System.out.print("정수를 입력하세요>>");
		 int n=scanner.nextInt();
		 
		 int s=0;
		 for(int i=0; i<n; i++)
			 s+=n;
		 
		 System.out.println("제곱 값은 "+s);
		 System.out.print("시간복잡도는 n");
			 

	}

}
