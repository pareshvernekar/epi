package sample.epi.stacks.bruteforce;

import java.util.*;

public class RPNEval {
	
	public static long evaluate(String str) {

		if (str == null || str.isEmpty())
			throw new IllegalArgumentException("Invalid parameter values");
		Deque<Long> expression = new LinkedList<>();

		int len = str.length();
		char ch='\u0000';
		int i = 0;
		while ((i < len) && ((ch=str.charAt(i)) != -1))
		 {
				long op1 = 0, op2 = 0;
			i++;
			if (ch==',')
				continue;
			if (Character.isDigit(ch)) {
				expression.addFirst((long)(ch - '0'));
			} else {	//character is an operator
					switch (ch) {
					
						case '+':
								{
									if (!expression.isEmpty()) {
										op1 = expression.removeFirst();
									}

									if (!expression.isEmpty()) {
										op2 = expression.removeFirst();
									}
									expression.addFirst(op1+op2);
									break;
								}
						case '-':
								{
									if (!expression.isEmpty()) {
										op1 = expression.removeFirst();
									}

									if (!expression.isEmpty()) {
										op2 = expression.removeFirst();
									}
									expression.addFirst(op1-op2);
									break;
								}
						case '*':
								{
									if (!expression.isEmpty()) {
										op1 = expression.removeFirst();
									}

									if (!expression.isEmpty()) {
										op2 = expression.removeFirst();
									}
									expression.addFirst(op1*op2);
									break;
								}
						case '/' :
								{
									if (!expression.isEmpty()) {
										op1 = expression.removeFirst();
									}

									if (!expression.isEmpty()) {
										op2 = expression.removeFirst();
									}
									expression.addFirst(op1/op2);
									break;
								}

					}
			}
		}
		return expression.removeFirst();
	}

	public static void main(String[] argv) {

		String expr = "3,4,*,2,*,5,+";
		System.out.println(evaluate(expr));
	}
}