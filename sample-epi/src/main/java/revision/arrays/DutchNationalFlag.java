package revision.arrays;

import java.util.*;

public class DutchNationalFlag {
	
	public void rearrange(List<Color> input, int i) {
		Color pivot = input.get(i);
		int smaller = 0;
		for (int k=0;k<input.size();k++) {

			if (input.get(k).ordinal() < pivot.ordinal()) {
				Collections.swap(input,smaller++,k);
			}
		}
		int larger=input.size()-1;
		for (int j=input.size() -1; j >= 0 && 
			input.get(j).ordinal() >= pivot.ordinal();j--) {
			if (input.get(j).ordinal() > pivot.ordinal()) {
				Collections.swap(input,larger--,j);
			}
		}
	}

	public void rearrangeMod(List<Color> input, int i) {
		Color pivot = input.get(i);

		int smaller=0, equal=0, larger = input.size();

		while (equal < larger) {
			if (input.get(equal).ordinal() < pivot.ordinal()) {
				Collections.swap(input, equal++,smaller++);
			} else if (input.get(equal).ordinal()==pivot.ordinal()) {
				equal++;
			} else {
				Collections.swap(input, equal,--larger);
			}


		}
	}

	public static void main(String[] argv) {

		DutchNationalFlag dnf = new DutchNationalFlag();
		List<Color> colorList = new ArrayList<>();
		colorList.add(Color.RED);
		colorList.add(Color.WHITE);
		colorList.add(Color.BLUE);
		colorList.add(Color.WHITE);
		colorList.add(Color.BLUE);
		colorList.add(Color.BLUE);
		colorList.add(Color.RED);
		colorList.add(Color.WHITE);
		colorList.add(Color.RED);
		dnf.rearrange(colorList,3);
		for (Color color:colorList) {
			System.out.print(color.ordinal());System.out.println("\t");
		}
		System.out.println();

		colorList = new ArrayList<>();
		colorList.add(Color.RED);
		colorList.add(Color.WHITE);
		colorList.add(Color.BLUE);
		colorList.add(Color.WHITE);
		colorList.add(Color.BLUE);
		colorList.add(Color.BLUE);
		colorList.add(Color.RED);
		colorList.add(Color.WHITE);
		colorList.add(Color.RED);
		dnf.rearrangeMod(colorList,3);
		for (Color color:colorList) {
			System.out.print(color.ordinal());System.out.println("\t");
		}
		System.out.println();


	}

}


enum Color  {
	RED, 
	WHITE,
	BLUE;
}