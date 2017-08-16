package revision.queues;
import java.util.*;
import java.lang.reflect.*;
public class CircularQueue<T extends Comparable<T>> {
	
	T[] data;
	Class c;
	int tail = -1, head = -1;
	int size = 0;
	public CircularQueue(Class<T> c) {
		data = (T[])Array.newInstance(c,10);
		this.c = c;
	}

	public CircularQueue(Class<T> c, int capacity) {
		data = (T[])Array.newInstance(c,capacity);
		this.c = c;
	}

	public void enqueue(T input) {
		this.size++;
		if (this.tail < data.length) {
			data[++this.tail]=input;
			if (this.tail == this.head) 
				this.head=-1;
		} else {
			if (this.head == -1 && this.tail == data.length-1) {
				resize();
			} else {
				this.tail = 0;
				this.data[this.tail]=input;
			}
		}
	}

	private void resize() {
		T[] newarr = (T[])Array.newInstance(c, this.data.length * 2);
		int i = head+1;
		int j = 0;
		while ( i != tail) {
			newarr[j++]=this.data[i];
			if (i == this.data.length-1) {
				i=0;
			} else {
				i++;
			}
		}
		this.data = newarr;
		this.head=-1;
		this.tail=j-1;
	}

	public T dequeue() {
		this.size--;
		T temp = null;
		if (head != tail) {
			if (tail == -1) {
				tail = this.data.length-1;
			}
			temp = this.data[tail--];
		} 

		return temp;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return (this.head==this.tail);
	}

	public static void main(String[] argv) {

		CircularQueue<Integer> cq = new CircularQueue<>(Integer.class,5);
		cq.enqueue(1);
		cq.enqueue(2);
		cq.enqueue(3);
		cq.enqueue(4);
		cq.enqueue(5);
		System.out.println(cq.size());
		System.out.println(cq.dequeue());
		System.out.println(cq.size());
		System.out.println(cq.dequeue());
		System.out.println(cq.size());
		System.out.println(cq.dequeue());
		System.out.println(cq.size());
		System.out.println(cq.dequeue());
		System.out.println(cq.size());
		System.out.println(cq.dequeue());
		System.out.println(cq.size());
		System.out.println(cq.dequeue());
	}
}