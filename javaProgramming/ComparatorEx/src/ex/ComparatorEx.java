package ex;

import java.util.ArrayList; 
import java.util.Collections; 
import java.util.Comparator; 


public class ComparatorEx {
	public static void main(String[] args) { 
	Student2 s1 = new Student2(201811111, "bam", "소프트웨어공학과", 2); 
		Student2 s2 = new Student2(201714111, "amy", "컴퓨터공학과", 3); 
		Student2 s3 = new Student2(201915811, "reyaz", "국어국문과", 1); 
		ArrayList<Student2> studentList = new ArrayList<Student2>(); 
		studentList.add(s1); 
		studentList.add(s2); 
		studentList.add(s3); 
		Collections.sort(studentList, new StudentNumComparator()); 
		
		// sorting in reverse order 
		Comparator<Student2> comp = Collections 
			.reverseOrder(new StudentNumComparator()); 
		Collections.sort(studentList, comp); 
		System.out.println("학번순"); 
		for (Student2 s : studentList) { 
			System.out.print("Student isss "); 
			System.out.print(s.num+" "); 
			System.out.print(s.name+" "); 
			System.out.print(s.major+" "); 
			System.out.println(s.grade+" "); 
			}
		
		Comparator<Student2> comp2 = Collections 
				.reverseOrder(new StudentNameComparator()); 
			Collections.sort(studentList, comp2); 
			System.out.println("이름순"); 
			for (Student2 s : studentList) { 
				System.out.print("Student isss "); 
				System.out.print(s.num+" "); 
				System.out.print(s.name+" "); 
				System.out.print(s.major+" "); 
				System.out.println(s.grade+" "); 
				}
			
			Comparator<Student2> comp3 = Collections 
					.reverseOrder(new StudentMajorComparator()); 
				Collections.sort(studentList, comp3); 
				System.out.println("학과순"); 
				for (Student2 s : studentList) { 
					System.out.print("Student isss "); 
					System.out.print(s.num+" "); 
					System.out.print(s.name+" "); 
					System.out.print(s.major+" "); 
					System.out.println(s.grade+" "); 
					} 
				
				Comparator<Student2> comp4 = Collections 
						.reverseOrder(new StudentGradeComparator()); 
					Collections.sort(studentList, comp4); 
					System.out.println("학년순"); 
					for (Student2 s : studentList) { 
						System.out.print("Student isss "); 
						System.out.print(s.num+" "); 
						System.out.print(s.name+" "); 
						System.out.print(s.major+" "); 
						System.out.println(s.grade+" "); 
						} 
		 
			} 

}
