import java.util.Scanner;

public class Main_11720 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int sum=0;
		String s = scanner.next();
		
        for(int i=0; i<n; i++) {
        	
        	sum += s.charAt(i)-'0'; 
        	
        }
        
        System.out.println(sum);
	}

}
