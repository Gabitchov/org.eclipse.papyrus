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
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.papyrus.infra.core.utils.PapyrusEcoreUtils;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.PartDecomposition;

/**
 * Helper advice for all {@link Lifeline} elements.
 */
public class LifelineHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {

		List<EObject> dependentsToDestroy = new ArrayList<EObject>();

		Lifeline lifeline = (Lifeline)request.getElementToDestroy();

		for(InteractionFragment ift : lifeline.getCoveredBys()) {
			// Destroy covered ExecutionSpecification
			if(ift instanceof ExecutionSpecification) {
				dependentsToDestroy.add(ift);
			}

			// Destroy related Message
			if((ift instanceof MessageOccurrenceSpecification) && (((MessageOccurrenceSpecification)ift).getMessage() != null)) {
				dependentsToDestroy.add(((MessageOccurrenceSpecification)ift).getMessage());
			}

			// Destroy covered OccurrenceSpecification
			if(ift instanceof OccurrenceSpecification) {
				dependentsToDestroy.add(ift);
			}
		}

		// Destroy decomposed lifelines
		PartDecomposition decomposition = lifeline.getDecomposedAs();
		if(decomposition != null && PapyrusEcoreUtils.isOnlyUsage(decomposition, lifeline)) {
			dependentsToDestroy.add(decomposition);
		}

		// return command to destroy dependents
		if(!dependentsToDestroy.isEmpty()) {
			return request.getDestroyDependentsCommand(dependentsToDestroy);
		}

		return null;
	}
}
