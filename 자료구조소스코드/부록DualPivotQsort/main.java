public class main {
	public static void main(String[] args) {
		DPQSort dpqs = new DPQSort();
		int[] a = {30, 90, 80, 20, 50, 40, 10, 70, 60};		
		System.out.println("���� ��");
		print(a);
		
		dpqs.sort(a); // ���� ȣ��
		
		System.out.println("���� ��");
		print(a);
	}	
	
	static void print(int[] a) { // �迭 ���
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");			
		System.out.println();
	}
}
