import java.util.Stack;

/**
 * Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..200,000];
string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 */
public class CodilityBrackets {
    public static void main(String[] args) {
        
    }

    /**
     * Score 100%
     * Iterate through the string characters, if we come across any opening bracket; (, {, or [ we add it to a Stack.
     * if we come across a closing bracket; ), } or ], we first check if the stack is empty. If ii is empty we return 0,
     * if not we check if the closing bracket matches with the opening bracket in the last element of the Stack. If it matches,
     * we remove the last element of the stack, if it doesn't match we return 0.
     * 
     * After iterating throught all the characters in the String, we check if the Stack is empty then return 1.
     */
    public static int solution(String S) {
        // write your code in Java SE 8
        int value = 0;
        
        Stack  charStack = new Stack();
        
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == '(' || S.charAt(i) == '{' || S.charAt(i) == '['){
                charStack.push(S.charAt(i));
            } else {
                if(charStack.isEmpty()){
                    return value;
                }
                
                if(S.charAt(i) == ')' && charStack.peek().equals('(') ||
                S.charAt(i) == ']' && charStack.peek().equals('[') ||
                S.charAt(i) == '}' && charStack.peek().equals('{')){
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