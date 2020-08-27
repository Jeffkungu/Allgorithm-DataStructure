import java.util.Stack;

/**
 * Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..1,000,000];
string S consists only of the characters "(" and/or ")".
 */
public class CodilityNesting {
    public static void main(String[] args) {
        
    }

    public static int solution(String S) {
        // write your code in Java SE 8
        int value = 0;
        
        Stack  charStack = new Stack();
        
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == '('){
                charStack.push(S.charAt(i));
            } else {
                if(charStack.isEmpty()){
                    return value;
                }
                
                if(S.charAt(i) == ')' && charStack.peek().equals('(')){
                    charStack.pop();
                }
            }
        }
        
        if(charStack.isEmpty()){
            value = 1;
        }
        
        return value;
    }
}