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

import org.eclipse.swt.widgets.Composite;

/**
 * A Widget for selecting Files on the workspace or on the file system.
 * The widgets only edits String values : it uses the path of the files
 * 
 * @author Camille Letavernier
 */
public class XWTStringFileSelectorEMF extends StringFileSelector {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 * @param style
	 */
	public XWTStringFileSelectorEMF(Composite parent, int style) {
		super(parent, style);
	}

	/**
	 * Creates the selector
	 * 
	 * @param parent
	 *        The composite in which the widget will be displayed
	 * @param style
	 *        The style for the widget
	 * @return the selector
	 */
	@Override
	protected StringFileSelectorEMF createSelector(Composite parent, int style) {
		return new StringFileSelectorEMF(parent, style);
	}
}
