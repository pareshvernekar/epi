package sample.epi.strings.bruteforce;

import java.util.*;
//7.4
public class ReplaceAndRemove {
	
	public static void replace(char[] charArr, int N) {

		int count = 0;
		int currSize = N;
		while (count < currSize) {
			char ch = charArr[count];
			if (ch=='a') {
				System.out.println(count+"::"+currSize);
				currSize=addChar(charArr,count, currSize);
				print(charArr);
				count+=2;
			} else {
				count+=1;
			}
		}
		count = 0;
		while (count < currSize) {
			char ch = charArr[count];
			if (ch=='b') {
				currSize=removeChar(charArr,count, currSize);
				print(charArr);
			} else {
				count+=1;
			}
			System.out.println("Count:"+count);
		}

	}

	private static int removeChar(char[] charArr,int pos, int currSize) {
		while (charArr[pos] != '\u0000') {
			charArr[pos]=charArr[++pos];
		}
		return currSize-1;
	}
	private static int addChar(char[] charArr,int pos, int currSize) {
		
		int i = currSize;
		while (i > pos) {
			charArr[i]=charArr[--i];
		}
		charArr[i]='d';
		charArr[i+1]='d';
		currSize+=1;
		return currSize;
	}

	public static void print(char[] charArr) {
		int i=0;
		char ch =charArr[i];
		int size = charArr.length;
		while (ch !='\u0000' && i < size) {
			
			System.out.print(ch);
			System.out.print(",");
			ch = charArr[++i];
		};
		System.out.println();
	}

	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		int N = 4;
		char[] charArr = new char[2*N];
		charArr[0]='b';
		charArr[1]='b';
		charArr[2]='b';
		charArr[3]='c';
		replace(charArr,N);
		print(charArr);
		scanner.close();
	}
}