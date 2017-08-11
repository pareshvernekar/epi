// Given an array of integers, return indices of the two numbers such that they add up to a specific target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// Example:
// Given nums = [2, 7, 11, 15], target = 9,

// Because nums[0] + nums[1] = 2 + 7 = 9,
// return [0, 1].

package revision.arrays;
import java.util.*;
public class TwoSum {


	public List<Integer> checkTwoSum(int[] input, int target) {

		if (input == null || input.length==0)
			return null;
		List<Integer> results = new ArrayList<>(2);
		for (int i=0;i<input.length;i++) {
			int required = target - input[i];
			for (int j=0;j<input.length;j++) {
				if (i==j) continue;
				if (input[j] == required) {
					results.add(i);
					results.add(j);
					return results;
				}
			}
		}
		return null;
	}

	public List<Integer> checkTwoSumMod(int[] input, int target) {

		if (input == null || input.length==0)
			return null;
		Map<Integer,Integer> indexMap = new HashMap<>();
		List<Integer> results = new ArrayList<>(2);
		for (int i=0;i<input.length;i++) {
			if (indexMap.containsKey(target-input[i])) {
				results.add(i);
				results.add(indexMap.get(target-input[i]));
				return results;
			}
			indexMap.put(input[i],i);
		}
		return null;
	}


	public static void main(String[] argv) {

		TwoSum ts = new TwoSum();
		int[] input = {2,7,11,15};
		List<Integer> indices = ts.checkTwoSumMod(input,9);
		System.out.println(indices != null? (indices.get(0)+"::"+indices.get(1)):"NULL");

		indices = ts.checkTwoSumMod(input,18);
		System.out.println(indices != null? (indices.get(0)+"::"+indices.get(1)):"NULL");

		indices = ts.checkTwoSumMod(input,23);
		System.out.println(indices != null? (indices.get(0)+"::"+indices.get(1)):"NULL");


	}
}