package mc.project.longest_common_prefix;
/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
 */
public class Main {
    public static void main(String[] args) {

    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        StringBuilder commonBuilder = new StringBuilder();

        for (int i = 0; i < strs[0].length(); i++) {
            char character = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() - 1 < i ||
                        character != strs[j].charAt(i)) {
                    return commonBuilder.toString();
                }
            }
            commonBuilder.append(character);
        }

        return commonBuilder.toString();
    }
}
