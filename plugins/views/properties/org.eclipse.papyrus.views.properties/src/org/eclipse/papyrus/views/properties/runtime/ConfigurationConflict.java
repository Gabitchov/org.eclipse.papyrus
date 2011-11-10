/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.papyrus.views.properties.contexts.Context;

/**
 * Represents a conflict in the applied Property view configurations
 * 
 * @author Camille Letavernier
 * 
 */
public class ConfigurationConflict {

	/**
	 * The ID of the section being in conflict
	 */
	public String sectionID;

	/**
	 * The list of contexts being in conflict
	 */
	public List<Context> conflictingContexts;

	/**
	 * Constructor.
	 * 
	 * Creates a conflict descriptor for the given section ID
	 * 
	 * @param sectionID
	 *        The ID of the section being in conflict
	 */
	public ConfigurationConflict(String sectionID) {
		conflictingContexts = new LinkedList<Context>();
		this.sectionID = sectionID;
	}

	/**
	 * Adds a conflicting context
	 * 
	 * @param context
	 */
	public void addContext(Context context) {
		conflictingContexts.add(context);
	}

	@Override
	public String toString() {
		String result = sectionID + " : "; //$NON-NLS-1$
		for(Context context : conflictingContexts) {
			result += context.getName() + ", "; //$NON-NLS-1$
		}
		return result.substring(0, result.length() - 2);
	}


}
