public class prac2 {
	
	static class Person {
		String name;
		int age;

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}
	}

	public static void main(String[] args) {
		Object [] obj1 = new Object[3];
		
		obj1[0] = new Double[] {1.1, 2.2, 3.3};
		obj1[1] = new String[] {"a", "b", "c"};
		obj1[2] = new Person("¿”≤©¡§", 22);
		
		for(Object o : obj1) { System.out.println(o); }
		
	}

}
