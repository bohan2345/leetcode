package code;

import java.util.Stack;

public class SimplifyPath {
	public String simplifyPath(String path) {
		if (path == null || path.length() == 0)
            return "";
        Stack<String> S = new Stack<>();
        String[] sub = path.split("/");
        String res = "";
        for (int i = 0; i < sub.length; i++) {
            if (sub[i].equals(".") || sub[i].equals("")){
            } else if (sub[i].equals("..")) {
                if (!S.isEmpty())
                    S.pop();
            } else {
                S.push(sub[i]);
            }
        }
        while (!S.isEmpty()) {
            res = "/" + S.pop() + res;
        }
        if (res.equals(""))
            res = "/";
        return res;
    }
}
