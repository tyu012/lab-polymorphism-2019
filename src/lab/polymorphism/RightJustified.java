package lab.polymorphism;

public class RightJustified implements TextBlock{
  private TextBlock contents;
  private int width;

  /**
   * Shifts the Textbox to the right 
   * @pre width must be greater than or equal to b.width
   * @exception Exception if width is invalid.
   */
  public RightJustified (TextBlock b, int width) throws Exception {
    if (width < b.width()) {
      throw new Exception("Invalid width; width must be greater than or equal to the width of given TextBlock");
    }
    this.contents = b;
    this.width = width;
  }


  /**
   * return an array containing all of the components that went into the creation of this textblock
   * It there are no components, the array will be empty.
   */
  public TextBlock[] components() {
    return new TextBlock[] { this.contents };
  }


  /**
   * Get one row from the block.
   * 
   * @pre i < this.height()
   * @exception Exception if the row number is invalid.
   */
  public String row(int i) throws Exception {
    if (i >= this.height() || i < 0) {
      throw new Exception("Invalid height; height must be less than " + height());
    }
    int lSpaces = this.width() - contents.width();
    String space = " ";
    String lSpace = space.repeat(lSpaces);
    return lSpace + contents.row(i);
  }

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return contents.height();
  }

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return this.width;
  }
} // class Centered