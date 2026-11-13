class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int sol = right;

        while(right >= left){
            int mid = (right - left)/2 + left;
            long time = 0;
            for(int i : piles){
                time += Math.ceil((double) i / mid);
            }
            if (time <= h){
                sol = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return sol;
    }
}
