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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.papyrus.properties.modelelement.ModelElement;
import org.eclipse.papyrus.properties.uml.expression.ExpressionList.Expression;
import org.eclipse.papyrus.properties.uml.preferences.LanguageRegistry;
import org.eclipse.papyrus.widgets.editors.AbstractValueEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;


public class DynamicBodyEditor extends AbstractValueEditor implements Listener {

	private BodyEditor currentEditor;

	private final Composite bodyEditorContainer;

	private final Set<Listener> changeListeners = new HashSet<Listener>();

	private boolean readOnly = false;

	private ModelElement context = null;

	public DynamicBodyEditor(Composite parent, int style) {
		super(parent, style);

		bodyEditorContainer = new Composite(this, style);
		bodyEditorContainer.setLayout(new FillLayout());
		bodyEditorContainer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}

	public void display(Expression expression) {
		String language = expression.getLanguage();
		String initialText = expression.getBody();

		if(currentEditor != null) {
			disposeBodyEditor();
		}

		BodyEditor editor = getEditor(language);
		editor.createWidget(bodyEditorContainer, SWT.NONE);
		if(context != null) {
			editor.setContext(context);
		}

		editor.setInput(initialText);
		editor.addChangeListener(this);

		editor.setReadOnly(readOnly);

		bodyEditorContainer.layout();

		currentEditor = editor;
	}

	public void addChangeListener(Listener listener) {
		changeListeners.add(listener);
	}

	public void removeChangeListener(Listener listener) {
		changeListeners.remove(listener);
	}

	private BodyEditor getEditor(String language) {
		return LanguageRegistry.instance.getEditorFor(language);
	}

	private void disposeBodyEditor() {
		currentEditor.removeChangeListener(this);
		currentEditor.dispose();
		for(Control control : bodyEditorContainer.getChildren()) {
			control.dispose();
		}
	}

	@Override
	public String getValue() {
		if(currentEditor != null) {
			return currentEditor.getValue();
		}
		return null;
	}

	@Override
	public Object getEditableType() {
		return String.class;
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		if(currentEditor != null) {
			currentEditor.setReadOnly(readOnly);
		}

		this.readOnly = readOnly;
	}

	@Override
	public boolean isReadOnly() {
		return readOnly;
	}

	@Override
	public void setToolTipText(String text) {
		super.setLabelToolTipText(text);
	}

	public void handleEvent(Event event) {
		for(Listener listener : changeListeners) {
			listener.handleEvent(event);
		}
	}

	@Override
	protected GridData getLabelLayoutData() {
		GridData result = super.getLabelLayoutData();
		result.verticalAlignment = SWT.BEGINNING;
		return result;
	}

	public void setContext(ModelElement modelElement) {
		this.context = modelElement;
		if(currentEditor != null) {
			currentEditor.setContext(context);
		}
	}
}
