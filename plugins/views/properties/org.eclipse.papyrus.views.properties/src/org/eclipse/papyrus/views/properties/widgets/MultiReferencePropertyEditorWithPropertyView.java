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
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.swt.widgets.Composite;


public class MultiReferencePropertyEditorWithPropertyView extends AbstractPropertyEditor {

	protected MultiReferenceEditorWithPropertyView editor;

	public MultiReferencePropertyEditorWithPropertyView(Composite parent, int style){
		editor = new MultiReferenceEditorWithPropertyView(parent, style);
		setEditor(editor);
	}

	@Override
	protected void doBinding() {
		//		IStaticContentProvider contentProvider = input.getContentProvider(propertyPath);
		ILabelProvider labelProvider = input.getLabelProvider(propertyPath);

		if(getInputObservableList() instanceof ICommitListener) {
			editor.addCommitListener((ICommitListener)getInputObservableList());
		}

		if(labelProvider != null) {
			editor.setLabelProvider(labelProvider);
		}

		editor.setOrdered(input.isOrdered(propertyPath));
		editor.setUnique(input.isUnique(propertyPath));

		editor.setFactory(input.getValueFactory(propertyPath));
		editor.setDirectCreation(input.getDirectCreation(propertyPath));

		super.doBinding();
	}
}
