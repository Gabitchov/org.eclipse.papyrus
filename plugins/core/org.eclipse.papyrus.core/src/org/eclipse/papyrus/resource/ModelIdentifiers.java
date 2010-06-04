/**
 * 
 */
package org.eclipse.papyrus.resource;

import java.util.ArrayList;


/**
 * A collection of Identifiers identifying Models.
 * 
 * @author cedric dumoulin
 *
 */
public class ModelIdentifiers extends ArrayList<String> {

	public ModelIdentifiers(String ... modelIdentifiers) {
		
		for(String identifier : modelIdentifiers)
		{
			add(identifier);
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
