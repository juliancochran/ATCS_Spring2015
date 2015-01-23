/**
 * Defines a Doubly-Linked ListNode
 * @author OldRoldGoldenfold
 * @version 01/23/2015
 */
public class ListNode {
	private Object value;
	private ListNode next;
	private ListNode prev;
	
	public ListNode(Object v, ListNode p, ListNode n)	{
		value = v;
		next = n;
		prev = p;
	}
	public ListNode(Object v, ListNode p){
		value = v;
		next = null;
		prev = p;
	}
	public ListNode(Object v){
		value = v;
		next = null;
		prev = null;
	}
	public Object getValue()	{	return value;	}
	public ListNode getNext()	{	return next;	}
	public ListNode getPrev()	{	return prev;	}
	public void setValue(Object v)	{ value = v;	}
	public void setNext(ListNode n)	{ next = n;	}
	public void setPrev(ListNode p)	{ prev = p;	}
	
	
	
	
}
