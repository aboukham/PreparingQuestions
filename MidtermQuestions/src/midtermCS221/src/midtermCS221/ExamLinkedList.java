package PreparingQuestions.MidtermQuestions.src.midtermCS221.src.midtermCS221;

import java.util.Iterator;

public class ExamLinkedList<E> implements Iterable<E>{

	private static class Node<E> {

		private E data;
		private Node<E> next = null;

		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}

		public Node(E data) {
			this(data, null);
		}
	}

	public class MyIterator implements Iterator<E> {
		Node<E> current = head;

		@Override
		public boolean hasNext() {
			return (current != null);
		}

		@Override
		public E next() {
			E item = current.data;
			current = current.next;
			return item;
		}
	}
	@Override
	public Iterator<E> iterator() {
		return new MyIterator();
	}


	private Node<E> head = null;
	private int size = 0;


	private void addFirst(E item) {

		head = new Node<E>(item, head);
		size++;
	}

	private void addAfter(Node<E> node, E item) {
		node.next = new Node<E>(item, node.next);
		size++;
	}

	private E removeFirst() {
		Node<E> temp = head;
		if (head != null) {
			head = head.next;
		}
		if (temp != null) {
			size--;
			return temp.data;
		} else { 
			return null;
		}
	}

	private E removeAfter(Node<E> node) {
		Node<E> temp = node.next;
		if (temp != null) {
			node.next = temp.next;
			size--;
			return temp.data;
		} else {
			return null;
		}
	}


	private Node<E> getNode(int index) {
		Node<E> node = head;
		for (int i = 0; i < index && node != null; i++) {
			node = node.next;
		}
		return node;
	}


	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		Node<E> node = getNode(index);
		return node.data;
	}


	public E set(int index, E newValue) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		Node<E> node = getNode(index);
		E result = node.data;
		node.data = newValue;
		return result;
	}

	public void add(int index, E item) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		if (index == 0) {
			addFirst(item);
		} else {
			Node<E> node = getNode(index - 1);
			addAfter(node, item);
		}
	}


	public void addLast(E item) {
		add(size, item);
	}


	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		Node<E> removedNode = null;
		if (index == 0) {
			return removeFirst();
		} else {
			Node<E> node = getNode(index - 1);
			return removeAfter(node);
		}
	}

	int size() {
		return size;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node p = head;
		if (p != null) {
			while (p.next != null) {
				sb.append(p.data.toString());
				sb.append(" ==> ");
				p = p.next;
			}
			sb.append(p.data.toString());
		}
		sb.append("]");
		return sb.toString();
	}

	public boolean removeItem(E item) {
		if (head == null) {
			return false;
		}
		Node<E> current = head;
		if (item.equals(current.data)) {
			removeFirst();
			return true;
		}
		while (current.next != null) {
			if (item.equals(current.next.data)) {
				removeAfter(current);
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public void addBeforeItem(E bitem, E item) {

		if (head == null)
			return;
		if (head.data.equals(bitem)) {
			addFirst(item);
			return;

		}
		Node<E> prev = null;
		Node<E> cur = head;

		while (cur != null && !cur.data.equals(bitem)) {
			prev = cur;
			cur = cur.next;
		}
		
		if (cur != null)
			prev.next = new Node<E>(item, cur);
		    size++;

	}

	public void addBeforeIndex(int index, E item) {
		if (index < 0) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		if (index == 0) {
			head = new Node(item, head);
			size++;
		} else {
			int i = index;
			Node<E> current = head;
			while (current != null && --i > 0) {
				current = current.next;
			}
			if (i == 0) {
				current.next = new Node(item, current.next);
				size++;
			} else {
				throw new IndexOutOfBoundsException(Integer.toString(index));
			}
		}
	}

	/*public int Q3B_countGreaterThan(int target){
		// TODO write your implementation here ...
		int count = 0;
		Node<E> current = head;
		while (current != null){
			if ((int)current.data > target)
				count++;
			current = current.next;
		}
		return count;
	}*/


	public int Q3B_countGreaterThan(int target){
		// TODO write your implementation here ...
		int count = 0;
		Iterator<E> iter = this.iterator();
		while (iter.hasNext()){
			if ((int)iter.next() > target)
				count++;
		}
		return count;
	}

	//create copy of node that exist in the given index in the list and add it in the first.

	public void crateCopyInFirst(int index){
		Node<E> node = getNode(index);
		addFirst(node.data);
	}

	public static void main(String args[]) {
		ExamLinkedList<Integer> sll = new ExamLinkedList<Integer>();

		sll.addLast(56);
		sll.addLast(45);
		sll.addLast(80);
		sll.addLast(10);
		sll.addLast(90);

		System.out.println(sll);
		sll.crateCopyInFirst(2);
		System.out.println(sll);
		//sll.addBeforeIndex(3, 77);
		//System.out.println(sll);
		//System.out.println(sll.Q3B_countGreaterThan(60));
		// Expected answer: 2

	}
}

