package mc.project.group_anagram;

import java.util.*;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */
public class Main {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        groupAnagrams(strs);

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashMap = new HashMap<>();

        for (String str : strs) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String key = String.valueOf(strArr);
            List<String> list = hashMap.get(key);
            if (list == null) {
                list = new LinkedList<>();
            }
            list.add(str);
            hashMap.put(key, list);
        }
        return new ArrayList<>(hashMap.values());
    }
}
