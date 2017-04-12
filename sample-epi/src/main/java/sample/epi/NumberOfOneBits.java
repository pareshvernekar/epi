package sample.epi;

/*
 * Count the number of 1 in a number
 */
public class NumberOfOneBits {

	public static short count(int n) {
		short i = 0;
		while (n != 0) {
			i += (n & 1);	// 5 & 1	--> 101 & 1, 
			n >>>= 1;
		}
		return i;
	}
	
	public static void main(String[] argv) {
		System.out.println(count(13));
		System.out.println( 5 & 1);
	}
}
