class Solution {
    public int removeDuplicates(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int num : nums){
            set.add(num);
        }
        int k = 0;
        for(Integer n : set){
            nums[k++] = n;
        }
        return set.size();
    }
}