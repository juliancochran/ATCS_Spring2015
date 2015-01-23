import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterates through the Doubly Linked List
 * @author OldRoldGoldenfold
 * @version 01/23/2015
 */
public class ListNodeIterator implements Iterator<Object>{
	private ListNode next;
	private ListNode head;
	private boolean isFirstIteration;
	
	
	
	public ListNodeIterator(ListNode n){
		next = n;
		head = n;
		isFirstIteration = true;
	}

	public boolean hasNext() {	return (isFirstIteration)? !(head == head.getNext()) : (next != head);	}

	public Object next() {
		if (isFirstIteration)	{
			isFirstIteration = false;
			next = next.getNext();
			return head.getValue();
		}
		else if (next == head)	{
			throw new NoSuchElementException();
		}
		else {
			ListNode temp = next;
			next = next.getNext();
			return temp.getValue();
		}
	}

	public void remove() { throw new UnsupportedOperationException();}
	
}
