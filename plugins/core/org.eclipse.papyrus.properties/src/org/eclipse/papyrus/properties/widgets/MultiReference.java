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
import org.eclipse.papyrus.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.widgets.editors.ICommitListener;
import org.eclipse.papyrus.widgets.editors.MultipleReferenceEditor;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;
import org.eclipse.swt.widgets.Composite;

/**
 * A PropertyEditor for editing multiple references in a List
 * 
 * @see org.eclipse.papyrus.widgets.editors.BooleanCheckbox
 * 
 * @author Camille Letavernier
 */
public class MultiReference extends AbstractPropertyEditor {

	/**
	 * The MultipleReferenceEditor widget
	 */
	protected MultipleReferenceEditor editor;

	/**
	 * The ReferenceValueFactory allowing creation and direct editing of values
	 */
	protected ReferenceValueFactory factory;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *        The composite in which the widget will be displayed
	 * @param style
	 *        The style for the widget
	 */
	public MultiReference(Composite parent, int style) {
		editor = new MultipleReferenceEditor(parent, style);
		super.setEditor(editor);
	}

	@Override
	protected void doBinding() {
		IStaticContentProvider contentProvider = input.getContentProvider(propertyPath);
		ILabelProvider labelProvider = input.getLabelProvider(propertyPath);

		if(getInputObservableList() instanceof ICommitListener) {
			editor.addCommitListener((ICommitListener)getInputObservableList());
		}

		editor.setProviders(contentProvider, labelProvider);
		editor.setOrdered(input.isOrdered(propertyPath));
		editor.setUnique(input.isUnique(propertyPath));
		if(factory == null) {
			editor.setFactory(input.getValueFactory(propertyPath));
		} else {
			editor.setFactory(factory);
		}
		editor.setDirectCreation(input.getDirectCreation(propertyPath));

		super.doBinding();
	}

	/**
	 * Sets the {@link ReferenceValueFactory} for this Editor. The factory
	 * allows creation and direct edition of objects.
	 * 
	 * @param factory
	 */
	public void setFactory(ReferenceValueFactory factory) {
		this.factory = factory;
		editor.setFactory(factory);
	}

	/**
	 * @return the {@link ReferenceValueFactory} used by this editor
	 */
	public ReferenceValueFactory getFactory() {
		return factory;
	}

}
