package prac10;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Example5 {
	static void randomValue(List<Integer> list, int count) {
		Random random = new Random();
		
		for(int i=0; i<count; ++i) {
			list.add(random.nextInt(100));
		}
	}
	
	static void swap(List<Integer> list, int i, int j) {
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
	
	static void bubbleSort(List<Integer> list) {
		for(int i=list.size()-1; i >= 1;  --i) {
			for(int j=0; j<i; ++j) {
				if(list.get(j) > list.get(j+1))
					swap(list, j, j+1);
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		
		randomValue(list1, 200);
		bubbleSort(list1);
		System.out.println(list1.toString());
	}

}
