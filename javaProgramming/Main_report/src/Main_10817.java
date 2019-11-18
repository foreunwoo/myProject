import java.util.Scanner;

class Main_10817 {
	
	
	public static void main(String [] args) {
		 
		Scanner sc = new Scanner(System.in); 
	System.out.println("세 개의 정수 입력");
	int a = sc.nextInt();
	int b = sc.nextInt();
	int c = sc.nextInt();

	if(a>b) {
		if(b>c)
		System.out.print(b); 
		else {
			if(a<c)
				System.out.print(a);
			else System.out.print(c);	
				}
		} else if(a==b){
		System.out.print(+a);
	} else {
		if(b<c)
			System.out.print(b);
		else if(b>c) {
			if(a<c)
			System.out.print(c); 
			else if(a>=c)
				System.out.print(a); 
		}
		else System.out.print(b);
	}
	
	sc.close();
}
	
}