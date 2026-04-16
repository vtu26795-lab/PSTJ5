import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T-- > 0)
		{
			String s = sc.next();
			int n = s.length();
			
			String left, right;
			
			if(n % 2 == 0)
			{
				left = s.substring(0, n/2);
				right = s.substring(n/2);
			}
			else
			{
				left = s.substring(0, n/2);
				right = s.substring(n/2 + 1);
			}
			
			if(isLapindrome(left, right))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
	
	static boolean isLapindrome(String a, String b)
	{
		int[] freq = new int[26];
		
		for(char c : a.toCharArray())
			freq[c - 'a']++;
			
		for(char c : b.toCharArray())
			freq[c - 'a']--;
			
		for(int i : freq)
			if(i != 0)
				return false;
				
		return true;

	}
}

