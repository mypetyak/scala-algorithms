# sorts
Practice implementations of classic sort algorithms, for the sake of (re)learning some algorithms and Scala.

#Quicksort

##Summary:  
Quicksort is a divide and conquer comparison sort that exhibits O(n*ln(n)) behavior on average. Its worst case O(n^2) occurs when sorting an already-sorted list.  Quicksort is unstable.

##Use Cases:
A high performance sort, Quicksort is versatile and widely used. Typically 2x-3x faster than merge sort and heapsort, except in worst cases where these alrogirthms operate in O(n*ln(n)). Because it operates in-place, auxiliary space complexity can be limited to O(ln(n)). Performs poorly on already-sorted lists, since partitioning can be lopsided in these cases. For very small data sets, insertion sort can be faster. Can be parallelized due to divide and concquer setup.

#Insertion Sort

##Summary:  
Insertion sort is a simple, in-place comparison sort that exhibits O(n^2) behavior on average and worst case. Insertion sort is stable.

##Use Cases:
An inefficient sort, Insertion sort is most frequently used on very small datasets due to its low constants, and can be faster than quicksort in these cases. Best case performance O(n) occurs when sorting already-sorted or nearly-sorted data. This algorithm can sort stream data and requires O(n) auxiliary space.

#Merge Sort

##Summary:
Merge sort is a divide an conquer comparison sort that exhibits O(N*ln(n)) behavior in both average and worst cases. It is typically slightly slower than quicksort, and cannot be performed in-place. Merge sort is stable.

##Use Cases:
Merge sort is ideal for cases where data must be accessed sequentially, such as when reading data from slow disk or linked lists. One trade-off is the need for O(n) auxiliary space in most applications. The algorithm is the default sorting mechanism in Perl, and it plays a role in the default algorithms for Python, Java, and Octave. Can be parallelized due to divide and conquer design.
