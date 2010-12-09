/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper.advice;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.diagram.common.commands.UnapplyAllStereotypesCommand;
import org.eclipse.uml2.uml.Element;

/**
 * <pre>
 * This is an advice helper used to remove any stereotype application before deleting
 * a UML {@link Element}.
 * 
 * </pre>
 */
public class ElementUnapplyStereotypeHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getBeforeDestroyElementCommand(DestroyElementRequest request) {

		EObject elementToDestroy = request.getElementToDestroy();
		if(elementToDestroy instanceof Element) {
			UnapplyAllStereotypesCommand command = new UnapplyAllStereotypesCommand(request.getEditingDomain(), request.getLabel(), (Element)elementToDestroy);
			if(!command.isEmpty()) {
				return command;
			}
		}

		return null;
	}
}
