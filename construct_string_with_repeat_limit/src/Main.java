import java.util.PriorityQueue;

public class Main {
//    You are given a string s and an integer repeatLimit. Construct a new string repeatLimitedString using the characters of s such that no letter appears more than repeatLimit times in a row. You do not have to use all characters from s.
//
//Return the lexicographically largest repeatLimitedString possible.
//
//A string a is lexicographically larger than a string b if in the first position where a and b differ, string a has a letter that appears later in the alphabet than the corresponding letter in b. If the first min(a.length, b.length) characters do not differ, then the longer string is the lexicographically larger one.
    public static void main(String[] args) {
        System.out.println(repeatLimitedString("cczazcc", 3));
    }

    public static String repeatLimitedString(String s, int repeatLimit) {
        int[] charsCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charsCount[s.charAt(i) - 'a']++;
        }

        // index(character), count
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < charsCount.length; i++) {
            if (charsCount[i] > 0) {
                maxHeap.add(new int[]{i, charsCount[i]});
            }
        }

        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            char currChar = (char) (curr[0] + 'a');
            int currCount = Math.min(repeatLimit, curr[1]);
            curr[1]-=currCount;

            for (int i = 0; i < currCount; i++) {
                result.append(currChar);
            }

            if (curr[1] <= 0) continue;
            if (maxHeap.isEmpty()) break;

            int[] next = maxHeap.poll();
            char nextChar = (char) (next[0] + 'a');
            next[1]--;

            result.append(nextChar);

            if (next[1] > 0) {
                maxHeap.add(next);
            }
            maxHeap.add(curr);
        }

        return result.toString();
    }
}