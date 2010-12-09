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
package org.eclipse.papyrus.editors;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * An Abstract class to represent Editors.
 * An editor is a Composite, containing a label and one
 * or more controls. The label may be null.
 * The controls are specified by the implementations
 * of this abstract class.
 * 
 * @author Camille Letavernier
 */
public abstract class AbstractEditor extends Composite {

	/**
	 * The label for this editor. May be null.
	 */
	protected Label label;

	/**
	 * The factory for creating all the editors with a common style
	 */
	public static TabbedPropertySheetWidgetFactory factory = new TabbedPropertySheetWidgetFactory();

	/**
	 * 
	 * Constructor. Constructs an editor without a label
	 * 
	 * @param parent
	 *        The composite in which this editor should be created
	 */
	public AbstractEditor(Composite parent) {
		this(parent, SWT.NONE, null);
	}

	/**
	 * 
	 * Constructor. Constructs an editor without a label
	 * 
	 * @param parent
	 *        The composite in which this editor should be created
	 * @param style
	 *        The style of this editor's main composite
	 */
	public AbstractEditor(Composite parent, int style) {
		this(parent, style, null);
	}

	/**
	 * 
	 * Constructor. Constructs an editor with a label
	 * 
	 * @param parent
	 *        The composite in which this editor should be created
	 * @param label
	 *        The label that will be displayed for this editor, or null
	 *        if no label should be displayed
	 */
	public AbstractEditor(Composite parent, String label) {
		this(parent, SWT.NONE, label);
	}

	/**
	 * 
	 * Constructor. Constructs an editor with a label
	 * 
	 * @param parent
	 *        The composite in which this editor should be created
	 * @param style
	 *        The style of this editor's main composite
	 * @param label
	 *        The label that will be displayed for this editor, or null
	 *        if no label should be displayed
	 */
	public AbstractEditor(Composite parent, int style, String label) {
		super(parent, style);
		setLayout(new GridLayout(2, false));
		if(label != null) {
			createLabel(label);
		}
	}

	/**
	 * Creates the label widget with the given text
	 * 
	 * @param text
	 *        The text to be displayed on the label
	 */
	protected void createLabel(String text) {
		label = factory.createLabel(this, text);
		label.setLayoutData(getLabelLayoutData());
	}

	/**
	 * @return The default layoutData for the label
	 */
	protected GridData getLabelLayoutData() {
		GridData data = new GridData();
		data.widthHint = 120;
		data.verticalAlignment = SWT.CENTER;

		return data;
	}

	/**
	 * This method should be called by subclasses to get the default layoutData
	 * for a control in this editor.
	 * 
	 * @return The default layoutData for the main control
	 */
	protected GridData getDefaultLayoutData() {
		GridData data = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
		return data;
	}

	/**
	 * Changes the text label for this editor. This method is available
	 * only when the editor has been constructed with a label.
	 * 
	 * @param label
	 *        The new text for this editor's label
	 */
	public void setLabel(String label) {
		if(this.label != null) {
			this.label.setText(label);
		}
		//TODO : else createLabel (Before the control(s))
	}

	/**
	 * Sets the converters to convert data from Model to Target (Widget),
	 * and from Widget to Model
	 * 
	 * @param targetToModel
	 * @param modelToTarget
	 */
	abstract public void setConverters(IConverter targetToModel, IConverter modelToTarget);

	/**
	 * Gets the BindingContext associated to the editors
	 * 
	 * @return
	 */
	protected DataBindingContext getBindingContext() {
		return new DataBindingContext();
	}

	/**
	 * Binds the Widget Observable to the Model observable property,
	 * using the specified converters when available
	 */
	abstract protected void doBinding();

	/**
	 * @return the type of objects that this widget can edit
	 */
	public abstract Object getEditableType();
}
