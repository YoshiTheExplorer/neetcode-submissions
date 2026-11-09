class Solution {
    public int findMin(int[] nums) {
        if (nums[nums.length-1] > nums[0]) return nums[0];
        int p1 = 0;
        int p2 = nums.length - 1;

        while (p1 < p2){
            int mid = (p2+p1)/2;
            //if sorted on left side, check right
            if(nums[mid] < nums[p2]){
                p2 = mid;
            } else {
                
                p1 = mid + 1;
            }
        }

        return nums[p1];
    }
}
