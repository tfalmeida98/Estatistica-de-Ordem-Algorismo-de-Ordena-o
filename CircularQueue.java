package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head; 
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(! isFull()) {
			tail += 1;
			array[tail] = element;
			if (tail == array.length + 1)
				tail = 0;

		}else {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (! isEmpty()) {
			T element = array[head];
			head += 1;
			if(head == array.length +1)
				head = 0;
			return element;
		}else {
			throw new QueueUnderflowException ();
		}
		
	}

	@Override
	public T head() {
		T element = null;
		if (! isEmpty())
			element = array[head];
		return element;
	}

	@Override
	public boolean isEmpty() {
		boolean isEmpty = elements == 0;
		return isEmpty;
	}

	@Override
	public boolean isFull() {
		boolean isEmpty = elements == array.length;
		return isEmpty;
	}

}
