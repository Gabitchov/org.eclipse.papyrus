/*****************************************************************************
 * Copyright (c) 2010-2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 *		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper.advice;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <pre>
 * This HelperAdvice completes {@link Classifier} edit commands with the deletion of :
 * - any Generalization related to the Classifier (source or target).
 * - any Association related to the Classifier (source or target type).
 * </pre>
 */
public class ClassifierHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * While deleting a Classifier:
	 * - remove {@link Generalization} in which this Classifier is involved
	 * - remove {@link Association} in which this Classifier is involved
	 * 
	 * </pre>
	 */
	@Override
	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {

		List<EObject> dependents = new ArrayList<EObject>();
		if(request.getElementToDestroy() instanceof Classifier) {

			Classifier classifierToDelete = (Classifier)request.getElementToDestroy();

			// Get related generalizations
			dependents.addAll(classifierToDelete.getSourceDirectedRelationships(UMLPackage.eINSTANCE.getGeneralization()));
			dependents.addAll(classifierToDelete.getTargetDirectedRelationships(UMLPackage.eINSTANCE.getGeneralization()));

			// Get related association for this classifier, then delete member ends for which this classifier is the type.
			for(Association association : classifierToDelete.getAssociations()) {
				for(Property end : association.getMemberEnds()) {
					if(end.getType() == classifierToDelete) {
						dependents.add(association);
					}
				}
			}
		}

		// Return the command to destroy all these dependent elements
		if(!dependents.isEmpty()) {
			return request.getDestroyDependentsCommand(dependents);
		}

		return null;
	}
}
