package revision.string;

import java.util.*;

/*
* . DOT	3
* , COMMA	5
* ! EXCLAMATIONMARK	15	
*/
public class TelexEncoding {
	


	public String encode(String input) {


		if (input == null || input.length() == 0)
			return input;

		int len = input.length();
		int reqLen = 0;

		for (int i=0;i<len;i++) {
			if (Character.isLetter(input.charAt(i)) || Character.isDigit(input.charAt(i)) || ' '==input.charAt(i))
				reqLen++;
			else //punctuation mark 
				reqLen+=getLength(input.charAt(i));
		}

		char[] inputArr = convertToArray(input, reqLen);
		reqLen-=1;
		len-=1;
		while (len != 0) {
			if (Character.isLetter(input.charAt(len)) || Character.isDigit(input.charAt(len)) || ' '==input.charAt(len)) {
				inputArr[reqLen]=input.charAt(len);
				reqLen-=1;
			} else {

				switch (inputArr[len]) {
					case '.': {
						inputArr[reqLen--]='T';inputArr[reqLen--]='O';inputArr[reqLen--]='D';
						break;
						}
					case  '!' : {
						inputArr[reqLen--]='K';inputArr[reqLen--]='R';inputArr[reqLen--]='A';inputArr[reqLen--]='M';inputArr[reqLen--]='N';inputArr[reqLen--]='O';
						inputArr[reqLen--]='I';inputArr[reqLen--]='T';inputArr[reqLen--]='A';inputArr[reqLen--]='M';inputArr[reqLen--]='A';
						inputArr[reqLen--]='L';inputArr[reqLen--]='C';inputArr[reqLen--]='X';inputArr[reqLen--]='E';
						break;
					}
					case  ',' : {
						inputArr[reqLen--]='A';inputArr[reqLen--]='M';inputArr[reqLen--]='M';inputArr[reqLen--]='O';inputArr[reqLen--]='C';
						break;
						}
					default:	{
					
						}
				}

			}
			len-=1;
		}
		return new String(inputArr);
	}
	private char[] convertToArray(String input, int reqLen) {

		char[] result = new char[reqLen];
		int len = input.length();
		for (int i=0;i<len;i++) {
			result[i]=input.charAt(i);
		}
		return result;
	}
	private int getLength(char ch) {
		int len = 0;
		switch (ch) {
			case '.': {
				len = 3;
				break;
				}
			case  '!' : {
					len= 15;
					break;
				}
			case  ',' : {
					len= 5;
					break;
					}
			default:	{
					len= 0;
				}
		}
		return len;

	}

	public static void main(String[] argv) {

		String input = "Wow, this is a wonderful idea! Are you in.";
		TelexEncoding te = new TelexEncoding();
		System.out.println(te.encode(input));
	}

}