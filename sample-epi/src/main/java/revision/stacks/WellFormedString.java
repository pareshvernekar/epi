package revision.stacks;
import java.util.*;
public class WellFormedString {
	
	static String OPEN_BRACKETS="({[";
	static String CLOSED_BRACKETS="]})";
	
	public boolean isWellFormed(String input) {

		if (input == null || "".equals(input) || input.length() == 1)
			return Boolean.FALSE;
		Deque<Character> stack = new LinkedList<>();
		int len = input.length();
		for (int i=0;i<len;i++) {
			if (OPEN_BRACKETS.indexOf(input.charAt(i)) != -1) {
				stack.addFirst(input.charAt(i));
			} else if (CLOSED_BRACKETS.indexOf(input.charAt(i)) != -1) {
				
				if (!check(input.charAt(i),stack)) return Boolean.FALSE;
			} else {
				return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}

	private boolean check(char ch, Deque<Character> stack) {
		boolean isWellFormed = Boolean.FALSE;
		if (stack.isEmpty()) return Boolean.FALSE;
		char ch1 = stack.removeFirst();
		switch(ch) {
			case ')': {
						isWellFormed='('==ch1?Boolean.TRUE:Boolean.FALSE;
						break;
					}
			case '}' : {
						isWellFormed='{'==ch1?Boolean.TRUE:Boolean.FALSE;
						break;
						}
			case ']'  : {
						isWellFormed='['==ch1?Boolean.TRUE:Boolean.FALSE;
						break;
						}
			default :
						isWellFormed=Boolean.FALSE;
		}
		
		return isWellFormed;
	}

	public static void main(String[] argv) {
		WellFormedString wfs = new WellFormedString();
		System.out.println("{}:"+wfs.isWellFormed("{}"));
		System.out.println("{[]}:"+wfs.isWellFormed("{[]}"));
		System.out.println("([{}]):"+wfs.isWellFormed("([{}])"));
		System.out.println("{{]}}:"+wfs.isWellFormed("{{]}}"));
	}
}