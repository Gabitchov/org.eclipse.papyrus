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
package org.eclipse.papyrus.infra.widgets.editors;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * A Property Editor representing a multivalued property as a label with the
 * selected values. If the list of values is too long, it is truncated. The
 * values can be edited via a selection dialog. This widget is useful when there
 * is not much vertical space available, and a MultipleValueEditor can not be
 * used.
 */
public class CompactMultipleValueEditor extends AbstractListEditor implements IChangeListener, DisposeListener, SelectionListener {

	/**
	 * The default value separator in the value label
	 */
	protected static final String DEFAULT_VALUE_SEPARATOR = ", "; //$NON-NLS-1$

	/**
	 * The label for displayed the selected values
	 */
	protected Label valueLabel;

	/**
	 * The button to open a dialog for editing the values
	 */
	protected Button edit;

	/**
	 * The label provider for this editor. Also used by the dialog.
	 */
	protected ILabelProvider labelProvider;

	/**
	 * The string used for separating values in the value label
	 */
	protected String separator;

	/**
	 * The Dialog displayed when adding new elements
	 */
	protected MultipleValueSelectorDialog dialog;

	/**
	 * The element selector for the dialog
	 */
	protected IElementSelector selector;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 *        The widget in which this editor is created
	 * @param style
	 *        The style for this editor's control
	 * @param selector
	 *        The IElementSelector for this editor's selection dialog
	 */
	public CompactMultipleValueEditor(Composite parent, int style, IElementSelector selector) {
		this(parent, style, selector, false, false, DEFAULT_VALUE_SEPARATOR, null);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 *        The widget in which this editor is created
	 * @param style
	 *        The style for this editor's control
	 * @param selector
	 *        The element selector to be used in the selection dialog
	 * @param ordered
	 *        True if the multivalued property is ordered
	 * @param unique
	 *        True if the multivalued property needs unique values
	 */
	public CompactMultipleValueEditor(Composite parent, int style, IElementSelector selector, boolean ordered, boolean unique) {
		this(parent, style, selector, ordered, unique, DEFAULT_VALUE_SEPARATOR, null);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 *        The widget in which this editor is created
	 * @param style
	 *        The style for this editor's control
	 * @param selector
	 *        The element selector to be used in the selection dialog
	 * @param ordered
	 *        True if the multivalued property is ordered
	 * @param unique
	 *        True if the multivalued property needs unique values
	 * @param separator
	 *        The string used to separate values in the display label
	 * @param label
	 *        The label for this editor
	 */
	public CompactMultipleValueEditor(Composite parent, int style, IElementSelector selector, boolean ordered, boolean unique, String separator, String label) {
		super(parent, label);

		((GridLayout)getLayout()).numColumns = 3;

		valueLabel = factory.createLabel(this, null, style);
		valueLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		edit = new Button(this, SWT.PUSH);
		edit.setText("..."); //$NON-NLS-1$
		edit.addSelectionListener(this);
		edit.setLayoutData(new GridData(SWT.END, SWT.CENTER, false, false));

		this.selector = selector;
		dialog = new MultipleValueSelectorDialog(parent.getShell(), selector, unique);

		labelProvider = new LabelProvider();
		this.separator = separator;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getEditableType() {
		return Collection.class;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doBinding() {
		// We don't do a real Databinding in this case
		modelProperty.addChangeListener(this);
		getParent().addDisposeListener(this);
		handleChange(null);
	}

	/**
	 * Sets the label provider for this editor
	 * 
	 * @param provider
	 *        The label provider for this editor
	 */
	public void setLabelProvider(ILabelProvider provider) {
		dialog.setLabelProvider(provider);
		this.labelProvider = provider;
	}

	/**
	 * Refreshes the Label when a change occurs on the ObservableList
	 * 
	 * @see org.eclipse.core.databinding.observable.IChangeListener#handleChange(org.eclipse.core.databinding.observable.ChangeEvent)
	 * 
	 * @param event
	 */
	public void handleChange(ChangeEvent event) {
		if(modelProperty != null) {

			List<String> labels = new LinkedList<String>();
			for(Object element : modelProperty) {
				labels.add(labelProvider.getText(element));
			}

			valueLabel.setText(createValueLabel(labels));
		}
	}

	/**
	 * Creates the text for the value label of this editor
	 * 
	 * @param labels
	 *        The labels for each selected element
	 * @return The concatenated label
	 */
	protected String createValueLabel(List<String> labels) {
		if(labels.size() == 0) {
			return ""; //$NON-NLS-1$
		}

		String result = labels.get(0);
		for(int i = 1; i < labels.size(); i++) {
			result += separator + labels.get(i);
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public void widgetDisposed(org.eclipse.swt.events.DisposeEvent e) {
		dispose();
		modelProperty.removeChangeListener(this);
	}

	/**
	 * {@inheritDoc} Handles the event when the edit button is pressed
	 */
	public void widgetSelected(SelectionEvent e) {
		dialog.setInitialSelections(modelProperty.toArray());
		int returnCode = dialog.open();
		if(returnCode == Window.CANCEL) {
			return;
		}

		modelProperty.clear();

		Object[] result = dialog.getResult();
		if(result == null) {
			return;
		}

		java.util.List<Object> resultElements = new LinkedList<Object>();
		for(Object r : result) {
			resultElements.add(r);
		}

		modelProperty.addAll(resultElements);
	}

	/**
	 * {@inheritDoc} Ignored
	 */
	public void widgetDefaultSelected(SelectionEvent e) {
		// Nothing
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		valueLabel.setEnabled(!readOnly);
		edit.setEnabled(!readOnly);
	}

	@Override
	public boolean isReadOnly() {
		return !valueLabel.isEnabled() || !edit.isEnabled();
	}

	@Override
	public void setToolTipText(String text) {
		valueLabel.setToolTipText(text);
		super.setLabelToolTipText(text);
	}

	@Override
	public void refreshValue() {
		handleChange(null);
	}
}
