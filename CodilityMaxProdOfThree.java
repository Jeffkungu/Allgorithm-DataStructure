import java.util.Arrays;
/**
 * Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A, returns the value of the maximal product of any triplet.

For example, given array A such that:

  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
the function should return 60, as the product of triplet (2, 4, 5) is maximal.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [3..100,000];
each element of array A is an integer within the range [−1,000..1,000].
 */
public class CodilityMaxProdOfThree {
    public static void main(String[] args) {
        int a = 2;
        System.out.println(Math.abs(a));
    }

    // Score = 44%
    public int solution(int[] A) {
        // write your code in Java SE 8
        
        Arrays.sort(A);

        int product = A[A.length - 1] * A[A.length - 2] * A[A.length - 3];
        
        return product;
    }
}