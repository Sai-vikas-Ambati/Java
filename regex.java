import java.util.regex.*;

class Solution {
    public boolean isMatch(String s, String p) {
        int s_l = s.length();
        int p_l = p.length();
        if(s_l != p_l){
            return false;
        }
        else if(s.isEmpty() || p.isEmpty()){
            return false;
        }
        else
        {
            for(int i = 0; i < s_l; i++){
                if(s.charAt(i) == p.charAt(i)){  // Corrected if condition
                    return true;
                }
                else if(s.charAt(i) != p.charAt(i)){
                    if(p.charAt(i) == '*'){  // Fixed a syntax issue
                        Pattern pattern = Pattern.compile(p);
                        Matcher matcher = pattern.matcher(s);  // Corrected Matcher object creation
                        if(matcher.matches()) {
                            return true;
                        }
                    }
                    else if(p.charAt(i) == '.'){  // Handle '.' condition
                        continue;  // '.' can match any character, so continue the loop
                    }
                }
            }
        }
        return false;  // If no match found
    }
}
//this is the regular expression problem in leetcode
// Input: s = "aa", p = "a"
// Output: false
// Input: s = "aa", p = "a*"
// Output: true
// Input: s = "ab", p = ".*"
// Output: true
// Input: s = "aab", p = "c*a*b"
// Output: true