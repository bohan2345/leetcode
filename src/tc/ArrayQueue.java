package tc;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class ArrayQueue implements Queue<Object> {

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

	public int size() {
		if (r > f)
			return r - f;
		return N - f + r;
	}

	public boolean isEmpty() {
		return (r == f) ? true : false;
	}

	public boolean isFull() {
		int diff = r - f;
		if (diff == -1 || diff == N)
			return true;
		return false;
	}

	public class QueueEmptyException extends RuntimeException {

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

	public class QueueFullException extends RuntimeException {

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

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Object> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean add(Object e) {
		// TODO Auto-generated method stub
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

	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object poll() throws QueueEmptyException {
		Object item;
		if (isEmpty()) {
			throw new QueueEmptyException();
		} else {
			item = Q[f];
			Q[f] = null;
			f = (f + 1) % (N + 1);
		}
		return item;
	}

	@Override
	public Object element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		return null;
	}
}
