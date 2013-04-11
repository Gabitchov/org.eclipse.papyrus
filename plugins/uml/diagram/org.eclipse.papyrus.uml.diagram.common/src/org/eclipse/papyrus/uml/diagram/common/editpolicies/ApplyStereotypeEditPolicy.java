/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.common.commands.ApplyStereotypeCommand;
import org.eclipse.papyrus.uml.diagram.common.commands.DefferedAppliedStereotypeToDisplayCommand;
import org.eclipse.papyrus.uml.diagram.common.service.ApplyStereotypeRequest;
import org.eclipse.uml2.uml.Element;

/**
 * Apply Stereotype edit policy.
 * <P>
 * Edit policy in charge of applying stereotypes on uml elements
 * </P>
 */
public class ApplyStereotypeEditPolicy extends AbstractEditPolicy {

	/**
	 * Creates a new ApplyStereotypeEditPolicy.
	 */
	public ApplyStereotypeEditPolicy() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Command getCommand(Request request) {
		if(understandsRequest(request)) {
			return getApplyStereotypeCommand((ApplyStereotypeRequest)request);
		} else
			return super.getCommand(request);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean understandsRequest(Request req) {
		if(ApplyStereotypeRequest.APPLY_STEREOTYPE_REQUEST.equals(req.getType())) {
			return true;
		}
		return super.understandsRequest(req);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EditPart getTargetEditPart(Request request) {
		if(understandsRequest(request)) {
			return getHost();
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * Returns the <code>Command</code> contribution for the given <code>ApplyStereotypeRequest</code>
	 * 
	 * @param request
	 *        the request linked to this edit policy
	 * @return the command that applies the stereotype or <code>null</code>
	 */
	protected Command getApplyStereotypeCommand(ApplyStereotypeRequest request) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(editingDomain, "Apply Stereotype");
		final Element element = (Element)(((View)getHost().getModel()).getElement());
		
		if (request.getElement() == null) {
			request.setElement(element);
		}

		// 1. apply stereotypes
		cc.compose(new ApplyStereotypeCommand(editingDomain, request));

		// 2. display stereotypes
		cc.compose(new EMFtoGMFCommandWrapper(new DefferedAppliedStereotypeToDisplayCommand(editingDomain, getHost(), "")));

		return new ICommandProxy(cc.reduce());
	}

}
