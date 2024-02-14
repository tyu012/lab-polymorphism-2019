package lab.polymorphism;

/**
 * Text block which inverts contents so that up-to-down will be down-to-up.
 * @author David Rhoades
 * @author Alyssa Trapp
 * @author Tim Yu
 */
public class VerticallyFlipped implements TextBlock{
  /** What will be vertically flipped */
  private TextBlock contents;

  /**
   * Constructs a new text block which horizontally inverts the given TextBlock b.
   */
  public VerticallyFlipped(TextBlock b) {
    this.contents = b;
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
