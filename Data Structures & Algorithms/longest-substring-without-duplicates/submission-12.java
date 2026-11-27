class Solution {
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new ArrayDeque<>();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int count = 0;

        for(char c : s.toCharArray()){
            while(map.getOrDefault(c, 0) == 1 && queue.size() != 0){
                map.put(queue.poll(), 0);
                count--;
            }
            queue.offer(c);
            count++;
            map.put(c, 1);
            max = Math.max(count, max);
        }
        return max;
    }
}
