import java.util.Scanner;

//***************************
//���ϸ�: TopologicalSort
//�ۼ���: 201814011 ������
//�ۼ���: 2020-06-06
//����: [hw10_2] topological sort
//***************************

class DirectedGraph {
	private Node[] list;	// ���� ����Ʈ
	private int numberOfVertices;	// ���� �� 
	
	// ����Ʈ�� ��� ������ ������ Ŭ����
	private class Node {
		int vertex;
		Node link;
	}
	
	// ���� ���� n�� �׷����� ����
	public DirectedGraph(int n) {
		list = new Node[n];
		numberOfVertices = n;
	}
	
	// ���� <v1, v2>�� ����
	public void addEdge(int v1, int v2) {
		// v1, v2�� �ùٸ� ���� ��ȣ�̸� list[v1]�� v2�� ����
		if(v1 >= numberOfVertices || v2 >= numberOfVertices) {
			System.out.println("���� ���� ���� - �߸��� ���� ��ȣ�Դϴ�. <"+v1+","+v2+">");
		} else {
			// �����ϴ� ������ �׻� ����Ʈ�� ù��° ���� �����ϵ��� ��
			Node n = new Node();
			n.vertex = v2;
			n.link = list[v1];
			list[v1] = n; 
		}
	}
	
	// ������ Ȯ���ϱ� ���� ���� ����Ʈ�� ��� ���
	public void printAdjacencyList() {
		// �ݺ����� �̿��Ͽ� list[0], ... list[numberOfVertices-1]�� ��� ���� ��ȣ�� ���
		Node nn = new Node();
		System.out.println();
		for(int i=0; i<numberOfVertices; i++) {
			System.out.print("���� "+i+"�� ������ ���� = ");
			nn = list[i];
			while(nn != null) {
				System.out.print(nn.vertex+" ");
				nn = nn.link;
			}
			System.out.println();
		}
	}
}
public class TopologicalSort {
	public void topologicalSort() {
		
	}

	public static void main(String[] args) {
		System.out.println("hw10_2: ������");
		System.out.println();
		
		// 1) ���� �� n�� �Է� ����
		System.out.println("���� ������ �����մϴ�. DAG�� �Է��ϼ���.");
		Scanner scan = new Scanner(System.in);
		System.out.print("���� �� �Է�: ");
		int n = scan.nextInt();
		
		// 2) ���� ���� n�� ���� �׷����� ����
		DirectedGraph graph = new DirectedGraph(n);
		
		// 3) ���� �� e�� �Է� ����
		System.out.print("���� �� �Է�: ");
		int e = scan.nextInt();
		System.out.println();
		
		// 4) e ���� ���� �Է¹޾� �׷����� ����
		System.out.println(e+"���� ���� �Է�(�� ������ ���� ��ȣ 2���� whitespace�� �����Ͽ� �Է�):");
		for(int i=1; i<=e; i++) {
			System.out.print("����"+i+" �Է�: ");
			int v1 = scan.nextInt();
			int v2 = scan.nextInt();
			graph.addEdge(v1, v2);
		}
		
		// 5) �׷��� ������ Ȯ��
		graph.printAdjacencyList();
		scan.close();

	}

}
