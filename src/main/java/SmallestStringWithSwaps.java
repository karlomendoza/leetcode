import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SmallestStringWithSwaps {

  public static void main(String[] args) {
    SmallestStringWithSwaps sm = new SmallestStringWithSwaps();

    List<List<Integer>> pairs = new ArrayList<>();

    pairs.add(Arrays.asList(0,3));
    pairs.add(Arrays.asList(1,2));

    System.out.println(sm.smallestStringWithSwaps("dcab", pairs));

    pairs.add(Arrays.asList(0,2));
    System.out.println(sm.smallestStringWithSwaps("dcab", pairs));

    System.out.println(sm.smallestStringWithSwaps("cba", pairs));

  }

  boolean[] visited;
  List<Integer>[] connections;
  char[] ans;
  public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

    ans = new char[s.length()];
    connections = new ArrayList[s.length()];
    for (int i = 0; i < s.length() ; i++) {
      connections[i] = new ArrayList();
    }
    for(List<Integer> pair : pairs ){
      int from = pair.get(0);
      int to = pair.get(1);
      connections[from].add(to);
      connections[to].add(from);
    }

    visited = new boolean[s.length()];
    for (int i = 0; i < s.length(); i++) {
      char _char = s.charAt(i);

      List<Character> connectedChars = new ArrayList<>();
      List<Integer> connectedIndex = new ArrayList<>();
      DFS(i, connections[i], connectedChars, connectedIndex, s);

      Collections.sort(connectedChars);
      Collections.sort(connectedIndex);

      for (int j = 0; j < connectedIndex.size(); j++) {
        ans[connectedIndex.get(j)] = connectedChars.get(j);
      }

    }


    return new String(ans);
  }

  private void DFS(int node, List<Integer> vortexs, List<Character> _chars, List<Integer> indexs, String s){
    if(visited[node])
      return;

    visited[node] = true;
    _chars.add(s.charAt(node));
    indexs.add(node);

    for (int vortex: vortexs) {
      DFS(vortex, connections[vortex], _chars, indexs, s);
    }
  }
}
