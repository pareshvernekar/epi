package revision.graphs;

import java.util.*;
import java.io.*;

public class Graph {

	public Map<Integer,List<Integer>> adjacencyList = new HashMap<>();
	int vertices;
	int edges;
	boolean[] visited;
	Color[] color;
	Map<Integer,Integer> pathTo;

	int V() {
		return this.vertices;
	}

	int E() {
		return this.edges;
	}

	public Graph() {

	}
	public Graph(int V, int E) {
		this.vertices=V;
		this.edges=E;
		visited = new boolean[V];
		color = new Color[V];
		for (int i=0;i<this.vertices;i++) {
			color[i]=Color.WHITE;
		}
	}
	public void addEdge(int src, int dest) {
		if (!adjacencyList.containsKey(src)) {
			adjacencyList.put(src,new ArrayList<>());
		}
		if (!adjacencyList.containsKey(dest)) {
			adjacencyList.put(dest,new ArrayList<>());
		}
		adjacencyList.get(src).add(dest);
	}

	public List<Integer> outEdges(int src) {
		return adjacencyList.get(src);
	}

	public void bfs(Graph g, int src) {

		Set<Integer> visited = new HashSet<>();
		Queue<Integer> childNodes = new LinkedList<>();

		childNodes.add(src);
		visited.add(src);
		while (!childNodes.isEmpty()) {

			Integer temp = childNodes.poll();
			
			System.out.print(temp);System.out.print("\t");
			
			List<Integer> sibling = g.adjacencyList.get(temp);
			for (Integer i:sibling) {
				if (!visited.contains(i)) {
					childNodes.add(i);
					visited.add(i);
				}
			}
		}
	} 

	public void dfs(Graph g, int src) {
		Color[] color = new Color[g.adjacencyList.keySet().size()];
		for (int i=0;i<color.length;i++) {
			color[i]=Color.WHITE;
		}
		helper(g,src,color);
	}

	public void dfsMod(Graph g, int i) {
		
		visited[i]=Boolean.TRUE;
		System.out.print(i);System.out.print("\t");
		for (Integer node:g.outEdges(i)) {
			if (!visited[node]) {
				if (pathTo==null) {
					pathTo=new HashMap<>();
				}
				pathTo.put(node,i);
				dfsMod(g,node);
			}
		}
	}

	public List<Integer> path(Integer dest) {
		if (pathTo==null) return Collections.<Integer>emptyList();
		Deque<Integer> stack = new LinkedList<>();
		for (int x=dest;x!=0;x=pathTo.get(x)) {
			stack.addFirst(x);
		}
		stack.addFirst(0);
		return new ArrayList<>(stack);
	}

	public void helper(Graph g, int src,Color[] color) {
		color[src]=Color.GRAY;
		System.out.print(src);System.out.print("\t");
		for (Integer i:g.outEdges(src)) {
			if (color[i]==Color.WHITE) {
				helper(g,i,color);
			}
		}

		color[src]=Color.BLACK;
	}
	public int shortestPath(Graph g, int src, int dest) {

		Set<Integer> unsettledNodes = new HashSet<>();
		Set<Integer> settledNodes = new HashSet<>();
		int[] distances = new int[g.adjacencyList.keySet().size()];
		int len = g.adjacencyList.keySet().size();
		for (int i=0;i<len;i++) {
			distances[i]=Integer.MAX_VALUE;
		}
		unsettledNodes.add(src);
		distances[src]=0;
		while (!unsettledNodes.isEmpty()) {

			int evaluationNode = getNodeWithMinDistance(unsettledNodes,distances);
			System.out.println("evaluationNode::"+evaluationNode);
			unsettledNodes.remove(evaluationNode);
			settledNodes.add(evaluationNode);
			if (evaluationNode==dest)
				return distances[evaluationNode];
			evaluateNeighBours(g,evaluationNode,unsettledNodes,settledNodes,distances);
		}


		return -1;
	}

	private void evaluateNeighBours(Graph g, int evalNode, Set<Integer> unsettledNodes,
		Set<Integer> settledNodes,int[] distances ) {

		int edgeDistance;
		int totalDistance;
		List<Integer> childNodes = g.outEdges(evalNode);
		for (int destNode=0;destNode<distances.length;destNode++) {
			
			if (!childNodes.contains(destNode)) continue;
				if (!settledNodes.contains(destNode)) {

					edgeDistance=1;
					totalDistance=distances[evalNode]+edgeDistance;
					if (totalDistance < distances[destNode]) 
						distances[destNode]=totalDistance;
					unsettledNodes.add(destNode);
				}
		}

	}
	private int getNodeWithMinDistance(Set<Integer> unsettledNodes, int[] distances) {
		int len = distances.length;

		Iterator<Integer> iter = unsettledNodes.iterator();
		int node = iter.next();
		int min = distances[node];
		for (int i=0;i<len;i++) {
			if (unsettledNodes.contains(i)) {
				if (distances[i] < min) {
					min = distances[i];
					node=i;
				}
			}
		}
		return node;
	}

	
	public static void main(String[] argv) {

		Graph g = new Graph();
		g.addEdge(0,1);
		g.addEdge(0,2);

		g.addEdge(1,0);
		g.addEdge(1,5);
		g.addEdge(1,3);
		g.addEdge(1,4);

		g.addEdge(2,0);
		g.addEdge(2,6);
		g.addEdge(2,5);

		g.addEdge(3,1);
		g.addEdge(3,4);
		g.addEdge(3,7);

		g.addEdge(4,3);
		g.addEdge(4,5);
		g.addEdge(4,8);

		g.addEdge(5,1);
		g.addEdge(5,2);
		g.addEdge(5,3);
		g.addEdge(5,4);

		g.addEdge(6,2);
		g.addEdge(6,10);

		g.addEdge(7,3);
		g.addEdge(7,8);

		g.addEdge(8,4);
		g.addEdge(8,7);
		g.addEdge(8,11);

		g.addEdge(9,4);
		g.addEdge(9,10);
		g.addEdge(9,11);

		g.addEdge(10,5);
		g.addEdge(10,6);
		g.addEdge(10,9);

		g.addEdge(11,8);
		g.addEdge(11,9);
		g.bfs(g,0);
		System.out.println("************************************");
		g.dfs(g,0);
		System.out.println("************************************");
		System.out.println("Shortest:"+g.shortestPath(g,0,11));
		Scanner sc = null;
		try { 
			sc = new Scanner(ClassLoader.getSystemClassLoader().getResourceAsStream("revision/graphs/mediumg.txt")) ;
			int V = sc.nextInt();
			int E= sc.nextInt();

			Graph g2 = new Graph(V,E);
			while (sc.hasNext()) {
				g2.addEdge(sc.nextInt(),sc.nextInt());
			}
			System.out.println("Vertices:"+g2.V()+"::Edges::"+g2.E());
			g2.dfsMod(g2,0);
			System.out.println("*******************PRINTING PATHS************");
			int nodes = g2.V();
			for (int i=0;i<nodes;i++) {
				if (g2.pathTo.containsKey(i)) {
					List<Integer> paths=g2.path(i);
					for (Integer n:paths) {
						System.out.print(n);System.out.print("\t");
					}
				}
				System.out.println("++++++++++++++++++++++++++++++++++++++");
			}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
			
		 finally {
			sc.close();
		}

	}
	
}

enum Color {
	WHITE, GRAY,BLACK;
}