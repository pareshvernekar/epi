package revision.graphs;

import java.util.*;
import java.io.*;

public class SymbolGraph {
	
	Map<String,Integer> nameIndexMap = new HashMap<>();
	String[] keys;
	Graph g;
	int[] edgeTo;
	boolean[] visited;
	int[] distance;

	public void doBFS(Graph g, int src) {
		edgeTo=new int[g.V()];
		visited=new boolean[g.V()];
		distance=new int[g.V()];
		bfs(g,src);
	}

	
	private void bfs(Graph g, int src) {
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		visited[src]=Boolean.TRUE;
		edgeTo[src]=src;
		distance[src]=0;

		while (!q.isEmpty()) {

			int temp = q.poll();
			for (Integer child:g.adjacencyList.get(temp)) {
				if (!visited[child]) {
					edgeTo[child] = temp;
					distance[child]=distance[temp]+1;
					visited[child]=Boolean.TRUE;
					q.add(child);
				}
			}
		}
	}
	public Deque<Integer> path(int src, int dest) {
		if (!visited[src] || !visited[dest])
			return new LinkedList<>();

		Deque<Integer> path = new LinkedList<>();
		for (int i=dest;i !=0 && i != src;i=edgeTo[i]) {
			path.addFirst(i);
		}
		path.addFirst(src);

		return path;
	}
	public Graph graph() {
		return g;
	}
	public boolean contains(String src) {
		return nameIndexMap.containsKey(src);
	}

	public int index(String src) {
		if (!contains(src))
			return -1;
		return nameIndexMap.get(src);
	}
	public String symbol(int index) {
		if (index >= keys.length)
			return "";
		return keys[index];
	}
	public SymbolGraph(String fileName, String separator) {
		Scanner sc = null;
		System.out.println(fileName+"::"+separator+"::");
		try { 
				sc = new Scanner(ClassLoader.getSystemClassLoader().getResourceAsStream(fileName)) ;
				while (sc.hasNext()) {
					String s[] = sc.nextLine().split(separator);
					for (int i=0;i<s.length;i++) {
						if (!nameIndexMap.keySet().contains(s[i])) {
							nameIndexMap.put(s[i],nameIndexMap.size());
						}
					}
				}
				keys=new String[nameIndexMap.keySet().size()];

				for(String str:nameIndexMap.keySet()) {
					keys[nameIndexMap.get(str)]=str;
				}
				
				g = new Graph();
				g.vertices = keys.length;
				sc = new Scanner(ClassLoader.getSystemClassLoader().getResourceAsStream(fileName)) ;
				while (sc.hasNext()) {
					String s[] = sc.nextLine().split(separator);
					int v = nameIndexMap.get(s[0]);
					for (int i=1;i<s.length;i++) {
						g.addEdge(v,nameIndexMap.get(s[i]));
					}
				}

		} catch(Exception ex) {
				ex.printStackTrace();
		} finally {
			sc.close();
		}
	}

	public static void main(String[] argv) {
		String filename = argv[0];
		String separator = argv[1];
		String source = argv[2];
		String target = argv[3];
		SymbolGraph sg = new SymbolGraph("revision/graphs/"+filename,separator);
		Graph g = sg.graph();
		if (sg.contains(source)) {
			int srcKey = sg.index(source);
			if (sg.contains(target)) {
				int tgtKey = sg.index(target);
				sg.doBFS(g,srcKey);
				Deque<Integer> path = sg.path(srcKey,tgtKey);
				for (Integer i:path) {
					System.out.print(sg.symbol(i));System.out.print("\t");
				}
				System.out.println();
				System.out.println("Distance::"+sg.distance[tgtKey]);
			} else {
				System.out.println(target +" Not in database");
			} 
		} else {
			System.out.println(source +" Not in database");
		}



	}
}