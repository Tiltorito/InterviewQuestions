// Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.


// Calling next() will return the next smallest number in the BST.


// Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.


import apple.laf.JRSUIUtils;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.add(15);
        tree.add(32);
        tree.add(5);
        tree.add(-1);
        tree.add(28);
        tree.add(9);
        tree.add(3);
        tree.add(42);
        tree.add(29);
        tree.add(68);
        tree.add(8);
        tree.add(11);

        TreeIterator iterator = new TreeIterator(tree.root);

        while(iterator.hasNext()) {
            System.out.println(iterator.next().value);
        }
    }
}

class BST {
    public TreeNode root;

    public void add(int value) {
        if(root == null) {
            root = new TreeNode(value);
        }
        else {
            add(root, value);
        }
    }

    private void add(TreeNode root, int value) {
        if(value < root.value) {
            if(root.left == null) {
                root.left = new TreeNode(value);
            }
            else {
                add(root.left, value);
            }
        }
        else {
            if(root.right == null) {
                root.right = new TreeNode(value);
            }
            else {
                add(root.right, value);
            }
        }
    }

    public void print() {
        print(root);
    }

    private void print(TreeNode root) {
        if(root == null) {
            return;
        }

        if(root.left != null) {
            print(root.left);
        }

        System.out.println(root.value);

        if(root.right != null) {
            print(root.right);
        }
    }
}
class TreeIterator implements Iterator<TreeNode>{
    private Stack<TreeNode> stack = new Stack<>();

    TreeIterator(TreeNode root) {
        findNext(root);
    }

    @Override
    public void remove() {

    }

    @Override
    public void forEachRemaining(Consumer<? super TreeNode> action) {

    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public TreeNode next() {
        TreeNode current = stack.pop();

        findNext(current.right);

        return current;
    }

    public void findNext(TreeNode current) {
        if(current != null) {
            stack.push(current);
            findNext(current.left);
        }
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


class Stack<Item> implements Iterable<Item> {
    private Item[] arr;
    private int n;

    public Stack() {
        arr = (Item[]) new Object[1];
        n = 0;
    }

    public void push(Item item) {
        if(n == arr.length) {
            resize(arr.length*2);
        }

        arr[n++] = item;
    }

    public Item pop() {
        Item item = arr[--n];
        arr[n] = null;

        if(n > 0 && n == arr.length/4) {
            resize(arr.length/2);
        }
        return item;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int index = n - 1;

        public boolean hasNext() {
            return index >= 0;
        }

        public Item next() {
            return arr[index--];
        }

        public void remove() {

        }
    }

    private void resize(int newSize) {
        Item[] newArr = (Item[]) new Object[newSize];
        System.arraycopy(arr,0,newArr,0,n);
        arr = newArr;
    }
}