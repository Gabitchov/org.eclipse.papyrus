/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.notation;

import java.util.Set;

/**
 * An Interface to represent the current event-based state(s) of a View (e.g. Selection, Focus, ...)
 * 
 * @author Camille Letavernier
 * 
 */
public interface StatefulView {

	public final String HOVER = "hover";

	public final String FOCUS = "focus";

	public final String ACTIVE = "active";

	/**
	 * Changes the current state of the View, by merging the current state the states given in parameter
	 * 
	 * @param states
	 *        The states to be merged with the current state
	 */
	public void addStates(Set<String> states);

	/**
	 * Changes the current state of the View, by removing from the current state the states given in parameter
	 * 
	 * @param states
	 *        The states to be removed from the current state
	 */
	public void removeStates(Set<String> states);

	/**
	 * Returns the current list of active states for this element
	 * 
	 * @return
	 */
	public Set<String> getStates();

}
