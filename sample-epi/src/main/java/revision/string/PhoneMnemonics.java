package revision.string;

import java.util.*;

public class PhoneMnemonics {


	static Map<Character,String> phoneLettersMap = new HashMap<>();

	static {

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
		List<String> results = new ArrayList<>();
		helper(input,0,new ArrayList<>(),results);
		return results;
	}

	public void helper(String input, int currPos,List<StringBuilder> intermediate,List<String> results) {


		List<StringBuilder> temp = new ArrayList<>();


		if (currPos == input.length()) {
				Iterator<StringBuilder> iter = intermediate.iterator();
				while (iter.hasNext()) {
					results.add(iter.next().toString());
				}
		} else {
			String mapping = phoneLettersMap.get(input.charAt(currPos));
			if (currPos==0) {

				for (int i = 0;i<mapping.length();i++) {
					StringBuilder sb = new StringBuilder();
					intermediate.add(sb.append(mapping.charAt(i)));
				}
				helper(input,currPos+1,intermediate,results);
			} else {
					Iterator<StringBuilder> iter = intermediate.iterator();
					
					while (iter.hasNext()) {
						StringBuilder sb = iter.next();
						for (int i = 0;i<mapping.length();i++) {
							StringBuilder sb1 = new StringBuilder();
							sb1.append(sb.toString());
							temp.add(sb1.append(mapping.charAt(i)));
						}
					}
				helper(input,currPos+1,temp,results);
			}
		}

	}


	public static void main(String[] argv) {

		String phoneNumber = "2276696";
		PhoneMnemonics pm = new PhoneMnemonics();
		List<String> results = pm.mnemonics(phoneNumber);
		System.out.println("RESULTS:"+results.size());
		/*Iterator<String> iter = results.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}*/

	}

}