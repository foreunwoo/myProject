import java.util.*;

public class Main_4344 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int test_num = input.nextInt();
		input.nextLine();
		// �׽�Ʈ ���̽� ����
		double[] ratios = new double[test_num];
		// �׽�Ʈ ���̽� ������ŭ ������ �޸𸮿� ������ �迭 ����
		
		for(int i=0 ; i<test_num ; i++) {
			String std_scores = input.nextLine();
			// �� ��° �ٺ��� �Էµ� �л� ���� �л� ����ŭ�� ����
			
			String[] values = std_scores.split(" ");
			// ������ �������� ���ڿ��� �ڸ��� �л� ���� ������ �������� values�迭�� String������ ����ȴ�.
			
			if (1 <= Integer.parseInt(values[0]) && Integer.parseInt(values[0]) <= 1000) {
				//values[0] : �л� ��
				int sum = 0;	// ������ ���� ����
				int over_avg_std = 0;	// ������ ��պ��� ���� �л� ���� ��Ÿ���� ����
				
				for(int j=1 ; j<values.length ; j++) {
					sum += Integer.parseInt(values[j]);
				}
				// ������ ���� ���ϱ�
				double avg = sum / (double) Integer.parseInt(values[0]);
				// ��ձ��ϱ�
				for(int j=1 ; j<values.length ; j++) {
					if (Integer.parseInt(values[j]) > avg)
						over_avg_std++;
				}
				// ������ ��պ��� ���� �л� �� ���ϱ�
				
				ratios[i] = Math.round(( over_avg_std / (double) Integer.parseInt(values[0])  * 100) * 1000) / 1000.0 ;
				// ����� �Ѵ� �л����� ����(%)�� �迭�� ����
			}else {
				System.out.println("error");
				break;
			}
			
		}
		
		for(double val : ratios) {
			System.out.printf("%.3f%%\n",val);
		}
		// �� ���̽����� �� �پ� ����� �Ѵ� �л����� ������ �ݿø��Ͽ� �Ҽ��� ��° �ڸ����� ���
	}
}