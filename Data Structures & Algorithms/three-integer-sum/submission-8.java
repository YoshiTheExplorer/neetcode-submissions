class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> seen = new HashSet<>();

        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 2;
        int k = nums.length - 1;

        while (i < nums.length - 2) {

            if (k - 1 == i) {
                i++;
                k = nums.length - 1;
                j = k - 1;
                continue;
            }

            if (j == i) {
                k--;
                j = k - 1;
                continue;
            }

            if (nums[i] + nums[j] + nums[k] == 0) {
                seen.add(Arrays.asList(nums[i], nums[j], nums[k]));
            }

            j--;
        }

        List<List<Integer>> sol = new ArrayList<>(seen);

        sol.sort((a, b) -> {
            if (!a.get(0).equals(b.get(0))) {
                return a.get(0) - b.get(0);
            }
            if (!a.get(1).equals(b.get(1))) {
                return a.get(1) - b.get(1);
            }
            return a.get(2) - b.get(2);
        });

        return sol;
    }
}