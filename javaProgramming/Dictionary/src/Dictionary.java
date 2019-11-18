import java.util.Scanner;

class Dictionary {
     private static String [] kor = { "사랑", "아기", "돈", "미래", "희망"};
     private static String [] eng = {"love","baby","money","future","hope"};
     public static String kor2Eng(String word) {
    	  for(int i=0 ; i<kor.length; i++) { 
          if( kor[i].equals(word) ) { //equals() 메소드를 이용해 입력 값과 배열 값 비교 
            return eng[i]; 
 }
    		    } 
return null; 
	  } 
}

