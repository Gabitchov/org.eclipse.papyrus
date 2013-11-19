/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *   
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.acceleo.debug.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.acceleo.AcceleoDriver;
import org.eclipse.papyrus.acceleo.ui.handlers.CmdHandler;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

public class ResetAcceleoHandler extends CmdHandler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		updateSelectedEObject();
		if(selectedEObject instanceof Element) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if(selectedEObject instanceof NamedElement) {
			AcceleoDriver.init();
		}
		return null;
	}
}
