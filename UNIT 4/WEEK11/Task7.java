class Solution {
    public String frequencySort(String s) {
        // Step 1: Count frequency
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 2: Convert keys to list and sort
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

        // Step 3: Build result
        StringBuilder result = new StringBuilder();
        for (char c : list) {
            int freq = map.get(c);
            while (freq-- > 0) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
