package revision.graphs;

import java.util.*;
import java.io.*;

public class WordLadder {

	Map<String,Integer> indexMap = new HashMap<>();
	String[] keys;

	public Graph constructGraph(List<String> keyWords) {
		if (keyWords==null || keyWords.isEmpty())
			throw new IllegalArgumentException("Invalid argument");
		for (String s:keyWords) {
			if (!indexMap.containsKey(s)) {
				indexMap.put(s,indexMap.size());
			}
		}
		
		keys = new String[indexMap.keySet().size()];

		for (String key:indexMap.keySet()) {
			keys[indexMap.get(key)]=key;
		}

		Graph g = new Graph();
		g.vertices = indexMap.size();
		for (int i=0;i<keys.length;i++) {
			String key = keys[i];
			for (String k:indexMap.keySet()) {
				if (k.equals(key)) continue;
				if (oneLetterDifferMod(key,k)) {
					g.addEdge(indexMap.get(key),indexMap.get(k));
				}

			}
		}
		return g;
	}

	public Deque<String> wordLadder(Graph g, int src, int dest) {
		boolean[] visited = new boolean[g.V()];
		int[] edgeTo = new int[g.V()];
		Deque<String> path = new LinkedList<>();
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		visited[src]=Boolean.TRUE;
		while (!q.isEmpty()) {
			Integer temp = q.poll();
			if (temp==dest) break;
			for (Integer child:g.adjacencyList.get(temp)) {
				if (!visited[child]) {
					q.add(child);
					visited[child]=Boolean.TRUE;
					edgeTo[child]=temp;
				}
			}
		}if (visited[dest]) {
			for (int i=dest;i!=src;i=edgeTo[i]) {
				path.addFirst(keys[i]);
			}
			path.addFirst(keys[src]);
		}
		return path;

	}

	private boolean oneLetterDiffer(String k1, String k2) {
		if (k1==null || k2==null || k1.isEmpty()||k2.isEmpty() || k1.length() != k2.length()) return Boolean.FALSE;
		char[] ch1Arr = k1.toCharArray();
		char[] ch2Arr = k2.toCharArray();

		Arrays.sort(ch1Arr);
		Arrays.sort(ch2Arr);

		int len = ch1Arr.length;
		int diff = 0;
		for (int i=0;i<len;i++) {
			if (diff > 1) return Boolean.FALSE;
			if (ch1Arr[i] != ch2Arr[i]) ++diff;
		}

		return (diff > 1?Boolean.FALSE:Boolean.TRUE);
	}

	private boolean oneLetterDifferMod(String k1, String k2) {
		if (k1==null || k2==null || k1.isEmpty()||k2.isEmpty() || k1.length() != k2.length()) return Boolean.FALSE;
		char[] ch1Arr = k1.toCharArray();
		char[] ch2Arr = k2.toCharArray();

		int len = ch1Arr.length;
		int diff = 0;
		for (int i=0;i<len;i++) {
			if (diff > 1) return Boolean.FALSE;
			if (ch1Arr[i] != ch2Arr[i]) ++diff;
		}

		return (diff > 1?Boolean.FALSE:Boolean.TRUE);
	}

	public static void main(String[] argv) {

		WordLadder wl = new WordLadder();
		String word1 = argv[0];
		String word2 = argv[1];
		String fileName = argv[2];
		List<String> keyWords = new ArrayList<>();
		Scanner sc = null;
		try { 
				sc = new Scanner(ClassLoader.getSystemClassLoader().getResourceAsStream("revision/graphs/"+fileName)) ;
				while (sc.hasNext()) {
					keyWords.add(sc.next());
				}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			sc.close();
		}

		Graph g = wl.constructGraph(keyWords);
		Deque<String> words = wl.wordLadder(g,wl.indexMap.get(word1),wl.indexMap.get(word2));
		while (!words.isEmpty()) {
			System.out.print(words.poll());System.out.print("\t");
		}
		System.out.println();
	}
}