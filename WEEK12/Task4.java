       int u1 = input1 % 10, t1 = (input1 / 10) % 10, h1 = (input1 / 100) % 10, th1 = (input1 / 1000) % 10;
        int u2 = input2 % 10, t2 = (input2 / 10) % 10, h2 = (input2 / 100) % 10, th2 = (input2 / 1000) % 10;
        int u3 = input3 % 10, t3 = (input3 / 10) % 10, h3 = (input3 / 100) % 10, th3 = (input3 / 1000) % 10;

        // Step 1: Minimum of Units
        int pinUnits = Math.min(u1, Math.min(u2, u3));

        // Step 2: Minimum of Tens
        int pinTens = Math.min(t1, Math.min(t2, t3));

        // Step 3: Minimum of Hundreds
        int pinHundreds = Math.min(h1, Math.min(h2, h3));

        // Step 4: Maximum of ALL digits across all three numbers
        int maxDigit = Math.max(u1, Math.max(t1, Math.max(h1, th1)));
        maxDigit = Math.max(maxDigit, Math.max(u2, Math.max(t2, Math.max(h2, th2))));
        maxDigit = Math.max(maxDigit, Math.max(u3, Math.max(t3, Math.max(h3, th3))));

        // Combine into a 4-digit PIN
        int pin = (maxDigit * 1000) + (pinHundreds * 100) + (pinTens * 10) + pinUnits;

        return pin;

