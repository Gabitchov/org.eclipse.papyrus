/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.multidiagram.actionbarcontributor;

import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.ui.part.EditorActionBarContributor;

/**
 * Descriptor of an ActionBarContributor. This descriptor is usually loaded from the Eclipse
 * extension mechanism.
 * 
 * @author Cedric Dumoulin
 * @author Patrick Tessier
 * 
 */
public class ActionBarContributorDescriptor {

	protected Class<? extends EditorActionBarContributor> contextClass;

	protected String contextId;

	/**
	 * Instance is created when requested.
	 */
	protected EditorActionBarContributor instance = null;

	/**
	 * constructor.
	 * 
	 * @return the context descriptor
	 * @throws BackboneException
	 */
	protected EditorActionBarContributor getActionBarContributor() throws BackboneException {
		if (instance == null)
			instance = createActionBarContributor();

		return instance;
	}

	private EditorActionBarContributor createActionBarContributor() throws BackboneException {
		try {
			EditorActionBarContributor context = contextClass.newInstance();
			return context;

		} catch (SecurityException e) {
			// Lets propagate. This is an implementation problem that should be solved by
			// programmer.
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			// Lets propagate. This is an implementation problem that should be solved by
			// programmer.
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			// Lets propagate. This is an implementation problem that should be solved by
			// programmer.
			throw new RuntimeException(e);
		}
	}

} // end class