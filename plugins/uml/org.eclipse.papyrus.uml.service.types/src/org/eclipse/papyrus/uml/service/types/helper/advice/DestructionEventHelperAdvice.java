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
 * Helper advice for all {@link DestructionEvent} elements.
 * 
 * @deprecated the related element no more exists in UML 2.4
 */
public class DestructionEventHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {
		//FIXME : change for UML 2.4
//
//		List<EObject> dependentsToDestroy = new ArrayList<EObject>();
//
//		DestructionEvent de = (DestructionEvent)request.getElementToDestroy();
//
//		Collection<Setting> usages = PapyrusEcoreUtils.getUsages(de);
//
//		// remove the associated OccurrenceSpecification
//		// if it is not used by another element.
//		for(Setting usage : usages) {
//			EObject os = usage.getEObject();
//			if(os instanceof OccurrenceSpecification && PapyrusEcoreUtils.isOnlyUsage(os, de)) {
//				dependentsToDestroy.add(os);
//			}
//		}
//
//		// return command to destroy dependents
//		if(!dependentsToDestroy.isEmpty()) {
//			return request.getDestroyDependentsCommand(dependentsToDestroy);
//		}

		return null;
	}
}
