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
package org.eclipse.papyrus.infra.widgets.databinding;

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.tools.databinding.AggregatedObservable;
import org.eclipse.papyrus.infra.widgets.messages.Messages;
import org.eclipse.swt.custom.CLabel;

/**
 * An IObservableValue to edit a CLabel (Text + Image), based on a LabelProvider
 * It supports AggregatedObservable
 * 
 * @author Camille Letavernier
 */
public class CLabelObservableValue extends AbstractObservableValue {

	/**
	 * The observed CLabel
	 */
	protected CLabel label;

	/**
	 * The current value
	 */
	protected Object currentValue;

	/**
	 * The LabelProvider used to define the CLabel's text and image,
	 * based on the current value
	 */
	protected ILabelProvider labelProvider;

	/**
	 * If the CLabel may represent more than one value,
	 * use an AggregatedObservable
	 * 
	 * May be null
	 */
	protected AggregatedObservable aggregated;

	/**
	 * Constructor
	 * 
	 * @param label
	 *        The observed CLabel
	 * @param modelObservable
	 *        The Model IObservable
	 */
	public CLabelObservableValue(CLabel label, IObservableValue modelObservable) {
		this(label, modelObservable, null);
	}

	/**
	 * Constructor
	 * 
	 * @param label
	 *        The observed CLabel
	 * @param modelObservable
	 *        The Model IObservable
	 * @param labelProvider
	 *        The LabelProvider used to define the CLabel's text/image from the current value
	 */
	public CLabelObservableValue(CLabel label, IObservableValue modelObservable, ILabelProvider labelProvider) {
		this.label = label;
		setLabelProvider(labelProvider);
		if(modelObservable instanceof AggregatedObservable) {
			this.aggregated = (AggregatedObservable)modelObservable;
		}
	}

	/**
	 * @param labelProvider
	 *        The LabelProvider used to define the CLabel's text and image,
	 *        based on the current value
	 */
	public void setLabelProvider(ILabelProvider labelProvider) {
		if(labelProvider != null) {
			this.labelProvider = labelProvider;
		} else {
			this.labelProvider = new LabelProvider();
		}
	}

	public Object getValueType() {
		return Object.class;
	}

	@Override
	protected Object doGetValue() {
		return currentValue;
	}

	@Override
	protected void doSetValue(Object value) {
		this.currentValue = value;
		if(aggregated != null && aggregated.hasDifferentValues()) {
			label.setText(Messages.ReferenceDialogObservable_Unchanged);
			label.setImage(null);
		} else if(currentValue == null) {
			label.setText(Messages.ReferenceDialog_Unset);
			label.setImage(null);
		} else {
			label.setText(labelProvider.getText(value));
			label.setImage(labelProvider.getImage(value));
		}
	}
}
