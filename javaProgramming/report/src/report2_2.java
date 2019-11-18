import java.util.Scanner;

public class report2_2 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("정수 입력>>");
		int n=scanner.nextInt();
		
		int s=0;
		for(int i=0; i<n; i++)
		for(int j=0; j<n; j++)
		{	s++; 
		 }
		
		System.out.println("1을 n번 더하고 이를 다시 n번 더한 결과 "+s);
		 System.out.print("시간 복잡도는 n^2");
	}

}
