class Solution {
    public int maxArea(int[] heights) {
        int max = -1;
        int p1 = 0;
        int p2 = heights.length-1;
        
        while(p1 < p2){
            int area = Math.min(heights[p1], heights[p2]) * (p2-p1);
            if(area > max) max = area;
            if(heights[p1] < heights[p2]){
                p1++;
            } else {
                p2--;
            }
        }
        return max;
    }
}
