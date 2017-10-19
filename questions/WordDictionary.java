// Design a data structure that supports the following two operations:

// void addWord(word)
// bool search(word)
// search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

// For example:

// addWord("bad")
// addWord("dad")
// addWord("mad")
// search("pad") -> false
// search("bad") -> true
// search(".ad") -> true
// search("b..") -> true

// Note:
// You may assume that all words are consist of lowercase letters a-z.

/**
 * Created by harry on 19/10/2017.
 */

public class WordDictionary {
    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    private class Node {
        Node[] subNodes = new Node[26];
        boolean flag;
    }

    public void addWord(String word) {
        Node current = root;

        for(char ch : word.toCharArray()) {
            int index = ch - 'a';

            if(current.subNodes[index] == null) {
                current.subNodes[index] = new Node();
            }

            current = current.subNodes[index];
        }

        current.flag = true;
    }

    public boolean contains(String word) {
        return contains(word.toCharArray(), 0, root);
    }

    private boolean contains(char[] arr, int index, Node node) {
        if(arr.length == index) {
            return node.flag;
        }

        if(arr[index] == '.') {
            for(int i = 0; i < 26; i++) {
                if(node.subNodes[i] != null && contains(arr, index + 1, node.subNodes[i])) {
                    return true;
                }
            }

            return false;
        }

        int i = arr[index] - 'a';

        if(node.subNodes[i] != null) {
            return contains(arr, index + 1, node.subNodes[i]);
        }

        return false;
    }

}
