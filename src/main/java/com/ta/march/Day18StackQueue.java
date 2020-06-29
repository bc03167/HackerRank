package com.ta.march;

import java.io.*;
import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Day18StackQueue {
    // Write your code here.

    BlockingQueue<String> q = new LinkedBlockingQueue<>();
    Stack<String> s = new Stack<>();

    public void pushCharacter(char c) {
        this.s.push(""+c);
    }

    public void enqueueCharacter(char c) {
        this.q.offer(""+c);
    }

    public char popCharacter() {
        return(this.s.pop().charAt(0));
    }

    public char dequeueCharacter() {
        return(this.q.remove().charAt(0));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        Day18StackQueue p = new Day18StackQueue();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + input + ", is "
                + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
    }
}