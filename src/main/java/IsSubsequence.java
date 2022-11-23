public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length())
            return false;

        if(s.length() == 0)
            return true;

        char[] small = s.toCharArray();
        char[] big = t.toCharArray();

        int j = 0;
        for(int i = 0; i < t.length(); i++){
            if( big[i] == small[j]){
                j++;
                if(j == small.length){
                    return true;
                }
            }
        }
        return false;
    }
}
