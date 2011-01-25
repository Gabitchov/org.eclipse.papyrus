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
package org.eclipse.papyrus.widgets.editors;

import java.util.HashSet;
import java.util.Set;

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
	 * The set of elements listening on changes from this editor
	 */
	protected Set<ICommitListener> commitListeners = new HashSet<ICommitListener>();

	/**
	 * The factory for creating all the editors with a common style
	 */
	public static TabbedPropertySheetWidgetFactory factory = new TabbedPropertySheetWidgetFactory();

	static {
		factory.setBackground(null);
	}

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
		GridLayout layout = new GridLayout(2, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		setLayout(layout);
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
		} else {
			createLabel(label);
			this.label.moveAbove(getChildren()[0]);
		}
	}

	/**
	 * Adds a commit listener to this editor. A Commit event is
	 * fired when a modification occures on this editor.
	 * 
	 * @param listener
	 *        The commit listener to add to this editor
	 */
	public void addCommitListener(ICommitListener listener) {
		commitListeners.add(listener);
	}

	/**
	 * Removes a commit listener from this editor.
	 * 
	 * @param listener
	 *        The commit listener to remove from this editor
	 */
	public void removeCommitListener(ICommitListener listener) {
		commitListeners.remove(listener);
	}

	/**
	 * Informs the commit listeners that a modification occured
	 */
	protected void commit() {
		for(ICommitListener listener : commitListeners) {
			listener.commit(this);
		}
	}

	/**
	 * Gets the BindingContext associated to the editors
	 * 
	 * @return
	 */
	protected DataBindingContext getBindingContext() {
		return new DataBindingContext();
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
	 * Binds the Widget Observable to the Model observable property,
	 * using the specified converters when available
	 */
	abstract protected void doBinding();

	/**
	 * @return the type of objects that this widget can edit
	 */
	public abstract Object getEditableType();

	/**
	 * Marks this editor as being read-only. The value of a read-only
	 * editor cannot be changed by the editor itself.
	 * 
	 * @param readOnly
	 */
	public abstract void setReadOnly(boolean readOnly);

	/**
	 * Tests whether this editor is read-only or not
	 * 
	 * @return
	 *         True if the editor is read-only
	 */
	public abstract boolean isReadOnly();
}
