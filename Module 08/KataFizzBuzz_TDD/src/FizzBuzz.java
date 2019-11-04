class FizzBuzz {

    /**
     * Returns specific String regarding number being dividable by 3, 5 or (3 AND 5)
     * @param number Number to check for
     * @return String to specify which case number is dividable for. Returns number as a String if no result.
     */
    String of(int number) {
        if (number < 0)
            throw new IllegalArgumentException(String.format("%s received as input, only numbers >= 0 is allowed!", number));

        if (number % 3 == 0 && number % 5 == 0)
            return "fizzbuzz";
        else if (number % 3 == 0)
            return "fizz";
        else if (number % 5 == 0)
            return "buzz";
        else
            return Integer.toString(number);
    }
}
