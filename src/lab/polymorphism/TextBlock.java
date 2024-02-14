package lab.polymorphism;

/**
 * Simple blocks of text for a lab on polymorphism
 * 
 * @author Samuel A. Rebelsky
 * @version 1.2 of February 2019
 */
public interface TextBlock {
  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   * 
   * @pre i < this.height()
   * @exception Exception if the row number is invalid.
   */
  public String row(int i) throws Exception;


  /**
   * return an array containing all of the TextBlock components that went into the creation of this TextBlock
   * If there are no TextBlock components, the array will be empty.
   */
  public TextBlock[] components();


  /**
   * Determine how many rows are in the block.
   */
  public int height();

  /**
   * Determine how many columns are in the block.
   */
  public int width();

} // interface TextBlock
