/**
 * Implements an example of Bubble sort.
 *
 * In English, here's how the algorithm works:
 * Moving left to right, compare two adjacent elements. If they are out of
 * order, swap them, then move one element to the right and repeat. Repeat
 * this whole exercise until the entire list is sorted. Note that, over time,
 * the greatest values race to the right and the unsorted subarray becomes
 * truncated. The final iteration only compares the leftmost pair.
 **/

object BubbleSort {
  def main(args: Array[String]) {
    var mess = Array(3, 9, 8, 13, 2, 5, 4);

    sort(mess)

    mess.foreach( println )
  }

  /** Executes bubble sort on an array. */
  def sort(a: Array[Int]): Unit = {
    // Track right edge of the (shrinking) yet-unsorted region
    var hi = a.length-1

    // Once we perform a full iteration without swapping, the array is sorted.
    var swapped = true

    while (swapped) {
      swapped = false
      for (i <- 0 until hi
           if a(i) > a(i+1)) {
        swapped = true
        swap(a, i, i+1)
        hi = i
      }
    }
  }

  /** Swaps two elements in an array. */
  def swap(a: Array[Int], i: Int, j: Int): Unit = {
    val staging: Int = a(i)
    a(i) = a(j)
    a(j) = staging
  }
}
