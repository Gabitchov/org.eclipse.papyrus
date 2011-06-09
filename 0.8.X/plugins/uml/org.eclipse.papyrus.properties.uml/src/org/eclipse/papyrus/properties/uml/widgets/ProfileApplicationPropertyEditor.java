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

import org.eclipse.papyrus.properties.uml.Activator;
import org.eclipse.papyrus.properties.uml.util.UMLUtil;
import org.eclipse.papyrus.properties.widgets.AbstractPropertyEditor;
import org.eclipse.papyrus.widgets.editors.ICommitListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

public class ProfileApplicationPropertyEditor extends AbstractPropertyEditor {

	private ProfileApplicationEditor editor;

	public ProfileApplicationPropertyEditor(Composite parent, int style) {
		editor = new ProfileApplicationEditor(parent, style);
		super.setEditor(editor);
	}

	@Override
	public void doBinding() {
		Object firstSelection = input.getSelection().getFirstElement();
		Element umlElement = UMLUtil.resolveUMLElement(firstSelection);
		if(umlElement == null || !(umlElement instanceof Package)) {
			Activator.log.warn("This editor can only be used with UML Packages"); //$NON-NLS-1$
			return;
		}

		editor.setLabelProvider(input.getLabelProvider(propertyPath));
		editor.setPackage((Package)umlElement);

		if(getInputObservableList() instanceof ICommitListener) {
			editor.addCommitListener((ICommitListener)getInputObservableList());
		}

		super.doBinding();
	}
}
