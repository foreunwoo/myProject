package prac5;

import java.util.Comparator; 

public class PersonNameComparator implements Comparator<Person> { 
	
	@Override 
	public int compare(Person p1, Person p2) { 
		int r = p2.name.compareTo(p1.name); // 먼저 이름(name)을 비교한다. 
		if (r != 0) return r; // 이름이 같지 않다면, 이름 비교 결과를 리턴한다. 
		return p2.age - p1.age; // 이름이 같다면, 나이(age) 비교 결과를 리턴한다. 
		 
	}
}
