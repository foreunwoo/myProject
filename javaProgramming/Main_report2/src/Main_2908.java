import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2908 {
public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(br.readLine()).reverse();
		int A = Integer.parseInt(sb.substring(0, 3));
		int B = Integer.parseInt(sb.substring(4, 7));
		System.out.println(A > B ? A : B);
		
	}
}
