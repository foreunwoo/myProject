import java.util.Scanner;

public class Main_2839 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		  int big = num / 5 ;
	        int a = num % 5 ;
	        int small = 0 ;
	        
	        switch(a) {
	        case 1 : big-- ; small =2; break;
	        case 2 : big-=2 ; small =4; break;
	        case 3 : small =1  ; break;
	        case 4 : big -- ; small =3; break;    
	        }
	        
	        if (big < 0) {
	            System.out.println("-1");
	            return;
	        }
	        
	        System.out.println(big+small);

	
}

}
