package Del_01;

public class HashForString {
    /**
     * Calculates the hashcode for a given String using 'Polynomial Hash Code'
     *
     * @param s String to calculate hash for
     * @return The hash value calculated from the String parameter
     */
    public static long hashCodeForString(String s) {
        long hash = 0;
        for (char i : s.toCharArray())
            hash = hash * 31 + i;
        return hash;
    }
}
