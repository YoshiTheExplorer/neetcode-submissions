class Solution {
    public int findMin(int[] nums) {
        int ptr1 = 0;
        int ptr2 = nums.length - 1;
        int mid;

        while(ptr1 < ptr2){
            mid = (ptr2 - ptr1)/2 + ptr1;
            if(nums[mid] > nums[ptr2]){
                ptr1 = mid + 1;
            } else {
                ptr2 = mid;
            }
        }

        return nums[ptr1];
    }
}
