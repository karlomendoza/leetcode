public class LongestPalindromicSubstring {

  public String longestPalindrome(String s) {
    if(s.length() == 1)
      return s;

    String maxPalindrome = s.substring(0,1);
    int distance = 0;
    int rightOffSetforPairBasedPalindrome = 0;
    //Case with middle letter
    for (int i = 0; i+1 <s.length() ; i++) {
      if(s.charAt(i) == s.charAt(i+1)) {
        maxPalindrome = findPalindrome(s, i, maxPalindrome, 1);
      }
      maxPalindrome = findPalindrome(s, i, maxPalindrome, 0);
    }
    return maxPalindrome;
  }

  public String findPalindrome(String s, int i, String maxPalindrome, int rightOffSetforPairBasedPalindrome){
    int distance = 0;
    while(i -distance >= 0 && i+distance + rightOffSetforPairBasedPalindrome< s.length()){
      if(s.charAt(i-distance) != s.charAt(i+distance + rightOffSetforPairBasedPalindrome)){
        break;
      } else {
        if(maxPalindrome.length() < 1 + distance*2 + rightOffSetforPairBasedPalindrome) {
          maxPalindrome = s.substring(i-distance, i+distance+1 + rightOffSetforPairBasedPalindrome);
        }
      }
      distance++;
    }
    return maxPalindrome;
  }
}
