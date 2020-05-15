package prac5;

import java.util.Comparator; 

public class PersonAgeComparator implements Comparator<Person> { 
	
	@Override 
	public int compare(Person p1, Person p2) { 
		int r = p2.age - p1.age; // ���� ����(age)�� ���Ѵ�. 
		if (r != 0) return r; // ���̰� ���� �ʴٸ�, ���� �� ����� �����Ѵ�. 
		return p2.name.compareTo(p1.name); // ���̰� ���ٸ�, �̸�(name) �� ����� �����Ѵ�.
	}
}