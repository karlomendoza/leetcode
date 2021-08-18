public class PowerOfFour {
  public boolean isPowerOfFour(int num) {
    if(num == 1)
      return true;
    if(num == 0)
      return false;

    if (num%4 == 0){
      return isPowerOfFour(num/4);
    }
    return false;
  }
}
