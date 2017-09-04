package revision.graphs;

import java.util.*;
import java.io.*;

public class Cycle {
	Deque<Integer> stack = new LinkedList<>();

	public boolean hasCycle(Graph g) {
		Deque<Integer> q = new LinkedList<>();
		for (int i:g.adjacencyList.keySet()){
			q.addLast(i);
		
			while (!q.isEmpty()) {
				Integer temp = q.removeLast();
				System.out.println("Processing::"+temp);
				g.color[temp]=Color.GRAY;
				stack = new LinkedList<>();
				stack.add(temp);
				for (Integer node:g.adjacencyList.get(temp)) {
					System.out.println("Adj::"+node+g.color[node]);
					stack.add(node);
					if (g.color[node].equals(Color.WHITE)) {
						q.addLast(node);
					} else if(g.color[node].equals(Color.GRAY)) {
						return Boolean.TRUE;
					}
				}
			}
			g.color[i]=Color.BLACK;

		}
		return Boolean.FALSE;
	}

	public static void main(String[] argv) {

		Scanner sc = null;
		try { 
				sc = new Scanner(ClassLoader.getSystemClassLoader().getResourceAsStream("revision/graphs/tinyg.txt")) ;
				int V = sc.nextInt();
				int E= sc.nextInt();
				Graph g = new Graph(V,E);
				while (sc.hasNext()) {
					g.addEdge(sc.nextInt(),sc.nextInt());
				}
				Cycle c = new Cycle();
				System.out.println("Cycle:"+c.hasCycle(g));
				while (!c.stack.isEmpty()) {
					System.out.println(c.stack.poll());
				}
		} catch(Exception ex) {
				ex.printStackTrace();
		} finally {
			sc.close();
		}
	}
}

