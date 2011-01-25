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

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.papyrus.properties.runtime.DataSource;
import org.eclipse.papyrus.properties.util.Util;
import org.eclipse.papyrus.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.widgets.editors.AbstractListEditor;
import org.eclipse.papyrus.widgets.editors.AbstractValueEditor;


public abstract class AbstractPropertyEditor {

	protected String propertyPath; //Format : "DataContext:propertyName"

	protected DataSource input;

	private boolean readOnly = false;

	private boolean isEditable = true;

	protected AbstractListEditor listEditor;

	protected AbstractValueEditor valueEditor;

	protected IObservableList observableList;

	protected IObservableValue observableValue;

	public AbstractPropertyEditor() {
	}

	public AbstractPropertyEditor(AbstractListEditor editor) {
		this.listEditor = editor;
	}

	public AbstractPropertyEditor(AbstractValueEditor editor) {
		this.valueEditor = editor;
	}

	protected void setEditor(AbstractListEditor editor) {
		this.listEditor = editor;
	}

	protected void setEditor(AbstractValueEditor editor) {
		this.valueEditor = editor;
	}

	protected void checkInput() {
		if(propertyPath != null && input != null) {
			isEditable = input.isEditable(propertyPath);
			doBinding();
			updateLabel();
		}
	}

	protected void doBinding() {
		boolean isReadOnly = getReadOnly();

		if(listEditor != null) {
			IObservableList inputObservableList = getInputObservableList();

			if(inputObservableList != null)
				listEditor.setModelObservable(inputObservableList);

			listEditor.setReadOnly(isReadOnly);
		} else if(valueEditor != null) {
			IObservableValue inputObservableValue = getInputObservableValue();

			if(inputObservableValue != null)
				valueEditor.setModelObservable(inputObservableValue);

			valueEditor.setReadOnly(isReadOnly);
		}
	}

	public void setProperty(String path) {
		propertyPath = path;
		updateLabel();
		checkInput();
	}

	public void updateLabel() {
		String label = Util.getLabel(getLocalPropertyPath());
		if(input != null && input.isMandatory(propertyPath)) {
			label += " *"; //$NON-NLS-1$
		}

		if(valueEditor != null) {
			valueEditor.setLabel(label);
		} else if(listEditor != null) {
			listEditor.setLabel(label);
		}
	}

	public String getProperty() {
		return propertyPath;
	}

	public void setInput(DataSource input) {
		this.input = input;
		checkInput();
	}

	public DataSource getInput() {
		return input;
	}

	public String getPropertyName() {
		return Util.getLabel(getLocalPropertyPath());
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
		getEditor().setReadOnly(getReadOnly());
	}

	public AbstractEditor getEditor() {
		return valueEditor == null ? listEditor : valueEditor;
	}

	public boolean getReadOnly() {
		boolean result = readOnly || !isEditable;
		return result;
	}

	protected IObservableList getInputObservableList() {
		if(observableList == null)
			observableList = (IObservableList)input.getObservable(propertyPath);

		return observableList;
	}

	protected IObservableValue getInputObservableValue() {
		if(observableValue == null)
			observableValue = (IObservableValue)input.getObservable(propertyPath);

		return observableValue;
	}

	protected String getLocalPropertyPath() {
		return propertyPath.substring(propertyPath.lastIndexOf(":") + 1); //$NON-NLS-1$
	}
}
