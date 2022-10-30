package onboarding;

import java.util.Stack;

class StackForPro2 {
    private static final int MINIMUM_LENGTH = 1;
    private static final int MAXIMUM_LENGTH = 1000;

    public StackForPro2(String cryptogram) {
        validateCrypto(cryptogram);
    }

    public Stack<Character> pushAndPop(Stack<Character> stack, String cryptogram) {
        char[] array = cryptogram.toCharArray();
        char tmp = array[0];
        stack.push(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (array[i] == tmp) {
                continue;
            }
            if (stack.peek() == array[i]) {
                tmp = stack.pop();
            } else if (stack.peek() != array[i]) {
                stack.push(array[i]);
            }
        }
        return stack;
    }

    private void validateCrypto(String crypto) {
        validateLength(crypto);
        validateSmallAlpha(crypto);
    }

    private void validateLength(String crypto) {
        if (crypto.length() < 1 || crypto.length() > 1000) {
            throw new IllegalArgumentException(
                "입력한 cryptogram의 길이는 " + MINIMUM_LENGTH + "이상 " + MAXIMUM_LENGTH + "이하여야 합니다.");
        }
    }

    private void validateSmallAlpha(String crypto) {
        if (!crypto.matches("^[a-z]*$")) {
            throw new IllegalArgumentException("cryptogram은 알파벳 소문자로만 입력해야 합니다.");
        }
    }
}

public class Problem2 {
    public static String solution(String cryptogram) {
        StackForPro2 material = new StackForPro2(cryptogram);
        String answer = "answer";
        return answer;
    }
}
