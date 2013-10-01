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
package org.eclipse.papyrus.uml.diagram.clazz.custom.helper.advice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.custom.utils.GeneralizationUtil;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelEditPart;
import org.eclipse.papyrus.uml.diagram.common.util.CrossReferencerUtil;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.NamedElement;

/**
 * <pre>
 * This HelperAdvice completes {@link Generalization} edit commands with diagram specific
 * commands in order to remove inconsistent views (e.g. inherited Port or Property
 * in case a {@link Generalization} is deleted or re-oriented.
 * </pre>
 */
public class GeneralizationHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getBeforeReorientRelationshipCommand(ReorientRelationshipRequest request) {
		// The list of member views becoming inconsistent after re-orient that should be deleted.
		Set<View> viewsToDestroy = new HashSet<View>();
		if(request.getRelationship() instanceof Generalization) {
			viewsToDestroy.addAll(getMemberViewsToDestroy((Generalization)request.getRelationship()));
		}
		//return the command to destroy all these views
		if(!viewsToDestroy.isEmpty()) {
			DestroyDependentsRequest ddr = new DestroyDependentsRequest(request.getEditingDomain(), request.getRelationship(), false);
			ddr.setClientContext(request.getClientContext());
			ddr.addParameters(request.getParameters());
			return ddr.getDestroyDependentsCommand(viewsToDestroy);
		}
		return null;
	}

	@Override
	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {
		EObject destructee = request.getElementToDestroy();
		Set<View> viewsToDestroy = new HashSet<View>();
		if(destructee instanceof Generalization) {
			viewsToDestroy = getMemberViewsToDestroy((Generalization)destructee);
		}
		//return the command to destroy all these views
		if(!viewsToDestroy.isEmpty()) {
			return request.getDestroyDependentsCommand(viewsToDestroy);
		}
		return null;
	}

	/**
	 * This methods looks for inconsistent views to delete in case the generalization is deleted or
	 * re-oriented.
	 * 
	 * @param generalization
	 *        the modified generalization
	 * @return the list of {@link View} to delete
	 */
	protected Set<View> getMemberViewsToDestroy(Generalization generalization) {
		Set<View> viewsToDestroy = new HashSet<View>();
		Classifier general = generalization.getGeneral();
		if(general != null) {
			// Parse members
			EList<NamedElement> members = general.getMembers();
			for(NamedElement member : members) {
				// Find Views in Composite Structure Diagram that are referencing current member
				Iterator<View> viewIt = CrossReferencerUtil.getCrossReferencingViews(member, ModelEditPart.MODEL_ID).iterator();
				while(viewIt.hasNext()) {
					View view = viewIt.next();
					// Test if current view (member) is concerned by the deletion (re-orientation) of the generalization
					GeneralizationUtil util = new GeneralizationUtil();
					if(util.isConcernedByGeneralizationChanges(generalization, view)) {
						viewsToDestroy.add(view);
					}
				}
			}
		}
		return viewsToDestroy;
	}
}
