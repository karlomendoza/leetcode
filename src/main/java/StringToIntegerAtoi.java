public class StringToIntegerAtoi {
  public int myAtoi(String s) {
    int result= 0;

    s = s.trim();
    if(s.length() == 0)
      return 0;
    StringBuilder sb = new StringBuilder();

    int i = 0;
    if (s.charAt(0) == '-'){
      sb.append( '-');
      i++;
    } else if (s.charAt(0) == '+'){
      sb.append( '+');
      i++;
    }

    while(i < s.length() && (s.charAt(i) >= ('0') && s.charAt(i) <= ('9'))){
      sb.append(s.charAt(i));
      i++;
    }

    try {
      return Integer.parseInt(sb.toString());
    } catch (Exception ex){
      if(sb.length() <= 1)
        return 0;
      if(sb.substring(0,1).equals("-"))
        return Integer.MIN_VALUE;
      else if(sb.substring(0,1).equals("+") || (s.charAt(0) >= '0' && s.charAt(0) <= '9') )
        return Integer.MAX_VALUE;
    }
    return result;
  }
}
