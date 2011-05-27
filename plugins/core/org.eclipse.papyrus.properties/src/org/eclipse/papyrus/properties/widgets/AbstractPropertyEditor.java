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
import org.eclipse.papyrus.properties.Activator;
import org.eclipse.papyrus.properties.contexts.Context;
import org.eclipse.papyrus.properties.contexts.Property;
import org.eclipse.papyrus.properties.modelelement.DataSource;
import org.eclipse.papyrus.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.properties.util.Util;
import org.eclipse.papyrus.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.widgets.editors.AbstractListEditor;
import org.eclipse.papyrus.widgets.editors.AbstractValueEditor;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Control;

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
	 * Indicates if the editor's label should be displayed
	 */
	protected boolean showLabel = true;

	/**
	 * The custom label used by this editor. If set, it replaces the property's default label
	 */
	protected String customLabel;

	/**
	 * The maximum number of characters per line for wrapping descriptions
	 */
	public static int descriptionMaxCharPerLine = 200;

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
				if(input != null) {
					input.removeChangeListener(AbstractPropertyEditor.this);
				}
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

			if(inputObservableList != null) {
				listEditor.setModelObservable(inputObservableList);
			}

		} else if(valueEditor != null) {
			IObservableValue inputObservableValue = getInputObservableValue();

			if(inputObservableValue != null) {
				valueEditor.setModelObservable(inputObservableValue);
			}
		}

		applyReadOnly(isReadOnly);

		if(input.forceRefresh(propertyPath)) {
			input.addChangeListener(this);
		}
	}

	/**
	 * Applies the readOnly state to the editor
	 * 
	 * @param readOnly
	 *        Indicates if this widget should be read-only
	 */
	protected void applyReadOnly(boolean readOnly) {
		AbstractEditor editor = getEditor();
		if(editor != null) {
			editor.setReadOnly(readOnly);
		}
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
		updateDescription();
		checkInput();
	}

	/**
	 * Updates the label for this PropertyEditor.
	 */
	public void updateLabel() {
		String label = getLabel();
		//		if(input != null && propertyPath != null && input.isMandatory(propertyPath)) {
		//			label += " *"; //$NON-NLS-1$
		//		}

		if(showLabel) {
			if(valueEditor != null) {
				valueEditor.setLabel(label);
			} else if(listEditor != null) {
				listEditor.setLabel(label);
			}
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
	protected String getLabel() {
		if(customLabel != null) {
			return customLabel;
		}

		Property property = getModelProperty();
		if(property == null || property.getLabel() == null || property.getLabel().trim().equals("")) { //$NON-NLS-1$
			return Util.getLabel(getLocalPropertyPath());
		}

		return property.getLabel();
	}

	/**
	 * Updates the description for this PropertyEditor.
	 * The description is the widget's ToolTipText
	 */
	protected void updateDescription() {
		String description = ""; //$NON-NLS-1$
		Property property = getModelProperty();
		if(property != null) {
			description = property.getDescription();
		}

		if(description == null || description.trim().equals("")) { //$NON-NLS-1$
			return;
		}

		description = Util.resizeString(description, descriptionMaxCharPerLine);

		if(valueEditor != null) {
			valueEditor.setToolTipText(description);
		} else if(listEditor != null) {
			listEditor.setToolTipText(description);
		}
	}

	protected Property getModelProperty() {
		if(propertyPath == null) {
			return null;
		}
		Context context = getContext();
		return ConfigurationManager.instance.getProperty(propertyPath, context);
	}

	private Context getContext() {
		if(input == null) {
			return null;
		} else {
			return input.getView().getContext();
		}
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
		if(observableList == null) {
			try {
				observableList = (IObservableList)input.getObservable(propertyPath);
			} catch (Exception ex) {
				Activator.log.error("Cannot find a valid IObservable for " + propertyPath, ex); //$NON-NLS-1$
			}
		}

		return observableList;
	}

	/**
	 * @return the IObservableValue for this propertyEditor, or null if it is not
	 *         available
	 */
	protected IObservableValue getInputObservableValue() {
		if(observableValue == null) {
			try {
				observableValue = (IObservableValue)input.getObservable(propertyPath);
			} catch (Exception ex) {
				Activator.log.error("Cannot find a valid IObservable for " + propertyPath, ex); //$NON-NLS-1$
			}
		}

		return observableValue;
	}

	/**
	 * @return the last segment of the property path (Which is the property name)
	 */
	protected String getLocalPropertyPath() {
		return propertyPath.substring(propertyPath.lastIndexOf(":") + 1); //$NON-NLS-1$
	}

	/**
	 * Sets the editor's Layout Data
	 * 
	 * @param data
	 */
	public void setLayoutData(Object data) {
		if(getEditor() != null) {
			getEditor().setLayoutData(data);
		}
	}

	/**
	 * Returns the editor's Layout Data
	 * 
	 * @return
	 *         The editor's layout data
	 */
	public Object getLayoutData() {
		return getEditor() == null ? null : getEditor().getLayoutData();
	}

	/**
	 * Indicates whether the editor's label should be displayed or not
	 * 
	 * @param showLabel
	 */
	public void setShowLabel(boolean showLabel) {
		AbstractEditor editor = getEditor();
		this.showLabel = showLabel;
		if(editor != null) {
			editor.setDisplayLabel(showLabel);
		}
	}

	/**
	 * Indicates whether the editor's label is displayed or not
	 * 
	 * @return
	 *         true if the label should be displayed
	 */
	public boolean getShowLabel() {
		return this.showLabel;
	}

	/**
	 * Sets the label for this editor. The label will replace the property's
	 * default label
	 * 
	 * @param customLabel
	 *        The label to use with this property editor
	 */
	public void setCustomLabel(String customLabel) {
		this.customLabel = customLabel;
		updateLabel();
	}

	/**
	 * @return the custom label used by this property editor. May be null
	 */
	public String getCustomLabel() {
		return this.customLabel;
	}

	/**
	 * @return the Control defined by this Property Editor
	 */
	public Control getControl() {
		if(valueEditor == null) {
			return listEditor;
		}
		return valueEditor;
	}
}
