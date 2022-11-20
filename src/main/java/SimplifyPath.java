import java.util.Stack;

class SimplifyPath {
    public String simplifyPath(String path) {
        
        Stack<String> stack = new Stack();
        String[] directorios = path.split("/");
        
        for(String dir : directorios){
            if(".".equals(dir) || dir.isBlank()){
                continue;
            }
            if("..".equals(dir)){
                if(!stack.isEmpty())
                    stack.pop();
            } else {
                stack.add(dir);
            }
        }
        StringBuilder ans = new StringBuilder();
        for(String dir : stack){
            ans.append("/");
            ans.append(dir);
        }
        return ans.length() > 0 ? ans.toString() : "/";
        
    }
}
