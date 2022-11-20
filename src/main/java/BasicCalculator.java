import java.util.Stack;

public class BasicCalculator {
  public int calculate(String s) {
    int sum = 0;
    Stack<Integer> partialSum = new Stack<>();
    int sign = 1;

    char[] characters = s.toCharArray();

    for(int i =0; i<s.length(); i++){

      if(Character.isDigit(characters[i])){
        //procesar el digito
        int val = 0;
        while(i < s.length() && Character.isDigit(characters[i])){
          val = val*10 + (characters[i]  - '0');
          i++;
        }
        i--;

        val = val*sign;
        sign = 1;
        sum += val;
      } else if(characters[i] == '('){
        //guardar suma parcial y signo
        partialSum.push(sum);
        partialSum.push(sign);
        sum = 0;
        sign = 1;
      } else if(characters[i] == ')'){
        sum *= partialSum.pop();
        sum += partialSum.pop();
      } else if(characters[i] == '-'){
        sign *=-1;
      }
    }
    return sum;
  }
}
