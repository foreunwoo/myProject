package aa;

public class main {
	public static void main(String[] args)	{
		Entry[] a;      // a[0]�� ��� ����  
		a = new Entry[7];

		a[1] = new Entry(50, "a", null, null, null);	a[2] = new Entry(10, "b", null, null, null);  	    
		a[3] = new Entry(15, "c", null, null, null);   	a[4] = new Entry(40, "d", null, null, null);  		
		a[5] = new Entry(25, "e", null, null, null);   	a[6] = new Entry(4, "f", null, null, null);  	     	

		Huffman h = new Huffman(a,6);
		System.out.println("�ּ��� ����� ��");
		h.print();

		h.createHeap();
		System.out.println("�ּ���:"); 
		h.print();

		System.out.println("������ �ڵ�"); 
		Entry root = h.createTree();
		h.preorder(root);
		System.out.println();
	}
}
