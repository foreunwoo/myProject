package kk;

public class Edge {
	int vertex, adjvertex; // ������ �糡 ������
	            // ������ ����ġ
	public int weight;
	
	public Edge(int u, int v, int wt) {
		vertex    = u;
		adjvertex = v;
		weight    = wt;
	}
}
