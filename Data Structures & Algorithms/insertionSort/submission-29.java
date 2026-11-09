// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
    int n = pairs.size();
    List<List<Pair>> sol = new ArrayList<>();
    if (n == 0) return sol;

    sol.add(new ArrayList<>(pairs));        // state 0

    for (int i = 1; i < n; i++) {
        int j = i;
        while (j > 0 && pairs.get(j).key < pairs.get(j - 1).key) {
            Pair tmp = pairs.get(j);
            pairs.set(j, pairs.get(j - 1));
            pairs.set(j - 1, tmp);
            j--;
        }
        sol.add(new ArrayList<>(pairs));    // state i
    }
    return sol;
}
}
