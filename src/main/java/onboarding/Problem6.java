package onboarding;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class NameStringClassForPro6 {
    private static String[] nameString;

    public NameStringClassForPro6(List<List<String>> forms) {
        ExceptionClassForPro6 exceptionClass = new ExceptionClassForPro6(forms);
        nameString = new String[forms.size()];
        fillNameString(forms);
    }

    private static void fillNameString(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            List<String> partOfForm = forms.get(i);
            nameString[i] = partOfForm.get(1);
        }
    }

    public Set<String> mainFunc() {
        for (int i = 0; i < nameString.length; i++) {
            NameForPro6 nameI = new NameForPro6(nameString[i]);
            for (int j = i + 1; j < nameString.length; j++) {
                NameForPro6 nameJ = new NameForPro6(nameString[j]);
                prepareAnsSet(nameI, nameJ);
            }
        }
        return nameSet;
    }
}

class NameForPro6 {

    private final String name;

    public NameForPro6(String name) {
        this.name = name;
    }

    public int nameSize() {
        return name.length();
    }

    public char nameChar(int index) {
        return name.charAt(index);
    }

    public String toString() {
        return name;
    }
}

class ExceptionClassForPro6 {

    private static final int MINIMUM_MEMBER = 1;
    private static final int MAXIMUM_MEMBER = 10000;
    private static final int EMAIL_LENGTH_MIN = 11;
    private static final int EMAIL_LENGTH_MAX = 20;
    private static final int NICK_LENGTH_MIN = 1;
    private static final int NICK_LENGTH_MAX = 20;

    public ExceptionClassForPro6(List<List<String>> forms) {
        validateArguments(forms);
    }

    private void validateArguments(List<List<String>> forms) {
        validateTotalMember(forms);
        for (List<String> userProfile : forms) {
            validateEmail(userProfile.get(0));
            validateEmailLength(userProfile.get(0));
            validateNickLength(userProfile.get(1));
            validateNickKor(userProfile.get(1));
        }
    }

    private void validateTotalMember(List<List<String>> forms) {
        if (forms.size() < MINIMUM_MEMBER || MAXIMUM_MEMBER < forms.size()) {
            throw new IllegalArgumentException(
                "총 인원 수는 " + MINIMUM_MEMBER + "이상 " + MAXIMUM_MEMBER + "이하의 정수여야 합니다.");
        }
    }

    private static void validateEmail(String email) {
        Pattern p = Pattern.compile("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$");
        Matcher m = p.matcher(email);
        if (!m.matches()) {
            throw new IllegalArgumentException("이메일 형식이 올바르지 않습니다.");
        }
        if (!email.contains("@email.com")) {
            throw new IllegalArgumentException("이메일의 도메인은 반드시 @email.com이어야 합니다.");
        }
    }

    private static void validateEmailLength(String email) {
        if (email.length() < EMAIL_LENGTH_MIN || EMAIL_LENGTH_MAX <= email.length()) {
            throw new IllegalArgumentException(
                "이메일의 길이는 " + EMAIL_LENGTH_MIN + "이상 " + EMAIL_LENGTH_MAX + "미만의 정수여야 합니다.");
        }
    }

    private static void validateNickLength(String nickname) {
        if (nickname.length() < NICK_LENGTH_MIN || NICK_LENGTH_MAX <= nickname.length()) {
            throw new IllegalArgumentException(
                "닉네임의 길이는 " + NICK_LENGTH_MIN + "이상 " + NICK_LENGTH_MAX + " 미만의 정수여야 합니다.");
        }
    }

    private static void validateNickKor(String nickname) {
        if (!nickname.matches("^[가-힣]*$")) {
            throw new IllegalArgumentException("닉네임은 한글만 가능합니다.");
        }
    }
}

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        NameStringClassForPro6 nameClass = new NameStringClassForPro6(forms);
        List<String> answer = List.of("answer");
        return answer;
    }
}
