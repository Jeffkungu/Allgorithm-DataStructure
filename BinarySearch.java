public class BinarySearch {
    public static void main(String[] args) {
        int value = solution(2, new int[]{0, 1, 2, 3});
        System.out.println(value);
    }

    private static int solution(int element, int[] A){
        int value = -1;
        int leftIndx = 0;
        int rightIndx = A.length - 1;
        int middleIndx = (rightIndx + leftIndx) / 2;

        while(rightIndx > leftIndx){
            System.out.println("Left indx = " + leftIndx + " middle indx = " + middleIndx + " right indx = " + rightIndx);
            System.out.println("");
            if(element > A[middleIndx]){
                leftIndx = middleIndx + 1;
                middleIndx = (rightIndx + leftIndx) / 2;
            } else if (element < A[middleIndx]){
                rightIndx = middleIndx - 1;
                middleIndx = (rightIndx + leftIndx) / 2;
            } else if (A[middleIndx] == element ){
                return middleIndx;
            }
            
            if (element == A[rightIndx]){
                return rightIndx;
            }
            
            if (A[leftIndx] == element){
                return leftIndx;
            }
        }
        System.out.println("Left indx = " + leftIndx + " middle indx = " + middleIndx + " right indx = " + rightIndx);
        
        
        return value;
    }
}