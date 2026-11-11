class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length-1;
        m--;
        n--;
        while(index >= 0){
            if(m < 0 ){
                while(n >= 0){
                    nums1[index] = nums2[n];
                    n--;
                    index--;
                }
                return;
            } else if (n < 0){
                while(m >= 0){
                    nums1[index] = nums1[m];
                    m--;
                    index--;
                }
                return;
            }

            if(nums1[m] >= nums2[n]){
                nums1[index] = nums1[m];
                index--;
                m--;
            } else{
                nums1[index] = nums2[n];
                index--;
                n--;
            }
        }
        return;
    }
}