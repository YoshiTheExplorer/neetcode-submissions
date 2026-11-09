class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        if(nums[0] < nums[nums.length - 1]) return nums[0];

        while(left < right){
            int middle = left + (right - left)/2;
            if(nums[middle] < nums[right]){ // not sorted on right side
                //todo
                right = middle;
            } else { // not sorted on left side
                //todo
                left = middle + 1;
            }
        }
        return nums[left];
    }
}
