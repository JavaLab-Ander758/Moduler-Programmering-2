public class PrintOutNonAlphanumerics {

    public static void main(String[] args) {
        // Prints out non-alphanumerics for the /test/Module01/PasswordTest.java from the ASCII table
        for (int i = 0, ASCII; i <= 127; i++) {
            String password = "abcdef123";
            if ((i >= 32 && i <= 47) || (i >= 58 && i <= 64) || (i >= 91 && i <= 96) || (i >= 123 && i <= 126))
                System.out.printf("%s\n", password + Character.toString((char)i));
        }
    }
}
