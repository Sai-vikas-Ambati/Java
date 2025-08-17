class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.isEmpty()) return false;

        s = s.trim();
        if (s.isEmpty()) return false;

        // Reject strings like "Infinity", "+Infinity", "-Infinity"
        if (s.equalsIgnoreCase("Infinity") || s.equalsIgnoreCase("+Infinity") || s.equalsIgnoreCase("-Infinity")) {
            return false;
        }

        int len = s.length();
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenE = false;

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '+' || c == '-') {
                // Sign only allowed at start or immediately after 'e' or 'E'
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
                // Sign can't be last character
                if (i == len - 1) return false;
            } else if (c == '.') {
                if (seenDot || seenE) return false; 
                seenDot = true;
                // Check for consecutive dots
                if (i + 1 < len && s.charAt(i + 1) == '.') return false;
            } else if (c == 'e' || c == 'E') {
                if (seenE || !seenDigit) return false; // only one 'e' and must follow a digit
                seenE = true;
                // 'e' can't be last char
                if (i == len - 1) return false;
            } else {
                // Invalid character
                return false;
            }
        }

        return seenDigit;
    }
}
