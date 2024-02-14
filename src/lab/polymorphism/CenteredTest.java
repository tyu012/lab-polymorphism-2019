package lab.polymorphism;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Tests for the Centered class.
 * @author Tim Yu
 */
public class CenteredTest {
  TextBlock helloWorld;
  TextBlock evenCenteredHelloWorld;
  TextBlock oddCenteredHelloWorld;
  TextBlock evenCenteredHelloWorldInBox;
  TextBlock sameWidthCenteredHelloWorld;
  TextBlock empty;
  TextBlock emptyCentered;

  String SP = " ";

  public CenteredTest() throws Exception {
    helloWorld = new TextLine("Hello World");
    sameWidthCenteredHelloWorld = new Centered(helloWorld, helloWorld.width());
    evenCenteredHelloWorld = new Centered(helloWorld, helloWorld.width() + 4);
    evenCenteredHelloWorldInBox = new BoxedBlock(evenCenteredHelloWorld);
    empty = new TextLine("");
    emptyCentered = new Centered(empty, 0);
  }

  @Test
  public void testEvenCentered() throws Exception {
    for (int sidePadding = 0; sidePadding < 1000; sidePadding++) {
      TextBlock evenCenteredHelloWorld = new Centered(helloWorld, helloWorld.width() + 2 * sidePadding);
      assertEquals(SP.repeat(sidePadding) + helloWorld.row(0) + SP.repeat(sidePadding),
          evenCenteredHelloWorld.row(0),
          "Centers text block with padding amount of" + sidePadding);
    }
  }

  @Test
  public void testOddCentered() throws Exception {
    for (int sidePadding = 0; sidePadding < 1000; sidePadding++) {
      TextBlock evenCenteredHelloWorld = new Centered(helloWorld, helloWorld.width() + 2 * sidePadding + 1);
      assertEquals(SP.repeat(sidePadding + 1) + helloWorld.row(0) + SP.repeat(sidePadding),
          evenCenteredHelloWorld.row(0),
          "Centers text block with padding amount of" + (sidePadding + 1));
    }
  }
 

  @Test
  public void testEvenCenteredInBox() throws Exception {
    assertEquals(evenCenteredHelloWorld.height() + 2,
        evenCenteredHelloWorldInBox.height(),
        "Box modifies height");
    assertEquals(evenCenteredHelloWorld.width() + 2,
        evenCenteredHelloWorldInBox.width(),
        "Box modifies width");
    assertEquals("|" + evenCenteredHelloWorld.row(0) + "|",
        evenCenteredHelloWorldInBox.row(1),
        "Box retains centered text block");
  }

  @Test
  public void testSameWidthCentered() throws Exception {
    assertEquals(true, TBUtils.equal(helloWorld, sameWidthCenteredHelloWorld),
        "Centers to same width");
  }

  @Test
  public void testCentersEmptyBlock() throws Exception {
    assertEquals(true, TBUtils.equal(empty, emptyCentered),
        "Centers zero width to zero width");
  }
}
