/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper.advice;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <pre>
 * This HelperAdvice completes {@link Classifier} edit commands with the deletion of any
 * Generalization related to the Classifier (source or target).
 * </pre>
 */
public class ClassifierHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {

		// Get related generalizations
		List<DirectedRelationship> generalizations = new ArrayList<DirectedRelationship>();
		if(request.getElementToDestroy() instanceof Classifier) {
			Classifier classifierToDelete = (Classifier)request.getElementToDestroy();
			generalizations.addAll(classifierToDelete.getSourceDirectedRelationships(UMLPackage.eINSTANCE.getGeneralization()));
			generalizations.addAll(classifierToDelete.getTargetDirectedRelationships(UMLPackage.eINSTANCE.getGeneralization()));
		}

		//return the command to destroy all these generalizations
		if(!generalizations.isEmpty()) {
			return request.getDestroyDependentsCommand(generalizations);
		}

		return null;
	}
}
