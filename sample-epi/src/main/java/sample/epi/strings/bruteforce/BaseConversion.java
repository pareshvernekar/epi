package sample.epi.strings.bruteforce;

import java.util.*;

public class BaseConversion {

                static Map<String,Integer> hexMap = new HashMap<>();
                static Map<Integer,String> reverseHexMap = new HashMap<>();
                static {

                                hexMap.put("A",10);
                                hexMap.put("B",11);
                                hexMap.put("C",12);
                                hexMap.put("D",13);
                                hexMap.put("E",14);
                                hexMap.put("F",15);

                                reverseHexMap.put(10,"A");
                                reverseHexMap.put(11,"B");
                                reverseHexMap.put(12,"C");
                                reverseHexMap.put(13,"D");
                                reverseHexMap.put(14,"E");
                                reverseHexMap.put(15,"F");
                }

                public static String convert(String number, int fromBase, int toBase) {

                                if (number == null || fromBase <= 0 || toBase <= 0)
                                                throw new IllegalArgumentException("Invalid method arguments");

                                int len = number.length()-1;
                                int intermediateRes=0;
                                String result = "";
                                int temp = 0;
                                int count = 0;
                                while (count < number.length()) {
                                                try {
                                                                temp = Integer.parseInt(number.charAt(len)+"");
                                                } catch (Exception ex) {
                                                //             ex.printStackTrace();
                                                                temp = hexMap.get(number.charAt(len)+"");
                                                }
                                                len-=1;
                                                intermediateRes+=temp*Math.pow(fromBase,count++);

                                }
                                System.out.println("Input number in base 10:"+intermediateRes);
                                StringBuilder builder = new StringBuilder();
                                int remainder = intermediateRes;
                                while (toBase <intermediateRes) {
                                                remainder = intermediateRes/toBase;
                                                System.out.println("REMAINDER:"+remainder);
                                                if (toBase==16 && remainder > 9)
                                                                builder.append(reverseHexMap.get(remainder)+"");
                                                else
                                                                builder.append(remainder+"");

                                                intermediateRes%=toBase;
                                                System.out.println("intermediateRes:"+intermediateRes);
                                }
                                                System.out.println("remainder:"+remainder);
                if (toBase==16 && remainder > 9)
                                                                builder.append(reverseHexMap.get(remainder)+"");
                                                else
                                                                builder.append(remainder+"");

                                return builder.toString();

                }

                public static void main(String[] argv) {

                                Scanner scanner = new Scanner(System.in);
                                String number = scanner.next();
                                int fromBase = scanner.nextInt();
                                int toBase = scanner.nextInt();
                                System.out.println("RESULT:"+convert(number,fromBase,toBase));
                                scanner.close();
                }
}