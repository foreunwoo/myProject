import java.util.Scanner;

public class Quiz { 
	public static void number(int n) {
		int a[] = {-30, -15, 1, 40, 50, 200, 315, 800, 9000, 12345}; // ���� �迭
		int score = 100; // ����
		int max = -30; // ���� �ִ�
		int min = 12345; // ���� �ּڰ�
		
		for(int i=0; i<a.length; i++) { 
			if(n > a[i]) { // �迭 ���� �� n���� ���� �� ã��
				if(max < a[i]) { //ã�� ���� �� ���� ū �� ã��
					max=a[i];
				}
			} else if(n < a[i]) {
				if(min > a[i]) { // �迭 ���� �� n���� ū ���ҵ� ã��
					min=a[i]; // ã�� ���� �� ���� ���� �� ã��
				}
			} else {
				System.out.println("���� = "+ 100); //�Է��� ���� �迭�� ���ҿ� ���� ���
			}
		} 
		
		int result = max-n; // n���� ���� ���� �� ���� ū ���� ã�� n�� �� ��� ����
		int result2 = min-n; // n���� ū ���� �� ���� ���� ���� ã�� n�� �� ��� ����
		System.out.println(max);
		System.out.println(min);
		
		int re = Math.min(result,result2); //�� ���� �� ���� ���� ������
		
		if(re > 0) { // ������ ������ ���� 0���� Ŭ ��� 100���� �� ����� score�� ����
		   score = 100 - re; 
		   if(score > 100) { // 100 �̻� ���̳� ��� 0��
			   System.out.println("����@ = "+ 0);
		   } else {
		   System.out.println("����1 = "+ score);
		   }
		} else { // 0���� ���� ��� 100�� ���� ���� score�� ����
			score = 100 + re;
			if(score < -1) { // // 100 �̻� ���̳� ��� 0��
				   System.out.println("����# = "+ 0);
			   } else {
	       System.out.println("����2 = "+ score);
			   }
		}
	} 
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("hw0_1 : ������");
		System.out.println("���� ���߱� ���α׷��Դϴ�.");
		System.out.print("�ϳ��� �������� �Է��ϼ���: ");
		int n = scanner.nextInt();
		
		number(n);  
	}
}
