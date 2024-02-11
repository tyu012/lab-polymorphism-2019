package lab.polymorphism;

public class HorizontallyFlipped implements TextBlock {
  private TextBlock contents;

  /**
   * Constructs a new text block which horizontally inverts the given TextBlock b.
   */
  public HorizontallyFlipped(TextBlock b) {
    this.contents = b;
  }

  /**
   * Returns the String s but reversed.
   */
  private String reverseString(String s) {
    char[] reversedStringArray = new char[s.length()];
    for (int i = 0; i < reversedStringArray.length; i++) {
      reversedStringArray[i] = s.charAt(s.length() - i - 1);
    }
    return new String(reversedStringArray);
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
    return reverseString(contents.row(i));
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
