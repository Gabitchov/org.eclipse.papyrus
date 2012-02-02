/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.ui.listeners;

import org.eclipse.papyrus.infra.emf.compare.ui.Activator;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;

/**
 * 
 * This listener listens the close of the editors and remove the customization manager associated to the closed editor from the map in the
 * {@link Activator}
 * 
 */
public class CloseEditorListener implements IPartListener2 {

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @param partRef
	 */
	public void partActivated(final IWorkbenchPartReference partRef) {
		//nothing to do 
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @param partRef
	 */
	public void partBroughtToTop(final IWorkbenchPartReference partRef) {
		//nothing to do 
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @param partRef
	 */
	public void partClosed(final IWorkbenchPartReference partRef) {
		final IWorkbenchPart part = partRef.getPart(false);
		if(part instanceof IEditorPart) {
			Activator.getDefault().remove((IEditorPart)part);
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @param partRef
	 */
	public void partDeactivated(final IWorkbenchPartReference partRef) {
		//nothing to do 
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @param partRef
	 */
	public void partOpened(final IWorkbenchPartReference partRef) {
		//nothing to do 
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @param partRef
	 */
	public void partHidden(final IWorkbenchPartReference partRef) {
		//nothing to do 
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @param partRef
	 */
	public void partVisible(final IWorkbenchPartReference partRef) {
		//nothing to do 
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @param partRef
	 */
	public void partInputChanged(final IWorkbenchPartReference partRef) {
		//nothing to do 
	}

}
