class Solution {
    public boolean halvesAreAlike(String s) {
        int mid=s.length()/2;
    int count=0;
      for(int i=0;i<mid;i++)
      {
        if(isVowel(s.charAt(i)))
        {
            count++;
        }
      }
      for(int i=mid;i<s.length();i++)
      {
        if(isVowel(s.charAt(i)))
        {
            count--;
        }
      }
      return count==0;
    }
    static boolean isVowel(char c)
    {
        return "aeiouAEIOU".indexOf(c) !=-1;
    }
}
