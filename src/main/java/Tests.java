public class Tests {


  public static void rotateMatrix(int[][] mat){

    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length ; j++) {

      }
    }
  }

  public static String complexNumberMultiply(String num1, String num2) {
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


    return realSum + (imgSum+"i");
  }

  public static void main(String[] args){

    System.out.println(complexNumberMultiply("1+1i","1+i1"));

//    int[][] r = new int[][]{new int[]{1,2,3},new int[]{4,5,6}, new int[]{7,8,9}};
//    rotateMatrix(r);
  }
}
