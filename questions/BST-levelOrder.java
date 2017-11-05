// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);


        List<List<TreeNode>> list = levelOrder(root);

        for(List<TreeNode> level : list) {
            for(TreeNode node : level) {
                System.out.print(node.value + " ");
            }

            System.out.println();
        }
    }

    public static List<List<TreeNode>> levelOrder(TreeNode root) {
        List<List<TreeNode>> list = new ArrayList<>();
        Queue<TreeNode> queue = new Queue<>();

        queue.enqueue(root);

        while(!queue.isEmpty()) {
            int size = queue.size();

            List<TreeNode> level = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                TreeNode current = queue.dequeue();

                level.add(current);

                if(current.left != null) {
                    queue.enqueue(current.left);
                }

                if(current.right != null) {
                    queue.enqueue(current.right);
                }
            }

            if(level.size() > 0) {
                list.add(level);
            }


        }


        return list;
    }
}



class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
    }
}



class Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;

    public void enqueue(Item item) {
        Node oldTail = last;

        last = new Node();
        last.item = item;

        if(isEmpty()) {
            first = last;
        }
        else {
            oldTail.next = last;
        }

        size++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;

        size--;

        if(isEmpty()) {
            last = null;
        }

        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class Node {
        Item item;
        Node next;
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;

            return item;
        }

        public void remove() {

        }
    }
}


