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
package org.eclipse.papyrus.uml.properties.widgets;

import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.uml.properties.Activator;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.papyrus.views.properties.widgets.AbstractPropertyEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

/**
 * A Property editor for Profile Application
 * 
 * @author Camille Letavernier
 * 
 */
public class ProfileApplicationPropertyEditor extends AbstractPropertyEditor {

	private ProfileApplicationEditor editor;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 * @param style
	 */
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
