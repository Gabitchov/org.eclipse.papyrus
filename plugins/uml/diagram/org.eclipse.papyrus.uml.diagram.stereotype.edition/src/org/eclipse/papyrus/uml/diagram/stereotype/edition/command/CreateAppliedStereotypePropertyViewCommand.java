/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.stereotype.edition.command;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.editpart.AppliedStereotypePropertyEditPart;
import org.eclipse.uml2.uml.Property;

/**
 * the goal of this command is to create a basic compartment in the notation that represent a compartment of stereotypes
 *
 */
public class CreateAppliedStereotypePropertyViewCommand extends RecordingCommand {
	
	protected View owner;
	protected Property property;
	
	public CreateAppliedStereotypePropertyViewCommand(TransactionalEditingDomain domain,View owner, Property property) {
		
		super(domain, "CreateStereotypePropertyView");
		this.owner = owner;
		this.property=property;
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public void doExecute() {
		
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(AppliedStereotypePropertyEditPart.ID);
		ViewUtil.insertChildView(owner, node, -1, false);
		node.setElement(property);
		node.setMutable(true);
		

		
	}

}
