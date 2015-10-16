/**
 * Implements an example of Selection sort.
 *
 * In English, here's how the algorithm works:
 * Iterate left to right over the array, finding the smallest value. Swap
 * smallest value with leftmost unsorted value. Repeat on remaining unsorted
 * region of the array (shrinks towards the right).
 **/

object SelectionSort {
  def main(args: Array[String]) {
    var mess = Array(3, 9, 8, 13, 2, 5, 4);

    sort(mess)

    mess.foreach( println )
  }

  /**Implements Selection sort algorithm.*/
  def sort(a: Array[Int]): Unit = {
    val n = a.length
    for (i <- 0 until n) {
      var min = i
      for (j <- i+1 until n) {
        if (a(j) < a(min)) min = j
      }

      if (min != i) swap(a, min, i)
    }
  }

  /**Swaps two elements of an array.*/
  def swap(a: Array[Int], i: Int, j: Int): Unit = {
    val staging = a(i)
    a(i) = a(j)
    a(j) = staging
  }

}
