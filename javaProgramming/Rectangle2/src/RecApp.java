import java.util.Scanner;

public class RecApp {
public static void main(String[] args) {
		Rectangle rect = new Rectangle();
		Scanner scanner=new Scanner(System.in);
		System.out.print(">>");
		rect.width=scanner.nextInt();
		rect.height=scanner.nextInt();
		
		
		System.out.print("�簢���� ������ "+rect.getArea());
		
		scanner.close();
	}

}
