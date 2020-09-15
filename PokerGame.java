import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        String[] hand1 = new String[]{"TC", "JD", "QH", "KS", "AS"};
        String[] hand2 = new String[]{"2C", "5C", "2C", "5C", "2C"};
        
        // int value = determineWinner(hand1, hand2);
        // System.out.println(value);

        isFullHouse(hand2);
    }

    private static String[] sortHand(String[] hand){
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
        }
        Arrays.sort(hand);

        return hand;
    }

    private static int determineWinner(String[] hand1, String[] hand2){
        int winner = 0;

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
        }

        return winner;
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

        System.out.println(handString);

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
        System.out.println("Array = " + Arrays.toString(input));

        Map<String, Integer> values = new HashMap<String, Integer>();
        for (String string : input) {
            
            String value = string.substring(0, string.length() - 1);
            System.out.println(value);

            if(values.containsKey(value)){
                values.replace(value, values.get(value)+1);
            } else {
                values.put(value, 1);
            }
        }
        System.out.println("Map = " + values.toString());

        if(values.containsValue(3) && values.containsValue(2)){
            isFullHouse = true;
        }

        System.out.println("Is full house = " + isFullHouse);

        return isFullHouse;
    }
}
