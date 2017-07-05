package sample.epi.stacks.bruteforce;

import java.util.*;

public class PNEval {

	public static long eval(String expr) {
		if (expr == null || expr.isEmpty())
			throw new IllegalArgumentException("Invalid parameter values");
		Deque<Long> operandStack = new LinkedList<>();
		Deque<Character> operatorStack = new LinkedList<>();
		int len = expr.length();
		int pos = 0;
		char ch = '\u0000', ch1='\u0000';
		long result = 0;
				long op1 = 0;
			long op2 = 0;
	
		while (pos < len && (ch=expr.charAt(pos)) != -1) {
			pos++;
			if (ch ==',')
				continue;
			if (Character.isDigit(ch)) {
				operandStack.add((long)ch-'0');
			} else {
				if (!operatorStack.isEmpty()) {
					ch1=operatorStack.removeFirst();
					operatorStack.addFirst(ch);
				} else {
					operatorStack.addFirst(ch);
					continue;
				}
				
				
				switch (ch1) {

					case '+' :{
									op1=operandStack.removeFirst();
									op2=operandStack.removeFirst();
									operandStack.addFirst(op1+op2);
									break;
								}
					case '-' : {
									op1=operandStack.removeFirst();
									op2=operandStack.removeFirst();
									operandStack.addFirst(op1-op2);
									break;}
					case '*' : {
								op1=operandStack.removeFirst();
									op2=operandStack.removeFirst();
									operandStack.addFirst(op1*op2);
								break;
								}
					case '/' : {
									op1=operandStack.removeFirst();
									op2=operandStack.removeFirst();
									operandStack.addFirst(op1/op2);
									break;
								}
					default : {
								break;
								}
				}
			}
		}
		if (!operatorStack.isEmpty()) {
			op1 = operandStack.removeFirst();
			op2 = operandStack.removeFirst();
			ch = operatorStack.removeFirst();
			if ('+'==ch) {
				return op1+op2;
			} else if ('-'==ch) {
				return op1-op2;
			} else if ('*'==ch) {
				return op1*op2;
			} else if ('/'==ch) {
				return op1/op2;
			}
		}
		return 0;

	}

	public static void main(String[] argv) {

		String expr = "*,3,4,*,2,+,5";
		System.out.println(eval(expr));
	}
}