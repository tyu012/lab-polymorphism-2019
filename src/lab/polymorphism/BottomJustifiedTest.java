package lab.polymorphism;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Tests for the BottomJustified text block class
 * @author Tim Yu
 */
public class BottomJustifiedTest {
  TextBlock helloWorld;
  TextBlock empty;
  
  public BottomJustifiedTest() throws Exception {
    helloWorld = new TextLine("Hello World");
    empty = new TextLine("");
  }

  private String spaces(int n) {
    return " ".repeat(n);
  }

  @Test
  public void testBottomJustifyString() throws Exception {
    for (int i = 1; i < 20; i++) {
      TextBlock bottomJustifiedHelloWorld = new BottomJustified(helloWorld, i);
      assertEquals(helloWorld.width(), bottomJustifiedHelloWorld.width(),
          "bottom justifying preserves width");
      for (int j = 0; j < i - 1; j++) {
        assertEquals(spaces(helloWorld.width()), bottomJustifiedHelloWorld.row(j),
            "bottom-justified padding is all-spaces");
      }
      assertEquals(helloWorld.row(0), bottomJustifiedHelloWorld.row(i - 1),
          "bottom-most row equal to 'Hello World'");
    }
  }

  @Test
  public void testBottomJustifyBoxedString() throws Exception {
    for (int i = 1; i < 20; i++) {
      TextBlock bottomJustifiedBoxedHelloWorld = new BoxedBlock(new BottomJustified(helloWorld, i));
      assertEquals(helloWorld.width() + 2, bottomJustifiedBoxedHelloWorld.width(),
          "bottom justifying inside box preserves width");
      for (int j = 1; j < i; j++) {
        assertEquals("|" + spaces(helloWorld.width()) + "|", bottomJustifiedBoxedHelloWorld.row(j),
            "bottom-justified padding is all-spaces surrounded by box");
      }
      assertEquals("|" + helloWorld.row(0) + "|", bottomJustifiedBoxedHelloWorld.row(i),
          "bottom-most row equal to '|Hello World|'");
    }
  }

  @Test
  public void testBottomJustifyEmpty() throws Exception {
    for (int i = 1; i < 20; i++) {
      TextBlock bottomJustifiedEmpty = new BottomJustified(empty, i);
      assertEquals(0, bottomJustifiedEmpty.width(), "width is 0");
      for (int j = 0; j < i; j++) {
        assertEquals("", bottomJustifiedEmpty.row(j), "row is empty string");
      }
    }
  }
}
