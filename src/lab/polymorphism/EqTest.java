/**
 * Testing for the eq method in TBUtils.java
 * @author David Rhoades
 * @author Alyssa Trapp
 * @author Tim Yu
 */

package lab.polymorphism;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.abort;
import org.junit.jupiter.api.Test;

public class EqTest {
  TextBlock helloworldTrunc; 
  

  public EqTest() throws Exception {
    TextBlock helloworldTrunc = new Truncated(new TextLine("Hello World1"), 11);
  }

  TextBlock helloWorldCopy = new TextLine("Hello World");
  TextBlock helloWorld = new TextLine("Hello World");
  TextLine empty = new TextLine("");
  TextLine empty2 = new TextLine("");
  TextBlock helloWorldRef = helloWorld;

  @Test
  public void testEqPositiveResult() {
    assertEquals(true, TBUtils.eq(helloWorld, helloWorldRef), "eq with same memory location");
  }

  @Test
  public void testEqSameTextBlock() {
    assertEquals(true, TBUtils.eq(helloWorld, helloWorld), "eq with same object");
  }

  @Test
  public void testEqDifferentTextBlockInMem() {
    assertEquals(false, TBUtils.eq(helloWorld, helloWorldCopy), "eq with different text block in memory");
  }

  @Test
  public void testEmptyStrings() {
    assertEquals(false, TBUtils.eq(empty, empty2), "eq with two different empty strings");
  }

  @Test
  public void testLookSame() {
    assertEquals(false, TBUtils.eq(helloWorld, helloworldTrunc), "eq look the same but built different");
  }
}
