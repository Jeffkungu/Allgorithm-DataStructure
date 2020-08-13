import java.lang.Integer;

/**
 * A binary gap within a positive integer N is any maximal sequence of consecutive
 * zeros that is surrounded by ones at both ends in the binary representation of N.
 * 
 * For example, number 9 has binary representation 1001 and contains a binary gap of
 * length 2. The number 529 has binary representation 1000010001 and contains two binary
 * gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and
 * contains one binary gap of length 1. The number 15 has binary representation 1111 and has no
 * binary gaps.
 */
public class CodilityBinaryGap {

    public static void main(String[] args) {
        findBinaryGap(8658);
    }

    private static int findBinaryGap(int N){
        String binaryString = Integer.toBinaryString(N);
        int max_gap = 0;
        int count_gap = 0;
        boolean is_binary_gap = false;

        for(int i = 0; i < binaryString.length(); i++){

            if(binaryString.charAt(i) == '1'){
                if(max_gap < count_gap){
                    max_gap = count_gap;
                }
                is_binary_gap = true;
                count_gap = 0;
            } else if (is_binary_gap){
                count_gap += 1;
            }
        }
        System.out.println(binaryString);
        System.out.println(max_gap);
        return 0;
    }
}