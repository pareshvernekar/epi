package sample.epi.arrays.episolution;

import java.util.*;

//6.8
public class NPrimeNumberMod {

	
	public static String getNPrimes(int N) {
		List<Boolean> primeNumbers = new ArrayList<>(Collections.nCopies(N,Boolean.TRUE));
		StringBuilder strBuilder = new StringBuilder();
		for (int i=1;i<N;i++) {
			if (primeNumbers.get(i)) {
					markNotPrime(primeNumbers,i+1);
				}
		}
		for (int i=1;i<N;i++) {
			if (primeNumbers.get(i))
				strBuilder.append(i+1).append(",");
		}
		return strBuilder.toString();
	}

	private static void markNotPrime(List<Boolean> primeNumbers, int currNumber) {
		int count = 2;
		int len = primeNumbers.size();
		while (currNumber*count <= len) {
			primeNumbers.set((currNumber*count)-1,Boolean.FALSE);
			count+=1;
		}
	}

	

	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		System.out.println(getNPrimes(N));
		scanner.close();
	}
}