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
 * A = [2, 3, 8, 9, 7, 6] K = 3 the function should return [9, 7, 6, 2, 3, 8]. Three
 * rotations were made:
 * 
 * [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7] [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9] [7, 6,
 * 3, 8, 9] -> [9, 7, 6, 3, 8] For another example, given
 */
public class CodilityCyclicRotation {

    public static void main(String[] args) {
        final int[] arry = new int[] { 6, 7, 1, 2};

        rotate2(arry, 3);
    }

    /**
     * METHOD 1 (Using temp array)
     * 
     * Total time complexity = O(N) + O(N) + O(N) => 3*O(N) => O(N)
     */
    public static int[] rotate(int[] A, int K){
        System.out.println("Initial value = " + Arrays.toString(A) + " and K = " + K);
        int[] value = null;
        
        if(A.length <= 1){
            return A;
        } else if(K > A.length){
           rotate(A, K / A.length);
           return null; 
        } else if(K < 1){
            System.out.println("K value = " + 0);
            return A;
        } else {
            int[] array1 = new int[K];
            int[] array2 = new int[A.length];
            int index1 = A.length - K;
            int index2 = K;
        
            for(int i = 0; i < K; i++){ // Time complexity = O(N)
                array1[i] = A[index1];
                index1++;
            }
        
            for(int i = 0; i < A.length - K; i++){
                array2[index2] = A[i];
                index2++;
            }
            System.out.println("Final value 1 = " + Arrays.toString(array2));

            for(int i = 0; i < K; i++){ // Time complexity = O(N)
                array2[i] = array1[i];
            }
        
            value = array2;
        }
        
        System.out.println("Final value 2 = " + Arrays.toString(value));
        return value;

    }

    // Method 2 = rotating one by one
    public static int[] rotate2(int[] A, int K){
        
        for(int i = 0; i < K; i++){
            System.out.println("Value 0 = " + Arrays.toString(A));
            int element = A[0];
            System.out.println("Element = " + element);
            for(int j = 0; j < A.length - 1; j++){
                A[j] = A[j+1];
                System.out.println("Value 1 = " + Arrays.toString(A));
            }
            A[A.length - 1] = element;
            System.out.println("Value 2 = " + Arrays.toString(A));
        }

        return A;
    }
}