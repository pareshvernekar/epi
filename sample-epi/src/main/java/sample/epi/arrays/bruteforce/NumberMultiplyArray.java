package sample.epi.arrays.bruteforce;

import java.util.*;

public class NumberMultiplyArray {

	public static List<Integer> multiple(List<Integer> operand1, List<Integer> operand2) {

		if (operand1 == null || operand2 == null || 
			operand1.size() ==0 || operand2.size() ==0) {
			throw new IllegalArgumentException("Invalid parameter values");
		}
		List<Integer> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		int len1 = operand1.size();
		int len2 = operand2.size();
		List<Integer> source1 = null;
		List<Integer> source2 = null;
		int sumCarry = 0;
		source1=(len1>=len2)?operand1:operand2;
		source2=(len1 < len2)?operand1:operand2;
		System.out.println(" Source1:"+toString(source1));
		System.out.println(" Source2:"+toString(source2));
		int carry=0;
		for (int i=0;i<source1.size();i++) {
			int n = source1.get(i);
			for (int j=0;j<source2.size();j++) {
				int res = n * source2.get(j)+carry;
				if (res > 10) {
					carry = res/10;
					res = res%10;
				}
				else
					carry = 0;
				temp.add(res);
			}
			if (carry != 0) {
				temp.add(carry);
				carry = 0;
			}
			sumCarry=add(result,temp, sumCarry);
		}
		return result;

	}

	private int add(List<Integer> result, List<Integer> temp, int sumCarry) {
		for (int i =0;i < )
	}

	public static String toString(List<Integer> data) {
		if (data==null || data.size()==0)
			return "NULL";
		StringBuilder strBuilder = new StringBuilder();
		int len = data.size();
		for (int i=0;i<len;i++) {
			if (strBuilder.length()==0)
				strBuilder.append(data.get(i));
			else
				strBuilder.append(","+data.get(i));
		}
		return strBuilder.toString();
	}

	public static void main(String[] argv) {

		Scanner scanner = new Scanner(System.in);
		int N1 = scanner.nextInt();
		List<Integer> operand1=new ArrayList<Integer>(N1);

		for (int i=0;i<N1;i++){
			operand1.add(scanner.nextInt());
		}
		int N2 = scanner.nextInt();
		List<Integer> operand2=new ArrayList<Integer>(N1);

		for (int i=0;i<N2;i++){
			operand2.add(scanner.nextInt());
		}
		System.out.println(toString(operand1));
		System.out.println(toString(operand2));
		System.out.println("RESULT:"+multiple(operand1, operand2));
		scanner.close();
	}
}