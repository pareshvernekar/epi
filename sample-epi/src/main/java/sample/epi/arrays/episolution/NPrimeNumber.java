package sample.epi.arrays.episolution;

import java.util.*;

//6.8
public class NPrimeNumber {

	public static List<Integer> getNPrimes(int N) {
		boolean[] arr = new boolean[N];
		List<Integer> primeNumbers = new ArrayList();
		arr[0]=Boolean.FALSE;
		for (int i=1;i<N;i++) {
			if (!arr[i]) {
				if (isPrime(i+1)) {
					markNotPrime(arr,i+1,N);
				}
			}
		}
		for (int i=1;i<N;i++) {
			if (!arr[i])
				primeNumbers.add(i+1);
		}
		return primeNumbers;
	}

	private static void markNotPrime(boolean[] arr, int currNumber, int N) {
		int count = 2;
		while (currNumber*count <= N) {
			arr[(currNumber*count)-1]=Boolean.TRUE;
			count+=1;
		}
	}

	private static boolean isPrime(int N) {
		int sqrt = (int)Math.sqrt(N);
		for (int i=2;i<sqrt;i++) {
			if (N%i==0) return Boolean.FALSE;
		}
		return Boolean.TRUE;
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
		int N = scanner.nextInt();
		System.out.println(toString(getNPrimes(N)));
		scanner.close();
	}
}