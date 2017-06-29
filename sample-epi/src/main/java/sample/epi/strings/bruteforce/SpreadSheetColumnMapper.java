package sample.epi.strings.bruteforce;

import java.util.*;


//7.3
public class SpreadSheetColumnMapper {
	
	public static void main(String[] argv) {
	Scanner scanner = new Scanner(System.in);
	String column = scanner.next();
	if (column == null || column.trim().length()==0) {
		throw new IllegalArgumentException();
	}
	int columnNum = 0;
	int len = column.length()-1;
	int i = 0;
	while (i <= len) {
		columnNum=(columnNum*26+(column.charAt(i)-'A'+1));
		i+=1;
	}
	System.out.println("Column Index:"+columnNum);

	scanner.close();
	}
}