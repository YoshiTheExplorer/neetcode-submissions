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
        return mergeSortHelper(pairs, 0, pairs.size()-1);
    }

    public List<Pair> mergeSortHelper(List<Pair> pairs, int s, int e) {
        if(e - s <= 0){
            return pairs;
        }

        int m = (e + s)/2;

        mergeSortHelper(pairs, s, m);
        mergeSortHelper(pairs, m+1, e);

        merge(pairs, s, m, e);

        return pairs;
    }

    public void merge(List<Pair> pairs, int s, int m, int e) {
        List<Pair> first = new ArrayList<>();
        List<Pair> second = new ArrayList<>();

        for(int i = s; i < m + 1; i++){
            first.add(pairs.get(i));
        }
        for(int i = m + 1; i < e + 1; i++){
            second.add(pairs.get(i));
        }

        int f = 0;
        int sec = 0;
        int i = s;

        while(f < first.size() && sec < second.size()){
            if(first.get(f).key <= second.get(sec).key){
                pairs.set(i, first.get(f));
                f++;
            } else {
                pairs.set(i, second.get(sec));
                sec++;
            }
            i++;
        }

        while(f < first.size()){
            pairs.set(i, first.get(f));
            f++;
            i++;
        }

        while(sec < second.size()){
            pairs.set(i, second.get(sec));
            sec++;
            i++;
        }
    }
}
