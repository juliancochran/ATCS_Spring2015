/**
 * Key value pair encapsulates a <code>key</code>, or a 6-digit integer with
 * a <code>value</code>, a 6-character string. Used for large dataset processing.
 * @author jcochran
 * @version 01/21/2015
 */

public class KeyValuePair implements Comparable<KeyValuePair> {
	private int key;		// 6 digits
	private String value;	// 6 characters
	
	/**
	 * Default constructor
	 */
	public KeyValuePair()	{
		key = -1;
		value = new String();
	}
	
	/**
	 * Parameterized constructor
	 * @param k Supplied variable for <code>key</code>
	 * @param v Supplied variable for <code>value</code>
	 */
	public KeyValuePair(int k, String v)	{
		key = k;
		value = v;
	}
	
	/**
	 * Randomizes <code>val</code> and <code>value</code> of <code>this</code>
	 * KeyValuePair object to 6-digit <code>int</code> and 6-character <code>String</code>
	 */
	public void makeRandom()	{
		int k = 0;
		String v = "";
		String al = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int index = -1;
		int place = 1;
		for(int i = 0; i < 7; i++)	{
			k += ((int)(Math.random()*10))*place;
			place *= 10;
			index = (int)(Math.random()*al.length());
			v += al.substring(index, index+1);
		}
	}
	
	/**
	 * Implements the <code>compareTo</code> method of the <code>Comparable</code> interface.
	 * Compares two <code>KeyValuePair</code> objects based on <code>key</code> first then <code>value</code> second if <code>key</code>s are equal.
	 * @param other A <code>KeyValuePair</code> object to be compared to <code>this</code>.
	 */
	public int compareTo(KeyValuePair other)	{
		return (this.key == other.key) ? this.value.compareTo(other.value) : this.key - other.key;
	}
	
	/**
	 * Overrides <code>Object</code>'s <code>.equals</code> method.
	 * @param other Another <code>KeyValuePair</code>object disguised as an <code>Object</code> for overriding purposes.
	 */
	public boolean equals(Object other){
		if(other instanceof KeyValuePair)	{
			KeyValuePair temp = (KeyValuePair)other;
			return this.key == temp.key && this.value.equals(temp.value);
		}
		else
			return false;
	}
}
