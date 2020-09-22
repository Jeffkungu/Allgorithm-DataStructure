/**
 * Have the function MinWindowSubstring(strArr) take the array of strings stored in strArr,
 * which will contain only two strings, the first parameter being the string N and the second
 * parameter being a string K of some characters, and your goal is to determine the smallest
 * substring of N that contains all the characters in K. For example: if strArr is ["aaabaaddae", "aed"]
 * then the smallest substring of N that contains the characters a, e, and d is "dae" located at the end
 * of the string. So for this example your program should return the string dae.
 * 
 * Another example: if strArr is ["aabdccdbcacd", "aad"] then the smallest substring of N that contains
 * all of the characters in K is "aabd" which is located at the beginning of the string. Both parameters
 * will be strings ranging in length from 1 to 50 characters and all of K's characters will exist somewhere
 * in the string N. Both strings will only contains lowercase alphabetic characters.
 */
public class CoderbiteMinWindowSubStrng {
    public static void main(String[] args) {
        String value = solution(new String[] {"adaebcs", "aba"});

    }

    public static String solution(String[] strArr) {
        // Get the different String from te Array ie "ascftde" and "ct"
        // Loop through the characters in the 1st string and find windows of
        // substring that match contain characters in 2nd string.
    
        // use two pointers on the 1st string (left and right) to move
        // use variable named size to monitor the smallest size
        // use a variable named window to store the substrings from string1
        String string1 = strArr[0];
        String string2 = strArr[1];
        String window = "";
    
        int left = 0;
        int right = 0;
        int size = string1.length();
        String substring = string1.substring(left, right);
    
        while(right < string1.length()){
          boolean containsSecondString = containsSecondString(substring, string2);
          
          if(containsSecondString == true){
            System.out.println(substring + " contains " + string2);
            window = substring;
    
            if(window.length() < size){
              size = window.length();
            }
            
            left++;
          } else {
            System.out.println(substring);
            right++; 
          }
          
          if(right < string1.length() && left < string1.length()){
            substring = string1.substring(left, right+1);
          } else if (right < string1.length() && left == string1.length()) {
            substring = string1.substring(left-1, right);
          } else if (left < string1.length() && right == string1.length()) {
            substring = string1.substring(left, right-1);
          } else if (right == string1.length() && left == string1.length()){
            substring = string1.substring(left-1, right-1);
          }
        }
    
        System.out.println("Window = " + window + " of size " + size);
    
        return window;
      }
    
    public static boolean containsSecondString(String string1, String string2){
        boolean containsSecondString = false;
        int index = 0;
        int elemntCount = string2.length();
        System.out.println("str 1 = " + string1);
        if(string1.length() > 0){
            while(index < string2.length()){
                System.out.println("str 2 = " + string1 + " contains " + string2.charAt(index));
                String charString = Character.toString(string2.charAt(index));
                if(string1.contains(charString)){
                    if(string1.indexOf(charString) == 0){
                        string1 = string1.substring(string1.indexOf(charString) + 1, string1.length());
                    } else {
                        string1 = string1.substring(0, string1.indexOf(charString)) + string1.substring(string1.indexOf(charString) + 1, string1.length());
                    }
                    
                    elemntCount--;
                }
          
                index++;
              }
        }
        
        if(elemntCount == 0){
          containsSecondString = true;
        }
    
        return containsSecondString;
      }

    public static void test(){
        String one = "abc";
        String two = "abacdef";


        for(int i = 0; i < one.length(); i++){
            if(two.indexOf(one.charAt(i)) == 0){
                two = two.substring(two.indexOf(one.charAt(i)) + 1, two.length());
            } else {
                two = two.substring(0, two.indexOf(one.charAt(i))) + two.substring(two.indexOf(one.charAt(i)) + 1, two.length());
            }
        }
        System.out.println(two);
    }
}
