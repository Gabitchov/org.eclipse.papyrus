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

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.widgets.editors.StringLabel;
import org.eclipse.swt.widgets.Composite;

/**
 * A property editor to display a reference's value as a CLabel, filled
 * via a LabelProvider
 * 
 * @author Camille Letavernier
 * 
 */
public class ReferenceLabel extends AbstractPropertyEditor {

	private StringLabel editor;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 * @param style
	 */
	public ReferenceLabel(Composite parent, int style) {
		editor = new StringLabel(parent, style);
		setEditor(editor);
	}

	@Override
	public void doBinding() {
		ILabelProvider labelProvider = input.getLabelProvider(propertyPath);
		if(labelProvider != null) {
			editor.setLabelProvider(labelProvider);
		}

		super.doBinding();
	}
}
