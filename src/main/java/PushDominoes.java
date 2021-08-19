import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PushDominoes {
  public String pushDominoes(String dominoes) {
    char[] answer = dominoes.toCharArray();
    Set<Integer> left = null;
    Set<Integer> right = null;
    while(true){

      left = new HashSet<>();
      right = new HashSet<>();

      for (int i = 0; i <answer.length ; i++) {
        if(answer[i] == 'L'){
          if(i-1 >= 0 && answer[i-1] == '.')
            left.add(i-1);
        } else if (answer[i] == 'R'){
          if(i+1 < answer.length && answer[i+1] == '.')
            right.add(i+1);
        }
      }

      Iterator<Integer> iterator = left.iterator();
      Set<Integer> removed = new HashSet<>();
      while (iterator.hasNext()){
        Integer next = iterator.next();
        if(right.contains(next)) {
          right.remove(next);
          removed.add(next);
        }
      }

      Iterator<Integer> rIterator = removed.iterator();
      while (rIterator.hasNext()){
        Integer next = rIterator.next();
        if(left.contains(next)) {
          left.remove(next);
        }
      }


      if(left.isEmpty() && right.isEmpty())
        break;

      Iterator<Integer> lIterator = left.iterator();
      while (lIterator.hasNext()){
        Integer next = lIterator.next();
        answer[next] = 'L';
      }
      Iterator<Integer> r2Iterator = right.iterator();
      while (r2Iterator.hasNext()){
        Integer next = r2Iterator.next();
        answer[next] = 'R';
      }
    }
    String s = answer.toString();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i <answer.length ; i++) {
      sb.append(answer[i]);
    }

    return sb.toString();
  }
}
