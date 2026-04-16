Task 5 code :

public int isPalindrome(String input1){

    input1 = input1.toLowerCase();

    String rev = "";

    for(int i = input1.length() - 1; i >= 0; i--){
        rev = rev + input1.charAt(i);
    }

    if(input1.equals(rev)){
        return 2;
    }

    return 1;
} 
     

Task 6 : code


public int allDigitsCount(int input1){

    int count = 0;

    while(input1 > 0){
        count++;
        input1 = input1 / 10;
    }

    return count;
}




Task 8 Code :

public int totalHillWeight(int input1, int input2, int input3){

    int total = 0;

    for(int i = 1; i <= input1; i++){
        int weight = input2 + (i - 1) * input3;
        total += i * weight;
    }

    return total;
}







Task 10 CODE : 

public int sumOfSumsOfDigits(int input1){

    String num = String.valueOf(input1);
    int total = 0;

    while(num.length() > 0){

        int sum = 0;

        for(int i = 0; i < num.length(); i++){
            sum += num.charAt(i) - '0';
        }

        total += sum;

        // remove first digit
        num = num.substring(1);
    }

    return total;
}