import java.util.Scanner;

public class DicApp{
	public static void main(String [] args) {
		 Scanner scanner = new Scanner(System.in); 
     System.out.println("�ѿ� �ܾ� �˻� ���α׷��Դϴ�.");
     String word = ""; 
     String eng = ""; 

     while(true) { //���� �ݺ��ϴ� while�� �ۼ�
 System.out.print("�ѱ� �ܾ�?");
 word = scanner.nextLine(); //�ܾ� �Է�
 
 if(word.equals("�׸�")) { //"�׸�"�� �Է� �Ǹ� �ݺ� ����
	 break; //if������ ����� ���� ����
 }
 eng = Dictionary.kor2Eng(word); 
 
 if( eng == null ) { //�迭�� ���� ���� �Է��� ����� ���ǽ�
 System.out.println(word + "�� ���� ������ �����ϴ�."); 
} 
else { //��� ���
System.out.println(word + "�� " + eng); 
} 
     }
     scanner.close();
}
}