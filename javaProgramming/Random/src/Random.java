public class Random {
     public static void main(String[] args) {
    	 int intArray [][] = new int[4][4]; //4*4�� 2���� �迭 ����
    	 
    	 for(int ten=0; ten<10;) { //ten�� 10���� ���� ������ �ݺ�
    		int i = (int)(Math.random()*4); //0~3������ ���� �߻�
    		int j = (int)(Math.random()*4);
    	if(intArray[i][j]==0) { //�����ϰ� 0~3������ ���� �迭�� 0�� ���ٸ�
    		ten++; //ten�� 1 ������Ű��
    	 
		intArray[i][j] = (int)(Math.random()*10+1); //�迭�� 1~10������ ������ ����
    	 }
    	 }
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++)
			System.out.print(intArray[i][j]+" ");
			System.out.println(); //�迭 ���
		}
		
	}

}
