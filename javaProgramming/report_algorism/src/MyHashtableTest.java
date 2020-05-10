import java.util.Scanner;

//***************************
//���ϸ�: MyHashtableTest
//�ۼ���: 201814011 ������
//�ۼ���: 2020-05-10
//����: [hw7_1] �й� hash table
//***************************

class MyHashtable {
	private int [] table; // �ؽ����̺�
	private int m; // �ؽ����̺� ũ��
	private static final int EMPTY = -1;
	private static final int DELETED = -2;

	public MyHashtable(int size) {
		table = new int[size];
		m = size; 
		
		for(int i=0; i<size; i++) {
			table[i] = EMPTY;
		}
	}
	
	public boolean put(int key) {
		int index=hash(key); // index �ʱ� ��ġ
		int i=index, j=1; 
		
		do {
			if(table[i] == EMPTY || table[i] == DELETED) { // ���� ��ġ �߰�
				table[i] = key; // key�� �ؽ����̺� ����
				return true;
			} 
			if(table[i] == key) { // �̹� key�� �����ϴ� ���
				return false;
		    }
		
			i = (index + j++) % m; // i = ���� ��ġ
		} while(i != index); // ���� i�� �ʱ� ��ġ�� ���� �Ǹ� ���� ����
		
		return false; // ���̺� �����÷ο�
	}
	
	// �ؽ����̺� key ���� �˻��Ͽ� �ε����� ����, �˻� ���н� -1 ����
	public int search(int key) {
		int index=hash(key);
		int i=index, j=1;
		
		while(table[i] != EMPTY || table[i] != DELETED) { // ���̺� i��°�� empty �Ǵ� deleted�� �ƴ� ������
			if(table[i] == key) 
				return i; // �˻� ����
			i = (index + j++) % m; 
			if(table[i] == EMPTY) { // ���̺� i��°�� ����� ��
				return EMPTY;
			}
		}
		
		return EMPTY; // �˻� ����
	}
	
	// �ؽ����̺��� key ���� �˻��ϰ� ���� ���θ� ����
	public boolean contains(int key) {
		int index = search(key);
		return (index >= 0);
	}
	
	public boolean remove(int key) {
		int index=hash(key);
		int i=index, j=1;
		
		while(table[i] != EMPTY || table[i] != DELETED) { 
			if(table[i] == key) {
				table[i] = DELETED;
				return true;		
			}
			i = (index + j++) % m; 
			
			if(table[i] == EMPTY) { 
				return false;
			}

		}
		return false; // ���� ����
	}
	
	public void print() {
		System.out.println("�ؽ� ���̺� ����");
		for(int i=0; i<m; i++) {
			if(table[i] == EMPTY) {
				System.out.println("["+i+"]");
			} else if(table[i] == DELETED) {
				System.out.println("["+i+"] DELETED");
			} else {
				System.out.println("["+i+"] "+table[i]);
			}
		}
	}
	
	private int hash(int x) {
		return x % m;
	}
	
}

public class MyHashtableTest {

	public static void main(String[] args) {
		System.out.println("hw7_1: ������");
		
		// �ؽ����̺� ũ��(size)�� �Է� ����
		Scanner scanner = new Scanner(System.in);
		System.out.print("�ؽ����̺� ũ�� �Է�: ");
		int size = scanner.nextInt();
		
		MyHashtable studentTable = new MyHashtable(size);
		
		int menu = 0;
		do {
			System.out.print("1:���� 2:�˻� 3:���� 4:���̺� ��� 5:���� ---> ");
			menu = scanner.nextInt();
			
			switch(menu) {
			case 1:
				System.out.print("������ �й�(������)�� �Է��ϼ���: ");
				int id = scanner.nextInt();
				if(studentTable.put(id))
					System.out.println(id + " ���� ����");
				else
					System.out.println(id + " ���� ����");
				break;
			case 2:
				System.out.print("�˻��� �й�(������)�� �Է��ϼ���: ");
				id = scanner.nextInt();
				if(studentTable.contains(id))
					System.out.println(id + " �л��� ã�ҽ��ϴ�.");
				else
					System.out.println(id + " �л��� ã�� �� �����ϴ�.");
				break;
			case 3:
				System.out.print("������ �й�(������)�� �Է��ϼ���: ");
				id = scanner.nextInt();
				if(studentTable.remove(id))
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
		} while(menu!=5);
		scanner.close();
	}

}
