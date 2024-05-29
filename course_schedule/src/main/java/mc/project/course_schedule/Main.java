package mc.project.course_schedule;

import java.util.*;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.
 */
public class Main {
    public static void main(String[] args) {
        int[][] prerequisites = {{0,1},{1,2},{3,1}};
        int numCourses = 2;

        canFinish(numCourses, prerequisites);
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> courses = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            Set<Integer> preCourses = courses.getOrDefault(prerequisites[i][0], new HashSet<>());
            for (int j = 1; j < prerequisites[i].length; j++) {
                preCourses.add(prerequisites[i][j]);
            }
            courses.put(prerequisites[i][0], preCourses);
        }

        Set<Integer> visitedCourses = new HashSet<>();
        for (int course : courses.keySet()) {
            canComplete(courses, course, visitedCourses);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!canComplete(courses, i, visitedCourses)) {
                return false;
            }
        }
        return true;
    }

    public static boolean canComplete(Map<Integer, Set<Integer>> courses, int course, Set<Integer> visitedCourses) {
        if (!courses.containsKey(course) || courses.get(course).isEmpty()) {
            return true;
        }
        if (visitedCourses.contains(course)) {
            return false;
        }
        visitedCourses.add(course);
        for (int preCourses : courses.get(course)) {
            if (!canComplete(courses, preCourses, visitedCourses)) {
                return false;
            }
        }
        courses.put(course, Collections.emptySet());
        return true;
    }
}
