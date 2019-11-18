import java.util.Scanner;

public class money1 {
       public static void main(String[] args) {
	          Scanner scanner = new Scanner(System.in); //scanner 객체 생성 후, System.in 객체를 이용해 문자를 입력받음
			  System.out.print("금액을 입력하시오>>"); // System.out 클래스로 문자열 출력 
			    int money = scanner.nextInt(); //scanner 클래스를 사용해서 정수 입력
                int result=money;
				
             int [] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1}; //배열 생성
		   String[] stringArr = {"50000원 짜리", "10000원 짜리", "1000원 짜리","500원 짜리", "100원 짜리","50원 짜리", "10원 짜리", "1원 짜리"};
             int [] moneyArr = new int[10];
			 
			 for(int i=0; i<unit.length; i++){ //for문으로 unit 배열 크기에 맞춰 돈 갯수 세기
             while(result >= unit[i]){
             result = result - unit[i]; //금액에서 unit 배열의 값을 차감하는 식
             moneyArr[i] += 1; 
   }
  }

  for(int i=0; i<moneyArr.length; i++){ //각 동전으로 변환하기 위한 for문 생성
   System.out.println(stringArr[i] + " : " + moneyArr[i] + "개"); //결과 출력
  }
  
  
			  }
			  }