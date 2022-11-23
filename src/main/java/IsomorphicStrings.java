import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> mapa = new HashMap<>();

        char[] ese = s.toCharArray();
        char[] te = t.toCharArray();

        for(int i = 0 ; i < s.length(); i++){
            if(mapa.containsKey(ese[i])){
                if( mapa.get(ese[i])  != te[i])
                    return false;
            } else {
                mapa.put(ese[i],te[i]);
            }
        }

        mapa.clear();
        for(int i = 0 ; i< s.length(); i++){
            if(mapa.containsKey(te[i])){
                if( mapa.get(te[i])  != ese[i])
                    return false;
            } else {
                mapa.put(te[i],ese[i]);
            }
        }
        return true;
    }
}
