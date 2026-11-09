class Solution {
    public int[] replaceElements(int[] arr) {
        int greatestRight = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];
            arr[i] = greatestRight;
            greatestRight = Math.max(greatestRight, current);
        }

        return arr;
    }
}