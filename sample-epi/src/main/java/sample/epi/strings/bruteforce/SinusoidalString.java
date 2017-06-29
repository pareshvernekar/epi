package sample.epi.strings.bruteforce;

import java.util.*;

public class SinusoidalString {
	
	public static String sinusoidal(String str1) {
		
		StringBuilder strBuilder = new StringBuilder();
		int i = 1;
		int len = str1.length();
		while (i < len) {
			strBuilder.append(str1.charAt(i));
			i+=4;
		}
		i=0;
		while (i < len) {
			strBuilder.append(str1.charAt(i));
			i+=2;
		}

		i=3;
		while (i < len) {
			strBuilder.append(str1.charAt(i));
			i+=4;
		}
		return strBuilder.toString();
	}

	public static void main(String[] argv) {
		String str1 = "Hello_World!";
		System.out.println(sinusoidal(str1));
	}
}
