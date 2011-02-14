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

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.papyrus.properties.modelelement.DataSource;
import org.eclipse.papyrus.properties.util.Util;
import org.eclipse.papyrus.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.widgets.editors.AbstractListEditor;
import org.eclipse.papyrus.widgets.editors.AbstractValueEditor;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;

/**
 * An Abstract class to factorize code for PropertyEditors. PropertyEditors are
 * <strong>not</strong> required to extend this class, but could benefit from
 * its methods.
 * 
 * @author Camille Letavernier
 */
public abstract class AbstractPropertyEditor implements IChangeListener {

	/**
	 * The qualified propertyPath. Represents the property edited by this widget
	 */
	protected String propertyPath; //Format : "DataContextElement:propertyName"

	/**
	 * The DataSource representing the semantic objects
	 */
	protected DataSource input;

	private boolean readOnly = false;

	private boolean isEditable = true;

	/**
	 * The SWT Widget (For list properties only)
	 */
	protected AbstractListEditor listEditor;

	/**
	 * The SWT Widget (For single values only)
	 */
	protected AbstractValueEditor valueEditor;

	/**
	 * The IObservableList representing the semantic property
	 * (For list properties only)
	 */
	protected IObservableList observableList;

	/**
	 * The IObservableValue representing the semantic property
	 * (For single values only)
	 */
	protected IObservableValue observableValue;

	/**
	 * Indicates if the PropertyEditor should listen on any modification on the Datasource
	 * It may be useful to force the refresh on Observable that don't listen on the model,
	 * such as some derived values (Which are not necessarily refreshed on model change)
	 * Default value is false
	 */
	protected boolean forceRefresh = false;

	/**
	 * Constructor.
	 * When using this constructor, you should explicitly call the #setEditor method.
	 */
	protected AbstractPropertyEditor() {
	}

	/**
	 * Constructor. Constructs a new PropertyEditor with the given ListEditor
	 * 
	 * @param editor
	 */
	protected AbstractPropertyEditor(AbstractListEditor editor) {
		setEditor(editor);
	}

	/**
	 * Constructor. Constructs a new PropertyEditor with the given ValueEditor
	 * 
	 * @param editor
	 */
	protected AbstractPropertyEditor(AbstractValueEditor editor) {
		setEditor(editor);
	}

	/**
	 * Sets the ListEditor for this PropertyEditor
	 * 
	 * @param editor
	 */
	protected void setEditor(AbstractListEditor editor) {
		this.listEditor = editor;
		addDisposeListener(editor);
	}

	/**
	 * Sets the ValueEditor for this PropertyEditor
	 * 
	 * @param editor
	 */
	protected void setEditor(AbstractValueEditor editor) {
		this.valueEditor = editor;
		addDisposeListener(editor);
	}

