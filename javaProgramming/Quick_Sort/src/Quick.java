import java.lang.Comparable;

public class Quick {
	public static int count=0;
	public static int count2=0;
	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int low, int high) {
		if (high <= low)
			return;
		int j = partition(a, low, high);
		sort(a, low, j - 1); // 피벗보다 작은 부분을 재귀호출
		
		sort(a, j + 1, high); // 피벗보다 큰 부분을 재귀호출
		
	}

	public static int partition(Comparable[] a, int pivot, int high) {
		
		int i = pivot + 1;
		int j = high;

		Comparable p = a[pivot];                                                       
		while (true) {
			while (i < high && isless(a[i], p))
				i++;
			System.out.print("left: ");
			for (int k = 0; k < a.length; k++) {
				
				System.out.printf(a[k]+"  ");
				
			}
			System.out.println("");
			// 피벗보다 작으면 i++
			while (j > pivot && isless(p, a[j]))
				j--; 
			System.out.print("right: ");
			for (int k = 0; k < a.length; k++) {
				
				System.out.printf(a[k]+"  ");
				
			}
			
			System.out.println("");
			count2++;
			// 피벗보다 크면 j--
			if (i >= j)
				break; // i와 j가 교차되면 루프 나가기
			swap(a, i, j);
			
		}
		
		
		swap(a, pivot, j); // 피벗과 a[j] 교환
		
		return j; // a[j]의 피벗이 "영원히" 자리 잡은 곳
		
	}

	private static boolean isless(Comparable u, Comparable v) {
		count++;
		return (u.compareTo(v) < 0);
		
	}

	private static void swap(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	public static void main(String[] args) {
		String a[] = {"3","4","5","1","2"};//String a[] = {"1","2","3","4","5"};
		Quick.sort(a);
		System.out.print("정렬 결과: ");
		for (int i = 0; i < a.length; i++) {
			System.out.printf(a[i]+"  ");
		}
		System.out.println("");
		System.out.println("이동 횟수 : "+count2);	
		System.out.print("비교 횟수 : "+count);	
		}
}
