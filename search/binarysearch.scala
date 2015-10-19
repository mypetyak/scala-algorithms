/**
 * Implements an example of Binary search.
 *
 * In English, here's how the algorithm works:
 * Given a sorted array 'a', find the midpoint. If the target is less than
 * the midpoint, repeat on the left half of the array. If the target is 
 * greater than the midpoint, repeat on the right half of the array. If
 * the target is the midpoint, return the midpoint location. If the subarray
 * has no length, stop (we haven't found the target).
 **/

object BinarySearch {
  def main(args: Array[String]) {
    val sorted = Array(2, 3, 4, 5, 8, 9, 13)

    println(search(sorted, 13, 0, sorted.length-1))
  }

  def search(a: Array[Int], target: Int, lo: Int, hi: Int): Int = {
    if(hi < lo) return -1
    val mid = (hi-lo)/2 + lo
    
    target match {
      case t if t < a(mid) => return search(a, target, lo, mid-1)
      case t if t > a(mid) => return search(a, target, mid+1, hi)
      case t if t == a(mid) => return mid
    }
  }

}
