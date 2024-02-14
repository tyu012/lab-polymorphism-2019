package lab.polymorphism;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.abort;
import org.junit.jupiter.api.Test;

/**
 * Test suite for the TBUtils.equal method
 * @author Alyssa Trapp
 * @author David Rhoades
 * @author Tim Yu
 */
public class EqualTest {
  public TextBlock boxedRightJustifiedHelloWorldCopy;
  public TextBlock boxedRightJustifiedHelloWorldDifCopy;
  public TextBlock emptyBlock;
  public TextBlock emptyBlock2;
  public TextBlock hFlippedBlock;
  public TextBlock hFlippedBlock2;
  public TextBlock vFlippedBlock;
  public TextBlock vFlippedBlock2;


//if have same lines should return true 
  public EqualTest() throws Exception {
    boxedRightJustifiedHelloWorldCopy =
        new BoxedBlock(new RightJustified(new TextLine("Hello World"), 12));
    boxedRightJustifiedHelloWorldDifCopy = 
        new BoxedBlock(new RightJustified(new Truncated (new TextLine("Hello World"), 11), 12));
    emptyBlock = 
        new BoxedBlock (new TextLine (("")));
    emptyBlock2 =
        new BoxedBlock (new Truncated (new TextLine (""), 0));
    hFlippedBlock = 
        new BoxedBlock (new HorizontallyFlipped (new TextLine ("Hello")));
    hFlippedBlock2 =
        new BoxedBlock (new HorizontallyFlipped (new HorizontallyFlipped (new HorizontallyFlipped (new TextLine ("Hello")))));
    vFlippedBlock = 
        new BoxedBlock (new VerticallyFlipped (new TextLine ("Hello")));
    vFlippedBlock2 =
        new BoxedBlock (new VerticallyFlipped (new VerticallyFlipped (new VerticallyFlipped (new TextLine ("Hello")))));
  } 

  @Test
  public void testEqualsTrue() {
    assertEquals(true, TBUtils.equal(boxedRightJustifiedHelloWorldCopy, boxedRightJustifiedHelloWorldDifCopy), "equals true, same appearance");
  }

  @Test
  public void testEqualsEmptyandNonEmpty() {
    assertEquals(false, TBUtils.equal (boxedRightJustifiedHelloWorldCopy, emptyBlock), "should be false, empty and non-empty string");
  }

  @Test 
  public void testEqualsEmptyString() {
    assertEquals(true, TBUtils.equal(emptyBlock, emptyBlock2), "equals true, same appearance");
  }

  @Test 
  public void testsEqualshFlipped() {
    assertEquals(true, TBUtils.equal(hFlippedBlock, hFlippedBlock2), "equals true, same appearance if flipped horizontally");
  }

  @Test 
  public void testsEqualsvFlipped() {
    assertEquals(true, TBUtils.equal(vFlippedBlock, vFlippedBlock2), "equals true, same appearance if flipped vertically");
  }


    
}
