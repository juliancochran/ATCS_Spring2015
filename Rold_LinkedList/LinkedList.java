import java.util.Iterator;

/**
 * Manages a Doubly-Linked List of ListNodes
 * 
 * @author OldRoldGoldenfold
 * @version 01/23/2015
 */
public class LinkedList implements Iterable<Object> {
	private ListNode head;
	private int size;

	/**
	 * adds an object to the end of the LinkedList
	 * @param o <code>Object</code> to be added
	 */
	public void append(Object o) {
		size++;
		ListNode n = new ListNode(o);
		ListNode temp = head.getPrev();
		temp.setNext(n);
		head.setPrev(n);
		n.setNext(head);
		n.setPrev(temp);
	}

	/**
	 * Constructs an empty LinkedList
	 */
	public LinkedList() {
		head = null;
		size = 0;
	}

	/**
	 * Constructs a LinkedList with a single Item
	 * @param o <code>Object</code> to be added
	 */
	public LinkedList(Object o) {
		size = 1;
		head = new ListNode(o, head, head);
	}

	/**
	 * Constructs a LinkedList from an Array of Objects
	 * @param o <code>Object[]</code> to be added
	 */
	public LinkedList(Object[] o) {
		size = o.length;
		head = new ListNode(o[0], head, head);
		head.setNext(getNextNode(o, head, 1));
	}

	/**
	 * Used by LinkedList(<code>Object[]</code>)
	 */
	private ListNode getNextNode(Object[] o, ListNode n, int i) {
		ListNode temp = (i < o.length) ? new ListNode(o[i]) : head;
		if (temp != head) {
			temp.setPrev(n);
			temp.setNext(getNextNode(o, temp, ++i));
		} else {
			head.setPrev(n);
		}
		return temp;
	}

	/**
	 * Returns each Object in the list's toString() with line breaks between
	 */
	public String toString() {
		if (head == null) {
			return "";
		}
		String out = (head.getValue().toString());
		ListNode temp = head.getNext();
		while (temp != head) {
			out += "\n" + temp.getValue().toString();
			temp = temp.getNext();
		}
		return out;
	}

	/**
	 * returns the first Node in the List
	 * @return <code>ListNode</code> head
	 */
	public ListNode getHead() {
		return head;
	}

	/**
	 * returns the size of the list
	 * @return <code>int</code> size
	 */
	public int getSize() {	return size;	}

	/**
	 * Implements the Iterator Interface
	 */
	public Iterator<Object> iterator() {	return new ListNodeIterator(head);	}

	/**
	 * If the item is present, removes the first instance and returns true.
	 * Returns false if the Object is not present.
	 * 
	 * @param o <code>Object</code> to be removed
	 * @return
	 */
	public boolean removeObject(Object o) {
		ListNode temp = head;
		if (size == 0)
			return false;
		if (head.getValue().equals(o)) {
			delete(head);
			size--;
			return true;
		}
		temp = head.getNext();
		while (temp != head) {
			if (temp.getValue().equals(o)) {
				delete(temp);
				size--;
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}

	private void delete(ListNode n) {
		if (size == 1) {
			head = null;
			return;
		}
		if (n == head) {
			head = n.getNext();
		}
		ListNode prev = n.getPrev();
		ListNode next = n.getNext();
		prev.setNext(next);
		next.setPrev(prev);

	}

	/**
	 * If an Object is present, removes all instances and returns true. If the
	 * Object is not present, returns false.
	 * @param o <code>Object</code> to be eliminated
	 * @return 
	 */
	public boolean removeAllObject(Object o) {
		boolean contains = false;
		while (removeObject(o)) {
			contains = true;
		}
		return contains;
	}

	/**
	 * Adds an array of Objects to the end of the LinkedList
	 * 
	 * @param o <code>Object[]</code> to be deleted
	 */
	public void append(Object[] o) {
		LinkedList temp = new LinkedList(o);
		if (head == null)
			head = temp.getHead();
		else {
			ListNode oldTail = getTail();
			ListNode tempHead = temp.getHead();
			ListNode newTail = temp.getTail();
			oldTail.setNext(tempHead);
			tempHead.setPrev(oldTail);
			newTail.setNext(head);
			head.setPrev(newTail);
		}
		size += temp.getSize();
	}

	/**
	 * returns the last node in the list.
	 * 
	 * @return
	 */
	public ListNode getTail() {
		return head.getPrev();
	}

	/**
	 * Adds a node to the end of a List.
	 * @param n <code>ListNode</code> to be added
	 */
	public void append(ListNode n) {
		if (head == null)
			head = n;
		else {
			ListNode prev = getTail();
			prev.setNext(n);
			n.setPrev(prev);
			head.setPrev(n);
			n.setNext(head);
		}
		size += 1;
	}

	/**
	 * finds an object and makes it the
	 * first item in the list
	 * @param o <code>Object</code> to be found
	 * @return
	 */
	public boolean findMTF(Object o) {
		ListNode temp = head;
		if (head.getValue().equals(o))
			return true;
		temp = head.getNext();
		while (temp != head) {
			if (temp.getValue().equals(o)) {
				head = temp;
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}

	/**
	 * finds an Object in the list and swaps it with the current first item, 
	 * without changing the position of the other items
	 * @param o <code>Object</code> to be found
	 * @return
	 */
	public boolean findTranspose(Object o) {
		if (size == 0) {	return false;	}
		ListNode temp = head;
		if (head.getValue().equals(o)) {	return false;	}
		temp = temp.getNext();
		while (temp != head) {
			if (temp.getValue().equals(o)) {
				ListNode afterHead = head.getNext();
				ListNode beforeHead = head.getPrev();
				ListNode afterTemp = temp.getNext();
				ListNode beforeTemp = temp.getPrev();
				if (afterHead == temp) {
					temp.setNext(head);
					head.setPrev(temp);
				} else {
					temp.setNext(afterHead);
					afterHead.setPrev(temp);
					head.setPrev(beforeTemp);
					beforeTemp.setNext(head);
				}
				if (beforeHead == temp) {
					temp.setPrev(head);
					head.setNext(temp);

				} else {
					temp.setPrev(beforeHead);
					beforeHead.setNext(temp);
					head.setNext(afterTemp);
					afterTemp.setPrev(head);
				}
				head = temp;
				return true;
			}
			temp = temp.getNext();
		}
		System.err.println("Item not found!");
		return false;
	}

	/**
	 * finds the first index of the <code>Object</code>
	 * @param o <code>Object</code>
	 * @return first index of o, -1 if not found
	 */
	public int indexOf(Object o){
		ListNode temp = head;
		for (int i = 0; i < size; i++){
			if (temp.getValue().equals(o)) return i;
			temp = temp.getNext();
		}
		return -1;
	}

	/**
	 * returns the object stored at a certain
	 * @param o <code>int</code> index
	 * @return <code>Object</code>
	 */
	public Object get(int o){
		ListNode temp = head;
		for (int i = 0; i < size; i++)	{
			if (i == o) return temp.getValue();
			temp = temp.getNext();
		}
		System.err.println("Item Not Found!");
		return null;
	}

}
