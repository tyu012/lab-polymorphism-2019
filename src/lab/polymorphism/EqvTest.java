package lab.polymorphism;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.abort;
import org.junit.jupiter.api.Test;

public class EqvTest{
  public TextBlock boxedRightJustifiedHelloWorld;
  public TextBlock boxedRightJustifiedHelloWorldCopy;
  public TextBlock boxedSpaceHelloWorld;

  public EqvTest() throws Exception {
    boxedRightJustifiedHelloWorld =
        new BoxedBlock(new RightJustified(new TextLine("Hello World"), 12));
    boxedRightJustifiedHelloWorldCopy =
        new BoxedBlock(new RightJustified(new TextLine("Hello World"), 12));
    boxedSpaceHelloWorld =
        new BoxedBlock(new TextLine(" Hello World"));
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
}

