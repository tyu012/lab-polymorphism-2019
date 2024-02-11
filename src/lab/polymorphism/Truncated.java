package lab.polymorphism;

public class Truncated implements TextBlock {
  private TextBlock contents;
  private int width;

  /**
   * Given a TextBlock b, truncates text block to specified width by removing
   * columns from the right side.
   * 
   * @pre 0 <= width <= b.width()
   * @exception Exception if width is invalid.
   */
  public Truncated(TextBlock b, int width) throws Exception {
    if (width < 0 || width > b.width()) {
      throw new Exception("Invalid width; width must be between 0 and width of given TextBlock (inclusive)");
    }
    this.contents = b;
    this.width = width;
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
    return contents.row(i).substring(0, this.width());
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
}
