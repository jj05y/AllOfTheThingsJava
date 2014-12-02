package structures;

import interFaces.List;
import interFaces.Position;
import exceptions.BoundaryViolationException;
import exceptions.ListEmptyException;

public class LinkedList implements List {

	private class Node implements Position {
		Node previous;
		Node next;
		Object element;

		public Node(Object element) {
			this.element = element;
		}

		public Object element() {
			return element;
		}

	}

	private int size;
	private Node first;
	private Node last;

	public LinkedList() {
		size = 0;
		first = null;
		last = null;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public Position first() throws ListEmptyException {
		if (first == null)
			throw new ListEmptyException();

		return first;
	}

	public Position last() throws ListEmptyException {
		if (last == null)
			throw new ListEmptyException();

		return last;
	}

	public Position prev(Position p) throws BoundaryViolationException {
		Node n = (Node) p;
		if (n == first) {
			throw new BoundaryViolationException();
		}
		return n.previous;
	}

	public Position next(Position p) throws BoundaryViolationException {
		Node n = (Node) p;
		if (n == last) {
			throw new BoundaryViolationException();
		}
		return n.next;
	}

	public Position insertFirst(Object e) {
		Node node = new Node(e);
		if (first == null) {
			last = node;
		} else {
			first.previous = node;
		}
		node.next = first;
		first = node;
		size++;
		return node;
	}

	public Position insertLast(Object e) {
		Node node = new Node(e);

		if (last == null) { // first creation
			first = node;
		} else {
			last.next = node;
		}
		node.previous = last;
		last = node;
		size++;
		return node;
	}

	public Position insertBefore(Position p, Object e) {
		Node n = (Node) p;

		if (p == first) {
			return insertFirst(e);
		}

		Node node = new Node(e);

		node.previous = n.previous;
		node.next = n;
		n.previous.next = node;
		n.previous = node;

		size++;
		return node;

	}

	public Position insertAfter(Position p, Object e) {
		Node n = (Node) p;

		if (p == last)
			return insertLast(e);

		Node node = new Node(e);

		node.next = n.next;
		node.previous = n;
		n.next.previous = node;
		n.next = node;

		size++;
		return node;
	}

	public Object replace(Position p, Object e) {
		Node n = (Node) p;
		Object temp = n.element;
		n.element = e;
		return temp;
	}

	public Object remove(Position p) throws ListEmptyException {
		if (size == 0) {
			throw new ListEmptyException();
		} else {
			Node n = (Node) p;

			if (p == first) {
				first = first.next;
			} else if (p == last) {
				last = last.previous;
			} else {
				n.previous.next = n.next;
			}

			size--;

			return n.element;
		}
	}

	public String toString() {
		StringBuilder message = new StringBuilder("Size: " + size + " \t");
		Node n = first;

		while (n != null) {
			message.append( n.element + " ");
			// System.out.println(n.element);
			n = n.next;
		}

		return new String(message);

	}
}
