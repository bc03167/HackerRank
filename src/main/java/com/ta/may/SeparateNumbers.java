package com.ta.may;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.*;

public class SeparateNumbers {

    static DefaultMutableTreeNode root = null;
    static boolean lPaddedZero = Boolean.FALSE;

    static DefaultMutableTreeNode buildGraph(String data) {
        DefaultMutableTreeNode n = new DefaultMutableTreeNode(data);

        if (data.length() >= 2)
            forkRecursionPrep(data, n);

        return n;
    }

    private static void forkRecursionPrep(String data, DefaultMutableTreeNode n) {
        if (data.length() % 2 != 0) {
            data = "0" + data;
            lPaddedZero = Boolean.TRUE;
        }

        long _mid = lPaddedZero ? (long) (data.length() / 2) - 1 : (long) data.length() / 2;

        String lV = data.substring(0, (int) _mid);
        String rV = data.substring((int) _mid);

        long _lVal = Long.parseLong(lV);
        long _rVal = Long.parseLong(rV);

        if (lPaddedZero) {
            n.add(new DefaultMutableTreeNode(lV));
            lPaddedZero  = Boolean.FALSE;

        }


        if (_rVal - _lVal == 1) {
            n.add(new DefaultMutableTreeNode(lV));
            n.add(new DefaultMutableTreeNode(rV));
        } else {
            n.add(buildGraph(lV));
            n.add(buildGraph(rV));
        }
    }


    static void separateNumbers(String s) {

        root = new DefaultMutableTreeNode(s);

        boolean allBeautiful = Boolean.TRUE;


        forkRecursionPrep(s, root);
        //Anatomy of Tree is stable

        DefaultMutableTreeNode p = root.getFirstLeaf();
        DefaultMutableTreeNode q = root.getFirstLeaf();
        List<DefaultMutableTreeNode> l = new LinkedList<>();

        l.add(p);
        while ((p = p.getNextLeaf()) != null) {
            l.add(p);
        }
        long firstNumber = Long.parseLong(l.get(0).getUserObject().toString());
        Collections.reverse(l);

        for (int i = 1; i < l.size(); i++) {
            p = l.get(i-1);
            q = l.get(i);
            if (p != null && q != null) {
                long pVal = Long.parseLong( p.getUserObject().toString() );
                long qVal = Long.parseLong( q.getUserObject().toString() );
                if (pVal - qVal != 1) {
                    allBeautiful = Boolean.FALSE;
                    break;
                }
            }
        }


        if (allBeautiful == Boolean.FALSE)
            System.out.println("NO");
        else
            System.out.println("YES "+firstNumber);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            if (s.length() == 1)
                System.out.println("NO");
            else
                separateNumbers(s);
        }

        scanner.close();
    }
}
