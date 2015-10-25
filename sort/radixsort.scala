/**
 * Implements an example of Radix sort.
 *
 * In English, here's how the algorithm works:
 * Iterate over the digit places, from least significant to most. In each
 * iteration, perform a counting sort on the elements using base10 keys,
 * effectively sorting from LSD through MSD.
 **/

object RadixSort {
  def main(args: Array[String]) {
    var mess = Array(3, 9, 8, 13, 2, 5, 4);

    val result = sort(mess, 2)

    result.foreach( println )
  }

  // Base-10 counting sort
  def sort(a: Array[Int], max_digits: Int): Array[Int] = {

    /** Computes a key (base10) for an integer, given the significatn digit.
     * @param value the value for which to return a key
     * @param digit the (one-based, right-to-left) index of which digit to key
     */ 
    def key(value: Int, digit: Int): Int = {
      return (value % (scala.math.pow(10, digit))).toInt / scala.math.pow(10, digit-1).toInt
    }

    // Each iteration, we move data from 'from' to 'to' during the sort
    var from = a
    var to = new Array[Int](a.length)

    for (digit <- 1 to max_digits) {
      val count  = new Array[Int](10)
      // Count how many of each key we have
      from.foreach( (e: Int) => count(key(e, digit)) += 1 )
      
      // Add preceding counts to compute offset for each key
      for (i <- 1 until 10) {
        count(i) += count(i-1)
      }

      // Assemble results using offset and sorted keys
      for (e <- from.reverseIterator) {
        count(key(e, digit)) -= 1
        to(count(key(e, digit))) = e
      }
      from = to
      to = new Array[Int](a.length)
    }
    return from
  }
}
