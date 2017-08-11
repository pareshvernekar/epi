 /*5 7 8 9
 2 3 4 6
 1 9 8 0
 2 3 6 9
 */



 package revision.arrays;

 import java.io.*;

 public class FindElement {

 	public static int element(int[] B, int r, int c) {

 		int col = B[0];

 		int drow = getRow(col, r,c);
 		return B[drow+1];
 	}
	private static int getRow(int col, int r, int c) {

 		return (r-1)*col+(c-1);
 	} 
 	public static void main(String[] argv) {

 		int[] B = {4,5,7,8,9,2,3,4,6,1,9,8,0,2,3,6,9};

 		System.out.println(element(B,1,1));
 		System.out.println(element(B,1,2));
 		System.out.println(element(B,1,3));
 		System.out.println(element(B,1,4));
 		System.out.println(element(B,2,2));
 		System.out.println(element(B,3,3));
 		System.out.println(element(B,4,4));
 		System.out.println(element(B,1,4));
 	}
 }

