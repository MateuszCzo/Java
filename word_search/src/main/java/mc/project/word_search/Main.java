package mc.project.word_search;
/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 */
public class Main {
    public static void main(String[] args) {
        char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word = "AAB";

        exist(board, word);
    }

    public static boolean exist(char[][] board, String word) {
        int yLength = board.length;
        int xLength = board[0].length;
        int lastYIndex = yLength - 1;
        int lastXIndex = xLength - 1;

        char[] characters = word.toCharArray();
        int lastCharacterIndex = word.length() - 1;

        boolean[][] alreadySearched = new boolean[yLength][xLength];

        for (int i = 0; i < yLength; i++) {
            for (int j = 0; j < xLength; j++) {
                if (board[i][j] == characters[0] &&
                        searchNext(
                                board, alreadySearched, lastYIndex, lastXIndex,
                                i, j, 0,
                                characters, lastCharacterIndex
                        )) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean searchNext(char[][] board, boolean[][] alreadySearched, int lastYIndex, int lastXIndex,
                                     int currentY, int currentX, int characterIndex,
                                     char[] characters, int lastCharacterIndex) {
        if (characterIndex == lastCharacterIndex) {
            return true;
        }
        alreadySearched[currentY][currentX] = true;
        characterIndex++;
        // up
        if (currentY - 1 >= 0 &&
                board[currentY - 1][currentX] == characters[characterIndex] &&
                !alreadySearched[currentY - 1][currentX] &&
                searchNext(board, alreadySearched, lastYIndex, lastXIndex,
                        currentY - 1, currentX, characterIndex,
                        characters, lastCharacterIndex)) {
            return true;
        }
        // right
        if (currentX + 1 <= lastXIndex &&
                board[currentY][currentX + 1] == characters[characterIndex] &&
                !alreadySearched[currentY][currentX + 1] &&
                searchNext(board, alreadySearched, lastYIndex, lastXIndex,
                        currentY, currentX + 1, characterIndex,
                        characters, lastCharacterIndex)) {
            return true;
        }
        // down
        if (currentY + 1 <= lastYIndex &&
                board[currentY + 1][currentX] == characters[characterIndex] &&
                !alreadySearched[currentY + 1][currentX] &&
                searchNext(board, alreadySearched, lastYIndex, lastXIndex,
                        currentY + 1, currentX, characterIndex,
                        characters, lastCharacterIndex)) {
            return true;
        }
        // left
        if (currentX - 1 >= 0 &&
                board[currentY][currentX - 1] == characters[characterIndex] &&
                !alreadySearched[currentY][currentX - 1] &&
                searchNext(board, alreadySearched, lastYIndex, lastXIndex,
                        currentY, currentX - 1, characterIndex,
                        characters, lastCharacterIndex)) {
            return true;
        }
        alreadySearched[currentY][currentX] = false;
        characterIndex--;
        return false;
    }
}
