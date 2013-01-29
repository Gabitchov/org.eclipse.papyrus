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
package org.eclipse.papyrus.uml.diagram.common.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.editparts.AppliedStereotypeConpartmentEditPart;

/**
 * the goal of this command is to create a basic compartment in the notation that represent a compartment of stereotypes
 *
 */
public class CreateAppliedStereotypeViewCommand extends RecordingCommand {
	
	protected View owner;
	protected EObject StereotypeApplication;
	protected boolean displayit=false;
	
	/**
	 * 
	 * Constructor.
	 *
	 * @param domain
	 * @param owner
	 * @param StereotypeApplication
	 * @param displayit
	 */
	public CreateAppliedStereotypeViewCommand(TransactionalEditingDomain domain,View owner, EObject StereotypeApplication, boolean displayit) {
		super(domain,"CreateStereotypeCompartment");
		this.owner = owner;
		this.StereotypeApplication=StereotypeApplication;
		this.displayit=displayit;
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public void doExecute() {
		Node compartment = NotationFactory.eINSTANCE.createBasicCompartment();
		compartment.setVisible(displayit);
		compartment.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		TitleStyle ts = NotationFactory.eINSTANCE.createTitleStyle();
		ts.setShowTitle(true);
		compartment.getStyles().add(ts);
		compartment.setElement(StereotypeApplication);
		compartment.setType(AppliedStereotypeConpartmentEditPart.ID);
		ViewUtil.insertChildView(owner, compartment, ViewUtil.APPEND, false);
		compartment.setMutable(true);
	}

}
