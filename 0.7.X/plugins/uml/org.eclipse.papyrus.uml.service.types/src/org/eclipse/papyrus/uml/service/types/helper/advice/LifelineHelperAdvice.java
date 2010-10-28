/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper.advice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.core.utils.PapyrusEcoreUtils;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.OccurrenceSpecification;

/**
 * Helper advice for all {@link Lifeline} elements.
 */
public class LifelineHelperAdvice extends AbstractEditHelperAdvice {

	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {

		List<EObject> dependentsToDestroy = new ArrayList<EObject>();

		Lifeline lifeline = (Lifeline)request.getElementToDestroy();

		for(InteractionFragment ift : lifeline.getCoveredBys()) {
			// Destroy covered ExecutionSpecification
			if(ift instanceof ExecutionSpecification) {
				dependentsToDestroy.add(ift);
			}

			// Destroy related Message
			if(ift instanceof MessageOccurrenceSpecification) {
				dependentsToDestroy.add(((MessageOccurrenceSpecification)ift).getMessage());
			}

			// Destroy covered OccurrenceSpecification
			if(ift instanceof OccurrenceSpecification) {
				dependentsToDestroy.add(ift);
			}
		}

		// remove child lifelines
		Collection<Setting> usages = PapyrusEcoreUtils.getUsages(lifeline);

		for(Setting usage : usages) {
			if(usage.getEObject() instanceof View) {
				dependentsToDestroy.addAll(getChildLifelinesFromView((View)usage.getEObject()));
			}
		}

		// return command to destroy dependents
		if(!dependentsToDestroy.isEmpty()) {
			return request.getDestroyDependentsCommand(dependentsToDestroy);
		}

		return null;
	}

	/**
	 * Child lifelines are not linked to the parent lifeline in the UML model, but they are visually.
	 * Use this "visual" information from the notation model to complete the destroy with all child lifelines.
	 * 
	 * @param lifelineView
	 *        the view of a Lifeline
	 * @return the child lifelines
	 */
	public static Set<Lifeline> getChildLifelinesFromView(View lifelineView) {
		Set<Lifeline> childLifelines = new HashSet<Lifeline>();

		for(Object view : lifelineView.getChildren()) {
			if (view instanceof Shape) {
				EObject elem = ((Shape)view).getElement();
				if(elem instanceof Lifeline) {
					childLifelines.add((Lifeline)elem);
				}
			}
		}

		return childLifelines;
	}

}
