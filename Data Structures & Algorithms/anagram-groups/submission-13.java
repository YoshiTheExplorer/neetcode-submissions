class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //Keep info of idx
        Map<String, Integer> idxTracker = new HashMap<>();

        //Keep info of match
        List<List<String>> match = new ArrayList<>();

        int i = 0;
        // Iterate through arr
        for(String str : strs){
            char[] sorted = str.toCharArray();
            Arrays.sort(sorted);
            String word = new String(sorted);
            if(idxTracker.containsKey(word)){
                match.get(idxTracker.get(word)).add(str);
            } else{
                List<String> newGroup = new ArrayList<>();
                newGroup.add(str);

                match.add(newGroup);
                idxTracker.put(word, i);
                i++;
            }
        }

        return match;
    }
}
