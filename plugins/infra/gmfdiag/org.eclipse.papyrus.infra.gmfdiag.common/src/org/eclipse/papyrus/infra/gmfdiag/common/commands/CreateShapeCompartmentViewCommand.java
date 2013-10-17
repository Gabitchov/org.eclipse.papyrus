/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.commands;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IShapeCompartmentEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.providers.ThemeInitializerManager;

/**
 * Command to create the compartment displaying shapes for an element
 */
public class CreateShapeCompartmentViewCommand extends RecordingCommand {

	/** owner of the compartment view to create */
	private View owner;

	/** booelan that indicates if the comaprtment has to be visible or not */
	private boolean isVisible;

	/**
	 * Creates a new CreateShapeCompartmentViewCommand.
	 * 
	 * @param domain
	 *        editing domain used to manipulate model
	 * @param label
	 *        the label of the command
	 * @param description
	 *        description of the command
	 */
	public CreateShapeCompartmentViewCommand(TransactionalEditingDomain domain, String label, String description, View owner, boolean isVisible) {
		super(domain, label, description);
		this.owner = owner;
		this.setVisible(isVisible);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doExecute() {
		// FIXME should use here a view factory...
		Node compartment = NotationFactory.eINSTANCE.createBasicCompartment();
		compartment.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		TitleStyle ts = NotationFactory.eINSTANCE.createTitleStyle();

		compartment.getStyles().add(ts);
		compartment.setType(IShapeCompartmentEditPart.VIEW_TYPE);
		ViewUtil.insertChildView(owner, compartment, ViewUtil.APPEND, false);

		//Bug 417178: The CSS Engine shall support compartments
		//Avoid preference-based or hard-coded initialization (CSS Compatibility)
		if(ThemeInitializerManager.instance.usePreferenceInitializer(compartment)) {
			ts.setShowTitle(false);
			compartment.setVisible(isVisible());
			compartment.setMutable(false);
		}
	}

	/**
	 * Returns <code>true</code> if the created compartment should be visible
	 * 
	 * @return <code>true</code> if the created compartment should be visible
	 */
	public boolean isVisible() {
		return isVisible;
	}

	/**
	 * Sets the visiblity of the created compartment
	 * 
	 * @param isVisible
	 *        <code>true</code> if the compartment should be visible
	 */
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
}
