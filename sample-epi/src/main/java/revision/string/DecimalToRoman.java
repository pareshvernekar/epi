package revision.string;
import java.util.*;

public class DecimalToRoman {

	private final static TreeMap<Integer, String> valueMap = new TreeMap<Integer, String>();

	static {
		valueMap.put(1,"I");
		valueMap.put(4,"IV");
		valueMap.put(5,"V");
		valueMap.put(9,"IX");
		valueMap.put(10,"X");
		valueMap.put(40,"XL");
		valueMap.put(50,"L");
		valueMap.put(90,"LC");
		valueMap.put(100,"C");
		valueMap.put(400,"CD");
		valueMap.put(500,"D");
		valueMap.put(900,"DM");
		valueMap.put(1000,"M");

	}
	

	public String convert(int input) {

		if (input <= 0)
			throw new IllegalArgumentException("Invalid parameter values");

		StringBuilder strBuilder = new StringBuilder();

		int l = valueMap.floorKey(input);
		System.out.println(l);
		if (input > l)
			strBuilder.append(valueMap.get(l)).append(convert(input-l));
		else
			strBuilder.append(valueMap.get(l));

		return strBuilder.toString();

	}

	public static void main(String[] argv) {

		DecimalToRoman dtr = new DecimalToRoman();
		System.out.println("1:"+dtr.convert(1));
		System.out.println("4:"+dtr.convert(4));
		System.out.println("9:"+dtr.convert(9));
		System.out.println("10:"+dtr.convert(10));
		System.out.println("11:"+dtr.convert(11));
		System.out.println("29:"+dtr.convert(29));

		System.out.println("100:"+dtr.convert(100));
		System.out.println("99:"+dtr.convert(99));

	}

	

}