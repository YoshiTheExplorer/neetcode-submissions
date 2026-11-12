class Solution {
    public int[][] kClosest(int[][] points, int k) {
        quickSort(points, 0, points.length - 1);
        return Arrays.copyOfRange(points, 0, k);
    }

    public void quickSort(int[][] points, int start, int end) {
        if (end < start)
            return;

        int[] pivot = points[end];
        double distPivot = distCalc(pivot);
        int ptr = start;

        for (int i = start; i < end; i++) {
            if (distCalc(points[i]) < distPivot) {
                int[] temp = points[ptr];
                points[ptr] = points[i];
                points[i] = temp;
                ptr++;
            }
        }

        points[end] = points[ptr];
        points[ptr] = pivot;

        quickSort(points, start, ptr - 1);

        quickSort(points, ptr + 1, end); 
    }

    public double distCalc(int[] pt) {
        return Math.sqrt(pt[0] * pt[0] + pt[1] * pt[1]);
    }
}
