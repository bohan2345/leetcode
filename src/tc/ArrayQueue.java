package tc;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.Queue;

public class ArrayQueue<E> extends AbstractQueue<E> implements Queue<E> {

	private static final int capacity = 5;
	private Object[] Q;
	private final int N; // capacity
	private int f = 0;
	private int r = 0;

	public ArrayQueue() {
		this(capacity);
	}

	public ArrayQueue(int capacity) {
		N = capacity;
		Q = new Object[N + 1];
	}

	@Override
	public int size() {
		if (r > f)
			return r - f;
		return N - f + r;
	}

	@Override
	public boolean isEmpty() {
		return (r == f) ? true : false;
	}

	public boolean isFull() {
		int diff = r - f;
		if (diff == -1 || diff == N)
			return true;
		return false;
	}

	@Override
	public boolean offer(Object e) throws QueueFullException {
		if (isFull()) {
			throw new QueueFullException("Queue is Full.");
		} else {
			Q[r] = e;
			r = (r + 1) % (N + 1);
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E poll() throws QueueEmptyException {
		E item;
		if (isEmpty()) {
			throw new QueueEmptyException();
		} else {
			item = (E) Q[f];
			Q[f] = null;
			f = (f + 1) % (N + 1);
		}
		return item;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public static class QueueEmptyException extends RuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public QueueEmptyException() {
			super();
		}

		public QueueEmptyException(String message) {
			super(message);
		}

		public QueueEmptyException(String message, Throwable cause) {
			super(message, cause);
		}
	}

	public static class QueueFullException extends RuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public QueueFullException() {
			super();
		}

		public QueueFullException(String message) {
			super(message);
		}

		public QueueFullException(String message, Throwable cause) {
			super(message, cause);
		}
	}
}
