import java.util.*;

public class Main_1157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
         String eng = sc.nextLine(); //�Է¹��� �ܾ ������ String ����
         
         char[] alphabet= new char[52]; //���ĺ� �迭 ũ�� 52 (�빮�� 26, �ҹ��� 26)
         int[] count = new int [alphabet.length]; //�� ���ĺ��� ��� Ƚ�� ī��Ʈ
         int max=0; //���� ���� ���� ���ĺ�
         
         for (int i = 0 ; i < alphabet.length ; i++)
         {
          if (i < 26)
           alphabet[i] = (char)(i + 65);  // �빮�� ���� - �빮�ڴ� �ƽ�Ű �ڵ� 65���� 26��
          else
           alphabet[i] = (char)(i + 71);  // �ҹ��� ���� - �ҹ��ڴ� �ƽ�Ű �ڵ� 97���� 26��
         }
         
      // ī��Ʈ ����
         for (int i = 0 ; i < eng.length() ; i++)   // �ܾ��� ���̸�ŭ �ݺ�
         {
          for (int j = 0 ; j < alphabet.length ; j++)  // ���ĺ� �迭�� ũ�⸸ŭ �ݺ�
          {
           if (eng.charAt(i) == alphabet[j])   // �Է¹��� �ܾ��� i��° ���ҿ� ���ĺ� �迭�� j��° ���ĺ��� ���� ���
           {
            count[j]++;        // ī��Ʈ �迭�� j��° ī��Ʈ�� 1 ����
            break;
           }
           
          }
          if(max > count[i]) {
         	 max = count[i];
          }
          
          System.out.print(max);
         }
       

	}

}
