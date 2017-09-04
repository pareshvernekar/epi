package revision.dp;
import java.util.*;

public class MinCostPath {
	
	private int min(int x, int y, int z) {
		if (x < y && y < z) return x;
		else if (y < x && x < z) return y;
		else return z;
	}
	
	public int minCost(int[][] cost, int row, int col) {
		if (cost == null || cost[0].length==0)
			return -1;

		int rowLen = cost.length;
		int colLen = cost[0].length;
		System.out.println(rowLen+"::"+colLen);
		int[][] tc = new int[rowLen][colLen];
		//initialize 0th row
		tc[0][0]=cost[0][0];
		for (int i=1;i<colLen;i++)
			tc[0][i]=cost[0][i]+tc[0][i-1];

		//initialize 0th column
		for (int j=1;j<rowLen;j++) {
			System.out.println("j:"+j);
			tc[j][0]=cost[j][0]+tc[j-1][0];
		}
		for (int i=1;i<rowLen;i++) {
			for (int j=1;j<colLen;j++) {
				tc[i][j]=cost[i][j]+min(tc[i-1][j],tc[i][j-1],tc[i-1][j-1]);
			}
		}

		for (int i=0;i<rowLen;i++) {
			for (int j=0;j<colLen;j++) {
				System.out.print(tc[i][j]);System.out.print("\t");
			}
			System.out.println();
		}
		return tc[row][col];
	}

	

	public static void main(String[] argv) {

		MinCostPath mcp = new MinCostPath();
		int[][] cost = {{1,3,5,8},
						{4,2,1,7},
						{4,3,2,3}};
		System.out.println(mcp.minCost(cost,2,3));
	}
}