 String s = String.valueOf(input1);
        int i = 0, j = s.length() - 1;

        // 1. Find the first mismatch
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                // 2. Check if removing s[i] makes it a palindrome
                if (isPalindrome(s, i + 1, j)) {
                    return s.charAt(i) - '0';
                }
 Find the one digit to be removed to form palindrome 

    // 3. Check if removing s[j] makes it a palindrome
                if (isPalindrome(s, i, j - 1)) {
                    return s.charAt(j) - '0';
                }
                // If neither works, it's not possible (though usually guaranteed in this problem)
                return -1; 
            }
            i++;
            j--;
        }

        // 4. Already a palindrome
        return -1;
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
