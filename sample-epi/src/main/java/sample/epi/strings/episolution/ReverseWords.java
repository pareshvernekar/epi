package sample.epi.strings.episolution;

public class ReverseWords {
	
	public static String reverseWords(String test) {
		if (test == null || test.isEmpty())
			throw new IllegalArgumentException("Invalid parameter values");
		char[] testArr = test.toCharArray();

		reverse(testArr,0,testArr.length-1);
		System.out.println("Initial reverse:"+new String(testArr));
		int spacePos;
		int start=0;
	//	while (start < testArr.length) {
			while ((spacePos=find(testArr,start,' '))!=-1) {
				reverse(testArr,start,spacePos-1);
				System.out.println("Intermediate reverse:"+new String(testArr));
				System.out.println("OLD start:"+start+":SPACEPOS:"+spacePos);
				start=spacePos+1;
				System.out.println("NEW start:"+start);
			} 
				reverse(testArr,start,testArr.length-1);
//		}

		System.out.println("After String reverse:"+new String(testArr));
		return new String(testArr);
	}

	public static int find(char[] testArr, int start, char ch) {
		for (int i=start;i<testArr.length;i++) {
			if (testArr[i]==ch) {
				return i;
			}
		}
		return -1;
	}

	private static void reverse(char[] testArr, int start, int end) {

		int j = end;
		System.out.println("Start:"+start+":END:"+end);
		for (int i = start;i <=(start+end)/2;i++) {
			System.out.println("i:"+i+":j:"+j);
			char ch = testArr[i];
			testArr[i]=testArr[j];
			testArr[j--]=ch;
		}

	}

	public static void main(String[] argv) {
		String test = "ram iscostly";
		System.out.println(reverseWords(test));

	}
}