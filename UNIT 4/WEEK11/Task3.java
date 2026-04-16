class Solution {
    public List<String> commonChars(String[] words) {
        int[] minFreq = new int[26];

        // Step 1: Initialize with first word
        for (char c : words[0].toCharArray()) {
            minFreq[c - 'a']++;
        }

        // Step 2: Compare with remaining words
        for (int i = 1; i < words.length; i++) {
            int[] freq = new int[26];

            for (char c : words[i].toCharArray()) {
                freq[c - 'a']++;
            }

            // Take minimum frequency
            for (int j = 0; j < 26; j++) {
                minFreq[j] = Math.min(minFreq[j], freq[j]);
            }
        }

        // Step 3: Build result
        List<String> result = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            while (minFreq[i] > 0) {
                result.add(String.valueOf((char) (i + 'a')));
                minFreq[i]--;
            }
        }

        return result;
    }
}
