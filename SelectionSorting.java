import java.util.Arrays;

public class SelectionSorting {
    public static void main(String[] args) {
        int[] result = solution(new int[]{1, 2, 3, 1, 4, 1});
        int[] result2 = solutionIndex(new int[]{1, 2, 3, 1, 4, 1});
        System.out.println("Value = " + Arrays.toString(result));
        System.out.println("Value 2 = " + Arrays.toString(result2));
    }

    private static int[] solution(int[] A){
        for(int i = 0; i < A.length; i++){
            int leastVal = A[i];
            System.out.println("Least value = " + leastVal);
            for(int j = i+1; j < A.length; j++){
                if(A[j] < leastVal){
                    System.out.print(A[j] + " is less than " + leastVal + " so ");
                    leastVal = A[j];
                    System.out.println("The new leastVal = " + leastVal + " so we'll switch " +  A[i] + " with " + A[j]);
                    A[j] = A[i];
                    A[i] = leastVal;
                }
                

                System.out.println(A[j] + " is not less than " + leastVal + " ");
            }
            
        }

        return A;
    }

    private static int[] solutionIndex(int[] A){
        for(int i = 0; i < A.length - 1; i++){
            int minIndx = i;
            for(int j = i + 1; j < A.length; j++){
                if(A[j] < A[minIndx]){
                    minIndx = j;
                }
            }
            int minVal = A[minIndx];
            A[minIndx] = A[i];
            A[i] = minVal; 
        }
        return A;
    }
}
