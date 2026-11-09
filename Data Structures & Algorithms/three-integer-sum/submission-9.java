class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate first numbers
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];

                if (sum > 0) {
                    high--;
                } else if (sum < 0) {
                    low++;
                } else {
                    sol.add(Arrays.asList(nums[i], nums[low], nums[high]));

                    low++;
                    high--;

                    // Skip duplicate second numbers
                    while (low < high && nums[low] == nums[low - 1]) {
                        low++;
                    }

                    // Skip duplicate third numbers
                    while (low < high && nums[high] == nums[high + 1]) {
                        high--;
                    }
                }
            }
        }

        return sol;
    }
}