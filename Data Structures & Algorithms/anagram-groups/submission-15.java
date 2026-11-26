class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> sol = new ArrayList<>();

        int ptx = 0;
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(map.get(key) == null){
                map.put(key, ptx);
                sol.add(new ArrayList<>());
                ptx++;
            }
            sol.get(map.get(key)).add(str);
        }
        return sol;
    }
}
