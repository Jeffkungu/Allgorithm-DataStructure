/**
 * The class checks if two Intergers are adjacent numbers in the Fibonacci Series
 * 
 * If the individual numbers and their sum is a perfect square, then the numbers are consecutive in a Fibonacci series.
 */
public class FibonacciNumbers {
    public static void main(String[] args) {
        System.out.println(isFibonacci(2, 3));
    }

    public static boolean isFibonacci(int n, int m){
        boolean isFib = false;

        if(isFibonacci(n) && isFibonacci(m) && isFibonacci(n+m)){
            isFib = true;
        }

        return isFib;
    }

    public static boolean isFibonacci(int n){
        return isPerfectSquare(5*n*n + 4) || isPerfectSquare(5*n*n - 4);
    }

    public static boolean isPerfectSquare(int x) 
    { 
        int s = (int) Math.sqrt(x); 
        return (s*s == x); 
    }
    
}