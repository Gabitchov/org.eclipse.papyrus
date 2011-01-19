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
package org.eclipse.papyrus.widgets.selectors;

/**
 * A Selector for Integer values
 * 
 * @author Camille Letavernier
 * 
 */
public class IntegerSelector extends StringSelector {

	/**
	 * {@inheritDoc}
	 */
	public IntegerSelector() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer[] getSelectedElements() {
		Integer[] result;
		try {
			result = new Integer[]{ Integer.parseInt(text.getText()) };
			text.setText(""); //$NON-NLS-1$
		} catch (NumberFormatException ex) {
			result = new Integer[]{};
		}
		return result;
	}
}
