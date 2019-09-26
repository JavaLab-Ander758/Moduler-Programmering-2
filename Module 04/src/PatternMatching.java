/*
Skriv et program som får inn to strenger fra bruker,  str og pattern,  og som sjekker ut om pattern finnes inni str,
dersom den finnes så skal program returnere indeks for første tegn av pattern inni str, ellers skal den returnere -1.
*/
class PatternMatching {


    /**
     * Finds a pattern in a given string
     *
     * @param str The string to search in
     * @param pattern The pattern to search for in str
     * @return The index of first char of pattern, if not found: -1
     */
     int findPatternInString(String str, String pattern) {
        int index = -1;
        for (int i = 0, k = 0; i < str.length(); i++) {
            if (str.charAt(i) == pattern.charAt(k)) {
                k++;
                if (k == pattern.length()) {
                    index = i - k + 1; // +1 because zero-indexing
                    break;
                }
            } else {
                k = 0;
                if (str.charAt(i) == pattern.charAt(k))
                    k++;
            }
        }
        return index;
    }
}