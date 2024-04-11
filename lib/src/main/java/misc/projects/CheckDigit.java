package misc.projects;

/**
     * Generate a EAN-13 check digit to given number code. 
     *
     * "The check digit is an additional digit, used to verify that a barcode has been scanned correctly. 
     * It is computed modulo 10, where the weights in the checksum calculation alternate 3 and 1. In particular, 
     * since the weights are relatively prime to 10, the EAN-13 system will detect all single digit errors. It 
     * also recognizes 90% of transposition errors (all cases, where the difference between adjacent digits is not 5)."
     * [Wikipedia EAN-13: https://en.wikipedia.org/wiki/International_Article_Number]
     *
     * @param code the number code as string
     * @return the number code suffixed with the check digit as string
     */

public class CheckDigit {

    public String calculateCheckDigit(String code) {
        
        // Calculates the check digit for given number code.
        // Digits are numbered from right to left, starting with index 1.
        // Odd indexed digits are tripled and added to the sum,.
        // Even indexed digits are added to the sum.
        // Modulo 10 of the sum is the check digit.
        // The checksum digit is the digit which must be added to this checksum 
        // to get a number divisible by 10 (i.e. the additive inverse of the checksum, modulo 10)

        char[] charArray = code.toCharArray();
        char[] reversed = new char[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            reversed[charArray.length -i -1] = charArray[i];
        }

        int sum = 0;
        for (int i =0; i < reversed.length; i++) {
            if ((i+1) % 2 == 0) {
                sum += Character.getNumericValue(reversed[i]);
            }
            else {
                sum += 3 * Character.getNumericValue(reversed[i]);
            }
        }
        int checkDigit;
        if (sum % 10 == 0) {
            checkDigit = 0;
        } 
        else {
            checkDigit = 10 - sum % 10;
        }
        return Integer.toString(checkDigit);
    }

    public String appendCheckDigit(String code) {
        String barcode = code;
        String checkDigit = calculateCheckDigit(barcode);
        barcode += checkDigit; 
        return barcode;
    }

}
