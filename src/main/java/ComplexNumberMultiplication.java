public class ComplexNumberMultiplication {
  /*
  Simple problem, just parse the numbers into integers.
  add the real values and the imaginary ones.
   */
  public String complexNumberMultiply(String num1, String num2) {
    int real1 = 0;
    int real2 = 0;
    int img1 = 0;
    int img2 = 0;

    String[] splitNum1 = num1.split("\\+");
    real1 = Integer.valueOf(splitNum1[0]);
    img1 = Integer.valueOf(splitNum1[1].replace("i",""));

    String[] splitNum2 = num2.split("\\+");
    real2 = Integer.valueOf(splitNum2[0]);
    img2 = Integer.valueOf(splitNum2[1].replace("i",""));

    int realSum = real1*real2 - img1*img2;
    int imgSum = real1*img2 + real2*img1;

    return realSum + "+" + (imgSum+"i");
  }
}
