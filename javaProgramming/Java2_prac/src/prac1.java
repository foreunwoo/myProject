import java.util.Arrays;
import java.lang.String;

public class prac1 {
	static Object [] obj1;
	static Object [] obj2;
	
	public static void addData(int count) {
		obj1 = new Object[count];
		obj2 = new Object[count];
		
		for(int i=0; i<count; i++) {
			obj1[i]= new Integer(i+1);
		}
		
		for(int i=0; i<count; i++) {
			obj2[i]= String.valueOf(i+1);
		}
	}
	
	public static int findIndex(int value) {
		int index = Arrays.asList(obj1).indexOf(value);
		return index;
	}
	
	public static int findIndex(String value) {
		int index = Arrays.asList(obj2).indexOf(String.valueOf(value));
		return index;
	}
	
	public static void main(String[] args) {
		int count=6;
		
		prac1.addData(count);
		for (Object o : obj1) { System.out.println(o); }
		for (Object o : obj2) { System.out.println(o); }
		System.out.println(prac1.findIndex(4));
		System.out.println(prac1.findIndex("4"));
		
	}

}
