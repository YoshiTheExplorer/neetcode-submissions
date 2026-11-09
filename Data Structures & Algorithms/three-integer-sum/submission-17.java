class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();

        // Sort array
        Arrays.sort(nums);
        // 2 pointer
        int left;
        int right;
        // [-4,-1,-1,0,1,2]
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            left = i + 1;
            right = nums.length - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                //if sum is +, move left to right
                if(sum > 0) {
                    int num = nums[right];
                    while (left < right && nums[right] == num) {
                        right--;
                    }
                }
                //if sum is -, move right to left
                else if(sum < 0) {
                    int num = nums[left];

                    while (left < right && nums[left] == num) {
                        left++;
                    }
                }
                //if sum is 0, move both
                else {
                    sol.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    int num = nums[left];
                    while (left < right && nums[left] == num) {
                        left++;
                    }

                    num = nums[right];
                    while (left < right && nums[right] == num) {
                        right--;
                    }
                }
            }
        }
        return sol;
    }
}
