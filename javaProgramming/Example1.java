package prac6;

import java.util.Arrays;

public class Example1 {

	public static void main(String[] args) {
		Integer[] a = new Integer[] { 10, 97, 81, 22, 3 };

		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		
		int index = Arrays.binarySearch(a, 97);
		System.out.print("index of 97: "+index);
	}

}
