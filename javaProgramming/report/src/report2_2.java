import java.util.Scanner;

public class report2_2 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("���� �Է�>>");
		int n=scanner.nextInt();
		
		int s=0;
		for(int i=0; i<n; i++)
		for(int j=0; j<n; j++)
		{	s++; 
		 }
		
		System.out.println("1�� n�� ���ϰ� �̸� �ٽ� n�� ���� ��� "+s);
		 System.out.print("�ð� ���⵵�� n^2");
	}

}
