/**
* The most confusing way to construct the LinkedList: Recursion!
* Batteries, Getters and Setters not included.
* @author OldRoldGoldenfold
* @version 1/22/2015
**/
public class LinkedList {
	private ListNode head;
	private int size;
	
	public LinkedList(Object[] o)	{
		size = o.length;
		head = new ListNode(o[0]);
		head.setNext(getNextNode(o, head, 1));
	}
	
	private ListNode getNextNode(Object[] o, ListNode n, int i)	{
		ListNode temp = (i < o.length)? new ListNode(o[i]) : null;
		if (temp != null) {
			temp.setPrev(n);  //this could be done in the initialization of temp,
			                  //but I can't predict everyone's constructor methods
			temp.setNext(getNextNode(o, temp, ++i));
		}
		return temp;
	}
}
