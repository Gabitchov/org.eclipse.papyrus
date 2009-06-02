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

package org.eclipse.papyrus.diagram.clazz.custom.helper;

import java.util.List;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.clazz.custom.command.PropertyCommandForAssociation;
import org.eclipse.papyrus.diagram.clazz.edit.commands.PropertyCreateCommand;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.ui.toolbox.LookForElement;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This helper contains method to help desgner to construct association
 * 
 */
public class AssociationHelper {

	public static int source = 0;
	public static int target = 1;

	/**
	 * create a association with ends
	 * 
	 * @param domain
	 *            the transactionnaleditdomain
	 * @param source
	 *            the type element source
	 * @param target
	 *            the type element target
	 * @param container
	 *            the package that will contain the association
	 * @return the association
	 */
	public static Association createSemantic(TransactionalEditingDomain domain,
			Type source, Type target, Package container) {

		AssociationClass association = UMLFactory.eINSTANCE
				.createAssociationClass();

		// create target property

		CreateElementRequest request = new CreateElementRequest(domain, source,
				UMLElementTypes.Property_3002, UMLPackage.eINSTANCE
						.getStructuredClassifier_OwnedAttribute());
		EditElementCommand c = new PropertyCreateCommand(request);
		LookForElement.getCommandStack().execute(new ICommandProxy(c));
		assert (c.getCommandResult() == null);
		assert (c.getCommandResult().getReturnValue() == null);
		Property targetProperty = (Property) c.getCommandResult()
				.getReturnValue();
		targetProperty.setType(target);
		targetProperty.setName(target.getName().toLowerCase());
		targetProperty.setLower(1);
		targetProperty.setUpper(1);
		// create source property

		request = new CreateElementRequest(domain, association,
				UMLElementTypes.Property_3002, UMLPackage.eINSTANCE
						.getAssociation_OwnedEnd());
		c = new PropertyCommandForAssociation(request);
		LookForElement.getCommandStack().execute(new ICommandProxy(c));
		assert (c.getCommandResult() == null);
		assert (c.getCommandResult().getReturnValue() == null);
		Property sourceProperty = (Property) c.getCommandResult()
				.getReturnValue();
		sourceProperty.setType(source);
		sourceProperty.setName(source.getName().toLowerCase());
		sourceProperty.setLower(1);
		sourceProperty.setUpper(1);
		List<Property> memberEnds = association.getMemberEnds();
		if ((memberEnds.indexOf(((Property) sourceProperty)) >= 0)) {
			association.getMemberEnds().move(0, ((Property) sourceProperty));
		} else {
			association.getMemberEnds().add(0, ((Property) sourceProperty));
		}
		if ((memberEnds.indexOf(((Property) targetProperty)) >= 0)) {
			association.getMemberEnds().move(1, ((Property) targetProperty));
		} else {
			association.getMemberEnds().add(1, ((Property) targetProperty));
		}

		container.getPackagedElements().add(association);
		UMLElementTypes.init_AssociationClass_2013(association);
		// ////////////////////////////////////////////////////////////////////
		return association;
	}

	/**
	 * this method is used to change the type of the end during the reconnection
	 * 
	 * @param end
	 *            source or target to change?
	 * @param association
	 *            the association where the end is changed
	 * @param newType
	 *            the new type that is the new or the new target
	 * @return the command result
	 */
	public static CommandResult reconnect(int end, Association association,
			Type newType) {

		((Property) association.getMemberEnds().get(end)).setType(newType);

		return CommandResult.newOKCommandResult(association);
	}

}
