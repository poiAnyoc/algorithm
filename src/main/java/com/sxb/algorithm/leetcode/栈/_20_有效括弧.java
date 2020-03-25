package com.sxb.algorithm.leetcode.栈;

import java.util.HashMap;
import java.util.Stack;

/**
 * @desc:
 * @author: poi
 * @date: 2020/3/24 23:52
 * @version: v1.0
 */
public class _20_有效括弧 {
    private HashMap<Character, Character> map = new HashMap<Character, Character>(){{
        put('(', ')');
        put('[', ']');
        put('{', '}');
    }};

    /**
     * 使用map来优化代码
     * @param s
     * @return
     */
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0, len = s.length(); i < len; i++) {
            char c = s.charAt(i);

//            if(c == '(' || c == '{' || c == '['){}
            if(map.containsKey(c)){
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                }

                Character peek = stack.pop();
                if(c != map.get(peek)){
                    return false;
                }
//                if(peek == '(' || c != ')'){
//                    return false;
//                }
//                if(peek == '[' || c != ']'){
//                    return false;
//                }
//                if(peek == '{' || c != '}'){
//                    return false;
//                }
            }
        }

        return stack.isEmpty();
    }

    /**
     * ()[]{}
     * ([{}])
     * @param s
     * @return
     */
    public boolean isValid2(String s){
        while (s.contains("{}") || s.contains("()") || s.contains("[]")){
            s = s.replace("{}", "");
            s = s.replace("()", "");
            s = s.replace("[]", "");
        }

        return s.isEmpty();
    }
}
