/**
 * Implements an example of Insertion Sort.
 *
 * In English, here's how the algorithm works:
 * Moving left to right, evaluate each new value against those to its left,
 * all of which are already sorted. Move this value leftwards until it too is
 * sorted, then move on to the next. At any point in the iteration, all 
 * elements to the left are already sorted, and an unsorted subset exists
 * to the right.
 **/

object InsertionSort {
  def main(args: Array[String]) {
    var mess = Array(3, 9, 8, 13, 2, 5, 4);

    sort(mess)

    mess.foreach( println )
  }

  def sort(a: Array[Int]) : Unit = {
    for (i <- 1 to a.length-1) {
      val x = a(i)
      var j = i
      while (j > 0 && a(j-1) > x) {
        a(j) = a(j-1)
        j-=1
      }
      a(j) = x
    }
  }

}
