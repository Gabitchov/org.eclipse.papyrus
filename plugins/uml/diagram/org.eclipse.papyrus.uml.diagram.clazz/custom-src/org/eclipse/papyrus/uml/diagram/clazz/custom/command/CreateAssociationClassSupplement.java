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
package org.eclipse.papyrus.uml.diagram.clazz.custom.command;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.PropertyForComponentCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.providers.ElementInitializers;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.commands.SupplementCommand;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This is the supplement command adapted for association
 * 
 */
public class CreateAssociationClassSupplement extends SupplementCommand {

	private CreateRelationshipRequest request;

	/**
	 * this is the constructor of the supplement command for the association
	 * 
	 * @param container
	 *        the container of the association (package)
	 * @param source
	 *        the source of the association (Type)
	 * @param target
	 *        the target of the association (Type)
	 */
	public CreateAssociationClassSupplement(EObject container, EObject source, EObject target) {
		super(container, source, target);
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
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public EObject doDefaultElementCreation(TransactionalEditingDomain domain, EObject newElement) {
		AssociationClass association = UMLFactory.eINSTANCE.createAssociationClass();
		// create target property
		CreateElementRequest request = new CreateElementRequest(domain, getSource(), UMLElementTypes.Property_3002, UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute());
		EditElementCommand c = new PropertyForComponentCreateCommand(request);
		try {
			c.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assert (c.getCommandResult() == null);
		assert (c.getCommandResult().getReturnValue() == null);
		Property targetProperty = (Property)c.getCommandResult().getReturnValue();
		targetProperty.setType((Type)getTarget());
		targetProperty.setName(((Type)getTarget()).getName().toLowerCase());
		targetProperty.setLower(1);
		targetProperty.setUpper(1);
		// create source property
		request = new CreateElementRequest(domain, association, UMLElementTypes.Property_3002, UMLPackage.eINSTANCE.getAssociation_OwnedEnd());
		c = new PropertyCommandForAssociation(request);
		try {
			c.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assert (c.getCommandResult() == null);
		assert (c.getCommandResult().getReturnValue() == null);
		Property sourceProperty = (Property)c.getCommandResult().getReturnValue();
		sourceProperty.setType((Type)getSource());
		sourceProperty.setName(((Type)getSource()).getName().toLowerCase());
		sourceProperty.setLower(1);
		sourceProperty.setUpper(1);
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
		ElementInitializers.getInstance().init_AssociationClass_2013(association);
		// ////////////////////////////////////////////////////////////////////
		return association;
	}

	public void setRequest(CreateRelationshipRequest request) {
		this.request = request;
	}
}
