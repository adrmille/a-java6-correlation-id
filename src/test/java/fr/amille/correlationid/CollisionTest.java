package fr.amille.correlationid;

import java.util.Set;
import java.util.TreeSet;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class CollisionTest {

  @Test
  public void shouldNotCollide() {
    // GIVEN
    final int maxRequestPerWeek = 14000000;
    final Set<String> valueDictionary = new TreeSet<String>();

    // WHEN
    String result;
    for (int i = 0; i <= maxRequestPerWeek; i++) {
      result = CorrelationId.randomCorrelationId();
      Assert.assertFalse(valueDictionary.contains(result));
      valueDictionary.add(result);
      if (i % (maxRequestPerWeek*10/100) == 0) { // Print every 10%
        System.out.println("Number of correlationId generated without collision: " + i);
      }
    }
  }

}
