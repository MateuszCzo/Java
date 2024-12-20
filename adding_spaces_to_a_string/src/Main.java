public class Main {
//    You are given a 0-indexed string s and a 0-indexed integer array spaces that describes the indices in the original string where spaces will be added. Each space should be inserted before the character at the given index.
//
//For example, given s = "EnjoyYourCoffee" and spaces = [5, 9], we place spaces before 'Y' and 'C', which are at indices 5 and 9 respectively. Thus, we obtain "Enjoy Your Coffee".
//Return the modified string after the spaces have been added.
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public String addSpaces(String s, int[] spaces) {
        StringBuilder stringBuilder = new StringBuilder();
        int spaceIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            if (spaceIndex < spaces.length && i == spaces[spaceIndex]) {
                spaceIndex++;
                stringBuilder.append(' ');
            }
            stringBuilder.append(s.charAt(i));
        }

        return stringBuilder.toString();
    }
}