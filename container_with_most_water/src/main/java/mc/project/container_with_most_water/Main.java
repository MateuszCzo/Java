package mc.project.container_with_most_water;

public class Main {
    public static void main(String[] args) {

    }

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int result = 0;
        int field;

        while (left < right) {
            if (height[left] < height[right]) {
                field = height[left] * (right - left);
                left++;
            } else {
                field = height[right] * (right - left);
                right--;
            }
            if (field > result) {
                result = field;
            }
        }
        return result;
    }
}
