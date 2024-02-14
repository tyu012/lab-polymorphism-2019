package lab.polymorphism;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.abort;
import org.junit.jupiter.api.Test;

/**
 * Tests for the HorizontallyFlipped class
 * @author David Rhoades, adapted from tests by Tim Yu
 */
public class VerticallyFlippedTest {
  TextBlock lorem;
  TextBlock ipsum;
  TextBlock loremIpsum;
  TextBlock loremIpsumText;
  TextBlock loremIpsumTextFlipped;
  TextBlock loremIpsumFlipped;
  TextBlock loremIpsumFlippedTwice;
  TextBlock boxedLoremIpsumFlipped;

  public VerticallyFlippedTest() throws Exception {
    lorem = new TextLine("Lorem");
    ipsum = new TextLine("Ipsum");
    loremIpsum = new VComposition(lorem, ipsum);
    loremIpsumText = new VComposition(loremIpsum, new TextLine("Text"));
    loremIpsumTextFlipped = new VComposition(new TextLine("Text"), new VComposition(new TextLine("Ipsum"), new TextLine("Lorem")));
    loremIpsumFlipped = new VerticallyFlipped(loremIpsum);
    loremIpsumFlippedTwice = new VerticallyFlipped(loremIpsumFlipped);
    boxedLoremIpsumFlipped = new BoxedBlock(loremIpsumFlipped);
  }

  @Test
  public void testVerticallyFlippedPreservesDimensions() throws Exception {
    assertEquals(loremIpsum.height(), loremIpsumFlipped.height(),
        "Vretically flipping preserves height");
    assertEquals(loremIpsum.width(), loremIpsumFlipped.width(),
        "Vertically flipping preserves width");
  }

  @Test
  public void testVerticallyFlippedTwoLines() throws Exception {
    assertEquals(true, TBUtils.equal(new VComposition(ipsum, lorem), loremIpsumFlipped),
        "Vertically flips block with even height");
  }

  @Test
  public void testVerticallyFlippedThreeLines() throws Exception {
    assertEquals(true, TBUtils.equal(new VerticallyFlipped(loremIpsumText), loremIpsumTextFlipped),
        "Vertically flips block with odd height");
  }
}