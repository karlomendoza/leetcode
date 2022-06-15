import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {

  public static void main(String[] args) {

    int[][] a = new int[][]{new int[]{-145,-111,69,-3,185,83,581,-283},
    new int[]{497,125,500,72,-356,-448,422,-393},
    new int[]{-562,-3,51,336,-591,-918,290,507},
    new int[]{562,-912,407,-862,178,270,633,-836},
        new int[]{-275,-663,-578,-857,859,-2,58,885},
    new int[]{553,836,-605,193,-319,238,-156,-587},
    new int[]{723,481,-454,275,-683,-937,-934,-400}};

    System.out.println(shiftGrid(a,57));

  }
  public static List<List<Integer>> shiftGrid(int[][] grid, int k) {


    if(k > grid.length*grid[0].length)
      k = k%(grid.length*grid[0].length);

    List<Integer> flatGrid = new ArrayList();
    for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[0].length; j++){
        flatGrid.add(grid[i][j]);
      }
    }

    int n = grid[0].length;
    List<List<Integer>> ans = new ArrayList();
    List<Integer> row = new ArrayList();

    for(int i = flatGrid.size()-k; i < flatGrid.size(); i++){
      row.add(flatGrid.get(i));
      if(row.size() == n){
        ans.add(row);
        row = new ArrayList();
      }
    }
    for(int i = 0; i < flatGrid.size()-k; i++){
      row.add(flatGrid.get(i));
      if(row.size() == n){
        ans.add(row);
        row = new ArrayList();
      }
    }
    return ans;
  }

}
//11,11,11