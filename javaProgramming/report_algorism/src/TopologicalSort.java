import java.util.*;

//***************************
//���ϸ�: TopologicalSort
//�ۼ���: 201814011 ������
//�ۼ���: 2020-06-08
//����: [hw10_2] topological sort
//***************************

class DirectedGraph {
	private Node[] list; // ���� ����Ʈ
	private int numberOfVertices; // ���� ��

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
		if (v1 >= numberOfVertices || v2 >= numberOfVertices) {
			System.out.println("���� ���� ���� - �߸��� ���� ��ȣ�Դϴ�. <" + v1 + "," + v2 + ">");
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
		for (int i = 0; i < numberOfVertices; i++) {
			System.out.print("���� " + i + "�� ������ ���� = ");
			nn = list[i];
			while (nn != null) {
				System.out.print(nn.vertex + " ");
				nn = nn.link;
			}
			System.out.println();
		}
	}

}

public class TopologicalSort {
	int n; // �׷����� ���� ��
	boolean[] visited; // �湮���� üũ ��
	List<Integer>[] adjList; // ��������Ʈ ������ �Է� �׷���
	List<Integer> sequence; // ���� ���� ������ ���� ����Ʈ

	public TopologicalSort(List<Integer>[] graph) { // ������
		n = graph.length;
		visited = new boolean[n];
		adjList = graph;
		sequence = new ArrayList<>();
	}

	public List<Integer> tsort() { // ���������� ���� DFS ����
		for (int i = 0; i < n; i++)
			if (!visited[i])
				dfs(i);
		Collections.reverse(sequence); // sequence�� �������� �����
		return sequence;
	}

	public void dfs(int u) { // DFS ����
		visited[u] = true;
		for (int v : adjList[u]) { // u�� �湮�� ������ ������ �湮�ؾ��ϴ� �� ���� v�� ����
			if (!visited[v])
				dfs(v);
		}
		sequence.add(u); // u���� �����ϴ� ������ �� �̻� �����Ƿ� u�� sequence�� �߰�
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
		List<Integer>[] adjList = new List[n]; 
		for (int i = 0; i < n; i++) {
			adjList[i] = new ArrayList<>();
		}

		// 3) ���� �� e�� �Է� ����
		System.out.print("���� �� �Է�: ");
		int e = scan.nextInt();
		System.out.println();

		// 4) e ���� ���� �Է¹޾� �׷����� ����
		System.out.println(e + "���� ���� �Է�(�� ������ ���� ��ȣ 2���� whitespace�� �����Ͽ� �Է�):");
		for (int i = 1; i <= e; i++) {
			System.out.print("����" + i + " �Է�: ");
			int v1 = scan.nextInt();
			int v2 = scan.nextInt();
			graph.addEdge(v1, v2);
			adjList[v1].add(v2);
		}
		
		TopologicalSort t = new TopologicalSort(adjList);
		List<Integer> sortedSeq = t.tsort();

		// 5) �׷��� ������ Ȯ��
		graph.printAdjacencyList();
		System.out.print("�������� ���: "+sortedSeq);
		scan.close();

	}

}
