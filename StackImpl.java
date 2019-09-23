package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		T element = null;
		if (! isEmpty())
			element = array[top];
		return element;
	}

	@Override
	public boolean isEmpty() {
		boolean isEmpy = (top == -1);
		return isEmpy;
	}

	@Override
	public boolean isFull() {
		boolean isEmpy = (top == array.length);
		return isEmpy;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (! isFull()) {
			top += 1;
			array[top] = element;
		} else {
			
			throw new StackOverflowException();
		}
	}
 
	@Override
	public T pop() throws StackUnderflowException {
		if (! isEmpty()) {
			T element = array[top]; 
			top -= 1;
			return element;
		}else {
			throw new StackUnderflowException();
		}
		
	}

}
