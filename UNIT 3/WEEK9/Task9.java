
String pattern = input1.toUpperCase();
String[] words = input2.split(":");

StringBuilder result = new StringBuilder();
boolean found = false;

for (String word : words) {
    word = word.trim().toUpperCase();

    if (word.length() != pattern.length()) continue;

    boolean isMatch = true;

    for (int i = 0; i < pattern.length(); i++) {
        if (pattern.charAt(i) != '_' && pattern.charAt(i) != word.charAt(i)) {
            isMatch = false;
            break;
        }
    }

    if (isMatch) {
        if (found) result.append(":");  // add separator
        result.append(word);
        found = true;
    }
}

return found ? result.toString() : "ERROR-009";

