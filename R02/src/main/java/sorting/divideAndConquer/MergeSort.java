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
		if(leftIndex >= rightIndex) {
			
		}else {
			int middle = (leftIndex + rightIndex)/2;
			sort(array,leftIndex,middle);
			sort(array,middle + 1,rightIndex);
			merge(array,leftIndex,middle,rightIndex);
		}
		
	}
	
	private void merge(T[] array, int leftIndex, int middle, int rightIndex) {
		T[] result = array.clone();
		for(int i = leftIndex;i <= rightIndex;i++) {
			 result[i] = array[i];
		}
		int i = leftIndex;
		int j = middle + 1;
		for(int k = leftIndex; k <= rightIndex;k++) {
			if(i > middle) {
				array[k] = result[j++];
			}else if(j > rightIndex){
				array[k] = result[i++];
			}else if(result[i].compareTo(result[j]) < 0) {
				array[k] = result[i++];
			}else {
				array[k] = result[j++];
			}
		}
	}
}
