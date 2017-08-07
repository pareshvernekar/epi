package revision.string;

import java.util.*;

public class LookAndSay {
	

	public String lookup() {

		int limit = 9;
		List<String> result = new ArrayList<>();
		result.add("1");
		int currPos = 0;
		for (int j=0;j<limit;j++) {
	
			String input = result.get(currPos);
			int count = 0;
			int len = input.length();
			StringBuilder strBuilder = new StringBuilder();
			for (int i=0;i<len;i++) {
				if (i==0) {
					count+=1;
				}	else if (i > 0 && input.charAt(i)==input.charAt(i-1)) {
					count+=1;
				} else if (input.charAt(i)!=input.charAt(i-1))  {
					strBuilder.append(count).append(input.charAt(i-1));
					count=1;
				}
			}

			strBuilder.append(count).append(input.charAt(len-1));
			result.add(strBuilder.toString());
			strBuilder = new StringBuilder();
			currPos+=1;
		}


		return result.get(limit-1);

	}


	public static void main(String[] argv) {
		LookAndSay las = new LookAndSay();
		System.out.println(las.lookup());
	}


}