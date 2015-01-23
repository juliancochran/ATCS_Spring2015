/**
 * Interface Dictionary provides specifications and
 * running requirements for a Dictionary ADT.
 * Your MTF, Transpose and Binary classes all must
 * implement this interface and define the functionality
 * of the following methods.
 * @author Julian Cochran
 * @version January 13, 2014
 */
public interface Dictionary {
	/**
	 * Re-initiallize the dictionary. Clears contents
	 * and de-allocates memory to prevent memory leaks.
	 */
	void clear();
	
	/**
	 * Inserts a record based on the organizational
	 * strategy and structure of the dictionary.
	 * @param kvp The key-value pair to be inserted.
	 */
	void insert(Comparable kvp);
	
	/**
	 * Remove and return the record pointed to by kvp.
	 * If that record does not exist, return null.
	 * @param kvp The key-value pair to be removed.
	 * @return The kvp item, if it exists, otherwise null.
	 */
	Object remove(Comparable kvp);
	
	/**
	 * Find the record pointed to by kvp and return it.
	 * @param kvp The key-value pair to be retrieved.
	 * @return The kvp item, if it exists, otherwise null.
	 */
	Object find(Comparable kvp);
	
	/**
	 * Returns the number of items in this dictionary.
	 * Programmer should modify the number of items in the
	 * dictionary in the insert and remove methods.
	 * @return The number of KVP items in the dictionary.
	 */
	int size();
}
