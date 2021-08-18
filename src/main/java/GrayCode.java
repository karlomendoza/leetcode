import java.util.ArrayList;
import java.util.List;

public class GrayCode {
  public List<Integer> grayCode(int n) {
    List<Integer> answer = new ArrayList<>();
    answer.add(0);
    if(n == 0)
      return answer;
    answer.add(1);
    if(n == 1)
      return answer;

    int loops = 1;
    while(loops < n){
      List<Integer> toAdd = new ArrayList<>();
      int power = ((Double) Math.pow(2, loops)).intValue();
      for (int i = answer.size() -1; i >= 0 ; i--) {
        toAdd.add( answer.get(i) + power);
      }
      answer.addAll(toAdd);
      loops++;
    }
    return answer;
  }
}
