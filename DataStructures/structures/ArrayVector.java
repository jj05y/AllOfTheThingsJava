package structures;

import interFaces.Vector;

import java.util.Arrays;

import exceptions.RankOutOfBoundsException;

public class ArrayVector implements Vector {

	private int size;
	private Object[] A;

	public ArrayVector(int capacity) {
		A = new Object[capacity];
		size = 0;
	}

	public ArrayVector() {
		A = new Object[1000];
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public Object elemAtRank(int rank) throws RankOutOfBoundsException {
		if (rank > size-1 || rank < 0)  {
			throw new RankOutOfBoundsException();
		} else {
			return A[rank];
		}
	}

	public Object replaceAtRank(int rank, Object element)
			throws RankOutOfBoundsException {
		if (rank > size -1 || rank < 0) {
			throw new RankOutOfBoundsException();
		} else {
			A[rank] = element;
			return A[rank];
		}
	}

	public void insertAtRank(int rank, Object element)
			throws RankOutOfBoundsException {
		if (rank > size  || rank < 0) {
			throw new RankOutOfBoundsException();
		} else {
			if (size == A.length) {
				A = Arrays.copyOf(A, A.length * 2);
			}
			for (int i = size; i > rank; i--) { // shuffle everyone along,
				A[i] = A[i-1];
			}
			A[rank] = element;
			size++;
		}
	}

	public Object removeAtRank(int rank) throws RankOutOfBoundsException {

		if (rank > size -1 || rank < 0) {
			throw new RankOutOfBoundsException();
		} else {
			Object removed = A[rank]; // hold onto to it to return it,

			for (int i = rank; i < size - 1; i++) {
				A[i] = A[i + 1];
			}
			A[size - 1] = null;
			size--;
			return removed;
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Size: " + size() + ":\t");
		for (int i = 0; i < size; i++) {
			sb.append(A[i] + " ");
		}

		return new String(sb);
	}

}