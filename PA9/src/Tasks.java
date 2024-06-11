/*
 * Name: Ganesh Kumarappan
 * PID: A17995383
 */

import com.sun.source.tree.BinaryTree;

import java.util.*;

/**
 * TODO
 *
 * @author Ganesh Kumarappan
 * @since 6/9/24
 */

public class Tasks {

    /**
     * TODO: Question A
     * Checks if there is a duplicate in the list
     * @param entries
     * @return boolean true if the list contains a duplicate and false if it doesn't
     */
    public static boolean raffleChecker(int[] entries) {
        // TODO
        Hashtable<Integer, Integer> raffles = new Hashtable<>();
        for(int i = 0; i < entries.length; i++){
            if(raffles.containsKey(entries[i])){
                return true;
            }
            raffles.put(entries[i], 1);
        }
        return false;
    }

    // List Node class provided for reference
    public static class Node {
        Node next;
        String name;
        public Node(String name) {
            this.name = name;
        }
    }

    /**
     * Return the middle node of the linked list
     * @param head
     * @return
     */
    public static String middleNode(Node head) {
        // TODO
        Node fastPointer = head;
        Node slowPointer = head;
        while(fastPointer.next != null){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer.name;
    }

    /**
     * Determine whether the new message can be constructed only by using character from oldMessage
     * @param newMessage the new message you want to construct
     * @param oldMessage the old message you want to construct
     * @return boolean true if you can construct it and false if you can't
     */
    public static boolean canConstruct(String newMessage, String oldMessage) {
       // TODO
        Hashtable<Character, Integer> letters = new Hashtable<>();
        for(int i = 0; i < oldMessage.length(); i++){
            char currentLetter = oldMessage.charAt(i);
            if(letters.containsKey(currentLetter)){
                letters.put(currentLetter, letters.get(currentLetter) + 1);
            }
            else{
                letters.put(currentLetter, 1);
            }
        }

        Hashtable<Character, Integer> letters2 = new Hashtable<>();
        for(int j = 0; j < newMessage.length(); j++){
            char currentLetter2 = newMessage.charAt(j);
            if(letters2.containsKey(currentLetter2)){
                letters2.put(currentLetter2, letters2.get(currentLetter2) + 1);
            }
            else{
                letters2.put(currentLetter2, 1);
            }
        }

        for(int k = 0; k < newMessage.length(); k++){
            char currentLetter = newMessage.charAt(k);
            if(!letters.containsKey(currentLetter) || letters2.get(currentLetter) >
                    letters.get(currentLetter)){
                return false;
            }
        }
        return true;
    }

    /**
     * Return the highest k amount of buyers from the given array of times people bought stuff
     * @param buyers the names of the buyers
     * @param k the highest k amount of buyers
     * @return String[] the list of the highest k buyers
     */
    public static String[] frequentCustomers(String[] buyers, int k) {
        // TODO
        HashMap<String, Integer> frequency = new HashMap<>();
        for(String buyer : buyers){
            if(frequency.containsKey(buyer)){
                frequency.put(buyer, frequency.get(buyer) + 1);
            }
            else{
                frequency.put(buyer, 1);
            }
        }
        List<Map.Entry<String, Integer>> sortingList = new ArrayList<>(frequency.entrySet());
        Collections.sort(sortingList, Comparator.comparing(Map.Entry<String, Integer>::getValue).
                reversed());

        String[] resultArray = new String[k];
        for (int i = 0; i < k; i++) {
            resultArray[i] = sortingList.get(i).getKey();
            System.out.println(resultArray[i]);
        }

        return resultArray;

    }
}
