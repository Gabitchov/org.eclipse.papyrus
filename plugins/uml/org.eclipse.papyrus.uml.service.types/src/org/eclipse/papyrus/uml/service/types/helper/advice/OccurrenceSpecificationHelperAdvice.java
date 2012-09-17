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

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;

/**
 * Helper advice for all {@link OccurrenceSpecification} elements.
 */
public class OccurrenceSpecificationHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * <pre>
	 * Add a command to destroy :
	 * - {@link Event} referenced by the {@link OccurrenceSpecification} to delete if unused
	 * - related time elements
	 * - linked general ordering
	 * </pre>
	 * 
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getBeforeDestroyDependentsCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest)
	 * 
	 * @param request
	 *        the request
	 * @return the command to execute before the edit helper work is done
	 */
	@Override
	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {
		//FIXME : change for UML 2.4
//		List<EObject> dependentsToDestroy = new ArrayList<EObject>();
//
//		OccurrenceSpecification os = (OccurrenceSpecification)request.getElementToDestroy();
//		Event event = os.getEvent();
//
//		// Delete referenced event if it is not referenced itself by another element.
//		if((event != null) && (PapyrusEcoreUtils.isOnlyUsage(event, os))) {
//			dependentsToDestroy.add(event);
//		}
//
//		// delete linked time elements
//		dependentsToDestroy.addAll(TimeObservationHelper.getTimeObservations(os));
//		dependentsToDestroy.addAll(TimeConstraintHelper.getTimeConstraintsOn(os));
//		dependentsToDestroy.addAll(DurationObservationHelper.getDurationObservationsOn(os));
//		dependentsToDestroy.addAll(DurationConstraintHelper.getDurationConstraintsOn(os));
//
//		// delete linked general ordering
//		dependentsToDestroy.addAll(os.getToBefores());
//		dependentsToDestroy.addAll(os.getToAfters());
//
//		if(!dependentsToDestroy.isEmpty()) {
//			return request.getDestroyDependentsCommand(dependentsToDestroy);
//		}

		return null;
	}
}
