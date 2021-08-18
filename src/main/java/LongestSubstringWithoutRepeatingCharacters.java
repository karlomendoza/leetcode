import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
  public int lengthOfLongestSubstring(String s) {
    int result = 0;
    Set<Character> substringLetters = new HashSet<>();
    int left =0, right = 0;
    while(right < s.length()){
      if(substringLetters.add(s.charAt(right))){
        right++;
        result = Math.max(result, substringLetters.size());
      } else {
        substringLetters.remove(s.charAt(left));
        left++;
      }
    }
    return result;
  }
}
