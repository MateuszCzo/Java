package mc.project.products_of_array_except_self;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,0,3,4,0};

        productExceptSelf2(nums);
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] nums2 = new int[nums.length];
        long product = 1;
        int indexZero = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (indexZero >= 0) {
                    return nums2;
                } else {
                    indexZero = i;
                }
            } else {
                product *= nums[i];
            }
        }
        if (indexZero >= 0) {
            nums2[indexZero] = (int)product;
            return nums2;
        }
        for (int i = 0; i< nums.length; i++) {
            nums2[i] = (int)(product / nums[i]);
        }
        return nums2;
    }

    public static int[] productExceptSelf2(int[] nums) {
        int n = nums.length;

        int [] res=new int[n];
        int l=1;
        int r=1;
        for(int i=0;i<n;i++)
        {
            res[i]=l;
            l*=nums[i];
        }
        for(int i=n-1;i>=0;i--)
        {
            res[i]*=r;
            r*=nums[i];

        }

        return res;
    }
}
