//***************************
//���ϸ�: PebbleTest
//�ۼ���: 201814011 ������
//�ۼ���: 2020-05-23
//����: [hw8_2] ���� ���α׷���
//***************************

public class PebbleTest {
	static int n = 5; // ���̺� ���� ��
	static int w [][] = { 
			{ 5, 3, -20, 10, 10},
			{ 2, 5, 10, 5, -5},
			{10, 6, 1, -10, 5} 
			};
	
	private static int Pebble(int k, int p) {
		int max, tmp = 0;
		int q;
		
		if(k==0) return Weight(k, p);
		else {
			max = -999;
			for(q=0; q<4; q++) {
				if(Compare(p, q)) { // ���� p�� q�� ��
					tmp = Pebble(k-1, q);
					if(tmp > max)
						max = tmp;
				}
			}
		}
		return max + Weight(k, p);
	}
	
	private static boolean Compare(int op, int cp) {
		if(op == 0) { // ���� 1���� ���
			if(cp == 1 || cp == 2) // �縳 ������ ���� 2, 3
				return true;
			else
				return false;
		} else if(op == 1) { // ���� 2���� ���
			if(cp == 0 || cp == 2 || cp == 3) // �縳 ������ ���� 1, 3, 4
				return true;
			else 
				return false;
		} else if(op == 2) { // ���� 3���� ���
			if(cp == 0 || cp == 1) // �縳 ������ ���� 1, 2
				return true;
			else 
				return false;
		} else if(op == 3) { // ���� 4���� ���
			if(cp == 1) // �縳 ������ ���� 2
				return true;
			else
				return false;
		} else {
			return false;
		}
	}
	
	private static int Weight(int k, int p) {
		if(p < 3) // 4�� ������ 1, 2, 3 ������ ���
			return w[p][k];
		else // ���� 4�� ���, 1, 3���� ����
			return w[0][k] + w[2][k];
	}
	

	public static void main(String[] args) {
		System.out.println("hw8_2: ������");
		
		int value, max = -999;
		for(int p=0; p<4; p++) {
			value = Pebble(n-1, p); 
			if(max < value)
				max = value; // �ִ� ����
		}
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<n; j++) 
				System.out.print(w[i][j]+" "); // ���̺� ���
			System.out.println();			
		}
		
		System.out.println();
		System.out.println("�ִ� ����= "+max);
	}

}
