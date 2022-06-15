class BraceExpansion {
    public String[] expand(String s) {
        char[] chars = s.toCharArray();
        
        PriorityQueue<StringBuilder> words = new PriorityQueue();
        words.add(new StringBuilder());
        List<StringBuilder> bufferWords = null;
        
        boolean insideExpasion = false;
        boolean firstLeeterOfExpansion = false;
        
        for(Character _char: chars){
            
            if(_char == '{'){
                bufferWords = new ArrayList();
                insideExpasion = true;
                firstLeeterOfExpansion = true;
                continue;
            }
            if(_char == '}'){
                words.addAll(bufferWords);
                insideExpasion = false;
                firstLeeterOfExpansion = false;
                continue;
            }
            if(_char == ',')
                continue;
            
            if(!insideExpasion){
                for(StringBuilder word : words){
                    word.append(_char);
                }
            } else {
                if(firstLeeterOfExpansion){
                    firstLeeterOfExpansion = false;
                    for(StringBuilder word : words){
                        word.append(_char);
                    }
                } else {
                    for(StringBuilder word : words){
                        StringBuilder sb = new StringBuilder(word);
                        sb.deleteCharAt(sb.length()-1);
                        sb.append(_char);
                        bufferWords.add(sb);
                    }
                }
            }
            //a,b,c,{d,a},f"
        }
        String[] ans = new String[words.size()];
        int i = 0;
        while(!words.isEmpty()){
            ans[i] = words.poll().toString();
            i++;
        }
        return ans;
    }
}
