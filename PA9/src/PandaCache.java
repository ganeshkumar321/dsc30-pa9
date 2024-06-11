/*
 * Name: Ganesh Kumarappan
 * PID: A17995383
 */

import java.util.*;

/**
 * TODO
 *
 * @author Ganesh Kumarappan
 * @since 6/9/24
 */

public class PandaCache {
    private class Node{

        int pandaID;
        int zoneNumber;
        Node next;
        Node prev;
        public Node(int pandaiD, int zoneNUmber){
            pandaID = pandaiD;
            zoneNumber = zoneNUmber;
        }
    }

    private static Node head;
    private static Node tail;
    private static Hashtable<Integer, Node> table;
    private static int capacity1;


    public PandaCache(int capacity) {
        // TODO
        head = new Node(0, 0);
        tail = new Node(0, 0);
        table = new Hashtable<>();
        head.prev = null;
        head.next = tail;
        tail.next = null;
        tail.prev = head;
        capacity1 = capacity;
    }

    public int get(int pandaID) {
        // TODO
        if(!table.containsKey(pandaID)){
            return -1;
        }
        moveToFront(table.get(pandaID));
        return table.get(pandaID).zoneNumber;
    }

    private void moveToFront(Node node){
        if(node.prev != null){
            node.prev.next = node.next;
        }

        if(node.next != null){
            node.next.prev = node.prev;
        }

        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }

    public void set(int pandaID, int zoneNumber) {
        // TODO
        if(table.containsKey(pandaID)){
            table.get(pandaID).zoneNumber = zoneNumber;
            moveToFront(table.get(pandaID));
        }
        else{
            if(table.size() == capacity1){
                removeLeastRecentlyUsed();
            }
            Node newNode = new Node(pandaID, zoneNumber);
            table.put(pandaID, newNode);
            moveToFront(newNode);
        }
    }

    private void removeLeastRecentlyUsed(){
        Node removed = tail.prev;
        tail.prev = removed.prev;
        if(removed.prev != null){
            removed.prev.next = tail;
        }

        table.remove(removed.pandaID);
    }
}