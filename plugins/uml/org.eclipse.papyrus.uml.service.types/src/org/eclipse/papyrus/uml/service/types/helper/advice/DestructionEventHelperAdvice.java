/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper.advice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.papyrus.core.utils.PapyrusEcoreUtils;
import org.eclipse.uml2.uml.DestructionEvent;
import org.eclipse.uml2.uml.OccurrenceSpecification;

/**
 * Helper advice for all {@link DestructionEvent} elements.
 */
public class DestructionEventHelperAdvice extends AbstractEditHelperAdvice {

	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {

		List<EObject> dependentsToDestroy = new ArrayList<EObject>();

		DestructionEvent de = (DestructionEvent)request.getElementToDestroy();

		Collection<Setting> usages = PapyrusEcoreUtils.getUsages(de);

		// remove the associated OccurrenceSpecification
		// if it is not used by another element.
		for(Setting usage : usages) {
			EObject os = usage.getEObject();
			if(os instanceof OccurrenceSpecification && PapyrusEcoreUtils.isOnlyUsage(os, de)) {
				dependentsToDestroy.add(os);
			}
		}

		// return command to destroy dependents
		if(!dependentsToDestroy.isEmpty()) {
			return request.getDestroyDependentsCommand(dependentsToDestroy);
		}

		return null;
	}
}
