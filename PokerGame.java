import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Poker Game

Determine the winner given each player’s set of cards per the following:

In a game poker, a hand consists of five cards and are ranked from lowest to highest,
in the following way;
    1. High Card Highest value card
    2. One Pair Two cards of the same value
    3. Two Pairs Two different pairs
    4. Three of a kind Three crds of the same value
    5. Straight All cards are consecutive
    6. Flush All cards of the same suit
    7. Full House Three of a kind and a pair
    8. Four of a kind Four cards of the same value
    9. Straight Flush All cards are consecutive values of the same suit
    10. Royal Flush Ten, Jack, Queen, King, Ace, in same suit

The cards are valued in the order:
2, 3, 4, 5, 6, 7, 8, 9, 10(T), Jack(J), Queen(Q), King(K), Ace(A)

The cards are suited, suit doesn’t beat suit.Spade(S), Head(H), Diamond(D), Club(C)

If two players have the same ranked hands then the rank made up of the highest value wins,
for example a pair of eights beats a pair of fivesBut if two ranks tie, for example both players
have a pair of queens, then. Highest cards in each hand are compared ; if the highest cards tie then
the next highest cards are compared, and so on.
 */
public class PokerGame {
    public static void main(String[] args) {
        String[] hand1 = new String[]{"TC", "JD", "5H", "KS", "AS"};
        String[] hand2 = new String[]{"2C", "AC", "5C", "8C", "JC"};
        
        // int value = determineWinner(hand1, hand2);
        // System.out.println("Winner is player " + value);

        highestValue(hand2);
    }

    private static int determineWinner(String[] hand1, String[] hand2){
        int winner = 0;
        System.out.println("Player one = " + Arrays.toString(hand1));
        System.out.println("Player two = " + Arrays.toString(hand2));

        if(isRoyalFlush(hand1)){
            return 1;
        } else if (isRoyalFlush(hand2)){
            return 2;
        } else if (isStraightFlush(hand1)){
            return 1;
        } else if (isStraightFlush(hand2)){
            return 2;
        } else if (isFourOfAkind(hand1)){
            return 1;
        } else if (isFourOfAkind(hand2)){
            return 2;
        } else if (isFullHouse(hand1)){
            return 1;
        } else if (isFullHouse(hand2)){
            return 2;
        } else if (isFlush(hand1)){
            return 1;
        } else if (isFlush(hand2)){
            return 2;
        } else if (isStraight(hand1)){
            return 1;
        } else if (isStraight(hand2)){
            return 2;
        } else if (isThreeOfAKind(hand1)){
            return 1;
        } else if (isThreeOfAKind(hand2)){
            return 2;
        } else if (isTwoPairs(hand1)){
            return 1;
        } else if (isTwoPairs(hand2)){
            return 2;
        } else if (isOnePair(hand1)){
            return 1;
        } else if (isOnePair(hand2)){
            return 2;
        } else if (highestValue(hand2) > highestValue(hand1)){
            return 2;
        } else if (highestValue(hand1) > highestValue(hand2)){
            return 1;
        }

        return winner;
    }

    private static String[] sortHand(String[] hand){
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        for(int i = 0; i < hand.length; i++){
            switch(hand[i].charAt(0)){
                case 'T':
                    hand[i] = "10" + Character.toString(hand[i].charAt(1));
                    break;
                case 'J':
                    hand[i] = "11" + Character.toString(hand[i].charAt(1));
                    break;
                case 'Q':
                    hand[i] = "12" + Character.toString(hand[i].charAt(1));
                    break;
                case 'K':
                    hand[i] = "13" + Character.toString(hand[i].charAt(1));
                    break;
                case 'A':
                    hand[i] = "14" + Character.toString(hand[i].charAt(1));
                    break;
                default:
                    break;
            }

            int key = Integer.parseInt(hand[i].substring(0, hand[i].length()-1));
            String value = hand[i].substring(hand[i].length() - 1);
            treeMap.put(key, value);
        }

        int index = 0;
        for(Map.Entry<Integer, String> entry: treeMap.entrySet()){
            hand[index] = entry.getKey().toString() + entry.getValue();
            index++;
        }

        return hand;
    }

    private static boolean isRoyalFlush(String[] hand) {
        String handString = "";
        boolean isRoyalFlush = false;
        int royalFlushCount = 1;

        for (String string : hand) {
            handString = handString + string;
        }

        if(handString.contains("T") && handString.contains("J") && handString.contains("Q") &&
            handString.contains("K") && handString.contains("A")){

            for(int i = 0; i < hand.length - 1; i++){
                if(hand[i].charAt(1) == hand[i+1].charAt(1)){
                    royalFlushCount++;
                }
            }
        }

        if(royalFlushCount == 5){
            isRoyalFlush = true;
        }

        return isRoyalFlush;
    }

