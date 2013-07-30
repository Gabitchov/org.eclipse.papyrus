/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.common.commands;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.core.util.IProxyEObject;
import org.eclipse.gmf.runtime.emf.core.util.PackageUtil;
import org.eclipse.gmf.runtime.notation.View;

/**
 * The Class SemanticAdapter used to package semantic or view element in a
 * deferred command
 */
public class SemanticAdapter implements IAdaptable, IProxyEObject {

	/** The element. */
	private Object element;

	/** The view. */
	private Object view;

	/**
	 * Instantiates a new semantic adapter.
	 * 
	 * @param element
	 *        the element
	 * @param view
	 *        the view
	 */
	public SemanticAdapter(EObject element, Object view) {
		this.element = element;
		this.view = view;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public Object getAdapter(Class adapter) {
		if(adapter.equals(EObject.class)) {
			return element;
		}
		if(adapter.equals(View.class)) {
			return view;
		}
		return null;
	}

	/**
	 * Sets the element.
	 * 
	 * @param element
	 *        the new element
	 */
	// @unused
	public void setElement(Object element) {
		this.element = element;
	}

	/**
	 * Sets the view.
	 * 
	 * @param view
	 *        the new view
	 */
	public void setView(Object view) {
		this.view = view;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getProxyClassID() {
		return (element != null) ? PackageUtil.getID(EMFCoreUtil.getProxyClass((EObject)element)) : null;
	}

	/**
	 * {@inheritDoc}
	 */
	public EObject resolve() {
		return (element != null) ? (EObject)element : null;
	}
}
