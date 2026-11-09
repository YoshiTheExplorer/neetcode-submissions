class Solution {
    public boolean isPalindrome(String s) {
        // Two Pointer
        // Change to Lower Case
        char[] arr = s.toLowerCase().toCharArray();
        if(arr.length == 1) return true;
        int left = 0, right = arr.length - 1; 
        // While loop (left < right)
        while(left < right){
            // check if its pointing at alphanumeric characters
            if(!Character.isLetterOrDigit(arr[left])){
                left++;
            } else if(!Character.isLetterOrDigit(arr[right])){
                right--;
            } else {
                if(arr[left] != arr[right]){
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
