public class VerifyingAnAlienDictionary {

/*
  This solution consist of 2 steps.
  Step 1: Is to map the alien language letters in a way we can access it quickly and know
  what order a given letter have.
  To do that, we store each letter in an array, where each index corresponds to the letter
  and the value of the index is it's position.
  ex. order = "cba". our array would be:
   a,b,c
  [3,2,1]

  That means, if we want to know the position letter a has in the order ge do abc['a' - 'a']
  and that gives us 3. Since 'a' is the third letter in the example order.

  Step 2: Any word not in order makes the entire thing not in order.
  We can compare i word with the i+1 word and do that for all i in words.

  3 Scenarios can happen when comparing word to word.

    1: The character of wordi is less than wordi+1. That means they are in proper lexicographical order.
      We can move to the next word.
    2: The character of wordi is bigger than wordi+1. That means they are in incorrect order.
      We can return false and it's done.
    3: The characters of wordi and wordi+1 are equal. Then we need to iterate over the next character.
      If both are equal, and we have compared all the characters of one of the words.
      ex. "app","apple"
      2 Things can happen:
        3.1: The words have the same length, and therefore are equal and are in proper order.
        3.2: The words have different length, if the first word has bigger length then it's not
        properly order.
 */
  public boolean isAlienSorted(String[] words, String order) {

    int[] abc = new int[26];
    for(int i=0; i<order.length(); i++){
      abc[order.charAt(i) - 'a'] = i;
    }

    for(int i=0; i<words.length-1;i++){
      String word1 = words[i];
      String word2 = words[i+1];
      for(int j =0; j < Math.min(word1.length(),word2.length()); j++){
        if(abc[word1.charAt(j)-'a'] < abc[word2.charAt(j)-'a']){
          break;
        } else if (abc[word1.charAt(j)-'a'] > abc[word2.charAt(j)-'a']){
          return false;
        } else{
          if( j == Math.min(word1.length(),word2.length()) -1){
            if(word1.length() > word2.length())
              return false;
          }
          continue;
        }
      }
    }
    return true;
  }
}
