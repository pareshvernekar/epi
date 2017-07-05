package sample.epi.stacks.bruteforce;

import java.util.*;

public class WellFormCheck {
	
	public static boolean check(String expr) {
		if (expr == null || expr.isEmpty()) {
			throw new IllegalArgumentException("Invalid parameter value");
		}
		Deque<Character> brackets = new LinkedList();
		char ch = '\u0000';
		int len = expr.length();
		int pos = 0;
		while (pos < len && (ch=expr.charAt(pos))!= -1) {
			pos++;
			if (ch ==',')
				continue;
			if ("{([".indexOf(ch) != -1) {
				brackets.addFirst(ch);
			} else {
				switch (ch) {
					case '}':{
								if (brackets.removeFirst() != '{')
									return false;

								break;
							}
					case ')':{
								System.out.println("brackets.removeFirst()::"+brackets.peekFirst());
								if (brackets.removeFirst() != '(')
									return false;

							break;
							}
					case ']':{

								if (brackets.removeFirst() != '[')
									return false;

							break;
							}
					default:{
								System.out.println(ch);
								return Boolean.FALSE;
								
							}
				}
			}
		}
		return brackets.isEmpty();
	}
	public static void main(String[] argv) {

		String wellformed = "{,},(,),[,]";
		String notWellformed = "{,},(,(,[,]";	
		System.out.println("wellformed :"+check(wellformed));
		System.out.println("wellformed :"+check(notWellformed));
			System.out.println("wellformed :"+check("()(())"));
	}
}