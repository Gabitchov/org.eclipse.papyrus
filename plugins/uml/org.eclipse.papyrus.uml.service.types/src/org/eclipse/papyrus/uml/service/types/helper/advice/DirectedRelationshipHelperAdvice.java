/*****************************************************************************
 * Copyright (c) 2010-2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
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
import org.eclipse.papyrus.uml.diagram.common.util.CrossReferencerUtil;
import org.eclipse.papyrus.uml.service.types.utils.RequestParameterUtils;
import org.eclipse.uml2.uml.DirectedRelationship;

/**
 * <pre>
 * This HelperAdvice completes {@link DirectedRelationship} edit commands 
 * in order to :
 * - remove inconsistent (all except currently edited view) views 
 * of the edited DirectedRelationship in case a {@link DirectedRelationship} is re-oriented.
 * </pre>
 */
public class DirectedRelationshipHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getBeforeReorientRelationshipCommand(ReorientRelationshipRequest request) {

		Set<View> viewsToDestroy = new HashSet<View>();
		viewsToDestroy.addAll(getViewsToDestroy((DirectedRelationship)request.getRelationship(), request));

		//return the command to destroy all these views
		if(!viewsToDestroy.isEmpty()) {

			DestroyDependentsRequest ddr = new DestroyDependentsRequest(request.getEditingDomain(), request.getRelationship(), false);
			ddr.setClientContext(request.getClientContext());
			ddr.addParameters(request.getParameters());
			return ddr.getDestroyDependentsCommand(viewsToDestroy);

		}
		return null;
	}

	/**
	 * Returns all views referencing DirectedRelationship except the view currently re-oriented.
	 * 
	 * @param relationship
	 *        the relationship referenced by views
	 * @param request
	 *        the re-orient relationship request
	 * @return the list of views to be destroy
	 */
	private Set<View> getViewsToDestroy(DirectedRelationship relationship, ReorientRelationshipRequest request) {
		Set<View> viewsToDestroy = new HashSet<View>();

		// Find Views that are referencing current DirectedRelationship
		View currentlyReorientedView = RequestParameterUtils.getReconnectedEdge(request);
		viewsToDestroy.addAll(CrossReferencerUtil.getCrossReferencingViews(relationship, null));
		viewsToDestroy.remove(currentlyReorientedView);

		return viewsToDestroy;
	}
}
