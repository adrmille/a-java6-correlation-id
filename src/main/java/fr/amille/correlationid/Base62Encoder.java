package fr.amille.correlationid;

import java.math.BigInteger;

class Base62Encoder {

  private static final BigInteger BASE = BigInteger.valueOf(62);
  private static final String DIGITS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

  private Base62Encoder() {
  }

  static String encodeFromBase10(Long number) {
    return encodeFromBase10(BigInteger.valueOf(number));
  }

  // From https://github.com/Devskiller/friendly-id
  static String encodeFromBase10(BigInteger number) {
    if (number.compareTo(BigInteger.ZERO) < 0) {
      throw new IllegalArgumentException("number must not be negative");
    }
    StringBuilder result = new StringBuilder();
    while (number.compareTo(BigInteger.ZERO) > 0) {
      BigInteger[] divmod = number.divideAndRemainder(BASE);
      number = divmod[0];
      int digit = divmod[1].intValue();
      result.insert(0, DIGITS.charAt(digit));
    }
    return (result.length() == 0) ? DIGITS.substring(0, 1) : result.toString();
  }

}
