public class Hanoi { //�ϳ���ž

static int count =0;
	static void move(int n, char from, char to, char tmp) 

	{
   count ++;
		if (n == 1) {

			System.out.println(n + " �̵� : " + from + " -> " + to);

		} else {

			move(n - 1, from, tmp, to);
			System.out.println(n + " �̵� : " + from + " -> " + to);
			move(n - 1, tmp, to, from);

		}

	}

	public static void main(String[] args) {

		move(3, 'A', 'B', 'C');
System.out.println(count);
System.out.println("�ð� ���⵵�� 2^n");
	}

}