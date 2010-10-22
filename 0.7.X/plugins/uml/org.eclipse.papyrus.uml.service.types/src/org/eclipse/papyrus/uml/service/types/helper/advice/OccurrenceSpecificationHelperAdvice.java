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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
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

		// Retrieve the list of elements referencing the Event.
		Set<EObject> crossReferences = new HashSet<EObject>();
		for(Setting setting : PapyrusEcoreUtils.getUsages(event)) {
			crossReferences.add(setting.getEObject());
		}

		// Remove the OccurrenceSpecification to be deleted and the container
		// of the referenced event from the list of referencer.
		crossReferences.remove(event.getOwner());
		crossReferences.remove(os);

		// Delete referenced event if it is not referenced itself by another element.
		if(crossReferences.isEmpty()) {
			return request.getDestroyDependentCommand(event);
		}

		return null;
	}
}
