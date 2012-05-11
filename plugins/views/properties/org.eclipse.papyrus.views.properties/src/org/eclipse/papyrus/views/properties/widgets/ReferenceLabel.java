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

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.widgets.editors.StringLabel;
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
		editor = createReferenceLabel(parent, style);
		setEditor(editor);
	}

	/**
	 * Creates the string label.
	 * 
	 * @param parent
	 *        The composite in which the widget will be displayed
	 * @param style
	 *        The style for the widget
	 * @return the string label.
	 */
	protected StringLabel createReferenceLabel(Composite parent, int style) {
		return new StringLabel(parent, style);
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
