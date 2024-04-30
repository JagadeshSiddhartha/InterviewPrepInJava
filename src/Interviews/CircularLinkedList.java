package Interviews;

import java.util.*;

class LinkedNode{
    int data;
    LinkedNode next;
    LinkedNode prev;

    LinkedNode(int a){
        data = a;
        next = null;
    }

}

public class CircularLinkedList {


    static HashMap<Integer, LinkedNode> nodeMap;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] ar = new int[n];
        String[] numbers = sc.nextLine().split(" ");
        for(int i = 0; i < numbers.length; i++) {
            ar[i] = Integer.parseInt(numbers[i]);
        }
        LinkedNode head  = constructLinked(ar);
        LinkedNode temp = head;
        while(temp.next != head) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(temp.data);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            numbers = sc.nextLine().split(" ");
            int a = Integer.parseInt(numbers[0]);
            int b = Integer.parseInt(numbers[1]);
            LinkedNode first = nodeMap.get(a).next;
            LinkedNode second = nodeMap.get(b);
            first.prev.next = first.next; //detach
            first.prev = second;
            first.next = second.next;
            second.next = first;
            first.next.prev = first;
        }
        int i = 0;
        temp = head;
        while(temp.next != head) {
//            ar[i] = temp.data;
//            i++;
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
//        ar[i] = temp.data;
        System.out.println(temp.data);

    }

    private static LinkedNode constructLinked(int[] ar) {
        nodeMap = new HashMap<>();
        LinkedNode head = new LinkedNode(ar[0]);
        LinkedNode temp = head;
        nodeMap.put(ar[0], head);
        for(int i = 1; i < ar.length; i++) {
            LinkedNode tempNode = new LinkedNode(ar[i]);
            tempNode.prev = temp;
            temp.next = tempNode;
            temp = tempNode;
            nodeMap.put(ar[i], temp);
        }
        temp.next = head;
        head.prev = temp;
        return head;
    }
}
/*
5
45 32 12 78 13
 */