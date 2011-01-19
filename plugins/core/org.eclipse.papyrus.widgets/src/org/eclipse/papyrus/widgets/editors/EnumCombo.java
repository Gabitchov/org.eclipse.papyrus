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
package org.eclipse.papyrus.widgets.editors;

import org.eclipse.swt.widgets.Composite;

/**
 * An editor representing an Enumeration as a Combo
 * This Editor needs a ContentProvider describing the Enumerated values,
 * and an optional label provider
 * 
 * @author Camille Letavernier
 */
public class EnumCombo extends ReferenceCombo {

	/**
	 * {@inheritDoc}
	 */
	public EnumCombo(Composite parent, int style) {
		super(parent, style);
	}

	/**
	 * {@inheritDoc}
	 */
	public EnumCombo(Composite parent, int style, String label) {
		super(parent, style, label);
	}

}
