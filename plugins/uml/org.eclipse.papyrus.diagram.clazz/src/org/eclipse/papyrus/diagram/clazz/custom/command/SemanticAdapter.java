/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.clazz.custom.command;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;

public class SemanticAdapter implements IAdaptable {

	private Object element;

	private Object view;

	public SemanticAdapter(EObject element, Object view) {
		this.element = element;
		this.view = view;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public Object getAdapter(Class adapter) {
		if (adapter.equals(EObject.class)) {
			return element;
		}
		if (adapter.equals(View.class)) {
			return view;
		}
		return null;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public void setView(Object view) {
		this.view = view;
	}

}