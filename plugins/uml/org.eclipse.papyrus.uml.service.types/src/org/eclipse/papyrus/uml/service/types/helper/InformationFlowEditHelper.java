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
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.uml.service.types.command.InformationFlowReorientCommand;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This helper provides edit commands for UML {@link InformationFlow}.
 */
public class InformationFlowEditHelper extends DirectedRelationshipEditHelper {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected EReference getSourceReference() {
		return UMLPackage.eINSTANCE.getInformationFlow_InformationSource();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected EReference getTargetReference() {
		return UMLPackage.eINSTANCE.getInformationFlow_InformationTarget();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean canCreate(EObject source, EObject target) {

		if ((source != null) && !(source instanceof NamedElement)) {
			return false;
		}
		
		if ((target != null) && !(target instanceof NamedElement)) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		return new InformationFlowReorientCommand(req);
	}
}
