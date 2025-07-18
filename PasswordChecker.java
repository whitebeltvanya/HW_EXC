public class PasswordChecker {
    public final static int INIT_LENGHT = -1;
    public final static int INIT_REPEAT = -1;

    private int minLength = INIT_LENGHT;
    private int maxRepeat = INIT_REPEAT;

    public void setSetMinLength(int minLength) {
        if (minLength < 0) {
            throw new IllegalArgumentException("Неверная длина");
        }

        this.minLength = minLength;
    }

    public void setSetMaxRepeat(int maxRepeat) {
        if (maxRepeat <= 0) {
            throw new IllegalArgumentException("Неверное кол-во повторений");
        }
        this.maxRepeat = maxRepeat;
    }

    public boolean verify(String password) {
        if (minLength == INIT_LENGHT || maxRepeat == INIT_REPEAT) {
            throw new IllegalStateException("Не настроен");
        }

        if (password.length() < minLength) {
            return false;
        }

        int counter = 0;
        char prevLetter = password.charAt(0);
        for (char letter : password.toCharArray()) {
            if (letter == prevLetter) {
                counter++;
            } else {
                counter = 1;
            }

            if (counter > maxRepeat) {
                return false;
            }

            prevLetter = letter;
        }

        return true;
    }

}
