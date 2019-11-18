import java.util.*;

public class Main_1157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
         String eng = sc.nextLine(); //입력받은 단어를 저장할 String 변수
         
         char[] alphabet= new char[52]; //알파벳 배열 크기 52 (대문자 26, 소문자 26)
         int[] count = new int [alphabet.length]; //각 알파벳의 사용 횟수 카운트
         int max=0; //제일 많이 사용된 알파벳
         
         for (int i = 0 ; i < alphabet.length ; i++)
         {
          if (i < 26)
           alphabet[i] = (char)(i + 65);  // 대문자 저장 - 대문자는 아스키 코드 65부터 26개
          else
           alphabet[i] = (char)(i + 71);  // 소문자 저장 - 소문자는 아스키 코드 97부터 26개
         }
         
      // 카운트 시작
         for (int i = 0 ; i < eng.length() ; i++)   // 단어의 길이만큼 반복
         {
          for (int j = 0 ; j < alphabet.length ; j++)  // 알파벳 배열의 크기만큼 반복
          {
           if (eng.charAt(i) == alphabet[j])   // 입력받은 단어의 i번째 원소와 알파벳 배열의 j번째 알파벳과 같은 경우
           {
            count[j]++;        // 카운트 배열의 j번째 카운트를 1 증가
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
