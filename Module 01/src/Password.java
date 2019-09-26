public class Password {
    private String password;
    private final int MAX_PASSWORD_LENGTH = 10;


    public boolean checkPassword(String password) {
         return checkPasswordLength(password) && checkPasswordForAlphanumerics(password) && checkPasswordForDigitCount(password);
    }
    private boolean checkPasswordLength(String password) {
        return password.length() >= MAX_PASSWORD_LENGTH;
    }
    private boolean checkPasswordForAlphanumerics(String password) {
        return password.matches("[a-zA-Z0-9]*$");
    }
    private boolean checkPasswordForDigitCount(String password) {
        return password.matches("(?:\\D*\\d){3,}.*");
    }
}