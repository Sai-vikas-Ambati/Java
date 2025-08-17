class Solution {
    public String convert(String s, int numRows) {
        if (s.length() == 1 || numRows == 1) {
            return s;
        }

        String[] rows = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = "";
        }

        int currentRow = 0;
        boolean down = true;

        for (int i = 0; i < s.length(); i++) {
            rows[currentRow] += s.charAt(i);

            if (down) {
                currentRow++;
                if (currentRow == numRows) {
                    currentRow = numRows - 2;
                    down = false;
                }
            } else {
                currentRow--;
                if (currentRow == -1) {
                    currentRow = 1;
                    down = true;
                }
            }
        }

        String output = "";
        for (int i = 0; i < numRows; i++) {
            output += rows[i];
        }

        return output;
    }
}
