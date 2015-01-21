public class StackOfStrings	{

	private Node first = null;

	private class Node	{
		String item;
		Node next;
	}

	public void push(String s)	{
		Node oldFirst = first;
		first = new Node();
		first.item = s;
		first.next = oldFirst;
	}

	public String pop()	{
		String item = first.item;
		first = first.next;
		return item;
	}

	public boolean isEmpty()	{
		return first == null;
	}

	/**
	Test client
	*/
	public static void main(String[] args)	{
		StackOfStrings stack = new StackOfStrings();
		while(!StdIn.isEmpty())	{
			String s = StdIn.readString();
			if(s.equals("-"))	{
				StdOut.print(stack.pop());
			}
			else	{
				stack.push(s);
			}
		}
	}
}