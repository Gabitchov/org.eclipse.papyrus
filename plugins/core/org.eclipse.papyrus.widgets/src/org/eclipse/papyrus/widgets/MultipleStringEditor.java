/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.editors;

import org.eclipse.papyrus.editors.selectors.StringSelector;
import org.eclipse.swt.widgets.Composite;


/**
 * An editor for multivalued String attributes
 * 
 * @author Camille Letavernier
 * 
 */
public class MultipleStringEditor extends MultipleValueEditor {

	/**
	 * {@inheritDoc}
	 */
	public MultipleStringEditor(Composite parent, int style) {
		super(parent, style, new StringSelector());
	}

	/**
	 * {@inheritDoc}
	 */
	public MultipleStringEditor(Composite parent, int style, boolean ordered, boolean unique) {
		super(parent, style, new StringSelector(), ordered, unique, null);
	}

	/**
	 * {@inheritDoc}
	 */
	public MultipleStringEditor(Composite parent, int style, boolean ordered, boolean unique, String label) {
		super(parent, style, new StringSelector(), ordered, unique, label);
	}

	/**
	 * {@inheritDoc}
	 */
	public MultipleStringEditor(Composite parent, int style, IElementSelector selector, boolean ordered, boolean unique, String label) {
		super(parent, style, selector, ordered, unique, label);
	}

	/**
	 * {@inheritDoc}
	 */
	public MultipleStringEditor(Composite parent, int style, IElementSelector selector) {
		super(parent, style, selector);
	}

	/**
	 * {@inheritDoc}
	 */
	public MultipleStringEditor(Composite parent, int style, IElementSelector selector, String label) {
		super(parent, style, selector, label);
	}

	/**
	 * {@inheritDoc}
	 */
	public MultipleStringEditor(Composite parent, int style, String label) {
		super(parent, style, new StringSelector(), label);
	}

}
