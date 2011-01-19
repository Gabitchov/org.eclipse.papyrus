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

import org.eclipse.papyrus.editors.selectors.IntegerSelector;
import org.eclipse.swt.widgets.Composite;

/**
 * An editor for multivalued Integer attributes
 * 
 * @author Camille Letavernier
 * 
 */
public class MultipleIntegerEditor extends MultipleStringEditor {

	/**
	 * {@inheritDoc}
	 */
	public MultipleIntegerEditor(Composite parent, int style) {
		super(parent, style, new IntegerSelector());
	}

	/**
	 * {@inheritDoc}
	 */
	public MultipleIntegerEditor(Composite parent, int style, String label) {
		super(parent, style, new IntegerSelector(), label);
	}

	/**
	 * {@inheritDoc}
	 */
	public MultipleIntegerEditor(Composite parent, int style, boolean ordered, boolean unique, String label) {
		super(parent, style, new IntegerSelector(), ordered, unique, label);
	}

}
