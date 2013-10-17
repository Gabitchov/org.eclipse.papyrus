/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.uml.service.types.command.InterfaceRealizationReorientCommand;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This helper is used to set the source and the target for a {@link InterfaceRealization}
 */
public class InterfaceRealizationEditHelper extends DependencyEditHelper {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected EReference getSourceReference() {
		return UMLPackage.eINSTANCE.getInterfaceRealization_ImplementingClassifier();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected EReference getTargetReference() {
		return UMLPackage.eINSTANCE.getInterfaceRealization_Contract();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean canCreate(EObject source, EObject target) {

		if((source != null) && !(source instanceof BehavioredClassifier)) {
			return false;
		}

		if((target != null) && !(target instanceof Interface)) {
			return false;
		}

		if((source != null) && (target != null) && (source == target)) {
			return false;
		}

		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		return new InterfaceRealizationReorientCommand(req);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.service.types.helper.DirectedRelationshipEditHelper#getCreateRelationshipCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest)
	 *
	 * @param req
	 * @return
	 * the command to use to create the interface realization link
	 */
	@Override
	protected ICommand getCreateRelationshipCommand(CreateRelationshipRequest req) {
		final ICommand cmd = super.getCreateRelationshipCommand(req);
		req.setContainer(req.getSource());
		return cmd;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper#configureRequest(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest)
	 * 
	 * @param request
	 *        the request
	 */
	@Override
	protected void configureRequest(final IEditCommandRequest request) {
		super.configureRequest(request);
		if(request instanceof CreateRelationshipRequest) {
			((CreateRelationshipRequest)request).setContainer(((CreateRelationshipRequest)request).getSource());
		}
	}
}
