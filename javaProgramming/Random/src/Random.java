public class Random {
     public static void main(String[] args) {
    	 int intArray [][] = new int[4][4]; //4*4의 2차원 배열 생성
    	 
    	 for(int ten=0; ten<10;) { //ten이 10보다 작을 때까지 반복
    		int i = (int)(Math.random()*4); //0~3까지의 난수 발생
    		int j = (int)(Math.random()*4);
    	if(intArray[i][j]==0) { //랜덤하게 0~3까지의 난수 배열이 0과 같다면
    		ten++; //ten을 1 증가시키고
    	 
		intArray[i][j] = (int)(Math.random()*10+1); //배열에 1~10까지의 난수를 저장
    	 }
    	 }
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++)
			System.out.print(intArray[i][j]+" ");
			System.out.println(); //배열 출력
		}
		
	}

}
