# github-gradle-my-misc-stuff
My first gradle build with miscellaneous coding projects.
## CheckDigit
Calculates and returns the check digit for a given barcode (number string).
Currently only returns EAN-13 standard check digit, used to verify that a barcode has been scanned correctly. It is computed modulo 10, where the weights in the checksum calculation alternate 3 and 1, based on digit position in the barcode.
