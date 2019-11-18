import java.util.Scanner;

public class Score {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    
		String course [] = {"Java", "C++", "HTML5", "컴퓨터구조", "안드로이드"};
	    int score [] = {95, 88, 76, 62, 55};
	
	    while(true) { //무한 반복하는 while문 작성
	    System.out.print("과목 이름>>");
	    String name = scanner.next(); //과목 입력
	    
	    if(name.equals("그만")) { //"그만"이 입력되면 반복 종료
	    	break; //if문으로 벗어나는 조건을 만듦
	    }
	 else {
	    int tmp=-1; 
	    for(int i=0; i<course.length; i++) { 
      if(course[i].equals(name)) { //string 클래스의 equals() 메소드를 이용해 입력 값과 배열 값 비교 
 tmp = score[i]; 
 break;
            }
	    }
	    if(tmp==-1) { //배열에 없는 값을 입력할 경우의 조건식
	    	System.out.println("없는 과목입니다."); 
	    }
	    else { //점수 출력
	    	System.out.println(name+"의 점수는"+" "+tmp); 
	    }
	    
 }
	    }
	    scanner.close();
}

}