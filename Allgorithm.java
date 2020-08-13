import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Allgorithm {

    public static void main(final String[] args) {
        // Set<Integer> set = new TreeSet<Integer>();
        // set.add(3);
        // set.add((int) 3.0);
        // set.add(2);
        // set.add(2);
        // set.add(new Integer(2));
        // set.add(Integer.parseInt("2"));

        int x = 9;
        if (x == 9) {
            x = 8;
            System.out.println(x);
        }
        final Integer[] myArr = { 2, 3, 1 };
        final List<Integer> newArr = Arrays.asList(myArr);
        newArr.sort(c);

    }

    public static int findSecondLargestNumber(final int[] input) {
        // int largest = 0;
        // int secondLargest = 0;

        // for(int i =0; i<input.length; i++){
        // if(input[i] > largest)
        // largest = input[i];
        // }

        // for(int i =0; i<input.length; i++){
        // if(input[i] > secondLargest && input[i] != largest)
        // secondLargest = input[i];
        // }

        Arrays.sort(input);
        return input[input.length - 2];
    }

    /**
     * Bubble Sort is the simplest sorting algorithm that works by repeatedly
     * swapping the adjacent elements if they are in wrong order.
     * 
     * Total time complexity = O(N) * O(N) = O(N^2)
     */
    public static int[] bubbleSort(final int[] input) {
        for (int i = 0; i < input.length; i++) { // 1st loop time complexity of O(N)

            for (int j = 0; j < input.length - 1; j++) { // 2nd loop time complexity of O(N)
                if (input[j + 1] < input[j]) {
                    final int value = input[j + 1];
                    input[j + 1] = input[j];
                    input[j] = value;
                }
            }
        }
        return input;
    }

    public static int[] selectionSort(final int[] input) {

        for (int i = 0; i < input.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[minIndex]) {
                    minIndex = j;
                }

            }
            final int minval = input[minIndex];
            input[minIndex] = input[i];
            input[i] = minval;

        }
        return input;
    }

    public static void findSumOfAdjacentNumbers() {
        final Scanner sc = new Scanner(System.in);
        final int input = sc.nextInt();
        int count = 0;

        for (int i = 1; i <= input; i++) {
            count = count + i;
        }
        System.out.println("The total sum of numbers between " + 1 + " and " + input + " is " + count);
    }

    public static void printInvertedPyramid() {
        final Scanner sc = new Scanner(System.in);
        final int input = sc.nextInt();
        int elements = input;

        for (int i = 1; i <= input; i++) {
            for (int j = 1; j <= elements; j++) {
                System.out.print(j + " ");
            }
            elements--;
            System.out.println(" ");
        }
    }

    public static void checkPrime(final int input) {
        boolean isPrime = true;
        for (int i = 2; i < input; i++) {
            if (input % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.print(input + " is prime number");
        } else {
            System.out.print(input + " is not prime number");
        }
    }

    public static void removeDuplicates(final String[] input) {
        final Set<String> nonDuplicate = new HashSet<>();
        for (final String string : input) {
            nonDuplicate.add(string);
        }
        System.out.println("Duplicates = " + Arrays.toString(nonDuplicate.toArray()));
    }

    public static void printDuplicates(final String[] input) {
        final List<String> nonDuplicate = new ArrayList<>();
        final List<String> duplicates = new ArrayList<>();
        for (final String string : input) {
            if (!nonDuplicate.contains(string)) {
                nonDuplicate.add(string);
            } else {
                duplicates.add(string);
            }
        }
        System.out.println("Duplicates = " + Arrays.toString(duplicates.toArray()));
    }

    public static void findLargestSmallestValue(final int[] input) {
        int smallest = 0;
        int largest = 0;

        for (final int i : input) {
            if (i < smallest)
                smallest = i;
            if (i > largest)
                largest = i;
        }
        System.out.println("Smallest value = " + smallest);
        System.out.println("Larges value = " + largest);

    }

    public static void countVowelsInString() {
        System.out.println("Enter String");
        final Scanner sc = new Scanner(System.in);
        final String input = sc.nextLine();
        final char[] inputArray = input.toCharArray();

        int count = 0;
        for (final char c : inputArray) {
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    count++;
                    break;
                default:
                    break;
            }
        }
        System.out.println("Vowels = " + count);
    }

    public static void printFloydTriangle() {

        final Scanner sc = new Scanner(System.in);
        final int input = sc.nextInt();
        int elements = 1;
        int number = 1;
        System.out.println("Floyd Triangle");

        for (int i = 1; i <= input; i++) { // row = 1, rows = 2
            for (int j = 1; j <= elements; j++) { // elements = 1,
                System.out.print(number + " "); // number = 1, number = 2
                number++;
            }
            System.out.println(" ");
            elements++;
        }
    }

    /**
     * 
     * @param input The method sorts array by splitting the input recursively to a
     *              single element then merges the single element arrays in the
     *              required order.
     */
    public static int[] mergeSort(final int[] input) {
        if (input.length <= 1) {
            return input;
        }

        final int midpoint = input.length / 2;

        int[] leftArray = new int[midpoint];
        int[] rightArray;
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

        int[] resultArray = new int[input.length];

        leftArray = mergeSort(leftArray);
        System.out.println("Left array = " + Arrays.toString(leftArray));
        rightArray = mergeSort(rightArray);
        System.out.println("Right array = " + Arrays.toString(rightArray));

        resultArray = merge(leftArray, rightArray);

        return resultArray;
    }

    /**
     * 
     * @param leftArray
     * @param rightArray
     * @return /usr/local/Cellar/zsh/5.8 /Users/user/.oh-my-zsh The method is used
     *         to merge arrays in the mergeSort method.
     */
    public static int[] merge(final int[] leftArray, final int[] rightArray) {
        System.out.println("Left array 1 = " + Arrays.toString(leftArray));
        System.out.println("Right array 1 = " + Arrays.toString(rightArray));

        final int[] resultArray = new int[leftArray.length + rightArray.length];

        int leftIndex, rightIndex, resultIndex;
        leftIndex = rightIndex = resultIndex = 0;

        while (leftIndex < leftArray.length || rightIndex < rightArray.length) {

            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {

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
        }
        return resultArray;
    }

    public static boolean palindromeString(final String input) {
        boolean isPalindrome = false;
        final char[] reveseChar = new char[input.length()];
        String reverse = "";

        for(int i = input.length() - 1; i >= 0; i--){
            reverse += input.charAt(i);
        }
        if(input.equals(reverse)){
            isPalindrome = true;
        }

        return isPalindrome;

    }

}