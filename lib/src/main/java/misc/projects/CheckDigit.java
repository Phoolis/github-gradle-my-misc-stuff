package misc.projects;

/**
     * Generate a check digit to given number code (string).
     *
     * The check digit is an additional digit, used to verify that a barcode has been scanned correctly. 
     * It is computed modulo 10, where the weights in the checksum calculation alternate 3 and 1. In particular, 
     * since the weights are relatively prime to 10, the EAN-13 system will detect all single digit errors. It 
     * also recognizes 90% of transposition errors (all cases, where the difference between adjacent digits is not 5). 
     * (from Wikipedia: https://en.wikipedia.org/wiki/International_Article_Number)
     *
     * @param code the price to number code, as a string
     * @return the number code suffixed with the check digit as a string
     */

public class CheckDigit {

    public String addCheckDigit(String code) {
        return "";
    }

}
