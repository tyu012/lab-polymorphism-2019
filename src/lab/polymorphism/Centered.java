package lab.polymorphism;

public class Centered implements TextBlock{
  private TextBlock contents;
  private int width;

  /**
   * Given a TextBlock b, centeres text block within the given width
   * 
   * @pre width must be greater than or equal to b.width
   * @exception Exception if width is invalid.
   */
  public Centered(TextBlock b, int width) throws Exception {
    if (width < b.width()) {
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
    int buffer = this.width() - contents.width();
    int rSpaces = buffer/2;
    int lSpaces = buffer - rSpaces;
    String space = " ";
    String lSpace = space.repeat(lSpaces);
    String rSpace = space.repeat(rSpaces);
    return lSpace + contents.row(i) + rSpace;
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
