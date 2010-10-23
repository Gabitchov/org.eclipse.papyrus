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
import org.eclipse.papyrus.core.utils.PapyrusEcoreUtils;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.OccurrenceSpecification;

/**
 * Helper advice for all {@link OccurrenceSpecification} elements.
 */
public class OccurrenceSpecificationHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * <pre>
	 * Add a command to destroy {@link Event} referenced by the {@link OccurrenceSpecification} to delete.
	 * This command is only added if the referenced {@link Event} is not referenced by another element.
	 * </pre>
	 * 
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getBeforeDestroyDependentsCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest)
	 * 
	 * @param request
	 *        the request
	 * @return the command to execute before the edit helper work is done
	 */
	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {

		OccurrenceSpecification os = (OccurrenceSpecification)request.getElementToDestroy();
		Event event = os.getEvent();

		// Delete referenced event if it is not referenced itself by another element.
		if((event != null) && (PapyrusEcoreUtils.isOnlyUsage(event, os))) {
			return request.getDestroyDependentCommand(event);
		}

		return null;
	}
}
