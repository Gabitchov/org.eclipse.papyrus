/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.advice;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

/**
 * An EditAdviceHelper which applies to all Papyrus page identifiers (i.e. Tables, Diagrams, ...)
 * When a page identifier object is deleted, the associated page is removed
 * 
 * @author Camille Letavernier
 * 
 */
public class DeletePageAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {
		return null;
	}

	@Override
	public ICommand getBeforeDestroyElementCommand(DestroyElementRequest request) {
		final EObject objectToDestroy = request.getElementToDestroy();
		if(objectToDestroy == null) {
			return null;
		}

		return RemovePageHelper.getRemovePageCommand(request.getEditingDomain(), objectToDestroy);
	}

}
