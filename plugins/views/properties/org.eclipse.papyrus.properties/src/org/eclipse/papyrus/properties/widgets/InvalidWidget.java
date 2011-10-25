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
package org.eclipse.papyrus.properties.widgets;

import org.eclipse.papyrus.properties.Activator;
import org.eclipse.papyrus.widgets.editors.StringLabel;
import org.eclipse.swt.widgets.Composite;

/**
 * A class for displaying invalid widgets without raising Java errors
 * The widget will display an error, and may display the property label
 * if it is available
 * 
 * @author Camille Letavernier
 */
public class InvalidWidget extends AbstractPropertyEditor {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 *        The Composite in which the editor will be created
	 * @param style
	 *        The style to apply to the editor
	 */
	public InvalidWidget(Composite parent, int style) {
		super();
		StringLabel editor = new StringLabel(parent, style);
		setEditor(editor);

		editor.getValueLabel().setText("Property view Error : invalid widget type"); //$NON-NLS-1$
		editor.getValueLabel().setImage(Activator.getDefault().getImage("icons/error.gif")); //$NON-NLS-1$
	}

	@Override
	public void doBinding() {
		//Skip to avoid the binding between the property's value and the CLabel
	}
}
