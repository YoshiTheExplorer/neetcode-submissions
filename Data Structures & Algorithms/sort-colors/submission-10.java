class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num] += 1;
        }

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count[k] == 0) {
                k++;
                i--;
            } else {
                nums[i] = k;
                count[k] -= 1;
            }
        }
    }
}