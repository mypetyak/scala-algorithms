/**
 * Implements an example of Quicksort.
 *
 * In English, here's how the algorithm works:
 * Moving left to right, move all values less than the pivot value to the
 * left of a floating divide, where the divide always marks the point to 
 * the left of which all values are less than the pivot. At the end, move
 * the pivot value to the divide location. Then recurse for the subarrays
 * on either side of the pivot.
 **/

object Quicksort {
  def main(args: Array[String]) {
    var mess = Array(3, 9, 8, 13, 2, 5, 4);

    quicksort(mess, 0, mess.length-1);
    mess.foreach( println )
  }

  /** Swaps two values in an array */
  def swap(a: Array[Int], pos1: Int, pos2: Int): Unit = {
    val stash = a(pos1)
    a(pos1) = a(pos2)
    a(pos2) = stash
  }

  /** Performs recursive quicksort on an array 
   *
   * There's an opportunity for limiting space complexity to
   * O(ln(n)) here if we recurse on the larger partition last
   * (tail recursion).
   *  */
  def quicksort(a: Array[Int], low: Int, hi: Int): Unit = {
    if (low < hi) {
      val p = partition(a, low, hi)
      quicksort(a, low, p-1)
      quicksort(a, p+1, hi)
    }
  }

  /** Partition an array around some pivot
   *
   *  Chooses a pivot, moves all values less than
   *  the pivot to its left, and moves all values
   *  greater than the pivot to its right.
   *
   *  To optimize: choose pivot corresponding to a median
   *  value of some sample. This helps ensure the 
   *  partitioning results in similarly-sized sub-arrays,
   *  and thus the optimal O(n*ln(n)) performance.
   *
   *  @return index (location) of pivot in partitioned array
   */
  def partition(subArray: Array[Int], low: Int, hi: Int): Int = {
    val pivot = hi;
    var i = low;
    for (
      j <- low to hi
      if subArray(j) < subArray(pivot)
    ) {swap(subArray, i, j); i+=1}

    // Lastly, move pivot value to the dividing line at i
    swap(subArray, i, pivot);
    return i
  }
}
