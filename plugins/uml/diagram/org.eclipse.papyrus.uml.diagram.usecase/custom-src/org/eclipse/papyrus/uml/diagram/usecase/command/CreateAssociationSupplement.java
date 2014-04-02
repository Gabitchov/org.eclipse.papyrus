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
 *  Emilien Perico (Atos Origin) - adapt class for use case association
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.usecase.command;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.uml.diagram.common.commands.SupplementCommand;
import org.eclipse.papyrus.uml.diagram.usecase.providers.ElementInitializers;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * This is the supplement command adapted for association in use case diagram
 * 
 * @author Emilien Perico
 */
public class CreateAssociationSupplement extends SupplementCommand {

	/**
	 * this is the constructor of the supplement command for the association.
	 * 
	 * @param container
	 *        the container of the association (package)
	 * @param source
	 *        the source of the association (Type)
	 * @param target
	 *        the target of the association (Type)
	 */
	public CreateAssociationSupplement(EObject container, EObject source, EObject target, Diagram diagram) {
		super(container, source, target, diagram);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canExecute() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ConfigureRequest createConfigureRequest(ConfigureRequest request) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EObject doDefaultElementCreation(TransactionalEditingDomain domain, EObject newElement) {
		Association association = UMLFactory.eINSTANCE.createAssociation();
		// create source property
		Property sourceProperty = association.createOwnedEnd(((Type)getSource()).getName().toLowerCase(), (Type)getSource());
		sourceProperty.setLower(1);
		sourceProperty.setUpper(1);
		// create target property
		Property targetProperty = association.createOwnedEnd(((Type)getTarget()).getName().toLowerCase(), (Type)getTarget());
		targetProperty.setLower(1);
		targetProperty.setUpper(1);
		List<Property> memberEnds = association.getMemberEnds();
		if((memberEnds.indexOf(((Property)sourceProperty)) >= 0)) {
			association.getMemberEnds().move(0, ((Property)sourceProperty));
		} else {
			association.getMemberEnds().add(0, ((Property)sourceProperty));
		}
		if((memberEnds.indexOf(((Property)targetProperty)) >= 0)) {
			association.getMemberEnds().move(1, ((Property)targetProperty));
		} else {
			association.getMemberEnds().add(1, ((Property)targetProperty));
		}
		((Package)getContainer()).getPackagedElements().add(association);
		ElementInitializers.getInstance().init_Association_4011(association);
		return association;
	}
}
