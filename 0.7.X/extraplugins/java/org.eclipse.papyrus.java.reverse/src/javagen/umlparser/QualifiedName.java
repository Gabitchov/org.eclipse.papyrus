/**
 * 
 */
package javagen.umlparser;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Instance of this class denote a qualified name of a type.
 * 
 * @author dumoulin
 * 
 */
@SuppressWarnings("serial")
public class QualifiedName extends ArrayList<String> {

	/**
     * 
     */
	public QualifiedName() {
	}

	/**
	 * @param initialCapacity
	 */
	public QualifiedName(int initialCapacity) {
		super(initialCapacity);
	}

	/**
	 * @param c
	 */
	public QualifiedName(Collection<String> c) {
		super(c);
	}

	/**
	 * Return the last name of the qualified name.
	 * This is usually the short name.
	 * 
	 * @return
	 */
	public String getName() {

		return get(size() - 1);
	}
}
