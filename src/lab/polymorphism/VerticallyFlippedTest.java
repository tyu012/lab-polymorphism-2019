package lab.polymorphism;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Tests for the HorizontallyFlipped class
 * @author David Rhoades, adapted from tests by Tim Yu
 */
public class VerticallyFlippedTest {
  TextBlock empty;
  TextBlock lorem;
  TextBlock ipsum;
  TextBlock loremIpsum;
  TextBlock loremIpsumText;
  TextBlock loremIpsumTextFlipped;
  TextBlock loremIpsumFlipped;
  TextBlock loremIpsumFlippedTwice;
  TextBlock boxedLoremIpsumFlipped;

  public VerticallyFlippedTest() throws Exception {
    
    empty = new TextLine("");
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

  @Test
  public void testVerticallyFlippedOneLine() throws Exception {
    assertEquals(true, TBUtils.equal(new VerticallyFlipped(lorem), lorem),
        "Vertically flips one line (no change)");
  }

  @Test
  public void testVerticallyFlippedEmptyLine() throws Exception {
    assertEquals(true, TBUtils.equal(new VerticallyFlipped(empty), empty),
        "Vertically flips an empty line (no change)");
  }

  @Test
  public void testVerticallyFlippedTwice() throws Exception {
    assertEquals(true, TBUtils.equal(new VerticallyFlipped(new VerticallyFlipped(loremIpsum)), loremIpsum),
        "Vertically flips one line (no change)");
  }
}