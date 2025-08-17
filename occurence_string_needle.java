class Solution {
    public int strStr(String haystack, String needle) {
        // If needle is empty, return 0
        if (needle.length() == 0) {
            return 0;
        }

        int haystackLength = haystack.length();
        int needleLength = needle.length();
        
       
        for (int i = 0; i <= haystackLength - needleLength; i++) {
           
            if (haystack.substring(i, i + needleLength).equals(needle)) {
                return i; 
            }
        }
        
        return -1; 
    }
}