package mc.project.word_search_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 */
public class Main {
    public static class TrieNode {
        public Map<Character, TrieNode> characters;
        public boolean isWord;
        public String word;
        TrieNode() {
            characters = new HashMap<>();
            isWord = false;
        }
    }
    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};

        String[] words = {"oath","pea","eat","rain"};

        for (String word : findWords(board, words)) {
            System.out.println(word);
        }
    }

    public static List<String> findWords(char[][] board, String[] words) {
        TrieNode trieNode = createTrie(words);

        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        List<String> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                wordsSearch(board, i, j, visited, result, trieNode);
            }
        }

        return result;
    }

    protected static TrieNode createTrie(String[] words) {
        TrieNode trieNode = new TrieNode();
        for (String word : words) {
            insertWord(trieNode, word);
        }
        return  trieNode;
    }

    protected static void insertWord(TrieNode trieNode, String word) {
        TrieNode currentNode = trieNode;
        for (int j = 0; j < word.length(); j++) {
            char key = word.charAt(j);
            if (currentNode.characters.containsKey(key)) {
                currentNode = currentNode.characters.get(key);
            } else {
                TrieNode newNode = new TrieNode();
                currentNode.characters.put(key, newNode);
                currentNode = newNode;
            }
        }
        currentNode.isWord = true;
        currentNode.word = word;
    }

    protected static void wordsSearch(char[][] board, int row, int col,
                                      boolean[][] visited, List<String> result, TrieNode trieNode) {
        if (row < 0 || col < 0 ||
                row >= board.length || col >= board[0].length ||
                visited[row][col] ||
                !trieNode.characters.containsKey(board[row][col])) {
            return;
        }
        visited[row][col] = true;

        trieNode = trieNode.characters.get(board[row][col]);

        if (trieNode.isWord) {
            trieNode.isWord = false;
            result.add(trieNode.word);
        }

        wordsSearch(board, row + 1, col, visited, result, trieNode);
        wordsSearch(board, row, col + 1, visited, result, trieNode);
        wordsSearch(board, row - 1, col, visited, result, trieNode);
        wordsSearch(board, row, col - 1, visited, result, trieNode);

        visited[row][col] = false;
    }
}
