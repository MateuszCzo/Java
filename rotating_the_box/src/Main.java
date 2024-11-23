public class Main {
//    You are given an m x n matrix of characters box representing a side-view of a box. Each cell of the box is one of the following:
//
//A stone '#'
//A stationary obstacle '*'
//Empty '.'
//The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.
//
//It is guaranteed that each stone in box rests on an obstacle, another stone, or the bottom of the box.
//
//Return an n x m matrix representing the box after the rotation described above.
    public static void main(String[] args) {
        System.out.println(rotateTheBox(new char[][]{{'#','.','*','.'},
                {'#','#','*','.'}}));
    }

    public static char[][] rotateTheBox(char[][] box) {
        char[][] result = new char[box[0].length][box.length];

        int col = 0;
        for (int i = box.length - 1; i >= 0; i--) {
            int row = box[i].length - 1;
            for (int j = box[i].length - 1; j >= 0; j--) {
                result[j][col] = '.';
                if (box[i][j] == '#') {
                    result[row][col] = '#';
                    row--;
                } else if (box[i][j] == '*') {
                    result[j][col] = '*';
                    row = j - 1;
                }
            }
            col++;
        }

        return result;
    }
}