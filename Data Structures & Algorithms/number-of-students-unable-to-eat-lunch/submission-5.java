class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int freq[] = {0, 0};
        int size = students.length;
        int res = size;
        for (int i=0;i<size;i++) {
            freq[students[i]]++;
        }
        for (int i=0; i<size; i++) {
            if (freq[sandwiches[i]] > 0) {
                res--;
                freq[sandwiches[i]]--;
            } else {
                break;
            }
        }

        return res;
    }
}