	private void addDisposeListener(AbstractEditor editor) {
		editor.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				if(input != null)
					input.removeChangeListener(AbstractPropertyEditor.this);
			}
		});
	}

	/**
	 * Checks if this editor has all the input needed to do the dataBinding.
	 * As this editor can be instantiated through the XWT Framework, which is
	 * based on an XML parser, there is no determinism in the order in which
	 * the parameters are set.
	 */
	protected void checkInput() {
		if(propertyPath != null && input != null) {
			isEditable = input.isEditable(propertyPath);
			doBinding();
			updateLabel();
		}
	}

	/**
	 * Binds the AbstractEditor (Either List or Value editor) to the semantic element
	 */
	protected void doBinding() {
		boolean isReadOnly = getReadOnly();

		if(listEditor != null) {
			IObservableList inputObservableList = getInputObservableList();

			if(inputObservableList != null)
				listEditor.setModelObservable(inputObservableList);

		} else if(valueEditor != null) {
			IObservableValue inputObservableValue = getInputObservableValue();

			if(inputObservableValue != null)
				valueEditor.setModelObservable(inputObservableValue);
		}

		AbstractEditor editor = getEditor();
		editor.setReadOnly(isReadOnly);

		updateRefreshListener();
	}

	/**
	 * Updates the refreshListener
	 * If forceRefresh is true, adds a change listener on the current input.
	 * Otherwise, the listener is removed.
	 * If the input Datasource is null, then nothing is done
	 */
	protected void updateRefreshListener() {
		if(input == null)
			return;

		if(forceRefresh) {
			input.addChangeListener(this);
		} else {
			input.removeChangeListener(this);
		}
	}

	/**
	 * Indicates if the PropertyEditor should listen on any modification on the Datasource
	 * It may be useful to force the refresh on Observable that don't listen on the model,
	 * such as some derived values (Which are not necessarily refreshed on model change)
	 */
	public boolean getForceRefresh() {
		return forceRefresh;
	}

	/**
	 * Indicates whether this editor should listen on any modification on the Datasource, and
	 * refresh the widget's value on each change.
	 * 
	 * @param forceRefresh
	 *        True if this editor should listen on any change on the Datasource, false otherwise
	 */
	public void setForceRefresh(boolean forceRefresh) {
		this.forceRefresh = forceRefresh;
		updateRefreshListener();
	}

	public void handleChange(ChangeEvent event) {
		AbstractEditor editor = getEditor();
		if(editor != null) {
			editor.refreshValue();
		}
	}

	/**
	 * Sets the property path for this PropertyEditor.
	 * The propertyPath elements should be separated by ":"
	 * e.g. UML:NamedElement:name
	 * 
	 * @param path
	 */
	public void setProperty(String path) {
		propertyPath = path;
		updateLabel();
		checkInput();
	}

	/**
	 * Updates the label for this PropertyEditor.
	 */
	public void updateLabel() {
		String label = getPropertyName();
		if(input != null && input.isMandatory(propertyPath)) {
			label += " *"; //$NON-NLS-1$
		}

		if(valueEditor != null) {
			valueEditor.setLabel(label);
		} else if(listEditor != null) {
			listEditor.setLabel(label);
		}
	}

	/**
	 * @return the property path for this Property editor.
	 */
	public String getProperty() {
		return propertyPath;
	}

	/**
	 * Sets the input DataSource for this Property editor.
	 * 
	 * @param input
	 */
	public void setInput(DataSource input) {
		this.input = input;
		checkInput();
	}

	/**
	 * @return the input DataSource for this Property editor
	 */
	public DataSource getInput() {
		return input;
	}

	/**
	 * @return the formatted property name for this Property Editor
	 */
	protected String getPropertyName() {
		if(getLocalPropertyPath() == null)
			return ""; //$NON-NLS-1$
		return Util.getLabel(getLocalPropertyPath());
	}

	/**
	 * Marks this editor as readOnly
	 * 
	 * @param readOnly
	 */
	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
		getEditor().setReadOnly(getReadOnly());
	}

	/**
	 * @return the AbstractEditor for this PropertyEditor
	 */
	public AbstractEditor getEditor() {
		return valueEditor == null ? listEditor : valueEditor;
	}

	/**
	 * Tests if this editor is read-only
	 * 
	 * @return
	 *         True if this editor is read-only
	 */
	public boolean getReadOnly() {
		boolean result = readOnly || !isEditable;
		return result;
	}

	/**
	 * @return the IObservableList for this propertyEditor, or null if it is not
	 *         available
	 */
	protected IObservableList getInputObservableList() {
		if(observableList == null)
			observableList = (IObservableList)input.getObservable(propertyPath);

		return observableList;
	}

	/**
	 * @return the IObservableValue for this propertyEditor, or null if it is not
	 *         available
	 */
	protected IObservableValue getInputObservableValue() {
		if(observableValue == null)
			observableValue = (IObservableValue)input.getObservable(propertyPath);

		return observableValue;
	}

	/**
	 * @return the last segment of the property path (Which is the property name)
	 */
	protected String getLocalPropertyPath() {
		return propertyPath.substring(propertyPath.lastIndexOf(":") + 1); //$NON-NLS-1$
	}
}
