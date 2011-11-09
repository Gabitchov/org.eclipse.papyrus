/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.edit.utils;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.services.edit.Activator;
import org.eclipse.papyrus.infra.services.edit.messages.Messages;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;

/**
 * This SelectionStatusValidator validate the selected object. It is assumed here the the selection
 * does not allow multiple elements.
 */
public class ElementTypeValidator implements ISelectionStatusValidator {

	/** The kind of element the selection has to match */
	IElementType elementType;

	/** Constructor */
	public ElementTypeValidator(IElementType elementType) {
		super();
		this.elementType = elementType;
	}

	/**
	 * <pre>
	 * The selection has to match the {@link IElementType} for validation.
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	public IStatus validate(Object[] selection) {

		IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, Messages.ElementTypeValidator_NoSelection);

		if((selection.length == 1) && (selection[0] instanceof EObject)) {

			// Default status : invalid
			status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind(Messages.ElementTypeValidator_InvalidSelection, elementType.getDisplayName()));

			EObject selected = (EObject)selection[0];
			if(elementType instanceof ISpecializationType) {
				if(((ISpecializationType)elementType).getMatcher().matches(selected)) {
					status = new Status(IStatus.OK, Activator.PLUGIN_ID, Messages.ElementTypeValidator_ValidSelection);
				}

			} else {
				if(elementType.getEClass().isInstance(selected)) {
					status = new Status(IStatus.OK, Activator.PLUGIN_ID, Messages.ElementTypeValidator_ValidSelection);
				}
			}
		}
		return status;
	}

}
