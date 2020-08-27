import java.util.Arrays;
import java.util.Stack;

/**
 * Write a function:

class Solution { public int solution(int[] A, int[] B); }

that, given two non-empty arrays A and B consisting of N integers, returns the number of fish that will stay alive.

For example, given the arrays shown above, the function should return 2, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [0..1,000,000,000];
each element of array B is an integer that can have one of the following values: 0, 1;
the elements of A are all distinct.
 */
public class CodilityFish {
    public static void main(String[] args) {
        solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 1, 0, 0});
    }

    public static int solution(int[] A, int[] B) {

        // special case: no fish
        if(A.length == 0)
            return 0;

        // main idea: use "stack" to store the fishes with B[i]==1 
        // that is, "push" the downstream fishes into "stack"
        // note: "push" the Size of the downstream fish
        Stack<Integer> st = new Stack<>(); 
        int numAlive = A.length;
        System.out.println("Total Fish alive = " + numAlive);
        for(int i=0; i<A.length; i++){
            
            // case 1; for the fish going to downstrem
            // push the fish to "stack", so we can keep them from the "last" one
            if(B[i] ==1){
                st.push(A[i]); // push the size of the downstream fish
            }
            System.out.println(Arrays.toString(st.toArray()));
            // case 2: for the fish going upstream
            // check if there is any fish going to downstream
            if(B[i] ==0){
                while( !st.isEmpty() ){ 
                    // if the downstream fish is bigger (eat the upstream fish)
                    if( st.peek() > A[i] ){
                        System.out.println(st.peek() + " > " + A[i]);
                        numAlive--;
                        System.out.println("Total Fish alive = " + numAlive);
                        break;      // the upstream fish is eaten (ending)   
                    }
                    // if the downstream fish is smaller (eat the downstream fish)
                    else if(st.peek() < A[i]){
                        System.out.println(st.peek() + " < " + A[i]);
                        numAlive--;
                        System.out.println("Total Fish alive = " + numAlive);
                        st.pop();   // the downstream fish is eaten (not ending)
                    }
                }
            }  
        }    
        System.out.println("Final total Fish alive = " + numAlive);
        return numAlive;
    }
}