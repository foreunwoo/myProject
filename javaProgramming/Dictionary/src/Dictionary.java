import java.util.Scanner;

class Dictionary {
     private static String [] kor = { "���", "�Ʊ�", "��", "�̷�", "���"};
     private static String [] eng = {"love","baby","money","future","hope"};
     public static String kor2Eng(String word) {
    	  for(int i=0 ; i<kor.length; i++) { 
          if( kor[i].equals(word) ) { //equals() �޼ҵ带 �̿��� �Է� ���� �迭 �� �� 
            return eng[i]; 
 }
    		    } 
return null; 
	  } 
}

