package report_add_list;

import java.util.Scanner;

public class Poly {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// ���׽� A �����
		System.out.println("--------���׽� A�� �Է��ϰڽ��ϴ�. --------");
		Polynomial A = new Polynomial();

		while (true) {

			System.out.print("���, ����: ");
			int coef = sc.nextInt();
			int expo = sc.nextInt();
			
			// 0�Է½� ���� �ٽ� ���ư�
			if (coef == 0) {
				continue;
			}
			
			// ��� -1 ,���� 0 �Է½� ����
			if (coef == -1 || expo == 0) {
							break;
						}
						
			A.insertNode(coef, expo);

		}
		System.out.print("->A���: ");
		A.print();

		// ���׽� B �����
		System.out.println("--------���׽� B�� �Է��ϰڽ��ϴ�. --------");
		Polynomial B = new Polynomial();

		while (true) {

			System.out.print("���, ����: ");
			int coef = sc.nextInt();
			int expo = sc.nextInt();
			
			// 0�Է½� ���� �ٽ� ���ư�
			if (coef == 0) {
				continue;
						}
			
			// -1�Է½� ����
			if (coef == -1 || expo == 0) {
				break;
			}
			
			B.insertNode(coef, expo);

		}

		System.out.print("->B���: ");
		B.print();

		Polynomial C = AddPolynomial(A, B);

		System.out.print("->A+B���: ");
		C.print();
	}

	static Polynomial AddPolynomial(Polynomial A, Polynomial B) {
		ListNode a = A.head;
		ListNode b = B.head;
		Polynomial C = new Polynomial();

		// A�� B �� �� �ϳ��� ��� �׿� ���� ������ ������ ��� while ����
		while (a != null && b != null) {
			// B�� ������ A�� �������� ū ���
			if (a.expo < b.expo) {
				C.insertNode(b.coef, b.expo);
				b = b.next;
			}
			// A�� ������ B�� �������� ū ���
			else if (a.expo > b.expo) {
				C.insertNode(a.coef, a.expo);
				a = a.next;
			}
			// A�� ������ B�� ������ ���� ���
			else {
				C.insertNode(a.coef + b.coef, a.expo);
				a = a.next;
				b = b.next;
			}
		}

		// A�� ���� ���� �ִ� ��� C�� �߰�
		while (a != null) {
			C.insertNode(a.coef, a.expo);
			a = a.next;
		}

		// B�� ���� ���� �մ� ��� B�� �߰�
		while (b != null) {
			C.insertNode(b.coef, b.expo);
			b = b.next;
		}

		return C;
		
		
	}
}





