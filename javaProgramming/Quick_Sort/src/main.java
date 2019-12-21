public class main {
	public static void main(String[] args) {
		String a[] = {"1","2","3","4","5"};//String a[] = {"1","2","3","4","5"};
		Quick.sort(a);
		System.out.print("정렬 결과: ");
		for (int i = 0; i < a.length; i++) {
			System.out.printf(a[i]+"  ");
		}
			
		}
	}

//최상의 경우 String a[] = {"3","1","2","4","5"};
//최악의 경우 String a[] = {"1","2","3","4","5"};