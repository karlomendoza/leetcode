public class ZeroOneMatrix {
  public int[][] updateMatrix(int[][] mat) {
    int n = mat.length;
    int m = mat[0].length;

    int[][] ans = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if(mat[i][j] == 0)
          ans[i][j] = 0;
        else
          ans[i][j] = Integer.MAX_VALUE -1000;
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m ; j++) {
        if( ans[i][j] != 0){
          int a = ans[i][j];
          a = i -1 >= 0 && ans[i-1][j] +1 < a ?  ans[i-1][j] +1 : a;
          a = j -1 >= 0 && ans[i][j-1] +1 < a ?  ans[i][j-1] +1 : a;
          ans[i][j] = a;
        }
      }
    }

    for (int i = n-1; i >= 0; i--) {
      for (int j = m-1; j >= 0 ; j--) {
        if( ans[i][j] != 0){
          int a = ans[i][j];
          a = i +1 < n && ans[i+1][j] +1 < a ?  ans[i+1][j] +1 : a;
          a = j +1 < m && ans[i][j+1] +1 < a ?  ans[i][j+1] +1 : a;
          ans[i][j] = a;
        }
      }
    }
    return ans;
  }
}
