package revision.stacks;

import java.util.*;

public class PathNormalize {
	
	public String normalize(String path) {
		if (path == null || path.isEmpty())
			return path;
		Deque<String> stack = new LinkedList<>();
		if (path.startsWith("/"))
			stack.addFirst("/");
		for (String token:path.split("/")) {

			if (token.equals("..")) {
				if (stack.isEmpty() || stack.peekFirst().equals(".."))
					stack.addFirst(token);
				else {
					if (stack.peekFirst().equals("/"))
						throw new IllegalArgumentException("Cannot move up a root");
					stack.removeFirst();
				}

			} else if (!token.equals(".") && !token.isEmpty()) {
				stack.addFirst(token);
			}

		}

		StringBuilder strBuilder = new StringBuilder();
		Iterator<String> iter = stack.descendingIterator();
		String prev = iter.next();
		strBuilder.append(prev);
		while (iter.hasNext()) {
			if (!"/".equals(prev))
				strBuilder.append("/");
			prev = iter.next();
			strBuilder.append(prev);
		}

		return strBuilder.toString();
	}


	public static void main(String[] argv) {

		PathNormalize pn = new PathNormalize();
		System.out.println("/:"+pn.normalize("/"));
		System.out.println("/tmp/usr/../var:"+pn.normalize("/tmp/usr/../var"));
		System.out.println("/tmp/usr/../././var:"+pn.normalize("/tmp/usr/../././var"));
		System.out.println("../../var:"+pn.normalize("../../var"));
	}
}