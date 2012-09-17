/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.ui;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.uml2.uml.CollaborationUse;

/**
 * This class is a basic content provider that assumes a {@link CollaborationUse} is given as the
 * root parent, and that will calculate the possible roles that can be used for binding.
 * 
 */
public class CollaborationRoleTreeContentProvider implements ITreeContentProvider {

	/**
	 * 
	 * {@inheritDoc}
	 */
	public Object[] getChildren(Object parentElement) {
		// no implementation needed.
		return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public Object getParent(Object element) {
		// no implementation needed.
		return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public boolean hasChildren(Object element) {
		// no implementation needed.
		return false;
	}

	/**
	 * <pre>
	 * This method returns the role referenced by the {@link Collaboration} that is 
	 * the type of the {@link CollaborationUse}.
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	public Object[] getElements(Object inputElement) {
		Object[] children = null;

		if(inputElement instanceof CollaborationUse) {
			CollaborationUse parentUMLElement = (CollaborationUse)inputElement;
			if(parentUMLElement.getType() != null) {
				children = parentUMLElement.getType().getCollaborationRoles().toArray();
			}
		}
		return children;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void dispose() {
		// no implementation needed.
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// no implementation needed.
	}

}
