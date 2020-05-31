package prac10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class Example3 {
	static int getSum(List<Integer> list) {
		int sum = 0;
		for (Integer i : list)
			sum = sum + i;
		return sum;
	}

	static void addRandomValue(List<Integer> list, int count) {
		Random random = new Random();
		for (int i = 0; i < count; ++i)
			list.add(random.nextInt(20));
	}

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>();
		LinkedList<Integer> list2 = new LinkedList<>();
		Vector<Integer> list3 = new Vector<>();
		
		addRandomValue(list1, 10);
		addRandomValue(list2, 10);
		addRandomValue(list3, 10);
		
		System.out.printf("%s 합계: %d\n", list1.toString(), getSum(list1));
		System.out.printf("%s 합계: %d\n", list2.toString(), getSum(list2));
		System.out.printf("%s 합계: %d\n", list3.toString(), getSum(list3));
	}
}