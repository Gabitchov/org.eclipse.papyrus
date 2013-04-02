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

import java.util.Set;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.infra.widgets.editors.AbstractListEditor;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.infra.widgets.editors.MultipleReferenceEditor;
import org.eclipse.papyrus.views.properties.contexts.View;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.views.properties.runtime.EmbeddedDisplayEngine;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public class MultiReferenceEditorWithPropertyView extends AbstractListEditor implements ISelectionChangedListener {

	protected MultipleReferenceEditor multiReferenceEditor;

	protected Composite propertiesComposite;

	protected EmbeddedDisplayEngine displayEngine = new EmbeddedDisplayEngine();

	public MultiReferenceEditorWithPropertyView(Composite parent, int style) {
		super(parent, style);
		// parent.setBackground(getDisplay().getSystemColor(SWT.COLOR_RED));
		((GridLayout)getLayout()).numColumns++;

		multiReferenceEditor = createMultipleReferenceEditor(style);
		multiReferenceEditor.addSelectionChangedListener(this);
		multiReferenceEditor.setLayoutData(new GridData(SWT.BEGINNING, SWT.FILL, false, true));

		propertiesComposite = new Composite(this, style);
		propertiesComposite.setLayout(new FillLayout());
		propertiesComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}

	/**
	 * Creates the multi reference editor.
	 * 
	 * @param parent
	 *        The composite in which the widget will be displayed
	 * @param style
	 *        The style for the widget
	 * @return the multi reference editor.
	 */
	protected MultipleReferenceEditor createMultipleReferenceEditor(int style) {
		return new MultipleReferenceEditor(this, style);
	}

	@Override
	public GridData getDefaultLayoutData() {
		GridData data = super.getDefaultLayoutData();
		data.grabExcessVerticalSpace = true;
		data.grabExcessHorizontalSpace = true;
		data.verticalAlignment = SWT.FILL;
		return data;
	}

	@Override
	public Object getEditableType() {
		return Object.class;
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		multiReferenceEditor.setReadOnly(readOnly);
		propertiesComposite.setEnabled(!readOnly);
	}

	@Override
	public boolean isReadOnly() {
		return multiReferenceEditor.isReadOnly();
	}

	@Override
	public void setToolTipText(String text) {
		multiReferenceEditor.setToolTipText(text);
	}

	@Override
	public void setLabel(String label) {
		multiReferenceEditor.setLabel(label);
	}

	public void setOrdered(boolean ordered) {
		multiReferenceEditor.setOrdered(ordered);
	}

	public void setUnique(boolean unique) {
		multiReferenceEditor.setUnique(unique);
	}

	@Override
	public void setModelObservable(IObservableList modelObservable) {
		multiReferenceEditor.setModelObservable(modelObservable);

		//If the properties view of the first element contains a recursive view, we may have a StackOverFlow here.
		//Do not force the initial selection.

		//		if(!modelObservable.isEmpty()) {
		//			multiReferenceEditor.getViewer().setSelection(new StructuredSelection(modelObservable.get(0)));
		//		}
	}

	@Override
	public void dispose() {
		super.dispose();
		multiReferenceEditor.removeSelectionChangedListener(this);
	}

	public void selectionChanged(SelectionChangedEvent event) {
		ISelection selection = event.getSelection();

		Set<View> views = ConfigurationManager.instance.constraintEngine.getViews(selection);
		displayEngine.display(views, propertiesComposite, selection, SWT.NONE);
		this.layout();
		propertiesComposite.layout();

		// TODO : How can we force the property view layout ?
		// In the tabbed property view, we need to go up to the 4th parent
		getParent().layout(); // This one works in the embedded editor

		// In the Eclipse Tabbed Property View, we need to go this far...
		getParent().getParent().getParent().getParent().layout();
	}

	public void setFactory(ReferenceValueFactory valueFactory) {
		multiReferenceEditor.setFactory(valueFactory);
	}

	public void setDirectCreation(boolean directCreation) {
		multiReferenceEditor.setDirectCreation(directCreation);
	}

	public void setLabelProvider(ILabelProvider labelProvider) {
		multiReferenceEditor.setLabelProvider(labelProvider);
	}

	@Override
	public void addCommitListener(ICommitListener commitListener) {
		multiReferenceEditor.addCommitListener(commitListener);
	}
}
