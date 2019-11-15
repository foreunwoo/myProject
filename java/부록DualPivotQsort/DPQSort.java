public class DPQSort {
	public void sort (int[] a){
		sort (a, 0, a.length-1);
	}
	private void sort(int[] a, int low, int high) {
		if (high <= low) return; 	
		int p1 = a[low];
		int p2 = a[high];	      
		if (p1 > p2){  // p1 < p2�� �ǵ���
			swap(a, low, high);
			p1 = a[low];
			p2 = a[high];
		}
		// a[low]�� ���� ���, a[high]�� ū �ǹ�
		// a[low+1]���� a[lt-1]������ ���� �ǹ����� �۰� 
		// a[gt+1]���� a[high-1]������ ū �ǹ����� ũ�� 
		int i  = low+1;   // ������Ҵ� a[i]
		int lt = low+1;    
		int gt = high-1;  
		while (i <= gt){
			if (a[i] < p1)      swap(a, i++, lt++);
			else if (p2 < a[i]) swap(a, i,   gt--);
			else       			i++;
			System.out.print("i="+i +", lt ="+lt+", gt ="+gt+" >> ");
			for(int l = 0; l < a.length; l++)
				System.out.print(a[l] + " ");			
			System.out.println();
		}
		swap(a, low,  --lt);
		swap(a, high, ++gt);
	
		for(int l = 0; l < a.length; l++)
			System.out.print(a[l] + " ");			
		System.out.println();
		
		// 3 �κ��� ���� ���ȣ��
		sort(a, low,  lt-1);
		sort(a, lt+1, gt-1);
		sort(a, gt+1, high);
	}
	
	private void swap(int[] a, int u, int v) {		
		int temp = a[u];
		    a[u] = a[v];
		    a[v] = temp;		
	}
}

