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

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.widgets.editors.ReferenceDialog;
import org.eclipse.swt.custom.CLabel;


/**
 * An ObservableValue for ReferenceDialog widget (Which displays
 * the current value with a CLabel)
 * 
 * @author Camille Letavernier
 */
public class ReferenceDialogObservableValue extends CLabelObservableValue {

	private ReferenceDialog referenceDialog;

	/**
	 * @param dialog
	 *        The observed ReferenceDialog
	 * @param label
	 *        The observed CLabel (Should correspond to dialog#currentValueLabel)
	 * @param modelObservable
	 *        The Model IObservable
	 */
	public ReferenceDialogObservableValue(ReferenceDialog dialog, CLabel label, IObservableValue modelObservable) {
		this(dialog, label, modelObservable, null);
	}

	/**
	 * @param dialog
	 *        The observed ReferenceDialog
	 * @param label
	 *        The observed CLabel (Should correspond to dialog#currentValueLabel)
	 * @param modelObservable
	 *        The Model IObservable
	 * @param labelProvider
	 *        The LabelProvider used to define the CLabel's text/image from the current value
	 */
	public ReferenceDialogObservableValue(ReferenceDialog dialog, CLabel label, IObservableValue modelObservable, ILabelProvider labelProvider) {
		super(label, modelObservable, labelProvider);
		this.referenceDialog = dialog;
	}

	@Override
	protected void doSetValue(Object value) {
		super.doSetValue(value);
		referenceDialog.update();
	}

}
