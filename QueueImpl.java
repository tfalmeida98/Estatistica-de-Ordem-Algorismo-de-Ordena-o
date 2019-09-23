package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;
	

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		T element = null;
		if(! isEmpty()) {
			element = array[0];
		}
		return element;
	}

	@Override
	public boolean isEmpty() {
		boolean isEmpty = (tail == -1);
		return isEmpty;
	}

	@Override
	public boolean isFull() {
		boolean isFull = (tail == array.length);
		return isFull;
	}

	private void shiftLeft() {
		for(int i = 0; i < array.length; i++) {
			array[i] = array[i + 1];
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(! isFull()) {
			tail += 1;
			array[tail] = element;
		}
		else {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(! isEmpty()) {
			T element = array[0];
			shiftLeft();
			return element;
		}
		else {
			throw new QueueUnderflowException();
		}
	}

}
