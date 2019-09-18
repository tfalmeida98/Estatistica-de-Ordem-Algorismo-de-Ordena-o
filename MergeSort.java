package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

   @Override
   public void sort(T[] array, int leftIndex, int rightIndex) {
      int n = (leftIndex + rightIndex) / 2;

      if (leftIndex < rightIndex) {
         sort(array, leftIndex, n);
         sort(array, n + 1, rightIndex);
         merge(array, leftIndex, n, rightIndex);
      }

   }

   private void merge(T[] array, int leftIndex, int middleIndex, int rightIndex) {

      T[] aux = (T[]) new Comparable[array.length];
      int indice = leftIndex;

      int n = middleIndex;
      int right = n + 1;
      int left = leftIndex;

      for (int i = left; i <= rightIndex; i++) {
         aux[i] = array[i];
      }

      while (left <= n && right <= rightIndex) {

         if (aux[left].compareTo(aux[right]) < 0) {
            array[indice] = aux[left];
            left++;
         }

         else {
            array[indice] = aux[right];
            right++;
         }

         indice++;
      }

      while (left <= n) {
         array[indice] = aux[left];
         indice++;
         left++;
      }

      while (right <= rightIndex) {
         array[indice] = aux[right];
         indice++;
         right++;
      }

   }

}
