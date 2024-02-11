package lab.polymorphism;

import java.io.PrintWriter;
import org.w3c.dom.Text;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2019
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    try {
      // Prepare for input and output
      PrintWriter pen = new PrintWriter(System.out, true);

      // Create a block to use
      TextBlock block = new TextLine("This is a test");

      TextBlock newBlock = new BoxedBlock(block);

      TextBlock newNewBlock = new BoxedBlock(newBlock);

      TextLine newLine = new TextLine("");

      TextBlock emptyBlock = new BoxedBlock(newLine);



      TextLine hello = new TextLine("Hello");

      TextLine goodbye = new TextLine("Goodbye");

      TextBlock vBlock = new BoxedBlock(new VComposition(hello, goodbye));






      
      // Print out the block
      TBUtils.print(pen, newBlock);
      
      TBUtils.print(pen, newNewBlock);

      TBUtils.print (pen, emptyBlock);

      TBUtils.print (pen, vBlock);

      TBUtils.print(pen, new Truncated(vBlock, 4));

      TBUtils.print(pen, new BoxedBlock(new Centered(vBlock, 18)));

      TBUtils.print(pen, new BoxedBlock(new RightJustified(vBlock, 12 )));

      TBUtils.print(pen, new HorizontallyFlipped(vBlock));

      TBUtils.print(pen, new VerticallyFlipped(vBlock));

      TBUtils.print(pen, new BoxedBlock(new BottomJustified(vBlock, 10)));

      TextBlock boxed1 = new BoxedBlock(new TextLine("  a"));

      TextBlock boxed2 = new BoxedBlock(new RightJustified(new TextLine("a"), 3));

      TextBlock boxed1cpy = boxed1;

      TextBlock boxed1cpy2 = new BoxedBlock(new TextLine("  a"));

      TBUtils.print(pen, boxed1);

      TBUtils.print(pen, boxed2);

      pen.println(TBUtils.equal(boxed1, boxed2)); // should be true

      pen.println(TBUtils.eqv(boxed1, boxed2)); // should be false

      pen.println(TBUtils.eqv(boxed1, boxed1cpy)); // should be true

      pen.println(TBUtils.eqv(boxed1, boxed1cpy2)); // should be true

      pen.println(TBUtils.eq(boxed1, boxed1)); //should be true
      pen.println(TBUtils.eq (boxed1, boxed1cpy)); //true
      pen.println(TBUtils.eq (boxed1, boxed2)); //false


      
      


      


      // Clean up after ourselves.
      pen.close();
    } catch (Exception e) {
      PrintWriter err = new PrintWriter(System.err, true);
      err.println(e.getMessage());
    }
  } // main(String[])

} // class TBExpt
