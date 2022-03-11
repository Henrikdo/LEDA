package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		MERGESORT_APPLICATIONS = 0;
		INSERTIONSORT_APPLICATIONS = 0;
		if(array.length <= SIZE_LIMIT) {
			insertionSort(array,leftIndex,rightIndex);
		}else if(array.length > SIZE_LIMIT){
			mergeSort(array,leftIndex,rightIndex);
		}
	}
	
	public void insertionSort(T[] array, int leftIndex, int rightIndex) {
		INSERTIONSORT_APPLICATIONS++;
		int n = array.length;
		for(int i = 1; i < n;i++) {
			T key = array[i];
			int j = i -1;
			while(j > -1 && (array[j].compareTo(key) > 0)) {
				array[j+1] = array[j];
				j = j - 1;
			}
			array[j+1] = key;
		}
	}
	public void mergeSort(T[] array, int leftIndex, int rightIndex) {
		MERGESORT_APPLICATIONS++;
		if(leftIndex >= rightIndex) {
			
		}else {
			int middle = (leftIndex + rightIndex)/2;
			mergeSort(array,leftIndex,middle);
			mergeSort(array,middle + 1,rightIndex);
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
