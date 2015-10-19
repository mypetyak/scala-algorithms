# sorts
Practice implementations of classic sort algorithms, for the sake of (re)learning some algorithms and Scala.

#Quicksort

##Summary:  
Quicksort is a divide and conquer comparison sort that exhibits O(n*log(n)) behavior on average. Its worst case O(n^2) occurs when sorting an already-sorted list.  Quicksort is unstable.

##Use Cases:
A high performance sort, Quicksort is versatile and widely used. Typically 2x-3x faster than merge sort and heapsort, except in worst cases where these alrogirthms operate in O(n*log(n)). Because it operates in-place, auxiliary space complexity can be limited to O(log(n)). Performs poorly on already-sorted lists, since partitioning can be lopsided in these cases. For very small data sets, insertion sort can be faster. Can be parallelized due to divide and concquer setup.

#Insertion Sort

##Summary:  
Insertion sort is a simple, in-place comparison sort that exhibits O(n^2) behavior on average and worst case. Insertion sort is stable.

##Use Cases:
An inefficient sort, Insertion sort is most frequently used on very small datasets due to its low constants, and can be faster than quicksort in these cases. Best case performance O(n) occurs when sorting already-sorted or nearly-sorted data. This algorithm can sort stream data and requires O(n) auxiliary space.

#Merge Sort

##Summary:
Merge sort is a divide an conquer comparison sort that exhibits O(N*log(n)) behavior in both average and worst cases. It is typically slightly slower than quicksort, and cannot be performed in-place. Merge sort is stable.

##Use Cases:
Merge sort is ideal for cases where data must be accessed sequentially, such as when reading data from slow disk or linked lists. One trade-off is the need for O(n) auxiliary space in most applications. The algorithm is the default sorting mechanism in Perl, and it plays a role in the default algorithms for Python, Java, and Octave. Can be parallelized due to divide and conquer design.

#Bubble Sort

##Summary:
Bubble sort is an exchange sort that exhibits O(n^2) in both average and worst cases. It is rarely used due to its poor performance (worse than Insertion sort). Bubble sort is stable.

##Use Cases:
Because of its terrible time complexity, Bubble sort is rarely used. One advantage is that its worst case auxiliary space complexity is O(1). It behaves reasonably fast on nearly-sorted data, but its use is rare.

#Heap Sort

##Summary:
Heap sort is a comparison sort that exhibits O(n*log(n)) behavior in average and worst cases. It typically uses an array to represent a complete binary tree max heap. As elements are popped off the heap, they are removed in reverse sorted order. Heap sort is not stable.

##Use Cases:
Heap sort is quite efficient, sorts in place (auxiliary space complexity is O(1)), and has better worst case time complexity than quicksort. Typically, however, it is slightly slower than quicksort. Less space is required than for merge sort. 

#Selection Sort

##Summary:
Selection sort is an in-place algorithm that exhibits O(n^2) performance in the best, average, and worst cases. Run time is actually always worst case. Though it typically runs faster than bubble sort, it is still very slow on large datasets. Basic selection sort is not stable.

##Use Cases:
The low time constant makes Selection sort outperform divide-and-conquer algorithms on very small (typically < 20 elements) arrays, so it is often paired with a d&c algorithm for versatility. Because the runtime is solely determined by the length of the array, this sort could be attractive for use in real-time systems. Auxiliary space complexity is limited to O(1), but the slow general performance limits the algorithm's use.

#Bucket Sort

##Summary:
Bucket sort is a distribution sort that exhibits O(n^2) worst case, but O(n+k) average performance, where k is the number of buckets. While it can be extremely fast, Bucket sort requires some additional information than comparison sorts do; namely, the maximum value of the data to be sorted. Bucket sort is stable.

##UseCases:
Because performance is directly correlated to how evenly data is distributed across the k buckets, Bucket sort is best deployed on values in a known domain, such as grade point averages, alphanumeric characters, etc, especially where data is uniformly distributed across the domain. It is frequently used as a first pass before then calling Insertion sort, as a way to boost the performance of the latter (which improves with nearly-sorted data).
