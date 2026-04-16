String[] p1 = split(input1);
        String[] p2 = split(input2);
        String[] p3 = split(input3);

        String output1 = p1[0] + p2[0] + p3[0];
        String output2 = p1[1] + p2[1] + p3[1];
        String output3 = p1[2] + p2[2] + p3[2];

        output3 = toggle(output3);

        return new Result(output1, output2, output3);
    }

    private String[] split(String str)
    {
        int n = str.length();
        int base = n / 3;
        int rem = n % 3;

        int front = base;
        int middle = base;
        int end = base;

        if (rem == 1)
        {
            middle++;
        }
        else if (rem == 2)
        {
            front++;
            end++;
        }

        String p1 = str.substring(0, front);
        String p2 = str.substring(front, front + middle);
        String p3 = str.substring(front + middle);

        return new String[]{p1, p2, p3};
    }

    private String toggle(String str)
    {
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray())
        {
            if (Character.isLowerCase(c))
                sb.append(Character.toUpperCase(c));
            else
                sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }
}