
// You are given a m x n 2D grid initialized with these three possible values.

// -1 - A wall or an obstacle.
// 0 - A gate.
// INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
// Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

// For example, given the 2D grid:
// INF  -1  0  INF
// INF INF INF  -1
// INF  -1 INF  -1
//   0  -1 INF INF
// After running your function, the 2D grid should be:
//   3  -1   0   1
//   2   2   1  -1
//   1  -1   2  -1
//   0  -1   3   4

package revision.graphs;

import java.util.*;

public class GateDistance {
	

	public void grid(int[][] input) {

		if (input == null)
			throw new IllegalArgumentException("Empty parameter values");


		int rowLen = input.length;
		int colLen = input[0].length;
		for (int i=0;i<rowLen;i++) {
			for (int j=0;j<colLen;j++) {
				if (input[i][j]==0) {
					helper(input,i,j,0);
				}
			}
		}
	}

	private void helper(int[][] input, int row, int col, int distance) {
		
		if (row < 0 || row >= input.length ||
			col < 0 || col >= input[0].length	||
			input[row][col] < distance)
			return;
		
			input[row][col]  = distance;
			helper(input,row-1,col,distance+1);
			helper(input,row+1,col,distance+1);
			helper(input,row,col-1,distance+1);
			helper(input,row,col+1,distance+1);
	
	}

	public static void main(String[] argv) {

		int[][] input = {

							{Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
							{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
							{Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
							{0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE},
						};

		GateDistance gd = new GateDistance();
		gd.grid(input);

		int i = input.length;
		int j = input[0].length;
		for (int k=0;k<i;k++) {
			for (int l=0;l<j;l++) {
				System.out.print(input[k][l]);System.out.print("\t");
			}
			System.out.println();
		}
		System.out.println();
	}

}