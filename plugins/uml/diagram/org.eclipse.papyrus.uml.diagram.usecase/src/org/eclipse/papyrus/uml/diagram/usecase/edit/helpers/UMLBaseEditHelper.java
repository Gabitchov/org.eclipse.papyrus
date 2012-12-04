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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.usecase.edit.helpers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
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
