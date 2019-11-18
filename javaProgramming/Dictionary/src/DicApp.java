import java.util.Scanner;

public class DicApp{
	public static void main(String [] args) {
		 Scanner scanner = new Scanner(System.in); 
     System.out.println("한영 단어 검색 프로그램입니다.");
     String word = ""; 
     String eng = ""; 

     while(true) { //무한 반복하는 while문 작성
 System.out.print("한글 단어?");
 word = scanner.nextLine(); //단어 입력
 
 if(word.equals("그만")) { //"그만"이 입력 되면 반복 종료
	 break; //if문으로 벗어나는 조건 만듦
 }
 eng = Dictionary.kor2Eng(word); 
 
 if( eng == null ) { //배열에 없는 값을 입력할 경우의 조건식
 System.out.println(word + "는 저의 사전에 없습니다."); 
} 
else { //결과 출력
System.out.println(word + "는 " + eng); 
} 
     }
     scanner.close();
}
}