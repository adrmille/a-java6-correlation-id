package fr.amille.correlationid;

/**
 * See for inspiration: http://www.dev-garden.org/2015/11/28/a-recipe-for-microservice-correlation-ids-in-java-servlets/
 */
public class CorrelationId {

  private static final CorrelationIdBuilder DEFAULT_BUILDER = new CorrelationIdBase62Size11();

  private CorrelationId() {
  }

  /**
   * Default generator
   *
   * @return a random base62 id of max size 11
   */
  public static String randomCorrelationId() {
    return DEFAULT_BUILDER.build();
  }

  public static String randomCorrelationId(CorrelationIdBuilder correlationIdBuilder) {
    return correlationIdBuilder.build();
  }

}
