package revision.dp;

import java.util.*;

public class EditDistance {
	
	private int min(int x, int y, int z) {

		if (x < y && y < z)
			return x;
		else if (y < x && x < z)
			return y;
		else 
			return z;
	}

	public int minEdit(String str1, String str2, int m, int n) {
		int edit[][] = new int[m+1][n+1];
		for (int i=0;i<=m;i++) {

			for (int j=0;j<=n;j++) {
				if (i==0)
					edit[i][j]=j;
				else if (j==0)
					edit[i][j]=i;
				else if (str1.charAt(i-1)==str2.charAt(j-1)) 
					edit[i][j]=edit[i-1][j-1];
				else edit[i][j]=1+min(edit[i][j-1],edit[i-1][j],edit[i-1][j-1]);
				System.out.println(edit[i][j]);
			}

		}

		return edit[m][n];
	}

	public static void main(String[] argv) {
		EditDistance ed = new EditDistance();
		String str1 = "geek";
		String str2 = "gesek";
		System.out.println(ed.minEdit(str1,str2,str1.length(),str2.length()));
	}

}