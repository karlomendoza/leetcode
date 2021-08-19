public class CheckIfOneStringSwapCanMakeStringsEqual {
  public boolean areAlmostEqual(String s1, String s2) {
    if(s1.equals(s2))
      return true;
    int index1 = -1;
    char charAtInd = 'a';
    for (int i=0; i < s1.length(); i++){

      if(s1.charAt(i) != s2.charAt(i)){
        if(index1 < 0){
          index1 = i;
          charAtInd = s1.charAt(i);
        }
        else {
          StringBuilder sb = new StringBuilder();
          sb.append(s1.substring(0,index1)).append(s1.charAt(i)).append(s1.substring(index1+1,i)).append(charAtInd).append(s1.substring(i+1));
          System.out.println(sb.toString());
          if(sb.toString().equals(s2))
            return true;
          else
            return false;
        }
      }

    }
    return false;
  }
}
