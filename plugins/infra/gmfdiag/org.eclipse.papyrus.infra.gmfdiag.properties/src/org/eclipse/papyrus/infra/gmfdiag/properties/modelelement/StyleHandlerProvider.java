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
package org.eclipse.papyrus.infra.gmfdiag.properties.modelelement;

import org.eclipse.papyrus.infra.constraints.constraints.Constraint;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElement;

/**
 * 
 * Provides a ModelElement and a Constraint implementation for a given
 * selection.
 * 
 * More than one implementation can be provided, with different priorities,
 * so that the Appearance property view can be used to edit different models,
 * in different contexts (e.g. Notation model, CSS stylesheet, Preferences...)
 * 
 * The Providers can be registered through the extension point:
 * org.eclipse.papyrus.infra.gmfdiag.properties.stylehandler
 * 
 * @author Camille Letavernier
 * 
 */
//TODO: Can this be generalized to the whole property view framework?
public interface StyleHandlerProvider {

	/**
	 * Returns a Constraint implementation
	 * 
	 * @return
	 */
	public Constraint createConstraint();

	/**
	 * Tests whether this provider can handle the given selection.
	 * 
	 * @param selection
	 * @return
	 */
	public boolean isProviderFor(Object selection);

	/**
	 * Returns a ModelElement for the given selection. This method can only be
	 * called when {@link #isProviderFor(Object)} returns true for the given
	 * selection.
	 * 
	 * @param selection
	 * @param context
	 * @return
	 */
	public ModelElement createModelElement(Object selection, DataContextElement context);
}
