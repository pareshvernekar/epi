package sample.epi.strings.episolution;

import java.util.*;

public class TelexReplace {
	

	public static void replaceDOT(char[] modCharArr, int size) {

		int currIdx = size - 1;
		int writeIdx = modCharArr.length - 1;

		while (currIdx >=0) {
			if (modCharArr[currIdx]=='.') {
				modCharArr[writeIdx--]='T';
				modCharArr[writeIdx--]='O';
				modCharArr[writeIdx--]='D';
			} else {
				modCharArr[writeIdx--]=modCharArr[currIdx];
			}
			currIdx-=1;
		}
			System.out.println(modCharArr);

	}
	public static void main(String[] argv) {

		Scanner scanner = new Scanner(System.in);
		String telexStr = scanner.next();
		char[] charArr = telexStr.toCharArray();
		int len = charArr.length;
		int dotCount =0;
		for (int i=0;i<len;i++) {
			if (charArr[i]=='.') {
				dotCount+=1;
			}
		}
		char[] modCharArr = new char[len+dotCount*2];
		for (int i =0;i<len;i++) {
			modCharArr[i]=charArr[i];
		}
		replaceDOT(modCharArr,len);
		scanner.close();
	}

}