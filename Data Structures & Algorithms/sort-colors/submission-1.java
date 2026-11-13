class Solution {
    public void sortColors(int[] nums) {
        int[] tab = {0, 0, 0};
        for(int num : nums){
            tab[num] += 1;
        }

        int j = 0;
        for(int i = 0; i < 3; i++){
            while(tab[i] > 0){
                nums[j] = i;
                tab[i] = tab[i] - 1;
                j++;
            }
        }
    }
}