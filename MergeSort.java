import java.util.Arrays;

public class MergeSort {
    
    public static void main(String[] args) {
        solution(new int[]{2, 1, 3});
    }

    private static int[] solution(int[] input){
        // {2, 4, 5, 3, 1}
        if(input.length <= 1){
            return input;
        }

        final int midpoint = input.length / 2;
        
        int[] leftArray = new int[midpoint];
        int[] rightArray = new int[midpoint];
        if (input.length % 2 == 0) {
            rightArray = new int[midpoint];
        } else {
            rightArray = new int[midpoint + 1];
        }
        

        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = input[i];
        }

        for (int j = 0; j < rightArray.length; j++) {
            rightArray[j] = input[midpoint + j];
        }
        
        System.out.println(Arrays.toString(leftArray) + " + " + Arrays.toString(rightArray));
        // System.out.println("Right arr 1 " + Arrays.toString(rightArr));

        leftArray = solution(leftArray);
        rightArray = solution(rightArray);
        System.out.println("Left array = " + Arrays.toString(leftArray));
        System.out.println("Right array = " + Arrays.toString(rightArray));

        int[] resultArr = new int[input.length];

        resultArr = merge(leftArray, rightArray);

        return resultArr;
    }

    private static int[] merge(final int[] leftArray, final int[] rightArray) {
        // System.out.println("Arrays to merge " + Arrays.toString(leftArray) + " + " + Arrays.toString(rightArray));
        // System.out.println("Right arr 2 " + Arrays.toString(rightArr));
        int[] resultArray = new int[leftArray.length + rightArray.length];
        int leftIndex, rightIndex, resultIndex;
        leftIndex = rightIndex = resultIndex = 0;

        while (leftIndex < leftArray.length || rightIndex < rightArray.length){
            if (leftIndex < leftArray.length && rightIndex < rightArray.length){
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    resultArray[resultIndex++] = leftArray[leftIndex++];
                } else {
                    resultArray[resultIndex++] = rightArray[rightIndex++];
                }
            } else if (leftIndex < leftArray.length) {
                resultArray[resultIndex++] = leftArray[leftIndex++];
            } else if (rightIndex < rightArray.length) {
                resultArray[resultIndex++] = rightArray[rightIndex++];
            }
            // System.out.println("Merged array = " + Arrays.toString(resultArray));
        }

        return resultArray;
    }
}
