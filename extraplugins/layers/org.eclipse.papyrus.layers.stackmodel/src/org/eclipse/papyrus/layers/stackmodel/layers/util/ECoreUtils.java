/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers.stackmodel.layers.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;


/**
 * @author cedric dumoulin
 *
 */
public class ECoreUtils {

	/**
	 * Check if one of the ancestor is instance of the specified type.
	 * Ancestors are classes that contains this class
	 * @param child Child for which we want to check the ancestor's type
	 * @param type The expected type
	 * @return true if one of the ancestor is of the expected type. False otherwise.
	 */
	public static boolean isAncestorInstanceOf(EObject child, EClass type) {


		try {
			lookupAncestorOfType(child, type);
			return true;
		} catch (NotFoundException e) {
			return false;
		}
		    
	}
	
	/**
	 * Lookup if one of the ancestor is instance of the specified type.
	 * Ancestors are classes that contains this class
	 * @param child Child for which we want to check the ancestor's type
	 * @param type The expected type
	 * @return the first ancestor of the specified type.
	 * @throws NotFoundException If no ancestor is found.
	 */
	public static EObject lookupAncestorOfType(EObject child, EClass type) throws NotFoundException {
		    if (child != null)
		    {
		    	if( type.isInstance(child)) {
		    		return child;
		    	}

		    	int count = 0;
		      for (EObject parent = child.eContainer(); parent != null; parent = parent.eContainer())
		      {
		        if (++count > 100000)
		        {
		          return lookupAncestorOfType(child, type);
		        }
		        // Check if this is the correct type
		        if( type.isInstance(parent)) {
		        	return parent;
		        }
		        if (parent == child)
		        {
		          throw new IllegalStateException("There is a cycle in the containment hierarchy of " + child);
		        }
		      }
		    }
		    //Nothing found
		    throw new NotFoundException("No ancestor of the specified type"	);

	}
}
