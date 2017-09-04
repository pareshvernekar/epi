package revision.dp;

import java.util.*;

/*
* http://www.geeksforgeeks.org/longest-common-subsequence/
*/


public class LCSDP {
	
	public int lcs(String str1,String str2) {
		if (str1==null || str2 == null || str1.length()==0 || str2.length() == 0)
			return 0;
		return process(str1,str1.length()-1,str2,str2.length()-1);
	}

	public int process(String str1, int n, String str2 , int m) {
		if (m >= 0 && n >=0) {
			if (str1.charAt(n)==str2.charAt(m)) {
				return 1 + process(str1, n-1, str2, m-1);
			} else if (str1.charAt(n) != str2.charAt(m)) {
				return Integer.max(process(str1, n-1,str2, m), process(str1,n,str2,m-1));
			}
		}
		return 0;
	}

	public static void main(String[] argv) {
		LCSDP lcsDP = new LCSDP();
		System.out.println(lcsDP.lcs("ABCDGH","AEDFHR"));
		System.out.println(lcsDP.lcs("AGGTAB","GXTXAYB"));
	}
}