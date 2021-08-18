import java.util.HashMap;
import java.util.Stack;

public class MapSumPairs {

  class MapSum {
    TrieNode pointer;
    TrieNode head;
    /** Initialize your data structure here. */
    public MapSum() {
      pointer = new TrieNode(new HashMap<>());
      head = pointer;
    }

    public void insert(String key, int val) {
      pointer = head;
      for (Character c: key.toCharArray()) {
        if (!pointer.mapa.containsKey(c)) {
          pointer.mapa.put(c, new TrieNode(new HashMap<>()));
        }
        pointer = pointer.mapa.get(c);
      }
      pointer.val = val;
    }

    public int sum(String prefix) {
      pointer = head;
      int sum = 0;
      for (Character c: prefix.toCharArray()) {
        if(!pointer.mapa.containsKey(c)) {
          return 0;
        }
        pointer = pointer.mapa.get(c);
      }

      Stack<TrieNode> queue = new Stack<>();
      queue.add(pointer);
      while(queue.size() > 0){
        pointer = queue.pop();

        if(pointer.val != null)
          sum+=pointer.val;

        queue.addAll(pointer.mapa.values());
      }
      return sum;
    }
  }
}
