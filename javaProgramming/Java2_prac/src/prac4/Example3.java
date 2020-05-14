package prac4;

public class Example3 {
	static String toString(String[] a) {
		StringBuilder builder = new StringBuilder();
		
		for(String s : a) {
			if(builder.length() > 0) builder.append(',');
			builder.append('"').append(s).append('"');
			
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		String[] a = { "one", "two", "three", "four" };
		String s = toString(a);
		System.out.println(s);
	}
}
