package prac10;

import java.util.LinkedList;

public class Example4 {

	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		
		for(int i=0; i<100; ++i) {
			list1.add(i);
		}
		
		for(int i=0; i<list1.size(); ++i) {
			System.out.print(list1.get(i*2)+" ");
			
		}

	}

}
