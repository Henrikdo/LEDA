package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

public class RecursiveBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do bubble sort. Você deve implementar apenas esse
	 * método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int n = array.length;
		rightIndex = leftIndex + 1;
		if(n > 0) {
			if(leftIndex == n-1) {
				
			}else {
				sort(array,leftIndex+1, rightIndex);
				if(array[leftIndex].compareTo(array[rightIndex]) > 0) {
					T temp = array[leftIndex];
					array[leftIndex] = array[rightIndex];
					array[rightIndex] = temp;
					sort(array,leftIndex+1, rightIndex);
				}
			}
		}
	}


}
