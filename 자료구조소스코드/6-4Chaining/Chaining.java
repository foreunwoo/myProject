public class Chaining<K, V> {
	 private int M = 11; // ���̺� ũ��
     private Node[] a = new Node[M]; // �ؽ� ���̺�
     public static class Node {  // Node Ŭ����
           private Object key;
           private Object data;
           private Node   next;
           public Node(Object newkey, Object newdata, Node ref){  // ������
        	   key  = newkey;
        	   data = newdata;
        	   next = ref;
           }
           public Object getKey()  { return key; }
           public Object getData() { return data;}
     }
     private int hash(K key) { //�ؽ��ڵ�
    	 return (key.hashCode() & 0x7fffffff) % M; } // ������ ����

     public V get(K key) {  //Ž�� ����
          int i = hash(key);
          for (Node x = a[i]; x != null; x = x.next)   // ���Ḯ��Ʈ Ž��
                if (key.equals(x.key)) return (V) x.data;  // Ž�� ����
          return null;  // Ž�� ����
     }
     private void put(K key, V data) { // ���� ����
         int i = hash(key);
         for (Node x = a[i]; x != null; x = x.next)
               if (key.equals(x.key)) {  // �̹� key ����
                     x.data =  data;     // �����͸� ����
                     return;
               }
         a[i] = new Node(key, data, a[i]); // ���� ����Ʈ�� ù ���� ����
    } 
     public static void main(String[] args) {
    	 Chaining t = new Chaining();
/*   	 //25, 37, 18, 55, 22, 35, 50, 63�� ���ʷ� ���̺� ����
    	 t.put(25, "grape"); 	t.put(37, "apple");	t.put(18, "bananna");
    	 t.put(55, "cherry");	t.put(22, "mango");	t.put(35, "lime");
    	 t.put(50, "orange");	t.put(63, "watermelon");

    	 System.out.println("Ž�� ���");
    	 System.out.println("50�� data = "+t.get(50));
    	 System.out.println("63�� data = "+t.get(63));
    	 System.out.println("37�� data = "+t.get(37));
    	 System.out.println("22�� data = "+t.get(22));
*/
    		t.put(71, "grape"); t.put(23, "apple");	t.put(73, "bananna");
    		t.put(49, "cherry");t.put(54, "mango");	t.put(89, "lime");
    		t.put(39, "orange");
    	 System.out.println();     	 System.out.println("�ؽ� ���̺�");
    	 for(int i=0;i<t.M;++i) {
    		 System.out.print(String.format("%2d", i));
    		 Node x =t.a[i];
    		 while (x != null){
    			 System.out.print("-->["+x.getKey()+", "+x.getData()+"]");
    			 x = x.next;
    		 }
    		 System.out.println();
    	 }
     }
}
