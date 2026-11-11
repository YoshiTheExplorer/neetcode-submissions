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
        List<Pair> sol;
        sol = divide(pairs);
        return sol;
    }

    public List<Pair> divide(List<Pair> pairs){
        int size = pairs.size();
        if (size <= 1) return pairs;
        int mid = size / 2;
        List<Pair> left = divide(new ArrayList<>(pairs.subList(0, mid)));
        List<Pair> right = divide(new ArrayList<>(pairs.subList(mid, size)));
        return conquer(left, right);
    }

    public List<Pair> conquer(List<Pair> left, List<Pair> right){
        List<Pair> sol = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i < left.size() && j < right.size()){
            if(left.get(i).key <= right.get(j).key){
                sol.add(left.get(i));
                i++;
            } else {
                sol.add(right.get(j));
                j++;
            }
        }

        if(i == left.size()){
            while(j < right.size()){
                sol.add(right.get(j));
                j++;
            }
        } else {
            while(i < left.size()){
                sol.add(left.get(i));
                i++;
            }
        }

        return sol;
    }
}
