import java.util.Iterator;
import java.util.TreeSet;

/***
 * Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class CodilityMissingInteger {
    public static void main(String[] args) {
        
    }

    // Score = 44%
    public int solution(int[] A) {
        // write your code in Java SE 8
        int element = 1;
        TreeSet<Integer> al = new TreeSet<Integer>();
        
        for(int i = 0; i < A.length ; i++){
            al.add(A[i]);
        }
        
        Iterator<Integer> itr=al.iterator();
        
        while(itr.hasNext()){
            if(itr.next() != element){
               return element; 
            } else if (!itr.hasNext()) {
                return al.pollLast() + 1;
            } else {
                element++;
                continue;
            }
        }
        
        return -1;
    }
}