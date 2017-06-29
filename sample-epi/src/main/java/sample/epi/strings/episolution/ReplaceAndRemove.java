package sample.epi.strings.episolution;

import java.util.*;
//7.4
public class ReplaceAndRemove {

	public static void replace(char[] charArr, int size) {
		int currIdx = 0, writeIdx = 0;
		int aCount = 0;
		for (int i=0;i<size;i++) {
			if (charArr[i] != 'b') {
				charArr[writeIdx++]=charArr[i];
			} else {
				charArr[i]='\u0000';
			}
			if (charArr[i]=='a') {
				aCount+=1;
			}

		}
		currIdx = writeIdx -1;
		writeIdx = writeIdx+aCount-1;
		System.out.println("currIdx:"+currIdx);
		while (currIdx>=0) {
			if (charArr[currIdx]=='a') {
				charArr[writeIdx--]='d';
				charArr[writeIdx--]='d';
			} else {
				charArr[writeIdx--]=charArr[currIdx];
			}
			currIdx-=1;
		}	
		print(charArr);
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
		charArr[2]='a';
		charArr[3]='c';
		print(charArr);
		replace(charArr,N);
		
		scanner.close();
	}
}