import java.util.Scanner;

public class report3_1 { //�Ǻ���ġ �ݺ�
	public static void main(String[] args) {
	int num1 = 1;
    int num2 = 0;
    int num3 = 0;

    Scanner sc = new Scanner(System.in);
    System.out.print("���� : ");
    int count = sc.nextInt();

    for(int i = 0; i < count; i++) {

        num2 = num3;
        num3 = num1;
        num1 = num2 + num3;

        System.out.print(num3);
        System.out.println();
    }
    
   
    System.out.println("�ð� ���⵵�� o(n)");

}
}
