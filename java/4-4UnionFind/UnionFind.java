public class UnionFind {  
	protected  Node[] a;    
	
	public UnionFind(Node[] iarray) {  // ������
		a = iarray;
	}
	
	//i�� ���� ������ ��Ʈ ��带 ��������� ã�� ���������� ��λ��� �� ������ �θ� ��Ʈ ���� �����.
	protected int find(int i) { // ��� ����
		if ( i != a[i].getParent())   
			a[i].setParent(find(a[i].getParent()));  //�����ϸ� ��λ��� �� ����� �θ� ��Ʈ���ǵ��� �����.
		return a[i].getParent();
	}

	public void union(int i, int j) {  // Union ����
		int iroot = find(i);
		int jroot = find(j);
		if (iroot == jroot) return;  // ��Ʈ ��尡 �����ϸ� ���̻��� ������� �״�� ����
		// rank�� ���� ��Ʈ ��尡 ���ڰ� �ȴ�.
		if (a[iroot].getRank() > a[jroot].getRank()) 
			a[jroot].setParent(iroot);               // iroot�� ����
		else if (a[iroot].getRank() < a[jroot].getRank()) 
			a[iroot].setParent(jroot);               // jroot�� ����
		else {
			a[jroot].setParent(iroot);  // ���߿� �ϳ� ���Ƿ� ����
			int t = a[iroot].getRank() + 1;
			a[iroot].setRank(t);        // iroot�� rank 1 ����
		}
	}
}
