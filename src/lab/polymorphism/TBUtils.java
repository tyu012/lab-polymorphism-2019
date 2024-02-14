package lab.polymorphism;

import java.io.PrintWriter;

/**
 * Utilities for TextBlocks.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2014
 */
public class TBUtils {
  // +--------------+------------------------------------------------------
  // | Class Fields |
  // +--------------+

  /**
   * A really big sequence of dashes. This sequence may grow as the program operates.
   */
  static String lotsOfDashes = "--";

  /**
   * A really big sequence of spaces. This sequence may grow as the program operates.
   */
  static String lotsOfSpaces = "  ";

  // +----------------+----------------------------------------------------
  // | Static Methods |
  // +----------------+

  /**
   * Build a sequence of dashes of a specified length.
   */
  static String dashes(int len) {
    // Note: This strategy probably represents an overkill in
    // attempts at efficiency.
    // Make sure the collection of dashes is big enough
    while (lotsOfDashes.length() < len) {
      lotsOfDashes = lotsOfDashes.concat(lotsOfDashes);
    } // while
    // Extract an appropriate length substring
    return lotsOfDashes.substring(0, len);
  } // dashes(int)

  /**
   * Print a TextBlock to the specified destination.
   */
  public static void print(PrintWriter pen, TextBlock block) {
    for (int i = 0; i < block.height(); i++) {
      // Even though we only call block.row with a valid i,
      // we need to put the call in a try/catch block.
      try {
        pen.println(block.row(i));
      } catch (Exception e) {
        pen.println();
      } // catch (Exception)
    } // for
  } // print(PrintWriter, TextBlock)

  /**
   * Build a sequence of spaces of a specified length.
   */
  static String spaces(int len) {
    // As with dashes, this is probably overkill.
    // Make sure the collection of dashes is big enough
    while (lotsOfSpaces.length() < len) {
      lotsOfSpaces = lotsOfSpaces.concat(lotsOfSpaces);
    } // while
    // Extract an appropriate length substring
    return lotsOfSpaces.substring(0, len);
  } // spaces(int)

  /**
   * Return true if both TextBlock objects contain the same lines
   */
  static boolean equal(TextBlock t1, TextBlock t2) {
    if (t1.height() != t2.height()) {
      return false;
    }
    for (int i = 0; i < t1.height(); i++) {
      try {
        if (!t1.row(i).equals(t2.row(i))) {
          return false;
        }
      } catch (Exception e) {
        return false;
      }
    }
    return true;
  }

  /**
   * Return true if both TextBlock objects contain the same lines and are built
   * in the same way.
   */
  static boolean eqv(TextBlock t1, TextBlock t2) {
    if (equal(t1, t2)
        && (t1.components().length == t2.components().length)
        && t1.getClass() == t2.getClass()) {
      if (t1.components().length == 0) {
        return true;
      }
      boolean result = true;
      for (int i = 0; i < t1.components().length; i++) {
        result = result && eqv(t1.components()[i], t2.components()[i]);
      }
      return result;
    } else {
      return false;
    }
  }

  /**
   * Return true if t1 and t2 are the same TextBlock object (with regards to
   * their location in memory).
   */
  static boolean eq(TextBlock t1, TextBlock t2) {
    return (t1 == t2);
  }


} // class TBUtils
