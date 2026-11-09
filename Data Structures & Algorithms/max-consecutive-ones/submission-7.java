class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result=0,count=0;
        for(int n:nums){
            if(n== 0){
                result = Math.max(result,count);
                count=0;
            }
            else{
                count++;
            }
        }
        return Math.max(result,count);
    }
}
