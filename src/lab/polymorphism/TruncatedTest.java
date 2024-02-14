package lab.polymorphism;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.abort;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for Truncated class
 */
public class TruncatedTest {
  public TextBlock helloWorld;
  public TextBlock truncatedHelloWorld;
  public TextBlock truncatedEqualHelloWorld;
  public TextBlock truncatedToEmptyHelloWorld;
  public TextBlock empty;
  public TextBlock truncatedEmpty;
  public TextBlock letters;
  public TextBlock truncatedLetters;
  public TextBlock boxedTruncatedLetters;

  public int TRUNCATED_WIDTH = 6;
  
  public TruncatedTest() throws Exception {
    helloWorld = new BoxedBlock(new TextLine("Hello World"));
    truncatedHelloWorld = new Truncated(helloWorld, TRUNCATED_WIDTH);
    truncatedEqualHelloWorld = new Truncated(helloWorld, helloWorld.width());
    truncatedToEmptyHelloWorld = new Truncated(helloWorld, 0);
    empty = new TextLine("");
    truncatedEmpty = new Truncated(empty, 0);
    letters = new TextLine("abcdefg");
    truncatedLetters = new Truncated(letters, TRUNCATED_WIDTH);
    boxedTruncatedLetters = new BoxedBlock(truncatedLetters);
  }

  @Test
  public void testTruncatedContents() {
    assertEquals(TRUNCATED_WIDTH, truncatedHelloWorld.width(),
        "Truncates to specified width");
    assertEquals(helloWorld.height(), truncatedHelloWorld.height(),
        "Retains original height");
    try {
      for (int i = 0; i < helloWorld.height(); i++) {
        assertEquals(helloWorld.row(i).substring(0, TRUNCATED_WIDTH),
            truncatedHelloWorld.row(i),
            "Truncated row matches substring of original row");
      }
    } catch (Exception e) {
      fail();
    }
  }

  @Test
  public void testTruncatedToSameWidth() {
    try {
      assertEquals(true, TBUtils.equal(helloWorld, truncatedEqualHelloWorld),
          "Truncates to same width as original TextBlock");
    } catch (Exception e) {
      fail();
    }
  }

  @Test
  public void testTruncatedToZeroWidth() {
    try {
      assertEquals(0, truncatedToEmptyHelloWorld.width(),
          "Truncates to zero width");
      assertEquals(helloWorld.height(), truncatedToEmptyHelloWorld.height(),
          "Retains original height");
      for (int i = 0; i < helloWorld.height(); i++) {
        assertEquals("", truncatedToEmptyHelloWorld.row(i),
            "Row truncated to zero width is empty string");
      }
    } catch (Exception e) {
      fail();
    }
  }

  @Test
  public void testTruncatedToSameEmptyWidth() {
    try {
      assertEquals(true, TBUtils.equal(truncatedEmpty, empty),
          "Truncates width 0 to width 0");
    } catch (Exception e) {
      fail();
    }
  }

  @Test
  public void testTruncatedThenBoxed() {
    try {
      assertEquals(truncatedLetters.width() + 2, boxedTruncatedLetters.width(),
          "Boxed truncated letters has correct width");
    } catch (Exception e) {
      fail();
    }
  }
}
