package ex;

import java.util.Comparator; 

class StudentNumComparator implements Comparator<Student2> {
	@Override 
	public int compare(Student2 o1, Student2 o2) { 
		if (o1.num == o2.num) { 
			return (o1.grade == o2.grade) ? 0 : (o1.grade > o2.grade ? 1 
					: -1); 
		} 
		return (o1.num > o2.num) ? 1 : -1; 
	 	} 
}

class StudentNameComparator implements Comparator<Student2> {
	@Override 
	public int compare(Student2 o1, Student2 o2) { 
		if (o1.name.charAt(0) == o2.name.charAt(0)) { 
			return (o1.major.charAt(0) == o2.major.charAt(0)) ? 0 : (o1.major.charAt(0) > o2.major.charAt(0) ? 1 
					: -1); 
		} 
		return (o1.name.charAt(0) > o2.name.charAt(0)) ? -1 : 1; 
	 	} 
	

}

class StudentMajorComparator implements Comparator<Student2> {
	@Override 
	public int compare(Student2 o1, Student2 o2) { 
		if (o1.major.charAt(0) == o2.major.charAt(0)) { 
			return (o1.name.charAt(0) == o2.name.charAt(0)) ? 0 : (o1.name.charAt(0) > o2.name.charAt(0) ? 1 
					: -1); 
		} 
		return (o1.major.charAt(0) > o2.major.charAt(0)) ? -1 : 1; 
	 	} 
	

}

class StudentGradeComparator implements Comparator<Student2> {
	@Override 
	public int compare(Student2 o1, Student2 o2) { 
		if (o1.grade == o2.grade) { 
			return (o1.num == o2.num) ? 0 : (o1.num > o2.num ? 1 
					: -1); 
		} 
		return (o1.grade > o2.grade) ? -1 : 1; 
	 	} 
	

}
