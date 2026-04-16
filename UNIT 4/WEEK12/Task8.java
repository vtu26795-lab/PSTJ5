       String str = input1;
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < str.length()) {
            int firstDigit = str.charAt(i) - '0';
            int firstParity = firstDigit % 2; // 0 for even, 1 for odd
            int sum = 0;

            // Start summing from the current digit
            while (i < str.length()) {
                sum += (str.charAt(i) - '0');
                int currentSumParity = sum % 2;
                
                i++; // Move to next digit
                
                // Break if the parity of the sum is opposite to first digit's parity
                if (currentSumParity != firstParity) {
                    break;
                }
            }
            // Append the group sum to the final result string
            result.append(sum);
        }

        return Integer.parseInt(result.toString());
