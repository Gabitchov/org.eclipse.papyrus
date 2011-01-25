/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
import org.eclipse.papyrus.properties.creation.PropertyEditorFactory;
import org.eclipse.papyrus.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.widgets.editors.ICommitListener;
import org.eclipse.papyrus.widgets.editors.MultipleReferenceEditor;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;
import org.eclipse.swt.widgets.Composite;


public class MultiReference extends AbstractPropertyEditor {

	protected MultipleReferenceEditor editor;

	protected ReferenceValueFactory factory;

	public MultiReference(Composite parent, int style) {
		editor = new MultipleReferenceEditor(parent, style);
		factory = new PropertyEditorFactory();
		editor.setFactory(factory);
		super.setEditor(editor);
	}

	@Override
	protected void doBinding() {
		IStaticContentProvider contentProvider = input.getContentProvider(propertyPath);
		ILabelProvider labelProvider = input.getLabelProvider(propertyPath);

		//		ModelElement element = input.getModelElement(propertyPath);
		//		EClass eClass = (EClass)((EMFModelElement)element).getFeature(getLocalPropertyPath()).getEType();
		//
		//		editor.setFactory(new EcorePropertyEditorFactory(eClass));

		if(getInputObservableList() instanceof ICommitListener) {
			editor.addCommitListener((ICommitListener)getInputObservableList());
		}

		editor.setProviders(contentProvider, labelProvider);
		editor.setOrdered(input.isOrdered(propertyPath));
		editor.setUnique(input.isUnique(propertyPath));

		super.doBinding();
	}

	public void setFactory(ReferenceValueFactory factory) {
		this.factory = factory;
		editor.setFactory(factory);
	}

	public ReferenceValueFactory getFactory() {
		return factory;
	}

}
