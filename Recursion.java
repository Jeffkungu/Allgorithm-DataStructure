/**
 * 
 */
public class Recursion {
    public static void main(String[] args) {
        System.out.println("Factorial = " + factorial(-1));
        // System.out.println("Fibonacci = " + fibonacci(5));

    }

    /**
     * N! = N*(N-1)!
     * ie Factorial of N ie equal to N times factorial oF (N-1)
     */
    private static int factorial(int n){
        if(n >= 1){
            return n*factorial(n-1);
        } else if (n == 0){
            return 1;
        }

        return -1;
    }

    /**
     * FibN = Fib(N-1) + Fib(N+2)
     * Fibonacci sequence is a sequence formed from adding current number to the previous number
     * in order to get the next number.
     * @return
     */
    private static int fibonacci(int N){
        
        if(N >= 3){
            return fibonacci(N - 1) + fibonacci(N - 2);
        } else if (N == 2 || N == 1){
            return 1;
        }

        return fibonacci(N);
    }
}