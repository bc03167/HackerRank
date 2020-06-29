package com.ta.april.already;

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }

}

public class Day23ListDupRemover {

    public static Node removeDuplicates(Node head) {
        Map<Integer,Integer> m = new HashMap<>();

        Node prev = null;
        for (Node n = head; n != null; n = n.next) {
            if (m.get(n.data) == null) {
                m.put(n.data, 1);
                //System.out.println("initial data="+n.data);
                prev = n;
            } else {
                //System.out.println("duplicate data="+n.data);
                prev.next = n.next;
            }
        }
        return head;
    }

    public static Node insert(Node head, int data) {
        Node p=new Node(data);
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            Node start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }
    public static void display(Node head)
    {
        Node start=head;
        while(start!=null)
        {
            System.out.print(start.data+" ");
            start=start.next;
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Node head=null;
        int T=sc.nextInt();
        while(T-->0){
            int ele=sc.nextInt();
            head=insert(head,ele);
        }
        head=removeDuplicates(head);
        display(head);

    }
}