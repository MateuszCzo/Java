package mc.project.design_add_adn_search_words_data_structure;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static class TreeNode {
        public boolean isEnd;
        public Map<Character, TreeNode> children;

        public TreeNode() {
            children = new HashMap<>();
            isEnd = false;
        }
    }

    public static void main(String[] args) {

    }

    static class WordDictionary {
        TreeNode root;

        public WordDictionary() {
            root = new TreeNode();
        }

        public void addWord(String word) {
            TreeNode currentNode = root;
            for (int i = 0; i < word.length(); i++) {
                char key = word.charAt(i);

                if (currentNode.children.containsKey(key)) {
                    currentNode = currentNode.children.get(key);
                    continue;
                }

                TreeNode newNode = new TreeNode();
                currentNode.children.put(key, newNode);
                currentNode = newNode;
            }
            currentNode.isEnd = true;
        }

        public boolean search(String word) {
            return searchCharacter(root, word, 0);
        }

        protected static boolean searchCharacter(TreeNode currentNode, String word, int index) {
            if (word.length() <= index) {
                return currentNode.isEnd;
            }

            char key = word.charAt(index);

            if (key != '.') {
                return currentNode.children.containsKey(key) &&
                        searchCharacter(currentNode.children.get(key), word, index + 1);
            }

            index++;
            for (TreeNode child : currentNode.children.values()) {
                if (searchCharacter(child, word, index)) {
                    return true;
                }
            }
            return false;
        }
    }
}
