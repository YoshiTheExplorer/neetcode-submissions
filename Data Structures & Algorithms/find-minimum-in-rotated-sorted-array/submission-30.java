class Solution {
    public int findMin(int[] nums) {
        int p1 = 0;
        int p2 = nums.length - 1;

        while(p1 < p2){
            int m = (p1 + p2) / 2;
            if(nums[m] < nums[p2]){
                p2 = m;
            } else {
                p1 = m + 1;
            }
        }
        return nums[p1];
    }
}
