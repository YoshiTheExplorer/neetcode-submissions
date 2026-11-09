class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int max = -1;

        while(left < right){
            // get water and check for max
            int water = (right-left) * Math.min(heights[left], heights[right]);
            max = Math.max(water, max);
            // if left next is bigger, go left
            if (heights[left] < heights[right]) {
                left++;
            }
            // if right next is bigger, go right
            else {
                right--;
            }
        }
        return max;
    }
}
