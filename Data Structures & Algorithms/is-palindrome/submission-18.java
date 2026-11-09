class Solution {
    public boolean isPalindrome(String s) {
        char[] charArr = s.toLowerCase().toCharArray();

        int i = 0;
        int j = charArr.length - 1;

        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(charArr[i])) {
                i++;
            }

            while (i < j && !Character.isLetterOrDigit(charArr[j])) {
                j--;
            }

            if (charArr[i] != charArr[j]) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}