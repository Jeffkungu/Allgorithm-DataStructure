import java.util.HashMap;
import java.util.Map;

/**
 * Write a function

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.

For example, given array A such that

 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
the function may return 0, 2, 4, 6 or 7, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 */
public class CodilityDominator {
    public static void main(String[] args) {
        
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int value = A.length/2;
        int dominator = -1;
        int dominatorIndx = -1;
        
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        
        for(int i = 0; i < A.length; i++){
            if(map.containsKey(A[i])){
                map.put(A[i], map.get(A[i])+1);
            } else {
                map.put(A[i], 1);
            }
        }
        
        for(Map.Entry entry : map.entrySet()){
            if(Integer.valueOf((int)entry.getValue()) > value){
                dominator = Integer.valueOf((int)entry.getKey());
            }
        }
        
        for(int i = 0; i < A.length; i++){
            if(A[i] == dominator){
                dominatorIndx = i;
            }
        }
        
        return dominatorIndx;
    }
}