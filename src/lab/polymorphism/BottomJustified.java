package lab.polymorphism;

public class BottomJustified implements TextBlock {
  private TextBlock contents;
  private int height;

    /**
   * Shifts the Textbox b to the bottom
   * @pre height greater than or equal to b.height()
   * @exception Exception if height is invalid
   */

  public BottomJustified (TextBlock b, int height) throws Exception {
    if (height < b.height()) {
      throw new Exception("Invalid height; height must be greater than or equal to the height of given TextBlock");
    }
    this.contents = b;
    this.height = height;
  }

  /**
   * return an array containing all of the components that went into the creation of this textblock
   * It there are no components, the array will be empty.
   */
  public TextBlock[] components() {
    return new TextBlock[] { this.contents };
  }


  /**
   * Get one row from the block
   * 
   * @pre i <= this.height()
   * @exception Exception if the row number is invalid.
   */
  public String row(int i) throws Exception {
    if (i > this.height() || i < 0) {
      throw new Exception("Invalid height; height must be less than " + height());
    }
    if (i < this.height - contents.height()){
      String spaceRow = " ".repeat(this.width());
      return spaceRow;
    } else {
      return contents.row(i - (this.height - contents.height()));
    }  
  }

 /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return this.height;
  }

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return contents.width();
  }
} //class BottomJustified

