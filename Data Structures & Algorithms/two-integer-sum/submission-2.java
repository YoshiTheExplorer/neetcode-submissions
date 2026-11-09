class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] sol = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(map.get(target - nums[i]) != null){
                sol[0] = map.get(target - nums[i]);
                sol[1] = i;
                return sol;
            }
            map.put(nums[i], i);
        }
        return sol;
    }
}
