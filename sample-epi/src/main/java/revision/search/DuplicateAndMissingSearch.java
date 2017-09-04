package revision.search;

import java.util.*;

public class DuplicateAndMissingSearch {
	
	public static void main(String[] argv) {
		int[] input= {5,3,0,3,1,2};
		DuplicateAndMissingSearch dmss = new DuplicateAndMissingSearch();
		DuplicateAndMissing dm = dmss.search(input);
		System.out.println(dm.dup+"::"+dm.miss);
	}

	public DuplicateAndMissing search(int[] input) {
		if (input == null || input.length<=1)
			return null;

		int missDupXOR = 0;
		int len = input.length;
		for (int i=0;i<len;i++) {
			missDupXOR^=i^input[i];
		}

		int differBit = missDupXOR & (~(missDupXOR-1));
		int missOrDup = 0;
		for (int i=0;i<len;i++) {

			if ((i & differBit) != 0) {
				missOrDup^=i;
			}

			if ((input[i] & differBit) != 0) {
				missOrDup^=input[i];
			}
		}
		for (int i=0;i<len;i++) {
			if (input[i]==missOrDup) {
				return new DuplicateAndMissing(missOrDup,missDupXOR^missOrDup);
			}
		}
		return new DuplicateAndMissing(missDupXOR^missOrDup,missOrDup);
	} 

}

class DuplicateAndMissing {
	int dup;
	int miss;
	public DuplicateAndMissing(int dup, int miss) {
		this.dup=dup;
		this.miss=miss;
	}
}