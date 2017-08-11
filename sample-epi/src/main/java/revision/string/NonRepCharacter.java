//Given a string "AvenueCode", find the second non-repeating character.
    
//Case matters - False
//
    package revision.string;
    import java.util.*;
    public class NonRepCharacter {
    
        
        public char getSecNonRep(String input) {
           if (input == null || input.length() == 0)
               throw new IllegalArgumentException("Input cannot be blank");
           
            
           String lower = input.toLowerCase();
           int len = lower.length();
           Set<Character> repSet = new HashSet<>();
           boolean repFound = Boolean.FALSE;
           char nonRep ='\u0000';
            int i = 0;
            while (i < len-1) {
                
                char ch = lower.charAt(i);
                
                for (int j=i+1;j<len;j++) {
                    if (repSet.contains(lower.charAt(j))) {
                        repFound=Boolean.TRUE;
                        continue;
                    } 
                    if (ch == lower.charAt(j)) {
                        repFound=Boolean.TRUE;
                        repSet.add(ch);
                        break;
                    }
                }

                if (repFound) {
                  repFound=Boolean.FALSE;
                } else if (nonRep=='\u0000') {

                  nonRep=ch;
                  System.out.println("In loop:"+nonRep);
                } else {
                    System.out.println("In loop");
                  return ch;
                }
                i++;

            }
            System.out.println("Out of for loop");
            return nonRep;
            
        }
        
        public static void main(String[] argv) {
            
           String input = "AavenueCode";
           NonRepCharacter m = new NonRepCharacter();
           System.out.println("Result:"+m.getSecNonRep(input));
            
        }    
        
        
}
    