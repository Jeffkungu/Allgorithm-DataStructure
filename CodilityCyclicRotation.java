import java.util.Arrays;

/**
 * An array A consisting of N integers is given. Rotation of the array means
 * that each element is shifted right by one index, and the last element of the
 * array is moved to the first place. For example, the rotation of array A = [3,
 * 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6
 * is moved to the first place).
 * 
 * The goal is to rotate array A K times; that is, each element of A will be
 * shifted to the right K times.
 * 
 * Write a function:
 * 
 * class Solution { public int[] solution(int[] A, int K); }
 * 
 * that, given an array A consisting of N integers and an integer K, returns the
 * array A rotated K times.
 * 
 * For example, given
 * 
 * A = [3, 8, 9, 7, 6] K = 3 the function should return [9, 7, 6, 3, 8]. Three
 * rotations were made:
 * 
 * [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7] [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9] [7, 6,
 * 3, 8, 9] -> [9, 7, 6, 3, 8] For another example, given
 */
public class CodilityCyclicRotation {

    public static void main(String[] args) {
        final int[] arry = new int[] { 1, 2, 3, 4, 5, 6 };

        cyclicRotation(arry, 5);
    }

    /**
     * METHOD 1 (Using temp array)
     * 
     * Total time complexity = O(N) + O(N) + O(N) => 3*O(N) => O(N)
     */
    private static void cyclicRotation(int[] A, int K) {
        int[] array1 = new int[K];
        int index1 = K;
        int index2 = A.length - K;

        for(int i = 0; i < K; i++){ // Time complexity = O(N)
            array1[i] = A[i];
        }

        for(int i = 0; i < A.length - K; i++){ // Time complexity = O(N)
            A[i] = A[index1];
            index1++;
        }

        for(int i = 0; i < array1.length; i++){ // Time complexity = O(N)
            A[index2] = array1[i];
            index2++;
        }
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(array1));
    }

    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int[] array1 = new int[K];
        int index1 = A.length - K;
        int index2 = K;
        
        for(int i = 0; i < K; i++){ // Time complexity = O(N)
            array1[i] = A[index1];
            index1++;
        }
        
        for(int i = 0; i < A.length - K; i++){
            A[index2] = A[i];
            index2++;
        }

        for(int i = 0; i < K; i++){ // Time complexity = O(N)
            A[i] = array1[i];
        }
        
        return A;
    }
}