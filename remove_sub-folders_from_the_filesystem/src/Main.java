import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
//  Given a list of folders folder, return the folders after removing all sub-folders in those folders. You may return the answer in any order.
//
//  If a folder[i] is located within another folder[j], it is called a sub-folder of it. A sub-folder of folder[j] must start with folder[j], followed by a "/". For example, "/a/b" is a sub-folder of "/a", but "/b" is not a sub-folder of "/a/b/c".
//
//  The format of a path is one or more concatenated strings of the form: '/' followed by one or more lowercase English letters.
//
//  For example, "/leetcode" and "/leetcode/problems" are valid paths while an empty string and "/" are not.

//  Constraints:
//
//  1 <= folder.length <= 4 * 104
//  2 <= folder[i].length <= 100
//  folder[i] contains only lowercase letters and '/'.
//  folder[i] always starts with the character '/'.
//  Each folder name is unique.
    public static void main(String[] args) {
        System.out.println(removeSubfolders(new String[]{"/c/f", "/a/b", "/a", "/c/d", "/c/d/e"}));
    }

    public static List<String> removeSubfolders(String[] folder) {
        List<String> result = new ArrayList<>();

        Arrays.sort(folder);

        String main = folder[0];
        result.add(main);

        for (int i = 1; i < folder.length; i++) {
            if (folder[i].startsWith(main) && folder[i].charAt(main.length()) == '/') {
                continue;
            }
            result.add(folder[i]);
            main = folder[i];
        }

        return result;
    }
}