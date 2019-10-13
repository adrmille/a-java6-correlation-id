package fr.amille.correlationid;

import java.math.BigInteger;

public class BigIntegerPairing {

  private static final BigInteger HALF = BigInteger.ONE.shiftLeft(64); // 2^64
  private static final BigInteger MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);

  private static BigInteger toUnsigned(BigInteger value) {
    return value.signum() < 0 ? value.add(HALF) : value;
  }

  private static BigInteger toSigned(BigInteger value) {
    return MAX_LONG.compareTo(value) < 0 ? value.subtract(HALF) : value;
  }

  static BigInteger pair(BigInteger hi, BigInteger lo) {
    BigInteger unsignedLo = toUnsigned(lo);
    BigInteger unsignedHi = toUnsigned(hi);
    return unsignedLo.add(unsignedHi.multiply(HALF));
  }

  static BigInteger[] unpair(BigInteger value) {
    BigInteger[] parts = value.divideAndRemainder(HALF);
    BigInteger signedHi = toSigned(parts[0]);
    BigInteger signedLo = toSigned(parts[1]);
    return new BigInteger[]{signedHi, signedLo};
  }

}
