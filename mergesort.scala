/**
 * Implements an example of Merge sort.
 *
 * In English, here's how the algorithm works:
 **/

object MergeSort {
  def main(args: Array[String]) {
    var mess = Array(3, 9, 8, 13, 2, 5, 4);

    val result = sort(mess, 0, mess.length-1)
    result.foreach( println )
  }

  def sort(a: Array[Int], lo: Int, hi: Int) : Array[Int] = {
    if (hi - lo < 1){
      return a.slice(lo, hi+1)
    }
    val mid = (hi - lo)/2 + lo
    val left = sort(a, lo, mid)
    val right = sort(a, mid+1, hi)

    return merge(left, right)
  }

  def merge(a: Array[Int], b: Array[Int]): Array[Int] = {
    var result = Array.fill(a.length + b.length)(0)

    var i: Int = 0
    var j: Int = 0

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
