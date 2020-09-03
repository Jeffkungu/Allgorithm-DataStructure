import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] value = solution(new int[]{2, 4, 3, 1});
        System.out.println("Value = " + Arrays.toString(value));
    }

    public static int[] solution(int[] A){
        for(int j = 0; j < A.length - 1; j++){
            for(int i = 0; i < A.length - 1; i++){
                if(A[i+1] < A[i]){
                    int element = A[i+1];
                    A[i+1] = A[i];
                    A[i] = element;
    
                }
            }
        }
        return A;
    }
}
