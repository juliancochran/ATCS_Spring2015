/**
* The most confusing way to construct the LinkedList: Recursion!
* Batteries, Getters and Setters not included (Some Assembly Required).
* @author OldRoldGoldenfold
* @version 1/22/2015
**/
public class LinkedList {
	private ListNode head;
	private int size;
	
	public LinkedList(Object[] o)	{
		size = o.length;
		// my ListNode constructor takes (Object o, ListNode prev, ListNode next)
		head = new ListNode(o[0], head, head);
		head.setNext(getNextNode(o, head, 1));	
	}
	private ListNode getNextNode(Object[] o, ListNode n, int i)	{
		// my ListNode class also has a constructor that takes only (Object o)
		// and sets the others to null
		ListNode temp = (i < o.length)? new ListNode(o[i]) : head;
		if (temp != head) {
			temp.setPrev(n);
			temp.setNext(getNextNode(o, temp, ++i));
		}
		else { head.setPrev(n);	}
		return temp;
	}
}
