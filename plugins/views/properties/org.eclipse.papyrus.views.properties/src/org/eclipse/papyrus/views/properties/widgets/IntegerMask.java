/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.widgets;

import org.eclipse.papyrus.views.properties.providers.XWTCompliantMaskProvider;
import org.eclipse.swt.widgets.Composite;

/**
 * A widget to edit mask-based Integer values
 * The integer value is interpreted as a list of boolean values
 * The widget cannot use more than 32 masks
 *
 * @author Camille Letavernier
 */
@Deprecated
public class IntegerMask extends InvalidWidget {

	/**
	 *
	 * Constructor.
	 *
	 * @param parent
	 *        The composite in which this widget will be created
	 * @param style
	 */
	public IntegerMask(Composite parent, int style) {
		super(parent, style);
	}

	/**
	 * @return the number of columns for this editor
	 *
	 */
	public int getNumColumns() {
		return 0;
	}

	/**
	 * Sets the number of columns for this editor. The mask checkboxes will be
	 * distributed according to this number
	 *
	 * @param numColumns
	 */
	public void setNumColumns(int numColumns) {
		//
	}

	/**
	 * Sets the MaskProvider for this editor
	 *
	 * @param provider
	 */
	public void setMaskProvider(XWTCompliantMaskProvider provider) {
		//
	}

	/**
	 *
	 * @return the MaskProvider associated to this editor
	 */
	public XWTCompliantMaskProvider getMaskProvider() {
		return null;
	}
}
