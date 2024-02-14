package lab.polymorphism;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.abort;
import org.junit.jupiter.api.Test;

/**
 * Testing for the eqv method in TBUtils.java
 * @author David Rhoades
 * @author Alyssa Trapp
 * @author Tim Yu
 */
public class EqvTest{
  public TextBlock boxedRightJustifiedHelloWorld;
  public TextBlock boxedRightJustifiedHelloWorldCopy;
  public TextBlock boxedSpaceHelloWorld;
  public TextBlock boxedRightJustifiedHelloWorldDifCopy;
  public TextBlock emptyBlock;
  public TextBlock emptyBlock2;

  public EqvTest() throws Exception {
    boxedRightJustifiedHelloWorld =
        new BoxedBlock(new RightJustified(new TextLine("Hello World"), 12));
    boxedRightJustifiedHelloWorldCopy =
        new BoxedBlock(new RightJustified(new TextLine("Hello World"), 12));
    boxedSpaceHelloWorld =
        new BoxedBlock(new TextLine(" Hello World"));
    boxedRightJustifiedHelloWorldDifCopy = 
        new BoxedBlock(new RightJustified(new Truncated (new TextLine("Hello World"), 11), 12));
    emptyBlock = 
        new BoxedBlock (new TextLine (("")));
    emptyBlock2 =
        new BoxedBlock (new TextLine (("")));
  }
  
  @Test
  public void testEqvTrue() {
    assertEquals(true, TBUtils.eqv(boxedRightJustifiedHelloWorld, boxedRightJustifiedHelloWorldCopy), "eqv true");
  }
  
  @Test
  public void testEqvIdentical() {
    assertEquals(true, TBUtils.eqv(boxedRightJustifiedHelloWorld, boxedRightJustifiedHelloWorld), "eqv identical");
  }
  
  @Test
  public void testEqvFalse() {
    assertEquals(false, TBUtils.eqv(boxedRightJustifiedHelloWorld, boxedSpaceHelloWorld), "eqv false, same appearance");
  }

  @Test
  public void testEqvFalse2() {
    assertEquals(false, TBUtils.eqv(boxedRightJustifiedHelloWorldCopy, boxedRightJustifiedHelloWorldDifCopy), "eqv false, same appearance");
  }

  @Test
  public void testEqvEmpty() {
   assertEquals (true, TBUtils.eqv (emptyBlock, emptyBlock2), "eqv, both have an empty string, so they should be true");
  }

  @Test
  public void testEqvEmptyString() {
    assertEquals (false, TBUtils.eqv (emptyBlock, boxedSpaceHelloWorld), "eqv, empty and non-empty string, so should be false");
  }
}

