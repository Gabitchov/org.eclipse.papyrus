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
import org.eclipse.papyrus.uml.service.types.command.ExtendReorientCommand;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UseCase;

/**
 * This helper provides edit commands for UML {@link Extend}.
 */
public class ExtendEditHelper extends DirectedRelationshipEditHelper {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected EReference getSourceReference() {
		return UMLPackage.eINSTANCE.getExtend_Extension();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected EReference getTargetReference() {
		return UMLPackage.eINSTANCE.getExtend_ExtendedCase();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean canCreate(EObject source, EObject target) {

		if ((source != null) && !(source instanceof UseCase)) {
			return false;
		}
		
		if ((target != null) && !(target instanceof UseCase)) {
			return false;
		}
		
		if ((source != null) && (target != null) && (source == target)) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		return new ExtendReorientCommand(req);
	}
}
