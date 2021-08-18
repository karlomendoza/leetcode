public class AddStrings {
  public String addStrings(String num1, String num2) {
    int i = num1.length()-1;
    int j = num2.length()-1;
    int k = 1;

    Integer add1 = 0;
    StringBuilder sb = new StringBuilder(Math.max(num1.length(),num2.length()));

    while(i >= 0 && j >= 0) {
      int i1 = Integer.valueOf(num1.charAt(i)) - '0' + Integer.valueOf(num2.charAt(j)) - '0';
      i1 = i1 + add1;
      add1 = 0;
      if(i1 >= 10) {
        i1 -= 10;
        add1 = 1;
      }
      sb.insert(0,i1);
      k*=10;i--;j--;
    }

    while(i>=0){
      int i1 = Integer.valueOf(num1.charAt(i)) - '0';
      i1 = i1 + add1;
      add1 = 0;
      if(i1 >= 10) {
        i1 -= 10;
        add1 = 1;
      }
      sb.insert(0,i1);
      k*=10;i--;
    }

    while(j>=0){
      int i1 = Integer.valueOf(num2.charAt(j)) - '0';
      i1 = i1 + add1;
      add1 = 0;
      if(i1 >= 10) {
        i1 -= 10;
        add1 = 1;
      }
      sb.insert(0,i1);
      k*=10;j--;
    }

    if(add1 == 1)
      sb.insert(0,1);

    return sb.toString();
  }
}
