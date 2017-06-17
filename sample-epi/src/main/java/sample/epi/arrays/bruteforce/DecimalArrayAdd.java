package sample.epi.arrays.bruteforce;

import java.util.*;

public class DecimalArrayAdd {
	

	public static int[] add(int[] data, int operand) {
		if (operand==0)
			return data
		;
		if (data == null || data.length==0)
			throw new IllegalArgumentException("Invalid parmeter values");

		int carry = 0;
		int len = data.length;
		for (int i=len-1;i>=0;i--) {
			int	n=carry+data[i]+operand;
			if (n==10) {
				carry=1;
				data[i]=0;
			} else {
				data[i]=n;
				carry=0;
			}

			operand=0;
		}
		System.out.println("carry:"+carry);
		int[] newArr = null;
		if (carry == 1) {

			newArr =  new int[len+1];
			newArr[0]=1;
			System.arraycopy(data,0,newArr,1,len);
			return  newArr;
		}
		return data;
	}


	public static String toString(int[] data) {
		if (data==null || data.length==0)
			return "NULL";
		StringBuilder strBuilder = new StringBuilder();
		int len = data.length;
		for (int i=0;i<len;i++) {

			if (strBuilder.length()==0)
				strBuilder.append(data[i]);
			else
				strBuilder.append(","+data[i]);
		}
		return strBuilder.toString();
	}
	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] data = new int[N];
		for (int i = 0;i<N;i++) {
			data[i]=scanner.nextInt();
		}
		
		System.out.println(toString(add(data,1)));
		scanner.close();
	}
}