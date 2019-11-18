import java.util.NoSuchElementException;
public class DoubleArrayList <E>{
		private  E d[];     // ����Ʈ�� �׸���� ������ �迭
	    private  int size;  // ����Ʈ�� �׸� ��
	   
	    public  DoubleArrayList() { // ������
	        d = (E[]) new Object[1];  // ���ʷ� 1���� ���Ҹ� ���� �迭 ����
	        size = 0;                 // �׸� ���� 0���� �ʱ�ȭ
	    }
	    public boolean isEmpty() {return size == 0;} // ����Ʈ�� empty�̸� true ����
	    
	    public void insertLast(E newItem) {	// ���� �ڿ� �� �׸� ����              
	        if (size == d.length)   	// �迭�� �� ������ ������
	        	resize(2*d.length);  	// �迭 ũ�� 2��� Ȯ��
	         d[size++] = newItem;    	// �� �׸� ����
	    }
	        
	    public void insert(E newItem, int k) { // �� �׸��� k-1��? �׸� ������ ����
	    	if (size == d.length)   		   // �迭�� �� ������ ������
	    		resize(2*d.length);			   // �迭 ũ�� 2��� Ȯ��
	    	for (int i = size-1; i >= k; i--)  d[i+1] = d[i];  // �� ĭ�� �ڷ� �̵�
	    	d[k] = newItem;
	    	size++;
	    }

	    public E delete(int k) {  // k��° �׸� ����
			if (isEmpty()) throw new NoSuchElementException(); // underflow ��쿡 ���α׷� ����
			E item = d[k];
			for (int i = k; i <size-1; i++)  d[i] = d[i+1];  // �� ĭ�� ������ �̵�
			d[size-1]=null;
			if (size > 0 && size == d.length/4) // �迭�� �׸���� 1/4�� �����Ѵٸ�
				resize(d.length/2); 			// �迭�� 1/2 ũ��� ���
			return item;
	    }
	    
	    public E peek(int k) {  // k��° �׸��� ����, �ܼ��� �б⸸ �Ѵ�.
	  		if (isEmpty()) throw new NoSuchElementException(); // underflow ��쿡 ���α׷� ����
	  		return d[k];
	      }
	    
	    private void resize(int newSize) {		// �迭 ũ�� ����
			Object[] t = new Object[newSize];   // newSize ũ���� ���ο� �迭 t ����
			for (int i = 0; i < size; i++)
				t[i] = d[i];                    // �迭 s�� �迭 t�� ���� 
			d = (E[]) t;                        // �迭 t�� �迭 s�� 
		}
	    
		public void print() { // �迭�� �׸���� ���
			if (isEmpty()) 
				System.out.print("�迭�� �������.");      
			else
				for(int i = 0; i < d.length; i++)	System.out.print(d[i]+"\t ");
			System.out.println();
		};

}
