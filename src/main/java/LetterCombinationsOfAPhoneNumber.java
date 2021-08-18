import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
  static List<String> result = null;
  public static List<String> letterCombinations(String digits) {
    if(digits.length() == 0)
      return new ArrayList<>();;

    result = new ArrayList<>();
    generate(digits, "");
    return  result;

  }

  public static String generate( String digits, String letters){

    if(digits.length() == 0) {
      result.add( letters);
      return "";
    }

    Character digit = digits.charAt(0);
    switch(digit){
      case '2':
        generate(digits.substring(1), letters + "a");
        generate(digits.substring(1), letters + "b");
        generate(digits.substring(1), letters + "c");
        break;
      case '3':
        generate(digits.substring(1), letters + "d");
        generate(digits.substring(1), letters + "e");
        generate(digits.substring(1), letters + "f");
        break;
      case '4':
        generate(digits.substring(1), letters + "g");
        generate(digits.substring(1), letters + "h");
        generate(digits.substring(1), letters + "i");
        break;
      case '5':
        generate(digits.substring(1), letters + "j");
        generate(digits.substring(1), letters + "k");
        generate(digits.substring(1), letters + "l");
        break;
      case '6':
        generate(digits.substring(1), letters + "m");
        generate(digits.substring(1), letters + "n");
        generate(digits.substring(1), letters + "o");
        break;
      case '7':
        generate(digits.substring(1), letters + "p");
        generate(digits.substring(1), letters + "q");
        generate(digits.substring(1), letters + "r");
        generate(digits.substring(1), letters + "s");
        break;
      case '8':
        generate(digits.substring(1), letters + "t");
        generate(digits.substring(1), letters + "u");
        generate(digits.substring(1), letters + "v");
        break;
      case '9':
        generate(digits.substring(1), letters + "w");
        generate(digits.substring(1), letters + "x");
        generate(digits.substring(1), letters + "y");
        generate(digits.substring(1), letters + "z");
        break;
    }
    return "";
  }
}
