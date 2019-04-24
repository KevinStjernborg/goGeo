package assignment2;

import java.util.LinkedList;

public class Buffer<T> {
	private LinkedList<T> buffer = new LinkedList<T>();
	private boolean isEmpty;

	

	public void put(T t) {
		if(isEmpty == true) {
			buffer.addLast(t);
			isEmpty = false;

		}

	}

	public synchronized void synchronizedPut(T t) {
		if(isEmpty == true) {
			buffer.addLast(t);
			notifyAll();
			isEmpty = false;
		}
	}

	public T get() {
		while (isEmpty== false) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		isEmpty = true;
		return buffer.getLast();

	}

	public synchronized T synchronizedGet() {
		while (isEmpty == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		isEmpty = true;
		return buffer.getLast();
	}
	
	public int size() {
		return buffer.size();
	}
	
}
