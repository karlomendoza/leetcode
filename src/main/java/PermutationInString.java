public class PermutationInString {
  public boolean checkInclusion(String s1, String s2) {
    int[] histogram = new int[27];
    int[] histogramTmp = new int[27];

    for(int i = 0; i< s1.length(); i ++){
      histogram[s1.charAt(i) - 'a']++;
    }

    for(int i = 0; i< s2.length(); i ++){
      if(histogram[s2.charAt(i) - 'a'] > 0){
        int j = i;
        while(j<s2.length() && histogram[s2.charAt(j) - 'a'] > 0){
          histogram[s2.charAt(j) - 'a']--;
          histogramTmp[s2.charAt(j) - 'a']++;
          j++;
        }

        boolean usedAllChars = true;
        for (int k = 0; k <histogram.length ; k++) {
          if(histogram[k] > 0) {
            usedAllChars = false;
            break;
          }
        }
        if( usedAllChars)
          return true;
        for (int k = 0; k <histogram.length ; k++) {
          histogram[k] += histogramTmp[k];
          histogramTmp[k] = 0;
        }
      }
    }
    return false;
  }
}
