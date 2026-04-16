int weight = 0;
    input1 = input1.toLowerCase(); // Standardize to lowercase
    
    for (int i = 0; i < input1.length(); i++) {
        char letter = input1.charAt(i);
        
        // Skip vowels if input2 is 0
        if (input2 == 0) {
            if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
                continue;
            }
        }     
        // Calculate weight for alphabets only
        if (letter >= 'a' && letter <= 'z') {
            weight += (letter - 'a' + 1);
        }
    }
    return weight;
