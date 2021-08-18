import java.util.Arrays;

public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    Arrays.stream(strs).sorted();
    String min = strs[0];
    for (int i = 0; i < strs.length-1; i++) {
      StringBuilder result = new StringBuilder();
      for (int j = 0; j <Math.min(strs[i].length(),strs[i+1].length()) ; j++) {

        if(j >= min.length())
          break;

        if(strs[i].charAt(j) == strs[i+1].charAt(j) && min.charAt(j) == strs[i+1].charAt(j)){
          result.append(strs[i].charAt(j));
        } else {
          break;
        }
      }
      if(min == null) {
        min = result.toString();
      }
      min = min.length() > result.length() ? result.toString() : min;
    }
    return min;
  }
}
