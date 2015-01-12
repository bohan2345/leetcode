package code;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> S = new Stack<>();
        String[] pathArray = path.split("/");
        for (int i = 0; i < pathArray.length; i++) {
            if (!S.isEmpty() && pathArray[i].equals(".."))
                S.pop();
            else if (pathArray[i].length() == 0 || pathArray[i].equals(".") || pathArray[i].equals(".."))
                continue;
            else
                S.push(pathArray[i]);
        }
        StringBuilder sb = new StringBuilder();
        while (!S.isEmpty()) {
            sb.insert(0, S.pop()).insert(0, "/");
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
