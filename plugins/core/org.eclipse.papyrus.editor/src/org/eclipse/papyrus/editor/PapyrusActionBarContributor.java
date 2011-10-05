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

package org.eclipse.papyrus.editor;

import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.multidiagram.actionbarcontributor.CoreComposedActionBarContributor;
import org.eclipse.ui.IEditorActionBarContributor;


/**
 * EditorActionBarContributor suitable to Papyrus multi editor.
 * This ActionBarContributor is composed of ActionBarContributor described in extension.
 * It also implements interfaces requested by some well knowns Papyrus nested
 * editors (EMF, GMF, ...)
 * 
 * @author dumoulin
 * 
 */
public class PapyrusActionBarContributor extends CoreComposedActionBarContributor implements IMenuListener {


	public PapyrusActionBarContributor() throws BackboneException {
		super();
	}

	/**
	 * Methods requested by EMF nested diagrams.
	 * Propagate the call to the currently active contributor.
	 * 
	 * @see org.eclipse.jface.action.IMenuListener#menuAboutToShow(org.eclipse.jface.action.IMenuManager)
	 * @param manager
	 * 
	 */
	public void menuAboutToShow(IMenuManager manager) {
		IEditorActionBarContributor contributor = getActiveContributor();
		if(contributor != this && contributor instanceof IMenuListener) {
			((IMenuListener)contributor).menuAboutToShow(manager);
			return;
		}

	}

}
