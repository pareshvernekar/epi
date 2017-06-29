package sample.epi.strings.bruteforce;

import java.util.*;

public class StringToInteger {

        public static int toInteger(String strNumber) {
                        if (strNumber==null || strNumber.isEmpty())
                                        throw new IllegalArgumentException("Invalid paramter value");
                        char[] charArr = strNumber.toCharArray();
                        return getNumber(charArr);
        }

    private static int getNumber(char[] charArr) {
                    if (charArr == null || charArr.length==0)
                                    throw new IllegalArgumentException("Invalid paramter value");

                    int number = 0;

                    int count = 1;
                    int len = charArr.length;
                    boolean isNegative = charArr[0]=='-'?Boolean.TRUE:Boolean.FALSE;
                    int startIndex = isNegative?1:0;

                    for (int i=startIndex;i<len;i++) {

                                    switch (charArr[i]) {

                                                    case '0':
                                                            number=0+(number*count);
                                                            break;
                                                    case '1':
                                                            number=1+(number*count);
                                                            break;
                                                    case '2':
                                                            number=2+(number*count);
                                                            break;
                                                    case '3':
                                                            number=3+(number*count);
                                                            break;
                                                    case '4':
                                                            number=4+(number*count);
                                                            break;
                                                    case '5':
                                                            number=5+(number*count);
                                                            break;
                                                    case '6':
                                                            number=6+(number*count);
                                                            break;
                                                    case '7':
                                                            number=7+(number*count);
                                                            break;
                                                    case '8':
                                                            number=8+(number*count);
                                                            break;
                                                    case '9':
                                                            number=9+(number*count);
                                                            break;
                                                    default:
                                                            number+=0;
                                    }
                                    if (count==1)
                                    	count=10;
                    }
                    return (isNegative?-1*number:number);
    }

                public static void main(String[] argv) {

                                String strNumber = argv[0];
                                System.out.println(strNumber+"::"+toInteger(strNumber));
                }
}