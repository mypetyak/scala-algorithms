/**
 * Implements an example of Merge sort.
 *
 * In English, here's how the algorithm works:
 * Recursively split the array in half, sort each subarray, and then merge
 * the sorted arrays into a single, sorted array, by traversing both arrays. 
 * The base case occurs when the subarray is a single element (considered 
 * sorted).
 **/

object MergeSort {
  def main(args: Array[String]) {
    var mess = Array(3, 9, 8, 13, 2, 5, 4);

    val result = sort(mess, 0, mess.length-1)
    result.foreach( println )
  }

  /** Recursively sorts a subarray via Merge Sort algorithm.
   *
   * @param a an unsorted array to be sorted 
   * @param lo the index of the left-most edge of desired subarray
   * @param hi the index of the right-most edge of desired subarray
   * @return a sorted array containing all elements in the prescribed subarray
   */
  def sort(a: Array[Int], lo: Int, hi: Int) : Array[Int] = {
    if (hi - lo < 1){
      return a.slice(lo, hi+1)
    }
    val mid = (hi - lo)/2 + lo
    val left = sort(a, lo, mid)
    val right = sort(a, mid+1, hi)

    return merge(left, right)
  }

  /** Combines two sorted arrays into a single sorted array. 
   *
   * @param a first sorted array
   * @param b second sorted array
   * @return a new sorted array containing all elements from a and b
   *  */
  def merge(a: Array[Int], b: Array[Int]): Array[Int] = {
    var result = Array.fill(a.length + b.length)(0)

    var i: Int = 0
    var j: Int = 0

    /** Note: this could also be done with recursion,
     *  which would probably be more idiomatic of 
     *  functional programming.
     */
    while (i < a.length || j < b.length){
      if (i >= a.length){
        result(i+j) = b(j)
        j+=1
      }
      else if (j >= b.length || a(i) <= b(j)) {
        result(i+j) = a(i)
        i+=1
      }
      else {
        result(i+j) = b(j)
        j+=1
      }
    }
    return result
  }
}
