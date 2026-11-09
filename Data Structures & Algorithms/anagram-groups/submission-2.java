class Solution {
  public static List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> listList = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    int num = 0;
    
    for(int i = 0; i < strs.length; i++) {
      char[] word = strs[i].toCharArray();
      Arrays.sort(word);
      String str = new String(word);
      System.out.println(str);
      
      //find pattern, get index for listList
      if(map.get(str) == null) {
        map.put(str, num);
        listList.add(num, new ArrayList<String>());
        num++;
      }
      listList.get(map.get(str)).add(strs[i]);
    }
    
    return listList;
  }
}

/*
 * Given an array of strings strs, group all anagrams together into sublists. You may return the
 * output in any order.
 * 
 * An anagram is a string that contains the exact same characters as another string, but the order
 * of the characters can be different.
 * 
 * Example 1:
 * 
 * Input: strs = ["act","pots","tops","cat","stop","hat"]
 * 
 * Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]] Example 2:
 * 
 * Input: strs = ["x"]
 * 
 * Output: [["x"]] Example 3:
 * 
 * Input: strs = [""]
 * 
 * Output: [[""]]
 */
