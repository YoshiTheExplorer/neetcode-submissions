// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        quickSortHelper(pairs, 0, pairs.size() - 1);
        return pairs;
    }

    public void quickSortHelper(List<Pair> pairs, int start, int end) {
        if (end <= start)
            return;

        Pair pivot = pairs.get(end);
        int ptr = start;

        for (int i = start; i < end; i++) {
            if (pairs.get(i).key < pivot.key) {
                Pair temp = pairs.get(ptr);
                pairs.set(ptr, pairs.get(i));
                pairs.set(i, temp);
                ptr++;
            }
        }

        pairs.set(end, pairs.get(ptr));
        pairs.set(ptr, pivot);

        quickSortHelper(pairs, start, ptr - 1);
        quickSortHelper(pairs, ptr + 1, end);
    }
}
