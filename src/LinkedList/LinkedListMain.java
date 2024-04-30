package LinkedList;

import java.util.*;

class Node{
    int data;
    Node next;

    Node(int a){
        data = a;
        next = null;
    }

}

public class LinkedListMain {

    public static int getCount(Node head){

        if(head == null)return 0;
        return 1 + getCount(head.next);
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            Node head=null;
            for(int i=0;i<n;i++)
            {int a=sc.nextInt();
                if(head==null){
                    head=new Node(a);
                }
                else
                    insert(head,a);
            }

            System.out.println(getCount(head));
        }
    }
    public static Node insert(Node head,int a){
        if(head==null){
            return new Node(a);
        }
        head.next=insert(head.next,a);
        return head;
    }
}
