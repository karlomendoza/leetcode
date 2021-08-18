public class ReverseInteger {
  public int reverse(int x) {
    StringBuilder sb = new StringBuilder();
    if( x > 0)
      while(x > 0){
        sb.append(x%10);
        x = x/10;
      }
    else {
      sb.append("-");
      while (x < 0) {
        sb.append( Math.abs(x % 10));
        x = x / 10;
      }
    }

    try {
      return Integer.parseInt(sb.toString());
    } catch (Exception exception){
      return 0;
    }
  }
}
