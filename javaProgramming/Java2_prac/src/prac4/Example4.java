package prac4;

public class Example4 {
	static String reverse(String s) {
		return (new StringBuilder(s)).reverse().toString();
	}

	public static void main(String[] args) {
		String s = "hello world";
		s = reverse(s);
		System.out.println(s);
	}
}