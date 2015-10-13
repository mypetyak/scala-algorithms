#Quicksort

##Summary:  
Quicksort is a divide and conquer comparison sort that exhibits O(n*ln(n)) behavior on average. Its worst case O(n^2) occurs when sorting an already-sorted list.  Quicksort is unstable.

##Use Cases:
A high performance sort, Quicksort is versatile and widely used. Typically 2x-3x faster than merge sort and heapsort, except in worst cases where these alrogirthms operate in O(n*ln(n)). Because it operates in-place, space complexity can be limited to O(ln(n)). Performs poorly on already-sorted lists, since partitioning can be lopsided in these cases. For very small data sets, insertion sort can be faster. Can be parallelized due to divide and concquer setup.
