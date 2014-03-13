/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.uml.diagram.composite.part.UMLDiagramEditorPlugin;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.uml2.uml.ConnectableElement;

/**
 * This SelectionStatusValidator validate the selected object. It is assumed here the the selection
 * does not allow multiple elements.
 * 
 */
public class CollaborationRoleValidator implements ISelectionStatusValidator {

	/**
	 * <pre>
	 * The selection has to be a {@link ConnectableElement} for validation.
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	public IStatus validate(Object[] selection) {

		IStatus status = new Status(IStatus.ERROR, UMLDiagramEditorPlugin.ID, "No selection found.");

		if(selection.length == 1) {
			if(selection[0] instanceof ConnectableElement) {
				status = new Status(IStatus.OK, UMLDiagramEditorPlugin.ID, "Selection validated.");
			} else {
				status = new Status(IStatus.ERROR, UMLDiagramEditorPlugin.ID, "Selection has to be a ConnectableElement.");
			}
		}
		return status;
	}

}
