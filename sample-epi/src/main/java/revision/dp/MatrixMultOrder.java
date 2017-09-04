package revision.dp;
import java.util.*;

public class MatrixMultOrder {


	public int costOfMult(int[] input, int i, int j) {

		if (i==j)
			return 0;
		int min = Integer.MAX_VALUE;
		for (int k=i;k<j;k++) {
			int cost = costOfMult(input, i,k)+costOfMult(input,k+1,j)+input[i-1]*input[k]*input[j];
			if (cost < min)
				min = cost;
		}
		return min;

	}
	
	public static void main(String[] argv) {
		int[] input1 = {40, 20, 30, 10, 30};
		int[] input2 = {10, 20, 30, 40, 30};
		int[] input3 = {10, 20, 30};

		MatrixMultOrder mmo = new MatrixMultOrder();
		System.out.println(mmo.costOfMult(input1,1,input1.length-1));
		System.out.println(mmo.costOfMult(input2,1,input2.length-1));
		System.out.println(mmo.costOfMult(input3,1,input3.length-1));
	}
}