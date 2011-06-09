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
package org.eclipse.papyrus.uml.diagram.common.edit.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.DefaultSemanticEditPolicy;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;

/**
 * Classifier semantic edit policy inherited from class diagram (for correct edge creation).
 * 
 * @deprecated - Not use anymore.
 */
public class ClassifierSemanticEditPolicy extends DefaultSemanticEditPolicy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {

		// Add default container
		//		EObject source = req.getSource();
		//		EObject target = req.getTarget();
		//		if ((source != null) && (target != null)) {
		//			EObject container = EMFCoreUtil.getLeastCommonContainer(Arrays.asList(new EObject[]{source, target}), UMLPackage.eINSTANCE.getPackage());
		//			req.setContainer(container);
		//		}

		CreateRelationshipRequest replacementRequest = new CreateRelationshipRequest(UMLElementTypes.DEPENDENCY);
		replacementRequest.setSource(req.getSource());
		replacementRequest.setTarget(req.getTarget());
		replacementRequest.setEditingDomain(req.getEditingDomain());
		replacementRequest.addParameters(req.getParameters());

		return super.getCreateRelationshipCommand(replacementRequest);
	}

}
