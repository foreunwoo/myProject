01 import java.util.*;
02 public class TopologicalSort {
03     int N;                        // �׷����� ���� ��
04     boolean[] visited;            // DFS ���� �� �湮���� üũ ��
05     List<Integer>[] adjList;      // ��������Ʈ ������ �Է� �׷���
06     List<Integer> sequence;       // ���� ���� ������ ���� ����Ʈ
07     public TopologicalSort(List<Integer>[] graph) {  //������
08         N = graph.length;
09         visited = new boolean[N]; 
10         adjList = graph;
11         sequence = new ArrayList<>();
12     }
13     public List<Integer> tsort() {     // ���������� ���� DFS ����
14         for (int i = 0; i < N; i++)    if (!visited[i]) dfs(i);
15         Collections.reverse(sequence); // sequence�� �������� �����
16         return sequence;
17     }
18     public void dfs(int i) {       // DFS ����
19         visited[i] = true;
20         for (int v : adjList[i]) { // u�� �湮�� ������ ������ �湮�ؾ��ϴ� �� ���� v�� ����
21             if (!visited[v]) dfs(v);
22         }
23         sequence.add(i);           // u���� �����ϴ� ������ �� �̻� �����Ƿ� u�� sequence�� �߰� 
24     }
25 }