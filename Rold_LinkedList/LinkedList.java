import java.util.Iterator;

/**
 * Manages a Doubly-Linked List of ListNodes
 * 
 * @author OldRoldGoldenfold
 * @version 01/23/2015
 */
public class LinkedList implements Iterable<Object> {
	private ListNode head;
	private int size = 0;
	
	public LinkedList()					{													}
	public LinkedList(KeyValuePair key) {	add(key);										}
	public LinkedList(KeyValuePair[] k)	{	for(KeyValuePair key : k)	add(key);			}
	public int getSize()				{	return size;									}
	public KeyValuePair getHead()		{	return (head == null)? null : head.getValue();	}
	public Iterator<Object> iterator() 	{	return new ListNodeIterator(head);				}
	
	
	public void add(KeyValuePair k){
		ListNode in = new ListNode(k);
		switch (++size){
		case 1:	head = in;
				return;
		case 2:	head.setNext(in);
				head.setPrev(in);
				in.setNext(head);
				in.setPrev(head);
				head = (head.compareTo(in) < 0)? head : in;
				return;
		}
		ListNode temp = head;
		for (int i = 1; i < size; i++)	{
			if (temp.compareTo(in) < 0)	temp = temp.getNext();
			else {
				insert(in, temp);
				head = (head == temp)? in : head;
				return;
			}
		}
		insert(in, head);
	}
	
	
	private void insert(ListNode in, ListNode next)	{
		ListNode beforeNext = next.getPrev();
		beforeNext.setNext(in);
		in.setPrev(beforeNext);
		in.setNext(next);
		next.setPrev(in);
	}
	
	public void removeAll(KeyValuePair k){	while (remove(k)){}	}
	public boolean remove(KeyValuePair k){
		switch (size)	{
		case 0: return false;
		case 1: head = (head.getValue().compareTo(k) == 0)? null : head;
				size -= (head == null)? 1 : 0;
				return (head == null)? true : false;
		}
		ListNode temp = head;
		if	(head.getValue().compareTo(k) == 0)	{
			head = head.getNext();
			delete(temp);
			size--;
			return true;
		}
		else	{
			temp = temp.getNext();
			while (temp != head)	{
				if ( temp.getValue().compareTo(k) == 0){
					delete(temp);
					size--;
					return true;
				}
				temp = temp.getNext();
			}
		}
		return false;
	}
	
	
	private void delete(ListNode tbd)	{
		ListNode prev = tbd.getPrev();
		ListNode next = tbd.getNext();
		prev.setNext(next);
		next.setPrev(prev);
	}
	
	
	public String toString()	{
		String out = "";
		out += (head == null)? "" : head.toString();
		ListNode temp = head.getNext();
		while (temp != head)	{ 
			out += "\n" + temp.toString();
			temp = temp.getNext();
		}
		return out;
	}
}