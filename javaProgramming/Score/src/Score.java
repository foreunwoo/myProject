import java.util.Scanner;

public class Score {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    
		String course [] = {"Java", "C++", "HTML5", "��ǻ�ͱ���", "�ȵ���̵�"};
	    int score [] = {95, 88, 76, 62, 55};
	
	    while(true) { //���� �ݺ��ϴ� while�� �ۼ�
	    System.out.print("���� �̸�>>");
	    String name = scanner.next(); //���� �Է�
	    
	    if(name.equals("�׸�")) { //"�׸�"�� �ԷµǸ� �ݺ� ����
	    	break; //if������ ����� ������ ����
	    }
	 else {
	    int tmp=-1; 
	    for(int i=0; i<course.length; i++) { 
      if(course[i].equals(name)) { //string Ŭ������ equals() �޼ҵ带 �̿��� �Է� ���� �迭 �� �� 
 tmp = score[i]; 
 break;
            }
	    }
	    if(tmp==-1) { //�迭�� ���� ���� �Է��� ����� ���ǽ�
	    	System.out.println("���� �����Դϴ�."); 
	    }
	    else { //���� ���
	    	System.out.println(name+"�� ������"+" "+tmp); 
	    }
	    
 }
	    }
	    scanner.close();
}

}