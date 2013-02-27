/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.common.handlers;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.nattable.common.handlers.AbstractCreateNattableEditorHandler;
import org.eclipse.uml2.uml.Element;


public abstract class AbstractCreateUMLNattableEditorHandler extends AbstractCreateNattableEditorHandler {

	public AbstractCreateUMLNattableEditorHandler(final String editorType, final String defaultName) {
		super(editorType, defaultName);
	}

	@Override
	public boolean isEnabled() {
		if(super.isEnabled()) {
			final List<EObject> selection = getSelection();
			return selection.size() == 1 && selection.get(0) instanceof Element;
		}
		return false;
	}
}
