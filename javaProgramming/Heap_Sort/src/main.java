public class main {
	public static void main(String[] args) {
		String a[] = {" ","90","60","80","50","30","40","70","10","20"};	
		Heap.sort(a);
		System.out.println("정렬 결과: ");
		for (int i = 1; i < a.length; i++) {
			System.out.printf(a[i]+"  ");
			
		}
		
	}
}