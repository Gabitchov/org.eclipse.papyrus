/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.runtime;

import java.util.Set;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.properties.contexts.Context;
import org.eclipse.papyrus.properties.contexts.View;

/**
 * An interface representing a Constraint Engine.
 * The Constraint Engine is responsible for retrieving the views
 * to display for a given ISelection.
 * 
 * @author Camille Letavernier
 */
public interface ConstraintEngine {

	/**
	 * Return the views corresponding to the given ISelection, or an Empty set
	 * if no matching view can be found.
	 * 
	 * @param forSelection
	 *        The selection from which to retrieve the views
	 * @return
	 *         The views corresponding to the given selection
	 */
	public Set<View> getViews(ISelection forSelection);

	/**
	 * Adds a {@link Context} to this ConstraintEngine. The context is used to
	 * retrieve the set of views this ConstraintEngine can return when matching
	 * a selection.
	 * 
	 * @param context
	 */
	public void addContext(Context context);

	/**
	 * Informs this ConstraintEngine that the set of enabled contexts has changed.
	 * If the method {@link #addContext(Context)} has been called, the {@link #contextChanged()} won't be called. However, if a context has been
	 * removed or edited, the {@link #contextChanged()} method will be called.
	 */
	public void contextChanged();

}
