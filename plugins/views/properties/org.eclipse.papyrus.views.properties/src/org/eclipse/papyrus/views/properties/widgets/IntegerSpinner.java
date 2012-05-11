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
package org.eclipse.papyrus.views.properties.widgets;

import org.eclipse.swt.widgets.Composite;

/**
 * A widget for editing Integer values with a SWT Spinner
 * 
 * @author Camille Letavernier
 * 
 * @see org.eclipse.papyrus.infra.widgets.editors.IntegerSpinner
 * @see org.eclipse.swt.widgets.Spinner
 */
public class IntegerSpinner extends AbstractPropertyEditor {

	private org.eclipse.papyrus.infra.widgets.editors.IntegerSpinner spinner;

	private int minimum = 0, maximum = 100, increment = 1;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 * @param style
	 */
	public IntegerSpinner(Composite parent, int style) {
		spinner = createIntegerSpinner(parent, style);
		spinner.setMinimum(minimum);
		spinner.setMaximum(maximum);
		spinner.setIncrement(increment);
		setEditor(spinner);
	}

	/**
	 * Creates the integer spinner.
	 * 
	 * @param parent
	 *        The composite in which the widget will be displayed
	 * @param style
	 *        The style for the widget
	 * @return the integer spinner.
	 */
	protected org.eclipse.papyrus.infra.widgets.editors.IntegerSpinner createIntegerSpinner(Composite parent, int style) {
		return new org.eclipse.papyrus.infra.widgets.editors.IntegerSpinner(parent, style);
	}

	/**
	 * @return the minimum value for the spinner
	 */
	public int getMinimum() {
		return minimum;
	}

	/**
	 * @param minimum
	 *        the minimum value for the spinner
	 */
	public void setMinimum(int minimum) {
		this.minimum = minimum;
		spinner.setMinimum(minimum);
	}

	/**
	 * @return the maximum value for the spinner
	 */
	public int getMaximum() {
		return maximum;
	}

	/**
	 * @param maximum
	 *        the maximum value for the spinner
	 */
	public void setMaximum(int maximum) {
		this.maximum = maximum;
		spinner.setMaximum(maximum);
	}

	/**
	 * @return the increment value for the spinner
	 */
	public int getIncrement() {
		return increment;
	}

	/**
	 * @param increment
	 *        the increment value for the spinner
	 */
	public void setIncrement(int increment) {
		this.increment = increment;
		spinner.setIncrement(increment);
	}
}
