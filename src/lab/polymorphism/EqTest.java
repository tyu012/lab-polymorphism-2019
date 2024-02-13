package lab.polymorphism;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.abort;
import org.junit.jupiter.api.Test;

public class EqTest {
  TextBlock helloWorld = new TextLine("Hello World");
  TextBlock helloWorldRef = helloWorld;
  TextBlock helloWorldCopy = new TextLine("Hello World");

  @Test
  public void testEqPositiveResult() {
    assertEquals(true, TBUtils.eq(helloWorld, helloWorldRef), "eq with same memory location");
  }

  @Test
  public void testEqSameTextBlock() {
    assertEquals(true, TBUtils.eq(helloWorld, helloWorld), "eq with same object");
  }

  @Test
  public void testEqDifferentTextBlockInMem() {
    assertEquals(true, TBUtils.eq(helloWorld, helloWorldCopy), "eq with different text block in memory");
  }
}
