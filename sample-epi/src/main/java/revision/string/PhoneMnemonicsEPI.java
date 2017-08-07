package revision.string;

import java.util.*;

public class PhoneMnemonicsEPI {


	static Map<Character,String> phoneLettersMap = new HashMap<>();

	static {
		phoneLettersMap.put('0',"0");
		phoneLettersMap.put('1',"1");
		phoneLettersMap.put('2',"ABC");
		phoneLettersMap.put('3',"DEF");
		phoneLettersMap.put('4',"GHI");
		phoneLettersMap.put('5',"JKL");
		phoneLettersMap.put('6',"MNO");
		phoneLettersMap.put('7',"PQRS");
		phoneLettersMap.put('8',"TUV");
		phoneLettersMap.put('9',"WXYZ");
	}


	public List<String> mnemonics(String input) {

		if (input == null || input.length()==0)
			return null;
		char[] ch = new char[input.length()];

		List<String> result = new ArrayList<>();
		helper(input,0,ch,result);
		return result;
	}


	public void helper(String input, int curPos, char[] ch, List<String> result) {

		if (curPos == input.length())
			result.add(new String(ch));

		else {
			String mapping = phoneLettersMap.get(input.charAt(curPos));
			for (int i = 0; i < mapping.length();i++) {

				ch[curPos] = mapping.charAt(i);
				helper(input, curPos+1, ch, result);
			}

		}

	}
	

	public static void main(String[] argv) {

		String phoneNumber = "2276696";
		PhoneMnemonicsEPI pm = new PhoneMnemonicsEPI();
		List<String> results = pm.mnemonics(phoneNumber);
		System.out.println("RESULTS:"+results.size());
		/*Iterator<String> iter = results.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}*/

	}
}