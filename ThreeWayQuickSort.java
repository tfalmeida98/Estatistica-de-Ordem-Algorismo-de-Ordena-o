package sorting.divideAndConquer.threeWayQuicksort;

import java.util.Arrays;

import sorting.AbstractSorting;

public class ThreeWayQuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * No algoritmo de quicksort, selecionamos um elemento como pivot, particionamos
	 * o array colocando os menores a esquerda do pivot e os maiores a direita do
	 * pivot, e depois aplicamos a mesma estrategia recursivamente na particao a
	 * esquerda do pivot e na particao a direita do pivot.
	 * 
	 * Considerando um array com muitoe elementos repetidos, a estrategia do
	 * quicksort pode ser otimizada para lidar de forma mais eficiente com isso.
	 * Essa melhoria eh conhecida como quicksort tree way e consiste da seguinte
	 * ideia: - selecione o pivot e particione o array de forma que * arr[l..i]
	 * contem elementos menores que o pivot * arr[i+1..j-1] contem elementos iguais
	 * ao pivot. * arr[j..r] contem elementos maiores do que o pivot.
	 * 
	 * Obviamente, ao final do particionamento, existe necessidade apenas de ordenar
	 * as particoes contendo elementos menores e maiores do que o pivot. Isso eh
	 * feito recursivamente.
	 **/
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex)
			return;

		int pivot = partition(array, leftIndex, rightIndex);
		int lastEqual = findEquals(array, leftIndex, rightIndex, pivot);
		sort(array, leftIndex, pivot - 1);
		sort(array, lastEqual + 1, rightIndex);

	}

	private int partition(T[] array, int left, int right) {
		T pivot = array[left];
		int i = left;
		for (int j = left; j <= right; j++) {
			if (array[j].compareTo(pivot) < 0) {
				i++;
				util.Util.swap(array, i, j);
			}
		}

		util.Util.swap(array, i, left);
		return i;
	}

	private int findEquals(T[] array, int left, int right, int i) {
		T pivot = array[i];
		int j = i;
		while(j <= right) {
			if(array[j].compareTo(pivot) == 0) {
				j = i;
			}
			else
				break;
		}
		return j;
	}

}
