import java.util.Scanner;

//***************************
//���ϸ�: MyHashtableTest2
//�ۼ���: 201814011 ������
//�ۼ���: 2020-05-11
//����: 	[hw7_2] �й�-���� hash table
//***************************

class MyHashtable<K, V> {
	private Student[] table; // �ؽ����̺�
	private int m; // �ؽ����̺� ũ��

	public static class Student { // �й��� ������ ����� Student Ŭ����
		private Object student_Num; // �й�(key)
		private Object score; // ����(value)
		private Student next;

		public Student(Object key, Object value, Student ref) {
			student_Num = key;
			score = value;
			next = ref;
		}

		public Object getStudent_Num() {
			return student_Num;
		}

		public void setStudent_Num(int student_Num) {
			this.student_Num = student_Num;
		}

		public Object getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

	}

	public MyHashtable(int size) {
		table = new Student[size];
		m = size;
	}

	public V contains(K key) { // �ؽ����̺��� key ���� �˻��ϰ� ���� ����
		int i = hash(key);
		for (Student x = table[i]; x != null; x = x.next) // ���Ḯ��Ʈ Ž��
			if (key.equals(x.student_Num))
				return (V) x.score; // Ž�� ����
		return null; // Ž�� ����
	}

	public boolean put(K key, V data) { // ���� ����
		int i = hash(key);
		for (Student x = table[i]; x != null; x = x.next)
			if (key.equals(x.student_Num)) { // �̹� key ����
				x.score = data; // �����͸� ����
				return false;
			}
		table[i] = new Student(key, data, table[i]); // ���� ����Ʈ�� ù ���� ����
		return true;
	}
	
	public boolean remove(K key) { // ���� ����
		int i = hash(key);
		
        for (Student x = table[i]; x != null; x = x.next)
        	if (key.equals(x.student_Num)) {
        		x.student_Num = null;
        		x.score = null;
        		
        		return true;	 
        	}
        return false;
    }

	public void print() {
		System.out.println("�ؽ� ���̺� ����");
		for (int i = 0; i < m; ++i) {
			System.out.print(String.format("%2d", i));
			Student x = table[i];
			while (x != null) {
				System.out.print("-->[" + x.getStudent_Num() + ", " + x.getScore() + "]");
				x = x.next;
			}
			System.out.println();
		}
	}

	private int hash(K key) { // �ؽ� �Լ�
		return (key.hashCode() & 0x7fffffff) % m;
	}

}

public class MyHashtableTest2 {

	public static void main(String[] args) {
		System.out.println("hw7_2: ������");

		// �ؽ����̺� ũ��(size)�� �Է� ����
		Scanner scanner = new Scanner(System.in);
		System.out.print("�ؽ����̺� ũ�� �Է�: ");
		int size = scanner.nextInt();

		MyHashtable studentTable = new MyHashtable(size);

		int menu = 0;
		do {
			System.out.print("1:���� 2:�˻� 3:���� 4:���̺� ��� 5:���� ---> ");
			menu = scanner.nextInt();

			switch (menu) {
			case 1:
				System.out.print("������ �й�, ����(������)�� �Է��ϼ���: ");
				int id = scanner.nextInt();
				int score = scanner.nextInt();
				if (studentTable.put(id, score))
					System.out.println(id + "," + score + " ���� ����");
				else
					System.out.println(id + "," + score + " ���� ����");
				break;
			case 2:
				System.out.print("�˻��� �й�(������)�� �Է��ϼ���: ");
				id = scanner.nextInt();
				if (studentTable.contains(id) != null)
					System.out.println(id + " �л��� ������ " + studentTable.contains(id) + " �Դϴ�.");
				else
					System.out.println(id + " �л��� ã�� �� �����ϴ�.");
				break;
			case 3:
				System.out.print("������ �й�(������)�� �Է��ϼ���: ");
				id = scanner.nextInt();
				if (studentTable.remove(id)) 
					System.out.println(id + " ���� ����"); 
				else
					System.out.println(id + " ���� ����");
				break;
			case 4:
				studentTable.print();
				break;
			case 5:
				System.out.println("���α׷��� �����մϴ�.");
				break;
			default:
				System.out.println("�޴� ��ȣ�� �߸��Ǿ����ϴ�. �ٽ� �Է��ϼ���.");
			}
		} while (menu != 5);
		scanner.close();
	}

}
