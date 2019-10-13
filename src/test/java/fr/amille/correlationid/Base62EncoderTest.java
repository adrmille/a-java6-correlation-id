package fr.amille.correlationid;

import fr.amille.correlationid.Base62Encoder;
import org.junit.Assert;
import org.junit.Test;

public class Base62EncoderTest {

  @Test
  public void shouldEncodeInBase62() {
    // GIVEN
    long aLongValue = 1248784487L;

    // WHEN
    final String result = Base62Encoder.encodeFromBase10(aLongValue);

    // THEN
    // see: http://convertxy.com/index.php/numberbases/
    Assert.assertEquals("1MVltH", result);
  }

  @Test
  public void shouldEncodeInBase62GivenLongMaxValueNumber() {
    // WHEN
    final String result = Base62Encoder.encodeFromBase10(Long.MAX_VALUE);

    // THEN
    // see: http://convertxy.com/index.php/numberbases/
    Assert.assertTrue(result.length() <= 11);
    Assert.assertEquals("AzL8n0Y58m7", result);
  }

}
