/*****************************************************************************
 * Copyright (c) 2010, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 402525
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.editors;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.infra.widgets.creation.IAtomicOperationExecutor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
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
//FIXME: The composite widget hides access to the encapsulated widget(s). 
//Thus, it is not possible to add custom listeners on the editors
//We should forward the listeners to the encapsulated (this.addListener(int, Listener) -> getMainWidget().addListener(int, Listener))
//Problem: some widgets have more than one "main widget" (e.g. EnumRadio).
public abstract class AbstractEditor extends Composite implements DisposeListener {

	/**
	 * The label for this editor. May be null.
	 */
	protected Label label;

	/**
	 * The label value for this editor
	 */
	protected String labelText;

	/**
	 * The set of elements listening on changes from this editor
	 */
	protected Set<ICommitListener> commitListeners = new LinkedHashSet<ICommitListener>();

	/**
	 * The binding between the model object and the widget
	 */
	protected Binding binding;

	/**
	 * The toolTipText associated to this editor
	 */
	protected String toolTipText;

	/**
	 * The factory for creating all the editors with a common style
	 */
	public static TabbedPropertySheetWidgetFactory factory = new TabbedPropertySheetWidgetFactory();

	static {
		factory.setBackground(null);
		factory.setBorderStyle(SWT.BORDER); //This seems to be used only by the FormToolKit factory, we still need to force it for the CLabel or CCombo widgets
	}

	/**
	 * 
	 * Constructor. Constructs an editor without a label
	 * 
	 * @param parent
	 *        The composite in which this editor should be created
	 */
	protected AbstractEditor(Composite parent) {
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
	protected AbstractEditor(Composite parent, int style) {
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
	protected AbstractEditor(Composite parent, String label) {
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
	protected AbstractEditor(Composite parent, int style, String label) {
		super(parent, style);
		GridLayout layout = new GridLayout(1, false);
		setLayout(layout);
		if(label != null) {
			createLabel(label);
		}
		parent.addDisposeListener(this);
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
		if(toolTipText != null) {
			label.setToolTipText(toolTipText);
		}
		((GridLayout)getLayout()).numColumns++;
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
		this.labelText = label;

		if(this.label != null) {
			this.label.setText(label);
		} else {
			createLabel(label);
			this.label.moveAbove(getChildren()[0]);
		}
	}

	/**
	 * Show or delete the Label Widget.
	 * 
	 * @param displayLabel
	 */
	public void setDisplayLabel(boolean displayLabel) {
		if(displayLabel) {
			setLabel(labelText);
		} else {
			if(this.label != null) {
				this.label.dispose();
				((GridLayout)getLayout()).numColumns--;
			}
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

	/**
	 * Indicates that this editor should notify its commit listeners
	 * when the given control looses the Focus
	 * 
	 * @param control
	 *        The control on which a FocusListener should be added,
	 *        to notify the CommitListeners
	 */
	protected void setCommitOnFocusLost(Control control) {
		control.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				// Nothing
			}

			public void focusLost(FocusEvent e) {
				commit();
			}

		});
	}

	/**
	 * Forces the refresh of the widget's value
	 */
	public void refreshValue() {
		if(binding != null) {
			binding.updateModelToTarget();
		}
	}

	/**
	 * Sets the given toolTip to the label
	 * 
	 * @param text
	 *        The new label's tooltip
	 */
	protected void setLabelToolTipText(String text) {
		toolTipText = text;
		if(label != null && !label.isDisposed()) {
			label.setToolTipText(text);
		}
	}

	/**
	 * Excludes or includes the given control from the layout
	 * 
	 * @param control
	 *        The control to exclude or include
	 * @param exclude
	 *        If true, the control will be excluded ; otherwise, it will be included
	 */
	protected void setExclusion(Control control, boolean exclude) {
		if(control.getLayoutData() == null) {
			GridData data = new GridData();
			control.setLayoutData(data);
		}

		GridData data = (GridData)control.getLayoutData();

		if(data.exclude != exclude) {
			data.exclude = exclude;
			GridLayout layout = (GridLayout)control.getParent().getLayout();
			if(exclude) {
				layout.numColumns--;
			} else {
				layout.numColumns++;
			}
		}
	}

	@Override
	public abstract void setToolTipText(String text);

	public void widgetDisposed(DisposeEvent e) {
		dispose();
	}

	/**
	 * Obtains the most appropriate operation executor for the object being edited.
	 * 
	 * @param context the object being edited
	 * @return the executor to use to run operations (never {@code null})
	 */
	public IAtomicOperationExecutor getOperationExecutor(Object context) {
		IAtomicOperationExecutor result;
		if(context instanceof IAdaptable) {
			result = (IAtomicOperationExecutor)((IAdaptable)context).getAdapter(IAtomicOperationExecutor.class);
		} else {
			result = (IAtomicOperationExecutor)Platform.getAdapterManager().getAdapter(context, IAtomicOperationExecutor.class);
		}

		if (result == null) {
			result = IAtomicOperationExecutor.DEFAULT;
		}
		
		return result;
	}
	
	/**
	 * Queries the model element that I edit.
	 * 
	 * @return the contextual model element
	 */
	protected abstract Object getContextElement();
}
