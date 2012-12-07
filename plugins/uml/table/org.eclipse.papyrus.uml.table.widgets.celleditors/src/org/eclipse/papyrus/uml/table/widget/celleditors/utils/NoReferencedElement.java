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
package org.eclipse.papyrus.uml.table.widget.celleditors.utils;

import org.eclipse.emf.ecore.impl.EModelElementImpl;

/**
 * 
 * This class allows to simulate <code>null</code> value in the combo editor
 * 
 */
public class NoReferencedElement extends EModelElementImpl {

	/**
	 * the text displayed by the {@link #toString()} method
	 */
	private final String text;

	/**
	 * default text used by {@link #toString()}
	 */
	private static final String DEFAULT_TEXT = "<Undefined>"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 * the default text for the {@link #toString()} method will be used
	 * 
	 */
	public NoReferencedElement() {
		this(DEFAULT_TEXT);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param text
	 *        the text to display by the method {@link #toString()}
	 */
	public NoReferencedElement(final String text) {
		this.text = text;
	}

	public String toString() {
		return this.text;
	};

}
