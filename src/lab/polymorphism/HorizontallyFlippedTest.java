package lab.polymorphism;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Tests for the HorizontallyFlipped class
 * @author Tim Yu
 */
public class HorizontallyFlippedTest {
  TextBlock loremIpsum;
  TextBlock loremIpsumFlipped;
  TextBlock loremIpsumFlippedTwice;
  TextBlock boxedLoremIpsumFlipped;
  TextBlock even;
  TextBlock evenFlipped;
  TextBlock symmetric;
  TextBlock uniform;
  TextBlock empty;

  public HorizontallyFlippedTest() throws Exception {
    loremIpsum = new TextLine("Lorem ipsum");
    loremIpsumFlipped = new HorizontallyFlipped(loremIpsum);
    loremIpsumFlippedTwice = new HorizontallyFlipped(loremIpsumFlipped);
    boxedLoremIpsumFlipped = new BoxedBlock(loremIpsumFlipped);
    even = new TextLine("even");
    evenFlipped = new HorizontallyFlipped(even);
    symmetric = new TextLine("asdfjkl;lkjfdsa");
    uniform = new TextLine(" ".repeat(10));
    empty = new TextLine("");
  }

  @Test
  public void testHorizontallyFlippedPreservesDimensions() throws Exception {
    assertEquals(loremIpsum.height(), loremIpsumFlipped.height(),
        "Horizontally flipping preserves height");
    assertEquals(loremIpsum.width(), loremIpsumFlipped.width(),
        "Horizontally flipping preserves width");
  }

  @Test
  public void testHorizontallyFlippedContentOdd() throws Exception {
    assertEquals(true, TBUtils.equal(new TextLine("muspi meroL"), loremIpsumFlipped),
        "Horizontally flips block with odd width");
  }

  @Test
  public void testHorizontallyFlippedContentEven() throws Exception {
    assertEquals(true, TBUtils.equal(new TextLine("neve"), evenFlipped),
        "Horizontally flips block with even width");
  }

  @Test
  public void testHorizontallyFlippedContentUniform() throws Exception {
    assertEquals(true, TBUtils.equal(uniform, new HorizontallyFlipped(uniform)),
        "Horizontally flips block with uniform text");
  }

  @Test
  public void testHorizontallyFlippedContentEmpty() throws Exception {
    assertEquals(true, TBUtils.equal(empty, new HorizontallyFlipped(empty)),
        "Horizontally flips block with empty string");
  }

  @Test
  public void testHorizontallyFlippedContentBoxed() throws Exception {
    assertEquals(true,
        TBUtils.equal(new BoxedBlock(new TextLine("muspi meroL")), boxedLoremIpsumFlipped),
        "Horizontally flips multirow block");
  }

  @Test
  public void testHorizontallyFlippedTwice() throws Exception {
    assertEquals(true, TBUtils.equal(loremIpsum, loremIpsumFlippedTwice),
        "Horizontally flipping twice yields original");
  }
}
