/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.sasheditor.sash;

import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * Allows to replace one of the window
 */
public class ReplaceableSashForm extends SashForm {

	private Composite leftComposite;

	private Composite rightComposite;

	public ReplaceableSashForm(Composite parent, int style) {
		super(parent, style);

		leftComposite = new Composite(this, 0);
		leftComposite.setLayout(new FillLayout());
		rightComposite = new Composite(this, 0);
		rightComposite.setLayout(new FillLayout());
	}

	public Composite getLeftParent() {
		return leftComposite;
	}

	public Composite getRightParent() {
		return rightComposite;
	}

	/**
	 * Reparent the provided control to have the leftPart parent.
	 */
	public void setLeftControl(Control control) {
		if (leftComposite == null) {
			leftComposite = new Composite(this, 0);
		}

		// reparent the control
		control.setParent(leftComposite);
	}

	/**
	 * Reparent the provided control to have the leftPart parent.
	 */
	public void setRightControl(Control control) {
		if (rightComposite == null) {
			rightComposite = new Composite(this, 0);
		}

		// reparent the control
		control.setParent(rightComposite);
	}

}
