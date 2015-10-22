/**
 * Implements an example of Heap sort.
 *
 * In English, here's how the algorithm works:
 * Push all elements onto a max heap (in place). Then pop off the root node (ie, max 
 * remaining value on heap) until you've popped all values off the heap. The values
 * leave the heap in reverse sorted order, so as the heap shrinks, we can put popped
 * values to the right end of the same array.
 **/

object HeapSort {
  def main(args: Array[String]): Unit = {
    var mess = Array(3, 9, 8, 13, 2, 5, 4);

    sort(mess)
   // buildHeap(mess, mess.length-1)

    mess.foreach( println )
  }

  def sort(a: Array[Int]): Unit = {
    var m = a.length - 1 
    buildHeap(a, m)
    while (m >= 1) {
      swap(a, 0, m)
      m-=1
      heapify(a, 0, m)
    }
  }

  def buildHeap(a: Array[Int], m: Int): Unit = {
    for (i <- m/2 to 0 by -1) {
      heapify(a, i, m)
    }
  }

  /**Pushes an illegally located element down the heap to restore heap property.*/
  @annotation.tailrec
  def heapify(a: Array[Int], loc: Int, lastLeaf: Int): Unit = {
    val l = left(loc) 
    val r = right(loc)

    var max = loc

    if(l <= lastLeaf && a(l) > a(max)) max = l
    if(r <= lastLeaf && a(r) > a(max)) max = r

    if(max != loc) {
      swap(a, max, loc)
      heapify(a, max, lastLeaf)
    }
  }

  /**Returns position of left child (possibly empty). */
  def left(loc: Int): Int = {
    return 2*loc
  }

  /**Returns position of right child (possibly empty). */
  def right(loc: Int): Int = {
    return 2*loc+1
  }

  def swap(a: Array[Int], i: Int, j:Int): Unit = {
    val staging = a(i)
    a(i) = a(j)
    a(j) = staging
  }
}
