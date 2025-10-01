package cote.study.stackQ05;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    private static final char PARENTHESIS_OPEN = '(';
    private static final char PARENTHESIS_CLOSE = ')';
    private static final char BRACE_OPEN = '{';
    private static final char BRACE_CLOSE = '}';
    private static final char BRACKET_OPEN = '[';
    private static final char BRACKET_CLOSE = ']';

    private record TokenInfo(char token, int index){}

    public int solution(String logs) {
        Deque<TokenInfo> stack = new ArrayDeque<>();
        int result = -1;

        for (int i = 0; i < logs.length(); i++) {
            char token = logs.charAt(i);

            switch (token) {
                case PARENTHESIS_OPEN:
                    stack.offerLast(new TokenInfo(PARENTHESIS_OPEN, i));
                    break;
                case PARENTHESIS_CLOSE:
                    result = checkMatchingToken(stack, i, PARENTHESIS_OPEN);
                    break;
                case BRACE_OPEN:
                    stack.offerLast(new TokenInfo(BRACE_OPEN, i));
                    break;
                case BRACE_CLOSE:
                    result = checkMatchingToken(stack, i, BRACE_OPEN);
                    break;
                case BRACKET_OPEN:
                    stack.offerLast(new TokenInfo(BRACKET_OPEN, i));
                    break;
                case BRACKET_CLOSE:
                    result = checkMatchingToken(stack, i, BRACKET_OPEN);
                    break;
                default:
                    break;
            }

            if (result != -1) {
                return result;
            }
        }

        if(stack.isEmpty()) {
            return -1;
        }

        return stack.pollFirst().index();
    }

    private int checkMatchingToken(Deque<TokenInfo> stack, int i, char token) {
        if (stack.isEmpty()) {
            return i;
        }

        if (token != stack.peekLast().token()) {
            return i;
        }

        stack.pollLast();
        
        return -1;
    }
}
