package lab.polymorphism;

import java.io.PrintWriter;

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




    // Clean up after ourselves.
    pen.close();
  } // main(String[])

} // class TBExpt
