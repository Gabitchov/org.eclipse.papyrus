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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.uml.diagram.composite.custom.messages.Messages;
import org.eclipse.papyrus.uml.diagram.composite.part.UMLDiagramEditorPlugin;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.InformationItem;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Signal;

/**
 * This SelectionStatusValidator validate the selected objects. It is assumed here that the
 * selection allow multiples elements.
 * 
 */
public class InformationItemValidator implements ISelectionStatusValidator {

	/**
	 * <pre>
	 * The selection has to be a {@link Classifier} or an {@link InformationItem} for validation.
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	public IStatus validate(Object[] selection) {

		IStatus status = new Status(IStatus.ERROR, UMLDiagramEditorPlugin.ID, Messages.NoSelectionFound);
		if(selection.length >= 1) {
			for(int i = 0; i < selection.length; i++) {
				if(selection[i] instanceof InformationItem || selection[i] instanceof Class || selection[i] instanceof Interface || selection[i] instanceof Signal || selection[i] instanceof Component)
					status = new Status(IStatus.OK, UMLDiagramEditorPlugin.ID, Messages.SelectionValidated);
				else {
					status = new Status(IStatus.ERROR, UMLDiagramEditorPlugin.ID, Messages.InformationFlowSelectInformationItem_ERROR);
					break;
				}
			}
		}
		return status;
	}
}
