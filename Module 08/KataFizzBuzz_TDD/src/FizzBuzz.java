class FizzBuzz {

    /**
     * Returns "Fizz", "Buzz" or "FizzBuzz" if number is dividable by 3, 5, or both 3 and 5
     * @param number Number to check
     * @return String to specify which case number is dividable for. Returns number as String if no result
     */
    static String of(int number) {
        if (number < 0) {
            return "Input must be 0 or higher!";
        }
        if (number == 0) {
            return "0";
        }

        String output = "";
        if (number % 3 == 0)
            output += "Fizz";
        if (number % 5 == 0)
            output += "Buzz";

        return output.isEmpty() ? Integer.toString(number) : output;
    }
}
