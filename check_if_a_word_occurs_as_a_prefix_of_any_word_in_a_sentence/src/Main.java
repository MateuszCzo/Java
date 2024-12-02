
public class Main {
//    Given a sentence that consists of some words separated by a single space, and a searchWord, check if searchWord is a prefix of any word in sentence.
//
//Return the index of the word in sentence (1-indexed) where searchWord is a prefix of this word. If searchWord is a prefix of more than one word, return the index of the first word (minimum index). If there is no such word return -1.
//
//A prefix of a string s is any leading contiguous substring of s.
    public static void main(String[] args) {
        System.out.println(isPrefixOfWord("i love eating burger", "i love eating burger"));
    }

    public static class Node {
        Node[] next = new Node[25];
        int index;
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        Node rootNode = new Node();
        Node currNode = rootNode;
        int wordCount = 1;

        for (int i = 0; i < sentence.length(); i++) {
            char currChar = sentence.charAt(i);
            if (currChar == ' ') {
                wordCount++;
                currNode = rootNode;
                continue;
            }
            int nextNodeIndex = currChar - 'a';
            Node nextNode = currNode.next[nextNodeIndex];
            if (nextNode == null) {
                nextNode = new Node();
                currNode.next[nextNodeIndex] = nextNode;
            }
            currNode = nextNode;
            if (currNode.index == 0) {
                currNode.index = wordCount;
            }
        }

        currNode = rootNode;
        for (int i = 0; i < searchWord.length(); i++) {
            int nextNodeIndex = searchWord.charAt(i) - 'a';
            Node nextNode = currNode.next[nextNodeIndex];
            if (nextNode == null) {
                return -1;
            }
            currNode = nextNode;
        }

        return currNode.index;
    }
}