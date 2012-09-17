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
import org.eclipse.papyrus.uml.service.types.command.ComponentRealizationReorientCommand;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This helper is used to set the source and the target for a {@link ComponentRealization}
 */
public class ComponentRealizationEditHelper extends DependencyEditHelper {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected EReference getSourceReference() {
		return UMLPackage.eINSTANCE.getComponentRealization_RealizingClassifier();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected EReference getTargetReference() {
		return UMLPackage.eINSTANCE.getComponentRealization_Abstraction();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean canCreate(EObject source, EObject target) {

		if ((source != null) && !(source instanceof Classifier)) {
			return false;
		}
		
		if ((target != null) && !(target instanceof Component)) {
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
		return new ComponentRealizationReorientCommand(req);
	}
}
