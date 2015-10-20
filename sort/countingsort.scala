/**
 * Implements an example of Counting sort.
 *
 * In English, here's how the algorithm works:
 * Create an ordered array of all unique values (ie, keys) between min and max
 * of the array to be sorted.
 * Count the occurrences of each key, and store this value in the array.
 * Iterate through array, assembling each key in order, repeated once for 
 * each occurrence.
 **/

object CountingSort {
  def main(args: Array[String]) {
    var mess = Array(3, 9, 8, 13, 2, 5, 4);

    val result = sort(mess, mess.min, mess.max)
    result.foreach( println )
  }

  def sort(a: Array[Int], min: Int, max: Int): Array[Int] = {
    def key(value: Int): Int = {
      return value - min
    }

    // Count how many of each key we have
    val count: Array[Int] = new Array[Int](max - min + 2)
    for (e <- a) {
      // leave the first position = 0; we ultimately ignore last position
      count(key(e)+1) += 1 
    }

    // Add preceding counts to compute offset for each key
    for (i <- 1 to (max-min+1)) {
      count(i) += count(i-1)
    }

    // Assemble results using offset and sorted keys
    val result: Array[Int] = new Array[Int](a.length)
    for (e <- a) {
      result(count(key(e))) = e
    }
    return result
  }
}
