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
        if(pairs.isEmpty()) return new ArrayList<>();
        List<List<Pair>> sol = new ArrayList<>();
        for (int i = 1; i < pairs.size(); i++) {
            int j = i - 1;
            sol.add(new ArrayList<>(pairs));
            while (j >= 0 && pairs.get(j + 1).key < pairs.get(j).key) {
                Pair temp = pairs.get(j + 1);
                pairs.set((j + 1), pairs.get(j));
                pairs.set((j), temp);
                j--;
            }
        }
        sol.add(new ArrayList<>(pairs));
        return sol;
    }
}
