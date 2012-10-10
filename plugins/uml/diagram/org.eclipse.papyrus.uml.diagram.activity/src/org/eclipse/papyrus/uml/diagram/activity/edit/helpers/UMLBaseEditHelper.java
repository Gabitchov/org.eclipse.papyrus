/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.helpers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.tooling.runtime.edit.helpers.GeneratedEditHelperBase;
import org.eclipse.papyrus.uml.diagram.common.commands.UnapplyAllStereotypesCommand;
import org.eclipse.uml2.uml.Element;

/**
 * @generated
 */
public class UMLBaseEditHelper extends GeneratedEditHelperBase {

	/**
	 * @generated NOT
	 *            handle unapply stereotypes before delete
	 */
	protected ICommand getDestroyElementCommand(DestroyElementRequest req) {
		EObject elementToDestroy = req.getElementToDestroy();
		if(elementToDestroy instanceof Element) {
			UnapplyAllStereotypesCommand command = new UnapplyAllStereotypesCommand(req.getEditingDomain(), req.getLabel(), (Element)elementToDestroy);
			if(!command.isEmpty()) {
				return command;
			}
		}
		return null;
	}
}
