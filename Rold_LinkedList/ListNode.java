/**
 * Defines a Doubly-Linked ListNode
 * @author OldRoldGoldenfold
 * @version 01/23/2015
 */
public class ListNode implements Comparable<ListNode>{
	private KeyValuePair value;
	private ListNode next;
	private ListNode prev;
	
	public ListNode(KeyValuePair v, ListNode p, ListNode n)	{
		value = v;
		next = n;
		prev = p;
	}
	public ListNode(KeyValuePair v, ListNode p){
		value = v;
		next = null;
		prev = p;
	}
	public ListNode(KeyValuePair v){
		value = v;
		next = null;
		prev = null;
	}
	public KeyValuePair getValue()	{	return value;	}
	public ListNode getNext()	{	return next;	}
	public ListNode getPrev()	{	return prev;	}
	public void setValue(KeyValuePair v)	{ value = v;	}
	public void setNext(ListNode n)	{ next = n;	}
	public void setPrev(ListNode p)	{ prev = p;	}
	
	public String toString()	{	return value.toString();	}
	
	public int compareTo(ListNode other) {	return this.getValue().compareTo(other.getValue());	}
	
	
	
	
	
}
