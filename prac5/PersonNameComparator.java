package prac5;

import java.util.Comparator; 

public class PersonNameComparator implements Comparator<Person> { 
	
	@Override 
	public int compare(Person p1, Person p2) { 
		int r = p2.name.compareTo(p1.name); // ���� �̸�(name)�� ���Ѵ�. 
		if (r != 0) return r; // �̸��� ���� �ʴٸ�, �̸� �� ����� �����Ѵ�. 
		return p2.age - p1.age; // �̸��� ���ٸ�, ����(age) �� ����� �����Ѵ�. 
		 
	}
}
