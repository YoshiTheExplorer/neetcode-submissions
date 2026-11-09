class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int len_s = s.length();
        int len_t = t.length();

        if(len_s != len_t){
            return false;
        }

        if(len_s == 0){
            return true;
        }

        char[] s_char = s.toCharArray();
        char[] t_char = t.toCharArray();
        int val;

        for(int i = 0; i < len_s; i++){
            val = map.getOrDefault(s_char[i], 0);
            map.put(s_char[i], val + 1);
        }

        for(int i = 0; i < len_t; i++){
            if(map.get(t_char[i]) == null){
                return false;
            }
            val = map.get(t_char[i]);
            map.put(t_char[i], val - 1);
            if(val-1 < 0){
                return false;
            }
        }

        return true;
    }
}