    private static boolean isStraightFlush(String[] hand){
        int straightFlushCount = 1;
        boolean isStraightFlush = false;
        String[] sortHand = sortHand(hand);

        for(int i = 0; i < sortHand.length - 1; i++){
            int value1 = Integer.parseInt(sortHand[i].substring(0, sortHand[i].length() - 1));
            int value2 = Integer.parseInt(sortHand[i+1].substring(0, sortHand[i+1].length() - 1));

            char suit1 = sortHand[i].charAt(sortHand[i+1].length()-1);
            char suit2 = sortHand[i].charAt(sortHand[i+1].length()-1);

            if((value2-value1) == 1 && suit1 == suit2){
                straightFlushCount++;
            }
        }

        if(straightFlushCount == 5){
            isStraightFlush = true;
        }

        return isStraightFlush;
    }

    private static boolean isFourOfAkind(String[] hand){
        boolean isFourOfAkind = false;
        int fourOfAkindCount = 1;

        for(int i = 0; i < hand.length - 1; i++){
            if(hand[i] == hand[i+1]){
                fourOfAkindCount++;
            }
        }

        if(fourOfAkindCount == 4){
            isFourOfAkind = true;
        }

        return isFourOfAkind;
    }

    private static boolean isFullHouse(String[] input){
        boolean isFullHouse = false;

        Map<String, Integer> values = new HashMap<String, Integer>();
        for (String string : input) {
            
            String value = string.substring(0, string.length() - 1);

            if(values.containsKey(value)){
                values.replace(value, values.get(value)+1);
            } else {
                values.put(value, 1);
            }
        }

        if(values.containsValue(3) && values.containsValue(2)){
            isFullHouse = true;
        }

        return isFullHouse;
    }

    private static boolean isFlush(String[] input){
        boolean isFlush = false;
        int flushCount = 1;

        for (int i = 0; i < input.length - 1; i++) {
            if(input[i].charAt(input[i].length() - 1) == input[i+1].charAt(input[i+1].length() - 1)){
                flushCount++;
            }
        }

        if(flushCount == 5){
            isFlush = true;
        }

        return isFlush;
    }

    private static boolean isStraight(String[] input){
        boolean isStraight = false;
        int isStraightCount = 1;
        String[] sortedArr = sortHand(input);

        for(int i = 0; i < sortedArr.length - 1; i++){
            int value1 = Integer.parseInt(sortedArr[i].substring(0, sortedArr[i].length() - 1));
            int value2 = Integer.parseInt(sortedArr[i+1].substring(0, sortedArr[i+1].length() - 1));

            if((value2 - value1) == 1){
                isStraightCount++;
            }
        }

        if(isStraightCount == 5){
            isStraight = true;
        }

        return isStraight;
    }

    private static boolean isThreeOfAKind(String[] input){
        boolean isThreeOfKind = false;

        Map<String, Integer> values = new HashMap<>();

        for (String string : input) {
            String value = string.substring(0, string.length()-1);
            if(values.containsKey(value)){
                values.replace(value, values.get(value) + 1);
            } else {
                values.put(value, 1);
            }
        }

        if(values.containsValue(3)){
            isThreeOfKind = true;
        }

        return isThreeOfKind;
    }

    private static boolean isTwoPairs(String[] input){
        boolean isTwoPairs = false;
        int isTwoPairsCount = 0;

        Map<String, Integer> values = new HashMap<>();
        for (String string : input) {
            String value = string.substring(0, string.length()-1);
            if(values.containsKey(value)){
                values.replace(value, values.get(value) + 1);
            } else {
                values.put(value, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : values.entrySet()) {
            if(entry.getValue() == 2){
                isTwoPairsCount++;
            }
        }
        System.out.println(isTwoPairsCount);

        if(isTwoPairsCount == 2){
            isTwoPairs = true;
        }

        return isTwoPairs;
    }

    private static boolean isOnePair(String[] input){
        boolean isOnePair = false;

        Map<String, Integer> values = new HashMap<>();
        for (String string : input) {
            String value = string.substring(0, string.length()-1);
            if(values.containsKey(value)){
                values.replace(value, values.get(value) + 1);
            } else {
                values.put(value, 1);
            }
        }

        if(values.containsValue(2) && values.size() > 3){
            isOnePair = true;
        }
        System.out.println(values);
        System.out.println("Has one pair = " + isOnePair);

        return isOnePair;
    }

    private static int highestValue(String[] input){
        System.out.println("Array = " + Arrays.toString(input));
        String[] sortedHand = sortHand(input);

        System.out.println("Sorted array = " + Arrays.toString(sortedHand));

        for(int i = 0; i < sortedHand.length; i++){
            sortedHand[i] = sortedHand[i].substring(0, sortedHand[i].length() - 1);
        }
        System.out.println("2nd arry = " + Arrays.toString(sortedHand));

        return Integer.parseInt(sortedHand[sortedHand.length - 1]);
    }
}
