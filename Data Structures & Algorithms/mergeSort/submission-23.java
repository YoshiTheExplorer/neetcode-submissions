// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        if (pairs == null || pairs.size() <= 1) {
            return pairs;
        }
        return merge(pairs, 0, pairs.size() - 1);
    }

    private List<Pair> merge(List<Pair> pairs, int left, int right){
        if (left == right) {
            List<Pair> single = new ArrayList<>();
            single.add(pairs.get(left));
            return single;
        }
        int m = (right - left)/2 + left;
        List<Pair> l = merge(pairs, left, m);
        List<Pair> r = merge(pairs, m+1, right);
        return conquer(l, r);
    }

    private List<Pair> conquer(List<Pair> l1, List<Pair> l2){
        List<Pair> sol = new ArrayList<>();

        int l1Count = 0;
        int l2Count = 0;

        while(l1Count < l1.size() && l2Count < l2.size()){
            if(l1.get(l1Count).key <= l2.get(l2Count).key){
                sol.add(l1.get(l1Count));
                l1Count++;
            } else {
                sol.add(l2.get(l2Count));
                l2Count++;
            }
        }

        if(l1Count < l1.size()){
            while(l1Count < l1.size()){
                sol.add(l1.get(l1Count));
                l1Count++;
            }
        }

        if(l2Count < l2.size()){
            while(l2Count < l2.size()){
                sol.add(l2.get(l2Count));
                l2Count++;
            }
        }

        return sol;
    }
}
