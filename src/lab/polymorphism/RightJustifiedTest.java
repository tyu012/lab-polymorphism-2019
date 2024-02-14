package lab.polymorphism;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


/**
 * Tests for the HorizontallyFlipped class
 * @author Tim Yu, Alyssa Trapp, David Rhoades
 */
public class RightJustifiedTest {
  TextBlock loremIpsum;
  TextBlock empty;
  TextBlock loremIpsumBoxed;


  public RightJustifiedTest() throws Exception {
    loremIpsum = new TextLine("Lorem ipsum");
    empty = new TextLine("");
  }

  @Test
  public void testRightJustifiedSameLength() throws Exception {
    assertEquals(true, TBUtils.equal(new RightJustified(loremIpsum, 11), loremIpsum),
        "Right justifies a string of length 11 in a space of length 11 (does not change)");
  }

  @Test
  public void testRightJustifiedEmptyString() throws Exception {
    assertEquals(true, TBUtils.equal(new RightJustified(empty, 1), (new TextLine(" "))),
        "Right justifies an empty string in a space of length 1");
  }

  @Test
  public void testRightJutifiedBase() throws Exception {
    assertEquals(true, TBUtils.equal(new RightJustified(loremIpsum, 13), new TextLine("  Lorem ipsum")),
        "Right justifies a string of length 11 in a space of length 13");
  }

  @Test
  public void testRightJutifiedVFlipped() throws Exception {
    assertEquals(true, TBUtils.equal(new VerticallyFlipped(new RightJustified(loremIpsum, 13)), new TextLine("  Lorem ipsum")),
        "Right justifies a string of length 11 in a space of length 13");
  }
}
