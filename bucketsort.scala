/**
 * Implements an example of Bucket Sort.
 *
 * In English, here's how the algorithm works:
 * Iterate over the input, segregating elements into a fixed number of ordinal
 * buckets. The sort each bucket. Iterate over the buckets in order,
 * reconstructing the original input in sorted order.
 **/
import scala.collection.mutable.ArrayBuffer

object BucketSort {
  def main(args: Array[String]) {
    var mess = Array(3, 9, 8, 13, 2, 5, 4);

    // Move contents to an ArrayBuffer since
    // our recursive sort requires a mutable
    // data structure. This could be avoided
    // in a hybrid bucketsort/insertionsort
    val ab = new ArrayBuffer[Int]
    ab ++= mess
    sort(ab, 5)

    ab.foreach( println )
  }

  def sort(a: ArrayBuffer[Int], n_buckets: Int) : Unit = {
    if (a.length < 2) return //a bucket could be empty, or have one element
    
    var (max, min) = (a(0), a(0))
    // find max and min in a single iteration through 'a'
    for (value <- a) {
      if (value > max) max = value
      else if(value < min) min = value
    }

    val buckets = new Array[ArrayBuffer[Int]](n_buckets)
    for (i <- 0 until n_buckets) {
      buckets(i) = new ArrayBuffer[Int]
    }

    for (value <- a) {
      val bucket = buckets((value - min) * (n_buckets - 1) / (max - min))
      bucket += value
    }

    // we'll overwrite 'a' to save space
    var i = 0
    for (bucket <- buckets) {
      sort(bucket, n_buckets)
      for (value <- bucket) {
        a(i) = value
        i+=1
      }
    }
  }

}
