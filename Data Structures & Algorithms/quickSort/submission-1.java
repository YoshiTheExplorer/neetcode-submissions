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
        int left = 0;
        int right = pairs.size() - 1;
        List<Pair> sol = recursion(pairs, left, right);
        return sol;
    }

    public List<Pair> recursion(List<Pair> pairs, int left, int right){
        if (right <= left) return pairs;
        Pair pivot = pairs.get(right);
        int ptr = left;

        for (int i = left; i < right; i++) {
            if (pairs.get(i).key < pivot.key) {
                Pair temp = pairs.get(ptr);
                pairs.set(ptr, pairs.get(i));
                pairs.set(i, temp);
                ptr++;
            }
        }

        pairs.set(right, pairs.get(ptr));
        pairs.set(ptr, pivot);

        recursion(pairs, left, ptr - 1);
        recursion(pairs, ptr + 1, right);
        return pairs;
    }
}
