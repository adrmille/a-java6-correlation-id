package fr.amille.correlationid;

import java.util.Random;

public class CorrelationIdBase62Size11 implements CorrelationIdBuilder {

  private static final Random RANDOM = new Random();

  @Override
  public String build() {
    return Base62Encoder.encodeFromBase10(Math.abs(RANDOM.nextLong()));
  }
}
