package revision.graphs;

import java.util.*;
import java.io.*;

public class Digraph {
	
	int vertices;
	int edges;
	boolean[] visited;
	Color[] colors;
	Map<Integer,List<Integer>> adjacencyList = new HashMap<>();

	public Digraph() {

	}

	public Digraph(int V) {
		this.vertices = V;
	}
	public Digraph(int V, int E) {
		this.vertices = V;
		this.edges = E;
	}

	public int V() {
		return this.vertices;
	}

	public int E() {
		return this.edges;
	}

	public void addEdge(int src, int dest) {
		if (!adjacencyList.containsKey(src)) {
			adjacencyList.put(src,new ArrayList<>());
		}
		adjacencyList.get(src).add(dest);
	}

	public List<Integer> adj(int src) {
		if (adjacencyList.containsKey(src)) {
			return adjacencyList.get(src);
		}
		return new ArrayList<>();
	}

	public Digraph reverse() {
		Digraph rd = new Digraph(this.V());
		Map<Integer,List<Integer>> adjacencyList = rd.adjacencyList;

		Map<Integer,List<Integer>> newAdjList = new HashMap<>();
		for (Integer i:adjacencyList.keySet()) {

			List<Integer> childNodes = adjacencyList.get(i);
			for (int j:childNodes) {
				rd.addEdge(j,i);
			}
		}
		return rd;
	}

	public void dfs(Digraph dg, int s) {
		visited[s]=Boolean.TRUE;
		for (Integer i:dg.adjacencyList.get(s)) {
			if (!visited[i])
				dfs(dg,s);
		}
	}

	public String toString() {
		return null;
	}

	public boolean hasCycle(Digraph dg) {
		colors = new Color[dg.V()];
		int[] edgeTo = new int[dg.V()];
		for (int j=0;j<dg.V();j++) {
			colors[j]=Color.WHITE;
		}
		Deque<Integer> stack = new LinkedList<>();
		for (Integer i:dg.adjacencyList.keySet()) {
			if (colors[i].equals(Color.WHITE)) {
				stack.addLast(i);
				while (!stack.isEmpty()) {
					Integer s = stack.poll();
					colors[s]=Color.GRAY;
					if (dg.adjacencyList.get(s) != null) {
						for (Integer child:dg.adjacencyList.get(s)) {
							edgeTo[child]=s;
							if (colors[child].equals(Color.WHITE)) {
								stack.addLast(child);
							}
							else {
								int k=s;
								do {
									System.out.print(k);System.out.print("\t");
									k=edgeTo[k];
								} while (k != child);
								System.out.print(child);
								System.out.println();
								return Boolean.TRUE;
							}
						}
					}
					colors[s]=Color.BLACK;
				}
			}
		}
		return Boolean.FALSE;
	}

	public static void main(String[] argv) {

		String fileName = argv[0];
		Scanner sc=null;
		Digraph dg = null;
		try { 

			sc = new Scanner(ClassLoader.getSystemClassLoader().getResourceAsStream("revision/graphs/"+fileName)) ;
			dg = new Digraph(sc.nextInt(),sc.nextInt());
			int x;
			int y;
			while (sc.hasNext()) {
				x=sc.nextInt();
				y=sc.nextInt();
				dg.addEdge(x,y);
			}
			List<Integer> adjacent = dg.adj(9);
			for (Integer i:adjacent) {
				System.out.print(i);System.out.print("\t");
			}
			System.out.println();
			System.out.println("*************************");
			System.out.println("Cycle:"+dg.hasCycle(dg));
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			sc.close();
		}
	}
}


enum Color {
	WHITE, GRAY, BLACK;
}