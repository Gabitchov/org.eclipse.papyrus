/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.search.results;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.openelement.service.OpenElementService;
import org.eclipse.papyrus.views.search.scope.ScopeEntry;
import org.eclipse.ui.PartInitException;

/**
 * 
 * Implements a result entry that doesn't correspond to a real match. it is used to create hierarchies
 * 
 */
public class ResultEntry extends AbstractResultEntry {

	public ResultEntry(Object source, ScopeEntry scopeEntry) {
		super(UNSPECIFIED, UNSPECIFIED, source, scopeEntry);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.search.results.AbstractResultEntry#elementToDisplay()
	 * 
	 * @return
	 */
	@Override
	public Object elementToDisplay() {
		return source;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.search.results.AbstractResultEntry#elementToCheckFilterFor()
	 * 
	 * @return
	 */
	@Override
	public Object elementToCheckFilterFor() {
		return source;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.search.results.AbstractResultEntry#openElement()
	 * 
	 * @return
	 */
	@Override
	public Object openElement(OpenElementService service) throws ServiceException, PartInitException {
		if(source instanceof EObject) {
			return service.openElement((EObject)source);
		}
		return null;
	}
}
