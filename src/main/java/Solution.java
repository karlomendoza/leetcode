import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();

    Trie trie = new Trie();

    trie.add("perro", 3);
    trie.add("perro1",2);
    trie.add("perro2",1);
    trie.add("perro3", 1);
    trie.add("perro4", 12);
    trie.add("perro5", 30);
    trie.add("gato", 55);
    trie.add("gaita", 54);

    List<Word> gai = trie.findAllWords("per");


    Collections.sort(gai);

    System.out.println(gai);

  }
}

class Word implements Comparable<Word>{
  String word;
  int rank;

  public Word(String word, int rank) {
    this.word = word;
    this.rank = rank;
  }

  @Override
  public String toString() {
    return "Word{" +
        "word='" + word + '\'' +
        ", rank=" + rank +
        '}';
  }

  @Override
  public int compareTo(Word o) {
    return Integer.compare(this.rank, o.rank);
  }
}

class Trie {
  TrieNode2 root;

  public Trie(){
    root = new TrieNode2();
  }

  public void add(String word, int rank){
    TrieNode2 pointer = root;
    for (Character _char: word.toCharArray()) {
      if(!pointer.childs.containsKey(_char)){
        pointer.childs.put(_char, new TrieNode2());
      }
      pointer = pointer.childs.get(_char);
    }
    pointer.isLeaf = true;
    pointer.rank = rank;
  }

  public List<Word> findAllWords(String prefix){
    TrieNode2 pointer = root;
    List<Word> words = new ArrayList<>();

    for (Character _char: prefix.toCharArray()) {
      if(!pointer.childs.containsKey(_char)){
        return words;
      } else{
        pointer = pointer.childs.get(_char);
      }
    }

    dfs(words, prefix, pointer);
    return words;
  }

  private void dfs(List<Word> words, String prefix, TrieNode2 pointer){
    if(pointer.isLeaf){
      words.add(new Word(prefix, pointer.rank));
    }
    for (Character _char : pointer.childs.keySet()) {
      dfs(words, prefix + _char, pointer.childs.get(_char));
    }
  }
}
class TrieNode2{
  Map<Character, TrieNode2> childs;
  boolean isLeaf;
  int rank;

  public TrieNode2(){
    childs = new HashMap<>();
    isLeaf = false;
  }
}
