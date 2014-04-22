/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.widgets;

import org.eclipse.swt.widgets.Composite;

/**
 * A PropertyEditor for editing Doubles through a Text field
 * 
 * @see org.eclipse.papyrus.infra.widgets.editors.DoubleEditor
 * 
 * @author Camille Letavernier
 */
public class DoubleEditor extends AbstractPropertyEditor {

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *        The composite in which the widget will be displayed
	 * @param style
	 *        The style for the widget
	 */
	public DoubleEditor(Composite parent, int style) {
		super(new org.eclipse.papyrus.infra.widgets.editors.DoubleEditor(parent, style));
	}

}
