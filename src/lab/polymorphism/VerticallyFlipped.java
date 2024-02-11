package lab.polymorphism;

public class VerticallyFlipped implements TextBlock{
  private TextBlock contents;

    /**
   * Constructs a new text block which horizontally inverts the given TextBlock b.
   */
  public VerticallyFlipped(TextBlock b) {
    this.contents = b;
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
    return contents.row(this.height() - (i + 1));
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
    return contents.width();
  }
}
