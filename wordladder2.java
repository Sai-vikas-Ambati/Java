class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> results = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return results;

        // Map to store the parents for each word
        Map<String, List<String>> parents = new HashMap<>();

        // BFS variables
        Set<String> currentLevel = new HashSet<>();
        currentLevel.add(beginWord);

        // To keep track of visited words at each level to avoid cycles
        Set<String> visitedThisLevel = new HashSet<>();
        
        boolean foundEnd = false;

        while (!currentLevel.isEmpty() && !foundEnd) {
            // Remove words visited in previous levels to prevent cycles
            wordSet.removeAll(currentLevel);

            Set<String> nextLevel = new HashSet<>();
            visitedThisLevel.clear();

            for (String word : currentLevel) {
                char[] wordChars = word.toCharArray();

                for (int i = 0; i < wordChars.length; i++) {
                    char originalChar = wordChars[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;

                        wordChars[i] = c;
                        String nextWord = new String(wordChars);

                        if (wordSet.contains(nextWord)) {
                            if (!parents.containsKey(nextWord)) {
                                parents.put(nextWord, new ArrayList<>());
                            }
                            parents.get(nextWord).add(word);

                            if (nextWord.equals(endWord)) {
                                foundEnd = true;
                            }

                            if (!visitedThisLevel.contains(nextWord)) {
                                nextLevel.add(nextWord);
                                visitedThisLevel.add(nextWord);
                            }
                        }
                    }

                    wordChars[i] = originalChar;
                }
            }

            currentLevel = nextLevel;
        }

        if (foundEnd) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            backtrack(results, parents, path, beginWord, endWord);
        }

        return results;
    }

    private void backtrack(List<List<String>> results, Map<String, List<String>> parents, 
                           List<String> path, String beginWord, String word) {
        if (word.equals(beginWord)) {
            // We have built the path from end to begin, so reverse it before adding
            List<String> validPath = new ArrayList<>(path);
            Collections.reverse(validPath);
            results.add(validPath);
            return;
        }

        if (!parents.containsKey(word)) {
            return;  // no path from here
        }

        for (String parent : parents.get(word)) {
            path.add(parent);
            backtrack(results, parents, path, beginWord, parent);
            path.remove(path.size() - 1);
        }
    }
}
