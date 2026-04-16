       int[] inputs = {input1, input2, input3, input4, input5};
        int stableSum = 0;
        int unstableSum = 0;

        for (int num : inputs) {
            if (isStable(num)) {
                stableSum += num;
            } else {
                unstableSum += num;
            }
        }

        return stableSum - unstableSum;
    }

    public boolean isStable(int num) {
        int[] freq = new int[10];
        String s = String.valueOf(Math.abs(num));
        
        // Count frequency of each digit
        for (char c : s.toCharArray()) {
            freq[c - '0']++;
        }

        int firstFreq = 0;
        for (int f : freq) {
            if (f > 0) {
                if (firstFreq == 0) {
                    firstFreq = f;
                } else if (f != firstFreq) {
                    return false; // Found a mismatching frequency
                }
            }
        }
        return true;
