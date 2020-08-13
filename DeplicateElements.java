import java.util.HashMap;
import java.util.Map;

public class DeplicateElements {

    public static void main(String[] args) {
        findDublicates(new int[]{1, 1, 2, 3, 1, 2, 4, 3, 1});
    }

    /**
     * Total time complexity = O(N) + O(N) => 2*O(N) => O(N)
     * 
     * @param input
     */
    public static void findDublicates(int[] input){
        // Loop through the array and and store elementsin a HashMap
        // Store the elements as the keys and assign int values to the elements
        // Loop through the the hash map and check the values for each key.@interface

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i : input){ // time complexity = O(N)
            if(map.containsKey(i)){
                map.replace(i, map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){ // time complexity = O(N)
            if(entry.getValue()>1){
                System.out.println(entry.getKey() + " has been repeated " + entry.getValue() + " times");
            }
        }
    }
    
}