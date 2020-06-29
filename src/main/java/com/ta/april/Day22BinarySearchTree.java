package com.ta.april;

import java.util.*;
import java.io.*;

class BTNode{
    BTNode left,right;
    int data;
    BTNode(int data){
        this.data=data;
        left=right=null;
    }
}
public class Day22BinarySearchTree {
    static int h = 0;
    static int maxH;

    public static int getHeight(BTNode btn){
        if (btn.left != null) {
            h++;
            if (h > maxH)
                maxH = h;
            getHeight(btn.left);
            h--;
        }
        if (btn.right != null) {
            h++;
            if (h > maxH)
                maxH = h;
            getHeight(btn.right);
            h--;
        }

        return maxH;
    }

    public static BTNode insert(BTNode root,int data){
        if(root==null){
            return new BTNode(data);
        }
        else{
            BTNode cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        BTNode root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        int height=getHeight(root);
        System.out.println(height);
    }
}