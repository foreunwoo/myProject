import java.util.Scanner;

public class Poly {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("--------���׽� A�� �Է��ϰڽ��ϴ�. --------");
		Polynomial A = new Polynomial();

		// A�� �Է�
		while (true)

		{
			System.out.print("���, ����: ");
			int coef = sc.nextInt();
			int expo = sc.nextInt();

			// 0�Է½� ���� �ٽ� ���ư�
			if (coef == 0) {
						     continue;
									}
			
			// -1�Է½� ����
			if (coef == -1|| expo == 0) {
							break;
						}
			
			

			A.insertArray(coef, expo);

		}

		System.out.print("->A���: ");
		A.print();

		System.out.println("--------���׽� B�� �Է��ϰڽ��ϴ�. --------");
		Polynomial B = new Polynomial();

		// B�� �Է�
		while (true)

		{
			System.out.print("���, ����: ");
			int coef = sc.nextInt();
			int expo = sc.nextInt();

			// 0�Է½� ���� �ٽ� ���ư�
			if (coef == 0) {
						continue;
							}
			
			// ��� -1, ����0 �Է½� ����
			if (coef == -1 || expo == 0) {
							break;
						}
			
			
			B.insertArray(coef, expo);

		}

		System.out.print("->B���: ");
		B.print();

		Polynomial C = new Polynomial();
		

		int startA = 0;
		int finishA = A.getSize()-1;
		int startB = 0;
		int finishB = B.getSize()-1;

		while (startA <= finishA && startB <= finishB) {

			// A�� ������ B�� �������� ū ���
			if (A.getExpo(startA) > B.getExpo(startB)) {
				C.insertArray(A.getCoef(startA), A.getExpo(startA));
				startA++;
			}
			// B�� ������ A�� �������� ū ���
			else if (A.getExpo(startA) < B.getExpo(startB)) {
				C.insertArray(B.getCoef(startB), B.getExpo(startB));
				startB++;
			}
			// A�� ������ B�� ������ ���� ���
			else {
				C.insertArray(A.getCoef(startA) + B.getCoef(startB), A.getExpo(startA));
				startA++;
				startB++;
			}
		}

		// A�� ���� ���� �ִ� ��� C�� �߰�
		for (; startA <= finishA; startA++)
			C.insertArray(A.getCoef(startA), B.getExpo(startA));

		// B�� ���� ���� �մ� ��� B�� �߰�
		for (; startB <= finishB; startB++)
			C.insertArray(B.getCoef(startB), B.getExpo(startB));

		System.out.print("->A+B���: ");
		C.print();
		
		if(C.getSize()==0) { System.out.print("0"); }

	}
}

