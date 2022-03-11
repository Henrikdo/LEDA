package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int n = array.length;
		for(int i = 0;i < n;i++) {
			int min = i;
			for(int j = i+1;j < n;j++) {
				if(array[j].compareTo(array[min]) < 0) {
					min = j;
				}
			}
			T temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
	}
}
