class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int a = 0; a < nums.length; a++) {
            int diff = target - nums[a];
            if (map.containsKey(diff) && map.get(diff) != a) {
                int b = map.get(diff);
                return new int[] {Math.min(a, b), Math.max(a, b)};
            }
        }
        return new int[] {};
    }
}
