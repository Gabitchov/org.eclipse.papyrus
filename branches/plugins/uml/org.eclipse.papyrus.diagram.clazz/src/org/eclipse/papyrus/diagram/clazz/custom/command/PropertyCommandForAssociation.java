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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.command;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.clazz.edit.commands.PropertyCreateCommand;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

public class PropertyCommandForAssociation extends PropertyCreateCommand {

	public PropertyCommandForAssociation(CreateElementRequest req) {
		super(req);
		// TODO Auto-generated constructor stub
	}

	/**
	 * {@inheritDoc}
	 */
	protected EObject doDefaultElementCreation() {
		Property newElement = UMLFactory.eINSTANCE.createProperty();

		Association owner = (Association) getElementToEdit();
		owner.getOwnedEnds().add(newElement);

		UMLElementTypes.init_Property_3002(newElement);
		return newElement;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected EClass getEClassToEdit() {
		return UMLPackage.eINSTANCE.getAssociation();
	}

}
