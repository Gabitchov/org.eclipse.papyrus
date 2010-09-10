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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.creation.helper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.uml2.uml.Dependency;


/**
 * this is a default Helper for UML element
 * 
 */
public class DependencyEditHelper extends DefaultUMLHelper {

	protected ICommand getDestroyReferenceCommand(DestroyReferenceRequest req) {

		Dependency l = (Dependency)req.getContainer();
		EObject removedEnd = req.getReferencedObject();

		ICommand ddrCommand = super.getDestroyReferenceCommand(req);

		DestroyElementRequest der = new DestroyElementRequest(req.getEditingDomain(), l, false);
		der.setClientContext(req.getClientContext());
		IElementType dET = ElementTypeRegistry.getInstance().getElementType(l, req.getClientContext());

		if((l.getSources().size() == 1) && (l.getSources().contains(removedEnd))) {
			ddrCommand = CompositeCommand.compose(ddrCommand, dET.getEditCommand(der));
		}

		if((l.getTargets().size() == 1) && (l.getTargets().contains(removedEnd))) {
			ddrCommand = CompositeCommand.compose(ddrCommand, dET.getEditCommand(der));
		}

		return ddrCommand.reduce();
	}
}
