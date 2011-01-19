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

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.SelectObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * A Property Editor representing a Boolean value
 * as a Radio, with two options (true/false).
 * 
 * @author Camille Letavernier
 * 
 */
public class BooleanRadio extends AbstractValueEditor {

	/**
	 * The "true" radio button
	 */
	protected Button trueRadio;

	/**
	 * The "false" radio button
	 */
	protected Button falseRadio;

	/**
	 * 
	 * Constructor. Creates a new Property Editor for a Boolean
	 * value, represented by two radio buttons.
	 * 
	 * @param parent
	 *        This editor's parent composite
	 * @param style
	 *        The style applied to this editor's radio buttons
	 */
	public BooleanRadio(Composite parent, int style) {
		this(parent, style, null);
	}

	/**
	 * 
	 * Constructor. Creates a new Property Editor for a Boolean
	 * value, represented by two radio buttons.
	 * 
	 * @param parent
	 *        This editor's parent composite
	 * @param style
	 *        The style applied to this editor's radio buttons
	 * @param label
	 *        The label for this editor
	 */
	public BooleanRadio(Composite parent, int style, String label) {
		super(parent, label);

		setLayout(new GridLayout(3, false));

		//trueRadio = new Button(this, SWT.RADIO);
		//trueRadio.setText("true");
		trueRadio = factory.createButton(this, "true", style | SWT.RADIO); //$NON-NLS-1$

		//		falseRadio = new Button(this, SWT.RADIO);
		//		falseRadio.setText("false");
		falseRadio = factory.createButton(this, "false", style | SWT.RADIO); //$NON-NLS-1$

		setWidgetObservable(getObservable(), true);
	}

	/**
	 * Defines a single observable value, encapsulating the ones
	 * from each radio button (true / false)
	 * 
	 * @return The encapsulating observable value
	 */
	private IObservableValue getObservable() {
		IObservableValue trueObservable = WidgetProperties.selection().observe(trueRadio);
		IObservableValue falseObservable = WidgetProperties.selection().observe(falseRadio);

		SelectObservableValue observable = new SelectObservableValue();
		observable.addOption(true, trueObservable);
		observable.addOption(false, falseObservable);

		return observable;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getEditableType() {
		return Boolean.class;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean getValue() {
		return trueRadio.getSelection();
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		trueRadio.setEnabled(!readOnly);
		falseRadio.setEnabled(!readOnly);
	}

	@Override
	public boolean isReadOnly() {
		return !trueRadio.isEnabled() || !falseRadio.isEnabled();
	}
}
