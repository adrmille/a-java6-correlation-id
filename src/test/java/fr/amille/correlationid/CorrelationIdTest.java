package fr.amille.correlationid;

import fr.amille.correlationid.CorrelationId;
import org.junit.Assert;
import org.junit.Test;

public class CorrelationIdTest {

  @Test
  public void shouldReturnValidBase62CorrelationId() {
    // WHEN
    final String result = CorrelationId.randomCorrelationId();

    // THEN
    Assert.assertTrue(result != null && result.length() > 0 && result.length() <= 11);
  }

}
