class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int sum = 0;
        int max = 0;
        for(int num : nums){
            if(num == 0) sum = 0;
            else {
                sum = sum + 1;
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}