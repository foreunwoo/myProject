import java.util.*;
public class RedBlackTree<Key extends Comparable<Key>, Value> {
	private static final boolean RED   = true;
	private static final boolean BLACK = false;
	private Node root;    
	private class Node {  // Node Ŭ����
		Key     id;
		Value   name;
		Node    left, right;
		boolean color;  // �θ��� link�� ��
		public Node(Key k, Value v, boolean col) {  // ��� ������
			id    = k;
			name  = v;
			color = col;
			left = right = null;
		}
	}	
	private boolean isEmpty(){ return root == null;}
	private boolean isRed(Node n) {
		if (n == null) return false; // null�� ���� ��             
		return (n.color == RED);                         
	}

	public Value get(Key k) {return get(root, k);} // Ž�� ����, 5-4-2��
	public Value get(Node n, Key k) {
		if (n == null) return null;   // Ž�� ����
		int t = n.id.compareTo(k);
		if (t > 0) 	    return get(n.left,  k); // if (k < ��� n�� id) ���� ����Ʈ��  Ž��
		else if (t < 0) return get(n.right, k); // if (k > ��� n�� id) �����ʼ���Ʈ�� Ž��
		else 	        return (Value) n.name; 	// Ž�� ���� 
	}
 
	private Node rotateLeft(Node n){
		Node x  = n.right;  		
		n.right = x.left;		
		x.left  = n;         		
		x.color = n.color; 	
		n.color = RED;     		
		return x; 
	} 

	private Node rotateRight(Node n){
		Node x  = n.left;    	
		n.left  = x.right;   		
		x.right = n;        		
		x.color = n.color; 	
		n.color = RED;     	
		return x;
	}
	
	private void flipColors(Node n){
		n.color = !n.color;		
		n.left.color  = !n.left.color;	
		n.right.color = !n.right.color;	  
	}    
	
	public void put(Key k, Value v) {   // ���� ����, 5-4-4��
		root = put(root, k, v);
		root.color = BLACK;
	}
	private Node put(Node n, Key k, Value v) { 
		if (n == null)  return new Node(k, v, RED); // ���ο� ���� ��� ����
		int t = k.compareTo(n.id);
		if (t < 0)      n.left  = put(n.left,  k, v); 
		else if (t > 0) n.right = put(n.right, k, v); 
		else            n.name  = v;   // k�� Ʈ���� �ִ� ��� v�� name�� ����
		// ������ link�� ������ ��� �ٷ���´�.
		if (!isRed(n.left) && isRed(n.right))      	n = rotateLeft(n);
		if (isRed(n.left)  && isRed(n.left.left)) 	n = rotateRight(n);
		if (isRed(n.left)  && isRed(n.right))     	flipColors(n);
		return n;
	}
	
	private Node moveRedLeft(Node n){
		flipColors(n);      // case 1 �� case 2
		if (isRed(n.right.left)) {  // case 2
			n.right = rotateRight(n.right);
			n       = rotateLeft(n);
			flipColors(n);
		}
		return n;
	}
	
	public void deleteMin() { // �ּڰ� ����, 5-4-5��
		root = deleteMin(root);
		root.color = BLACK;
	}
	private Node deleteMin(Node n) {
		if (n.left == null)  return null;
		if (!isRed(n.left) && !isRed(n.left.left))
			n = moveRedLeft(n); 
		n.left = deleteMin(n.left);
		return fixUp(n);
	}
	
	private Node moveRedRight(Node n){
		flipColors(n);             // case 1 �� case 2
		if (isRed(n.left.left)) {  // case 2
			n = rotateRight(n);
			flipColors(n);
		}
		return n;
	}
	
	private Node fixUp(Node n) {
		if (isRed(n.right))   n = rotateLeft(n);
		if (isRed(n.left) && isRed(n.left.left))  n = rotateRight(n);
		if (isRed(n.left) && isRed(n.right))  flipColors(n);
		return n;
	}
	
	public Key min() {   // �ּڰ� ã��
		if (isEmpty()) return null;
		return (Key) min(root).id;
	}
	private Node min(Node n) {
		if (n.left == null) return n;
		return min(n.left);
	}

	public void delete(Key k) { // ���� ����
		root = delete(root, k);
		root.color = BLACK;
	}
	private Node delete(Node n, Key k) { // ���n���κ��� Ű�� k�� ���� ��� ����
		if (k.compareTo(n.id) < 0)  {    // k�� ���n�� id���� ������
			if (!isRed(n.left) && !isRed(n.left.left))  
				n = moveRedLeft(n);      // �������� ���� link ���� ������
			n.left = delete(n.left, k);  // k�� ã�� ���� ���� ����Ʈ���� ������
		}
		else { // k�� ���n�� id�� ���ų� ũ��
			if (isRed(n.left))      // n�� ���� �ڽ��� �����̸�
				n = rotateRight(n); // ���������� ���� link ���� ������
			if (k.compareTo(n.id) == 0 && (n.right == null)) // n�� ���ĸ�����϶�
				return null;        // ���ĸ� ��� n ����
			if (!isRed(n.right) && !isRed(n.right.left))     // ���������� ���� link ���� ������
				n = moveRedRight(n);
			if (k.compareTo(n.id) == 0) {       // ��� n�� �����ļ��� ��� ������ �����ϰ� ������ 
				Node successor = min(n.right);  // successor�� ��� n�� �����ļ��� ���
				n.name  = get(n.right, successor.id); // ���n�� successor��� name ����
				n.id    = successor.id;               // ���n�� successor���   id  ����
				n.right = deleteMin(n.right);         // successor��� ����
			}
			else 
				n.right = delete(n.right, k);         // k�� ã�� ���� ������ ����Ʈ���� ������
		}
		return fixUp(n);  // ���� ȣ�� ���� �����ϸ�, ����� Ʈ�� ���� �ٷ����
	}
	
	public void print()  {  // Ʈ�� ���
		System.out.printf("\ninorder:\n");
		inorder(root);
		System.out.printf("\npreorder:\n");
		preorder(root);
		System.out.printf("\nlevel order:\n");
		levelorder(root);
	}
	public void inorder(Node n){       // ���� ��ȸ
		if (n != null) {
			inorder(n.left);   // n�� ���� ���� Ʈ���� ��ȸ�ϱ� ����
			System.out.print(n.id+" ");  // ��� n �湮
			inorder(n.right);  // n�� ������ ���� Ʈ���� ��ȸ�ϱ� ����
		}
	}
	public void levelorder(Node root) { // ���� ��ȸ
		Queue<Node> q = new LinkedList<Node>(); // ť �ڷᱸ�� �̿�
		Node t;
		q.add(root);  // ��Ʈ ��� ť�� ����
		while (!q.isEmpty()) { 
			t = q.remove();   //ť���� ���� �տ� �ִ� ��� ����
			System.out.print(t.id+" "); // ���ŵ� ��� ���(�湮)
			if (t.left != null)      // ���ŵ� ���� �ڽ��� null�� �ƴϸ�
				q.add(t.left);       // ť�� ���� �ڽ� ����
			if (t.right != null)     // ���ŵ� ������ �ڽ��� null�� �ƴϸ�
				q.add(t.right);      // ť��  ������ �ڽ� ����
		} 
	}
	public void preorder(Node n) {     // ���� ��ȸ
		if (n != null) {
			System.out.print(n.id+" ");  // ��� n �湮
			preorder(n.left);  // n�� ����    ���� Ʈ���� ��ȸ�ϱ� ����
			preorder(n.right); // n�� ������ ���� Ʈ���� ��ȸ�ϱ� ����
		}
	}	
}
