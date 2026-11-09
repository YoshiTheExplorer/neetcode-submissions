class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        int one = m - 1;
        int two = n-1;

        while(one >= 0 && two >= 0){
            if(nums1[one] > nums2[two]){
                nums1[i] = nums1[one];
                one--;
            } else {
                nums1[i] = nums2[two];
                two--;
            }
            i--;
        }

        while(one >= 0){
            nums1[i] = nums1[one];
            one--;
            i--;
        }
        while(two >= 0){
            nums1[i] = nums2[two];
            two--;
            i--;
        }
    }
}