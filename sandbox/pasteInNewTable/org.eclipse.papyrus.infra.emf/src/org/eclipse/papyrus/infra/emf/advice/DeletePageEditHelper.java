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
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

/**
 * An EditHelper which applies to all Papyrus page identifiers (i.e. Tables, Diagrams, ...)
 * When a page identifier object is deleted, the associated page is removed
 * 
 * This EditHelper will be called when a Page is deleted
 * 
 * @author Camille Letavernier
 * 
 */
public class DeletePageEditHelper extends AbstractEditHelper {

	@Override
	protected ICommand getDestroyElementCommand(DestroyElementRequest req) {
		ICommand baseCommand = super.getDestroyElementCommand(req);

		final EObject elementToDestroy = req.getElementToDestroy();

		ICommand removePage = RemovePageHelper.getRemovePageCommand(req.getEditingDomain(), elementToDestroy);

		baseCommand = CompositeCommand.compose(removePage, baseCommand);

		return baseCommand;
	}

}
