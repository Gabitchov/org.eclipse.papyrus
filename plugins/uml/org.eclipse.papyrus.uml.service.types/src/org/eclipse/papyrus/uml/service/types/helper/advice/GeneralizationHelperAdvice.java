/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper.advice;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.editpolicies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.common.util.CrossReferencerUtil;
import org.eclipse.uml2.uml.Generalization;

/**
 * <pre>
 * This HelperAdvice completes {@link Generalization} edit commands 
 * in order to :
 * - remove inconsistent (all except currently edited view) views 
 * of the edited Generalization in case a {@link Generalization} is re-oriented.
 * </pre>
 */
public class GeneralizationHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getBeforeReorientRelationshipCommand(ReorientRelationshipRequest request) {

		Set<View> viewsToDestroy = new HashSet<View>();

		if(request.getRelationship() instanceof Generalization) {
			viewsToDestroy.addAll(getGeneralizationViewsToDestroy((Generalization)request.getRelationship(), request));
		}

		//return the command to destroy all these views
		if(!viewsToDestroy.isEmpty()) {

			DestroyDependentsRequest ddr = new DestroyDependentsRequest(request.getEditingDomain(), request.getRelationship(), false);
			return ddr.getDestroyDependentsCommand(viewsToDestroy);

		}
		return null;
	}

	/**
	 * Returns all views referencing generalization except the view currently re-oriented.
	 * 
	 * @param generalization
	 *        the generalization referenced by views
	 * @param request
	 *        the re-orient relationship request
	 * @return the list of views to be destroy
	 */
	protected Set<View> getGeneralizationViewsToDestroy(Generalization generalization, ReorientRelationshipRequest request) {
		Set<View> viewsToDestroy = new HashSet<View>();

		// Find Views that are referencing current Generalization
		View currentlyReorientedView = (View)request.getParameter(UMLBaseItemSemanticEditPolicy.GRAPHICAL_RECONNECTED_EDGE);
		viewsToDestroy.addAll(CrossReferencerUtil.getCrossReferencingViews(generalization, null));
		viewsToDestroy.remove(currentlyReorientedView);

		return viewsToDestroy;
	}
}
