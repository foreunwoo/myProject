package kk;

public class Edge {
	int vertex, adjvertex; // 간선의 양끝 정점들
	            // 간선의 가중치
	public int weight;
	
	public Edge(int u, int v, int wt) {
		vertex    = u;
		adjvertex = v;
		weight    = wt;
	}
}
