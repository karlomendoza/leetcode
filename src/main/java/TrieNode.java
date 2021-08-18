import java.util.Map;

public class TrieNode {
  Integer val;
  Map<Character,TrieNode> mapa;
  TrieNode(Map<Character,TrieNode> mapa) {
    this.mapa = mapa;
  }
}