package mc.project.implement_trie__prefix_tree;

import java.util.HashMap;
import java.util.Map;

public class Main {
    class TrieNode {
        public Map<Character, TrieNode> children;
        public boolean isEndOfWord;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    class Trie {
        private TrieNode rootNode;

        public Trie() {
            rootNode = new TrieNode();
        }

        public void insert(String word) {
            TrieNode currentNode = rootNode;

            for (int i = 0; i < word.length(); i++) {
                char character = word.charAt(i);

                if (currentNode.children.containsKey(character)) {
                    currentNode = currentNode.children.get(character);
                    continue;
                }

                TrieNode newNode = new TrieNode();
                currentNode.children.put(character, newNode);
                currentNode = newNode;
            }
            currentNode.isEndOfWord = true;
        }

        public boolean search(String word) {
            TrieNode currnetNode = rootNode;

            for (int i = 0; i < word.length(); i++) {
                char character = word.charAt(i);

                if (!currnetNode.children.containsKey(character)) {
                    return false;
                }

                currnetNode = currnetNode.children.get(character);
            }

            return currnetNode.isEndOfWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode currnetNode = rootNode;

            for (int i = 0; i < prefix.length(); i++) {
                char character = prefix.charAt(i);

                if (!currnetNode.children.containsKey(character)) {
                    return false;
                }

                currnetNode = currnetNode.children.get(character);
            }

            return true;
        }
    }

    public static void main(String[] args) {

    }
}
