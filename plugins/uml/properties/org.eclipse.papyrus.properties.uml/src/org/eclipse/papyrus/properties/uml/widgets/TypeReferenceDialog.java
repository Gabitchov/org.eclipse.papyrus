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
package org.eclipse.papyrus.properties.uml.widgets;

import org.eclipse.papyrus.properties.widgets.AbstractPropertyEditor;
import org.eclipse.swt.widgets.Composite;


public class TypeReferenceDialog extends AbstractPropertyEditor {

	protected UMLReferenceDialog editor;

	public TypeReferenceDialog(Composite parent, int style) {
		editor = new UMLReferenceDialog(parent, style);
		setEditor(editor);
	}

	@Override
	protected void doBinding() {
		//IStaticContentProvider provider = input.getContentProvider(propertyPath);
		editor.setLabelProvider(input.getLabelProvider(propertyPath));
		//editor.setContentProvider(provider); //The widget uses its own ContentProvider

		super.doBinding();
	}

}
