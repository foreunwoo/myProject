import java.util.Scanner;

public class money1 {
       public static void main(String[] args) {
	          Scanner scanner = new Scanner(System.in); //scanner ��ü ���� ��, System.in ��ü�� �̿��� ���ڸ� �Է¹���
			  System.out.print("�ݾ��� �Է��Ͻÿ�>>"); // System.out Ŭ������ ���ڿ� ��� 
			    int money = scanner.nextInt(); //scanner Ŭ������ ����ؼ� ���� �Է�
                int result=money;
				
             int [] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1}; //�迭 ����
		   String[] stringArr = {"50000�� ¥��", "10000�� ¥��", "1000�� ¥��","500�� ¥��", "100�� ¥��","50�� ¥��", "10�� ¥��", "1�� ¥��"};
             int [] moneyArr = new int[10];
			 
			 for(int i=0; i<unit.length; i++){ //for������ unit �迭 ũ�⿡ ���� �� ���� ����
             while(result >= unit[i]){
             result = result - unit[i]; //�ݾ׿��� unit �迭�� ���� �����ϴ� ��
             moneyArr[i] += 1; 
   }
  }

  for(int i=0; i<moneyArr.length; i++){ //�� �������� ��ȯ�ϱ� ���� for�� ����
   System.out.println(stringArr[i] + " : " + moneyArr[i] + "��"); //��� ���
  }
  
  
			  }
			  }